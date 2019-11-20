package pl.sda.view;

import pl.sda.presenter.EmailData;
import pl.sda.presenter.EmailPresenter;
import pl.sda.session.LoginSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailView extends JFrame {
    private JButton sendButton;
    private JTextField emailSubject;
    private JTextField emailSender;
    private JTextField emailReceiver;
    private JTextArea emailContent;
    private JPanel mailViewPanel;
    private JButton emailHistory;

    private EmailPresenter presenter;

    public EmailView() {
        this.presenter = new EmailPresenter(this);
        initView();
        initListeners();

    }

    private void initView() {
        setTitle("Email Client");
        add(mailViewPanel);
        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        emailSender.setText(LoginSession.getInstance().getLoggedEmail());
    }

    private void initListeners() {
//        sendButton.addActionListener((a) -> presenter.sendEmail(getEmailDataFromForm()));

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.sendEmail(getEmailDataFromForm());
            }
        });

        emailHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            goToHistory();
            }
        });

    }

    private void goToHistory() {
        new EmailHistoryView();

    }

    private EmailData getEmailDataFromForm() {
        EmailData emailData = new EmailData();
        emailData.setSender(emailSender.getText());
        emailData.setReceiver(emailReceiver.getText());
        emailData.setSubject(emailSubject.getText());
        emailData.setContent(emailContent.getText());

        return emailData;
    }

    public void clearForm() {
        emailReceiver.setText("");
//        emailSender.setText("");
        emailSubject.setText("");
        emailContent.setText("");
    }

    public void emailSentSuccessfully() {
        JOptionPane.showMessageDialog(this, "Email sent successfully", "Email sent", JOptionPane.INFORMATION_MESSAGE);
    }

    public void emailSentFailure() {
        JOptionPane.showMessageDialog(this, "Email does not sent", "Error message", JOptionPane.ERROR_MESSAGE);
    }
}
