import java.util.ArrayList;
import java.util.List;
import ObjectCredentials.Date;
import ObjectCredentials.Address;

public class ObjectParse {
    public static List<Book> parseBooks(String bookData) {
        List<Book> parsedBooks = new ArrayList<>();

        // Split the bookData string into individual book entries
        String[] bookEntries = bookData.split(";");

        for (String bookEntry : bookEntries) {
            // Split each book entry into individual attributes
            String[] attributes = bookEntry.split(",");

            // Extract the attributes and create a Book object
            String title = attributes[0];
            String author = attributes[1];
            String isbn = attributes[2];
            String genre = attributes[3];
            String content = attributes[4];
            double price = Double.parseDouble(attributes[5]);
            int day = Integer.parseInt(attributes[6]);
            int month = Integer.parseInt(attributes[7]);
            int year = Integer.parseInt(attributes[8]);
            int stock = Integer.parseInt(attributes[9]);

            // Create a Date object using the appropriate constructor or factory method
            Date releaseDate = new Date(day, month, year);

            Book book = new Book(title, author, isbn, genre, content, price, releaseDate, stock);

            parsedBooks.add(book);
        }

        return parsedBooks;
    }

    public static List<User> parseUsers(String userData) {
        List<User> parsedUsers = new ArrayList<>();

        // Split the userData string into individual user entries
        String[] userEntries = userData.split(";");

        for (String userEntry : userEntries) {
            // Split each user entry into individual attributes
            String[] attributes = userEntry.split(",");

            // Extract the attributes and create a User object
            String username = attributes[0];
            String password = attributes[1];
            String email = attributes[2];
            double balance = Double.parseDouble(attributes[3]);

            // Assuming the address information is stored as a comma-separated string
            String addressString = attributes[4];
            String[] addressAttributes = addressString.split("/");
            String street = addressAttributes[0];
            String city = addressAttributes[1];
            String state = addressAttributes[2];
            String postalCode = addressAttributes[3];
            Address address = new Address(street, city, state, postalCode);

            User user = new User(username, address, password, email, balance);

            parsedUsers.add(user);
        }

        return parsedUsers;
    }
}
