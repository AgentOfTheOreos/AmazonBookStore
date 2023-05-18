import java.util.List;

public class AttributeAccess
{
    public static boolean hasContentAccess(User user, Book book)
    {
        List <Book> books = user.getPurchasedBooks();
        for (Book aBook : books)
            if (aBook.getIsbn().equals(book.getIsbn()))
                return true;
        return false;
    }

    public static boolean canChangePassword(User user, String currentPassword)
    {
        return currentPassword.equals(user.getPassword());
    }
}
