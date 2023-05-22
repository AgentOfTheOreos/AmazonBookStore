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

    public Bookstore(ArrayList<User> users, ArrayList<Book> books)
    {
        this.users = users;
        this.books = books;
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
        List<Book> matchingBooks = new ArrayList<>();

        switch (categoryLowerCase) {
            case "title" -> {
                for (Book book : books)
                    if (book.getTitle().contains(query))
                        matchingBooks.add(book);
                return matchingBooks;
            }
            case "author" -> {
                for (Book book : books)
                    if (book.getAuthor().contains(query))
                        matchingBooks.add(book);
                return matchingBooks;
            }
            case "genre" -> {
                for (Book book : books)
                    if (book.getGenre().contains(query))
                        matchingBooks.add(book);
                return matchingBooks;
            }
            case "price" -> {
                try {
                    double price = Double.parseDouble(query);
                    for (Book book : books)
                        if (book.getPrice() == price)
                            matchingBooks.add(book);
                    return matchingBooks;
                } catch (NumberFormatException ignored) {
                    return null;
                }
            }
            case "year" -> {
                try {
                    int year = Integer.parseInt(query);
                    for (Book book : books)
                        if (book.getReleaseDate().getYear() == year)
                            matchingBooks.add(book);
                    return matchingBooks;
                } catch (NumberFormatException ignored) {
                    return null;
                }
            }
            default -> {
                return null;
            }
        }
    }

    public List<Book> searchBooksByRange(String category, int min, int max)
    {
        List<Book> matchingBooks = new ArrayList<>();
        switch (category) {
            case "price" -> {
                for (Book book : books)
                    if (book.getPrice() >= min && book.getPrice() <= max)
                        matchingBooks.add(book);
                return matchingBooks;
            }
            case "year" -> {
                for (Book book : books)
                    if (book.getReleaseDate().getYear() >= min && book.getReleaseDate().getYear() <= max)
                        matchingBooks.add(book);
                return matchingBooks;
            }
            default -> {
                return null;
            }
        }
    }

    public Book searchBookByISBN(String isbn)
    {
        for (Book book : books)
            if (book.getIsbn().equals(isbn))
                return book;
        return null;
    }

    public User getUser(String email, String password) {
        for (User user : users)
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
                return user;
        return null;
    }

    public void purchaseBook(User user, Book book) {
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
                    // Update user's purchased books file
                    String filePath = "UserPurchaseHistory/" + user.getEmail() + "'s Purchased Books";
                    FileHandler.saveEncryptedObject(filePath, user.getPurchasedBooks());
                    // Update stock in store
                    aBook.setStock(stock - 1);
                    System.out.println("Book purchased and added to account successfully.");
                    return;
                } else {throw new IllegalStateException("Not enough funds to purchase.");}
            }
        }
        throw new IllegalArgumentException("Book does not exist in store.");
    }

    public void addToBasket(User user, Book book) {
        if (user.getBasket().contains(book))
        {
            System.out.println("The book already exists in your basket.");
            return;
        }
        if (books.contains(book)) {
            user.getBasket().add(book);
            System.out.println("The Book has been added to the basket successfully.");
            return;
        }
        System.out.println("The book does not exist in the store.");
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