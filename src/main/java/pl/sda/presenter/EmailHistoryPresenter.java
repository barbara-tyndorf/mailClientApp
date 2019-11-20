package pl.sda.presenter;

import pl.sda.model.EmailHistory;
import pl.sda.model.EmailHistoryDatabase;
import pl.sda.model.User;
import pl.sda.model.UserDatabase;
import pl.sda.session.LoginSession;
import pl.sda.view.EmailHistoryView;

import java.util.List;


public class EmailHistoryPresenter {

    private EmailHistoryView emailHistoryView;
    private EmailHistoryDatabase emailHistoryDatabase;
    private UserDatabase userDatabase;

    public EmailHistoryPresenter(EmailHistoryView emailHistoryView) {
        this.emailHistoryView = emailHistoryView;
    }

    public List<EmailHistory> showUserHistory(String email) {
        email = LoginSession.getInstance().getLoggedEmail();
        User user = userDatabase.getByEmail(email);
        return EmailHistoryDatabase.getEmailHistoryMap().get(user);
    }
}
