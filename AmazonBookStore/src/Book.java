import java.util.Objects;

class Book
{
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private double price;
    private Date releaseDate;

    public Book(String title, String author, String isbn, String genre, double price, Date releaseDate)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.price = price;
        this.releaseDate = releaseDate;
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

    // Extra Methods
    public void displayDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price + '$' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(book.getPrice(), price) && Objects.equals(title, book.getTitle()) &&
                Objects.equals(author, book.getAuthor()) && Objects.equals(isbn, book.getIsbn()) &&
                Objects.equals(genre, book.getGenre()) && Objects.equals(releaseDate, book.getReleaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn, genre, price, releaseDate);
    }
}