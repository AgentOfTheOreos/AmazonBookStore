import java.io.Serializable;
import java.util.*;

public class Bookstore implements Serializable
{
    private List<User> users;
    private List<Book> books;
    public Bookstore()
    {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
    }
    public List<User> getUsers() {
        return users;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void loadBooksFromFile() {
        ArrayList<?> loadedBooks = (ArrayList<?>) FileHandler.loadDecryptedObject("BookLists/StoreBooks");
        if (loadedBooks != null) {
            ArrayList<Book> books = new ArrayList<>();
            for (Object obj : loadedBooks) {
                if (obj instanceof Book) {
                    books.add((Book) obj);
                }
            }
            this.books = books;
            System.out.println("Books loaded successfully into the store");
        } else {
            System.out.println("Failed to load books from file BookLists/StoreBooks");
        }
    }
    public void loadUsersFromFile() {
        ArrayList<?> loadedUsers = (ArrayList<?>) FileHandler.
                loadDecryptedObject("UserLists/StoreUsers");
        if (loadedUsers != null) {
            ArrayList<User> users = new ArrayList<>();
            for (Object obj : loadedUsers) {
                if (obj instanceof User) {
                    users.add((User) obj);
                }
            }
            this.users = users;
            System.out.println("Users loaded successfully into the store");
        } else {
            System.out.println("Failed to load users from file ObjectFiles/UserLists/StoreUsers");
        }
    }
    public void saveUsersToFile() {
        try {
            String filePath = "StoreUsers";
            FileHandler.saveEncryptedObject(filePath, users);
            System.out.println("Users saved to file: " + filePath);
        } catch (Exception e) {
            System.out.println("Failed to save users to file: " + e.getMessage());
        }
    }
    public void saveBooksToFile() {
        try {
            String filePath = "StoreBooks";
            FileHandler.saveEncryptedObject(filePath, books);
            System.out.println("Books saved to file: " + filePath);
        } catch (Exception e) {
            System.out.println("Failed to save books to file: " + e.getMessage());
        }
    }
    public List<Book> searchBooks(String category, String query) {
        String categoryLowerCase = category.toLowerCase();
        String queryLowerCase = query.toLowerCase();
        List<Book> matchingBooks;

        switch (categoryLowerCase) {
            case "title" -> matchingBooks = books.stream().filter(book ->
                    book.getTitle().toLowerCase().contains(queryLowerCase))
                    .toList();
            case "author" -> matchingBooks = books.stream().filter(book ->
                            book.getAuthor().toLowerCase().contains(queryLowerCase))
                    .toList();
            case "genre" -> matchingBooks = books.stream().filter(book ->
                            book.getGenre().toLowerCase().contains(queryLowerCase))
                    .toList();
            case "price" -> {
                try {
                    double price = Double.parseDouble(query);
                    matchingBooks = books.stream().filter(book ->
                                    book.getPrice() == price)
                            .toList();
                } catch (NumberFormatException ignored) {
                    return null;
                }
            }
            case "year" -> {
                try {
                    int year = Integer.parseInt(query);
                    matchingBooks = books.stream().filter(book ->
                                    book.getReleaseDate().year()
                                            == year)
                            .toList();
                } catch (NumberFormatException ignored) {
                    return null;
                }
            }
            default -> {
                return null;
            }
        }
        if (matchingBooks.isEmpty())
            return null;
        else return matchingBooks;
    }
    public List<Book> searchBooksByRange(String category, int min, int max) {
        List<Book> matchingBooks;
        switch (category) {
            case "price" -> matchingBooks = books
                    .stream()
                    .filter(aBook -> aBook.getPrice() >= min &&
                            aBook.getPrice() <= max).toList();
            case "year" -> matchingBooks = books
                    .stream()
                    .filter(aBook -> aBook.getReleaseDate().year() >= min &&
                            aBook.getReleaseDate().year() <= max).toList();
            default -> {
                return null;
            }
        }
        if (matchingBooks.isEmpty())
            return null;
        else return matchingBooks;
    }
    public Book searchBookByISBN(String isbn) {
        return books
                .stream()
                .filter(aBook -> aBook.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
    public boolean purchaseBook(User user, Book book) {
        if (user.getPurchasedBooks().contains(book)){
            System.out.println("You already own this book!");
            return false;
        }
        Book matchingBook = books
                .stream()
                .filter(aBook -> aBook.equals(book))
                .findAny()
                .orElse(null);
        if (matchingBook == null) {
            System.out.println("Book does not exist in store. :(");
            return false;
        }
        double balance = user.getBalance();
        double price = matchingBook.getPrice();
        int stock = matchingBook.getStock();

        if (stock <= 0) {
            System.out.println("Book is out of stock. Please check again later :(.");
            return false;
        }

        if (balance >= price) {
            // Mark the book as purchased by the user
            matchingBook.setPurchasedByUser(user, true);
            // Update user's balance
            user.setBalance(balance - price);
            // Add the book to the user's list of purchased books
            user.getPurchasedBooks().add(matchingBook);
            // Update stock in store
            matchingBook.setStock(stock - 1);
            System.out.println("Book '" + matchingBook.getTitle() + "' purchased and added to account successfully! :)");
            return true;
        } else {
            System.out.println("Not enough funds to purchase the book." +
                    " But not all is lost, we're constantly adding new books to the store! :)");
            return false;
        }
    }
    public boolean addToBasket(User user, Book book) {
        if (user.getBasket().contains(book))
        {
            System.out.println("The book already exists in your basket.");
            return false;
        }
        if (books.contains(book)) {
            user.getBasket().add(book);
            System.out.println("The Book has been added to the basket successfully! :)");
            return true;
        }
        System.out.println("The book does not exist in the store. :(");
        return false;
    }
    // We use StringBuilder in this case due to the possibility of the returned string being overly long, as we are
    // dealing with arrays of objects, each object with a multitude of attributes
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bookstore{\n");

        sb.append("Users:\n");
        for (User user : users)
            sb.append(user.toString()).append("\n");

        sb.append("Books:\n");
        for (Book book : books)
            sb.append(book.toString()).append("\n");

        sb.append("}");

        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookstore bookstore = (Bookstore) o;
        return Objects.equals(users, bookstore.getUsers()) && Objects.equals(books, bookstore.getBooks());
    }
    @Override
    public int hashCode() {
        return Objects.hash(users, books);
    }
}