import ObjectCredentials.*;


public class Main
{
    public static void main(String[] args)
    {
        User user = new User("AlanWake", new Address("Atlanta", "NJ", "Texas", "4585000"),
                "122344", "alanwake@gmail.com", 200.0);
        User user1 = new User("HaramSake", new Address("Nevada", "NY", "Texas", "4585000"),
                "122344", "alanwake@gmail.com", 1000.0);
        User user2 = new User("Harambote", new Address("ZooLand", "NoWhere", "Texas", "4585000"),
                "122344", "alanwake@gmail.com", 10000.0);
        Book book = new Book("Aladdin", "J.K Rowling", "1234212341232", "Horror",
                "Yada yada", 50.0, new Date(3, 2, 1996), 2);
        Book book1 = new Book("HumusFalafel", "Elyahu", "1234212341232", "Horror",
                "Yada yada", 60.0, new Date(3, 2, 1996), 2);
        Book book2 = new Book("HorribleStench", "Gombler", "1234212341232", "Horror",
                "Yada yada", 100.0, new Date(3, 2, 1996), 2);
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
        FileHandler.saveEncryptedObject("StoreBooks", bookstore.getBooks());
        bookstore.getBooks().get(0).setPrice(5000.0);
        System.out.println(bookstore);
        bookstore.loadBooksFromFile();
        System.out.println(bookstore);
    }
}