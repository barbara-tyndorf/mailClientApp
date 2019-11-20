package pl.sda.model;

import pl.sda.presenter.dto.LoginDto;

import java.util.HashSet;
import java.util.Set;

public class UserDatabase {

    private static Set<User> users = new HashSet<>();

    //FIXME remove it - fake user
    public UserDatabase(){
        User user = new User();
        user.setEmail("baba@wp.pl");
        user.setPassword("abc123");
        user.setName("Bożena");
        user.setLastName("Kowalska");

        users.add(user);
    }


    public void addUser(User user) {
        users.add(user);
    }

    public boolean findUser(LoginDto loginDto) {
        //sprawdź czy istnieje w secie
        for (User user : users) {
            if (user.getEmail().equals(loginDto.getEmail())
                    && user.getPassword() == (loginDto.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static Set<User> getUserDatabase() {
        return users;
    }

    public boolean findUser(String email) {
        //sprawdź czy istnieje i nie pozwól na rejestrację
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public User getByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
//        users.stream()
//                .filter(user -> user.getEmail().equals(email))
//                .findFirst();
        return null;
    }

}
