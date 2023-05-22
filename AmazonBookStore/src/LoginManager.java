import Visuals.ConsoleColors;

import java.util.List;
public class LoginManager {
    public static User login(Bookstore bookstore, String email, String password)
    {
        List<User> bookstoreUsers = bookstore.getUsers();
        for (User aUser : bookstoreUsers)
        {
            if (aUser.getEmail().equals(email))
            {
                if (AttributeAccess.validatePassword(aUser, password))
                {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.YELLOW + "Login successful!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
                    return aUser;
                }
                else
                {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.RED + "Incorrect Password" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
                    return null;
                }
            }
        }
        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.RED + "Incorrect Credentials" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
        return null;
    }
}
