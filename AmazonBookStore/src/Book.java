import ObjectCredentials.Date;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book implements Serializable
{
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String content;
    private double price;
    private Date releaseDate;
    private int stock;
    private Map<User, Boolean> purchasedByUsers;

    public Book(String title, String author, String isbn, String genre,
                String content, double price, Date releaseDate, int stock)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.content = content;
        this.price = price;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.purchasedByUsers = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Map<User, Boolean> getPurchasedByUsers() {
        return purchasedByUsers;
    }

    public void setPurchasedByUser(User user, boolean purchased) {
        purchasedByUsers.put(user, purchased);
    }

    // Extra Methods
    public void displayDetails() {
        System.out.println(this);
    }

    public boolean displayContent(User user)
    {
        if (AttributeAccess.hasContentAccess(user, this))
        {
            System.out.println(content);
            return true;
        }
        System.out.println("You must purchase the book first to view its contents");
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                " Title: '" + title + '\'' +
                ", Author: '" + author + '\'' +
                ", ISBN Code: '" + isbn + '\'' +
                ", Genre: '" + genre + '\'' +
                ", Price: " + '$' + price +
                ", Release Date: " + releaseDate + '\'' +
                ", Stock: " + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(book.getPrice(), price) && Objects.equals(title, book.getTitle()) &&
                Objects.equals(author, book.getAuthor()) && Objects.equals(isbn, book.getIsbn()) &&
                Objects.equals(genre, book.getGenre()) && Objects.equals(content, book.getContent()) &&
                Objects.equals(releaseDate, book.getReleaseDate()) &&
                Objects.equals(purchasedByUsers, book.getPurchasedByUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn, genre, price, releaseDate, stock, purchasedByUsers);
    }
}