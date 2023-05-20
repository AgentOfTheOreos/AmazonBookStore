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
                    System.out.println("                                    Login successful!                                 ");
                    return aUser;
                }
                else
                {
                    System.out.println("                                    Incorrect password                                 ");
                    return null;
                }
            }
        }
        System.out.println("                                    Incorrect credentials                                 ");
        return null;
    }
}
