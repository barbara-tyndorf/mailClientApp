package pl.sda.presenter;

import pl.sda.model.*;
import pl.sda.session.LoginSession;
import pl.sda.view.EmailView;

import java.util.regex.Pattern;

public class EmailPresenter {

    private EmailView emailView;
    private EmailSender emailSender;
    private EmailHistoryDatabase emailHistoryDatabase;
    private UserDatabase userDatabase;

    public EmailPresenter(EmailView emailView) {
        this.emailView = emailView;
        emailSender = new EmailSender();
        emailHistoryDatabase = new EmailHistoryDatabase();
        userDatabase = new UserDatabase();

    }

    public void sendEmail(EmailData emailData) {

        if (!isValid(emailData)) {
            emailView.emailSentFailure();
            return;
        }
        boolean emailSent = emailSender.sendEmail(emailData);
        if (emailSent) {
            emailView.emailSentSuccessfully();
            emailView.clearForm();

            createHistory(emailData);

        } else {
            emailView.emailSentFailure();
        }
    }

    private void createHistory(EmailData emailData) {
        User loggedUser = userDatabase.getByEmail(LoginSession.getInstance().getLoggedEmail());
        EmailHistory emailHistory = new EmailHistory();
        emailHistory.setReceiver(emailData.getReceiver());
        emailHistory.setSubject(emailData.getSubject());
        emailHistory.setContent(emailData.getContent());

        emailHistoryDatabase.add(loggedUser,emailHistory);
    }

    private boolean isValid(EmailData emailData) {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        return emailPattern.matcher(emailData.getReceiver()).find()
                && emailPattern.matcher(emailData.getSender()).find()
                && emailData.getContent().length() >= 3;
    }

}

