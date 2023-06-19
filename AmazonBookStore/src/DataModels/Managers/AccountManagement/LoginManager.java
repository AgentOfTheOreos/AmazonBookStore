package DataModels.Managers.AccountManagement;

import DataModels.User;
import DataModels.Bookstore;
import DataModels.Security.AttributeAccess;
import DataModels.Visuals.ConsoleColors;


import java.util.List;
public class LoginManager {
    public static User login(Bookstore bookstore, String email, String password) {
        //The login method checks if there is a user that has an email and password that matches the input, it will
        // return null if not found
        List<User> bookstoreUsers = bookstore.getUsers();
        for (User aUser : bookstoreUsers) {
            if (aUser.getEmail().equals(email)) {
                // Validate that the entered password matches the user's password
                if (AttributeAccess.validatePassword(aUser, password)) {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.YELLOW + "Login successful!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
                    return aUser;
                } else {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.RED + "Incorrect Password" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
                    return null;
                }
            }
        }
        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.RED + "Incorrect Credentials" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
        return null;
    }
}
