package pl.sda.presenter;

import pl.sda.model.User;
import pl.sda.model.UserDatabase;
import pl.sda.presenter.dto.LoginDto;
import pl.sda.presenter.dto.RegisterDto;
import pl.sda.session.LoginSession;
import pl.sda.view.LoginRegisterView;

import java.util.regex.Pattern;

public class LoginRegisterPresenter {

    private LoginRegisterView loginRegisterView;
    private UserDatabase userDatabase;

    public LoginRegisterPresenter(LoginRegisterView loginRegisterView) {
        this.loginRegisterView = loginRegisterView;
        userDatabase = new UserDatabase();
    }

    public void login(LoginDto loginDto) {
//        if (!dataValidation(loginDto)) {
//            return;
//        } // FIXME
        if (userDatabase.findUser(loginDto)) {
            LoginSession session = LoginSession.getInstance();
            session.add(loginDto.getEmail());
            loginRegisterView.loginSuccessfully();

        } else {
            loginRegisterView.errorMessage("Incorrect email or password. Try again.");
        }

    }

    public void register(RegisterDto registerDto) {
        if (!dataValidation(registerDto)) {
            return;
        }
        if (userDatabase.findUser(registerDto.getEmail())) {
            loginRegisterView.errorMessage("User already exist. Try again.");
            return;
        }
        User user = new User();
        user.setName(registerDto.getName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());

        userDatabase.addUser(user);
        loginRegisterView.successMessage("Account created.");
        loginRegisterView.clearForm();

        LoginDto loginDto = new LoginDto(registerDto.getEmail(), registerDto.getPassword());
        login(loginDto);

    }


    private boolean dataValidation(RegisterDto registerDto) {
        Pattern registerPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        return registerPattern.matcher(registerDto.getEmail()).find()
                && registerDto.getName().length() >= 3
                && registerDto.getLastName().length() >= 3
                && registerDto.getPassword().length() >= 3
                && !registerDto.getPassword().equals(" ");
    }
}
