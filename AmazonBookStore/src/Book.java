import java.util.*;
import java.io.*;

class Book
{
    private String title;
    private String author;
    private String isbn;
    private double price;

    public Book(String title, String author, String isbn, double price)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }



    public String getTitle()
    {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice()
    {
        return price;
    }
}