import ObjectCredentials.*;

public class Main
{
    public static void main(String[] args)
    {
        /*
        User user = new User("AlanWake", new Address("Atlanta", "NJ", "Texas",
                "4585000"), "122344", "alanwake@gmail.com", 200.0, false, new Date(2, 1, 1990));
        User user1 = new User("HarmSake", new Address("Nevada", "NY", "Texas",
                "4585000"), "122344", "alanwake@gmail.com", 1000.0, false, new Date(5, 1, 1996));
        User user2 = new User("Harbormaster", new Address("ZooLand", "NoWhere", "Texas",
                "4585000"), "122344", "alanwake@gmail.com", 10000.0, true, new Date(3, 6, 2001));

        Book book = new Book("Aladdin", "J.K Rowling", "1234212341232", "Horror",
                "Dada Dada", 50.0, new Date(3, 2, 1996), 2);
        Book book1 = new Book("HumusRafaela", "Elyane", "1234212341232", "Horror",
                "Dada Dada", 60.0, new Date(3, 2, 1996), 2);
        Book book2 = new Book("HorribleStench", "Gambler", "1234212341232", "Horror",
                "Yad Dada", 100.0, new Date(3, 2, 1996), 2);
        Bookstore bookstore = new Bookstore();
        bookstore.getBooks().add(book);
        bookstore.getBooks().add(book1);
        bookstore.getBooks().add(book2);
        bookstore.getUsers().add(user);
        bookstore.getUsers().add(user1);
        bookstore.getUsers().add(user2);
        bookstore.purchaseBook(user, book);
        bookstore.addToBasket(user, book);
        System.out.println(user);
        System.out.println(bookstore);
        bookstore.saveBooksToFile();
        bookstore.getBooks().get(0).setPrice(5000.0);
        System.out.println(bookstore);
        bookstore.loadBooksFromFile();
        System.out.println(bookstore);
        bookstore.saveUsersToFile();
        bookstore.loadUsersFromFile();
         */
        MenuManager menuManager = new MenuManager();
        menuManager.initializeStore();
    }

}