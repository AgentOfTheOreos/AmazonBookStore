
public class AttributeAccess
{
    public static boolean validatePassword(User user, String currentPassword)
    {
        return currentPassword.equals(user.getPassword());
    }
}
