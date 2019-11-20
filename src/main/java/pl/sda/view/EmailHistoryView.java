package pl.sda.view;


import pl.sda.presenter.EmailHistoryPresenter;
import pl.sda.session.LoginSession;

import javax.swing.*;

public class EmailHistoryView extends JFrame {
    private JTextField userEmail;
    private JPanel historyPanel;
    private JTextField emailHistory; // fixme


    private EmailHistoryPresenter presenter;


    public EmailHistoryView() {
        this.presenter = new EmailHistoryPresenter(this);
        initView();

    }

    private void initView() {
        setTitle("Email History");
        add(historyPanel);
        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showHistory();
    }

    public void showHistory () {
        String email = LoginSession.getInstance().getLoggedEmail();
        userEmail.setText(email);
        emailHistory.setText((presenter.showUserHistory(email)).toString());
    }
}
