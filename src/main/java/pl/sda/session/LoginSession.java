package pl.sda.session;

import java.util.Objects;


public class LoginSession {


    static LoginSession INSTANCE;
    private String loggedEmail;

    private LoginSession() {
    }

    public static LoginSession getInstance() {
//        if (INSTANCE == null) {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new LoginSession();
        }
        return INSTANCE;
    }

    public void add(String email) {
        loggedEmail = email;
    }

    public void clear() {
        loggedEmail = null;
    }

    public String getLoggedEmail() {
        return  loggedEmail;
    }
}
