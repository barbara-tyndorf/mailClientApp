package pl.sda.view;

import pl.sda.presenter.LoginRegisterPresenter;
import pl.sda.presenter.dto.LoginDto;
import pl.sda.presenter.dto.RegisterDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginRegisterView extends JFrame {
    private JTextField emailLogin;
    private JPasswordField passwordLogin;
    private JButton loginButton;

    private JTextField nameRegister;
    private JTextField lastNameRegister;
    private JTextField emailRegister;
    private JPasswordField passwordRegister;
    private JPasswordField confirmPasswordRegister;
    private JButton registerButton;

    private JPanel contentPanel;

    private LoginRegisterPresenter presenter;

    public LoginRegisterView() {
        presenter = new LoginRegisterPresenter(this);
        initView();
        initListeners();

    }

    private void initView() {
        setTitle("Email Client");
        add(contentPanel);
        setVisible(true);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.login(new LoginDto(emailLogin.getText(),new String(passwordLogin.getPassword())));
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterDto registerDto = new RegisterDto();
                registerDto.setEmail(emailRegister.getText());
                registerDto.setPassword(new String(passwordRegister.getPassword()));
                registerDto.setConfirmPasswordRegister(new String(confirmPasswordRegister.getPassword()));
                registerDto.setName(nameRegister.getText());
                registerDto.setLastName(lastNameRegister.getText());

                presenter.register(registerDto);
            }
        });
    }

    public void loginSuccessfully() {
        new EmailView();
        this.dispose();
    }

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void successMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void clearForm() {
        emailRegister.setText("");
        passwordRegister.setText("");
        confirmPasswordRegister.setText("");
        nameRegister.setText("");
        lastNameRegister.setText("");

    }
}
