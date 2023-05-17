import ObjectCredentials.*;



public class Main
{
    public static void main(String[] args)
    {
        User user = new User("AlanWake", new Address("Atlanta", "NJ", "Texas", "4585000"),
                "122344", "alanwake@gmail.com", 200.0);
        Book book = new Book("Aladdin", "J.K Rowling", "1234212341232", "Horror",
                "Yada yada", 50.0, new Date(3, 2, 1996), 2);
        Bookstore bookstore = new Bookstore();
        bookstore.getBooks().add(book);
        bookstore.getUsers().add(user);
        bookstore.purchaseBook(user, book);
        bookstore.addToBasket(user, book);
        System.out.println(user);
        System.out.println(book.displayContent(user));

    }
}