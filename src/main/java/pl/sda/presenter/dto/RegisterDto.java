package pl.sda.presenter.dto;

public class RegisterDto {

    private String nameRegister;
    private String lastNameRegister;
    private String emailRegister;
    private String passwordRegister;
    private String confirmPasswordRegister;


    public String getName() {
        return nameRegister;
    }

    public void setName(String nameRegister) {
        this.nameRegister = nameRegister;
    }

    public String getLastName() {
        return lastNameRegister;
    }

    public void setLastName(String lastNameRegister) {
        this.lastNameRegister = lastNameRegister;
    }

    public String getEmail() {
        return emailRegister;
    }

    public void setEmail(String emailRegister) {
        this.emailRegister = emailRegister;
    }

    public String getPassword() {
        return passwordRegister;
    }

    public void setPassword(String passwordRegister) {
        this.passwordRegister = passwordRegister;
    }

    public String getConfirmPasswordRegister() {
        return confirmPasswordRegister;
    }

    public void setConfirmPasswordRegister(String confirmPasswordRegister) {
        this.confirmPasswordRegister = confirmPasswordRegister;
    }

}
