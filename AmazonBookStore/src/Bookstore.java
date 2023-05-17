import java.security.GeneralSecurityException;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import EncryptionDecryption.EncryptionUtils;

public class Bookstore
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

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Extra methods
    public ArrayList<Book> searchBooks(String query) {
        ArrayList<Book> matchingBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) ||
                    book.getAuthor().equalsIgnoreCase(query) ||
                    book.getIsbn().equalsIgnoreCase(query) ||
                    book.getGenre().equalsIgnoreCase(query) ||
                    String.valueOf(book.getPrice()).equalsIgnoreCase(query) ||
                    book.getReleaseDate().getYear() == (Integer.parseInt(query))) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public Book searchBook(String category, String query) {
        String categoryLowerCase = category.toLowerCase();

        switch (categoryLowerCase) {
            case "title" -> {
                return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(query)).findFirst()
                        .orElse(null);
            }
            case "author" -> {
                return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(query)).findFirst()
                        .orElse(null);
            }
            case "isbn" -> {
                return books.stream().filter(book -> book.getIsbn().equalsIgnoreCase(query)).findFirst()
                        .orElse(null);
            }
            case "genre" -> {
                return books.stream().filter(book -> book.getGenre().equalsIgnoreCase(query)).findFirst()
                        .orElse(null);
            }
            case "price" -> {
                try {
                    double price = Double.parseDouble(query);
                    return books.stream().filter(book -> book.getPrice() == price).findFirst()
                            .orElse(null);
                } catch (NumberFormatException ignored) {
                    return null;
                }
            }
            case "year" -> {
                try {
                    int year = Integer.parseInt(query);
                    return books.stream().filter(book -> book.getReleaseDate().getYear() == year).findFirst()
                            .orElse(null);
                } catch (NumberFormatException ignored) {
                    return null;
                }
            }
            default -> {
                return null;
            }
        }
    }

    public User getUser(String email, String password) {
        for (User user : users)
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
                return user;
        return null;
    }

    public boolean purchaseBook(User user, Book book) {
        for (Book aBook : books) {
            if (aBook.equals(book)) {
                double balance = user.getBalance();
                double price = aBook.getPrice();
                int stock = aBook.getStock();

                if (stock == 0) {
                    throw new IllegalStateException("Book is out of stock.");
                }

                if (balance >= price) {
                    // Mark the book as purchased by the user
                    aBook.setPurchasedByUser(user, true);

                    // Update user's balance
                    user.setBalance(balance - price);

                    // Add the book to the user's list of purchased books
                    user.getPurchasedBooks().add(aBook);

                    // Update stock in store
                    aBook.setStock(stock - 1);

                    // updatePurchaseFile(user); possible implementation

                    System.out.println("Book purchased and added to account successfully.");
                    return true;
                } else {
                    throw new IllegalStateException("Not enough funds to purchase.");
                }
            }
        }

        throw new IllegalArgumentException("Book does not exist in store.");
    }

    public boolean addToBasket(User user, Book book) {
        if (user.getBasket().contains(book))
        {
            System.out.println("The book already exists in your basket.");
            return false;
        }
        if (books.contains(book)) {
            user.getBasket().add(book);
            System.out.println("The Book has been added to the basket successfully.");
            return true;
        }
        System.out.println("The book does not exist in the store.");
        return false;
    }

    public void loadBooksFromFile(String filename) {
        try {
            byte[] encryptedData = Files.readAllBytes(Path.of(filename));
            byte[] decryptedData = EncryptionUtils.decryptData(encryptedData);
            String bookData = new String(decryptedData, StandardCharsets.UTF_8);

            // Parse the book data and add books to the list
            List<Book> loadedBooks = ObjectParse.parseBooks(bookData);
            books.addAll(loadedBooks);

            System.out.println("Books loaded from file successfully.");
        } catch (IOException | GeneralSecurityException e) {
            System.out.println("Failed to load books from file: " + e.getMessage());
        }
    }

    public void loadUsersFromFile(String filename) {
        try {
            byte[] encryptedData = Files.readAllBytes(Path.of(filename));
            byte[] decryptedData = EncryptionUtils.decryptData(encryptedData);
            String userData = new String(decryptedData, StandardCharsets.UTF_8);

            // Parse the user data and add users to the list
            List<User> loadedUsers = ObjectParse.parseUsers(userData);
            users.addAll(loadedUsers);

            System.out.println("Users loaded from file successfully.");
        } catch (IOException | GeneralSecurityException e) {
            System.out.println("Failed to load users from file: " + e.getMessage());
        }
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