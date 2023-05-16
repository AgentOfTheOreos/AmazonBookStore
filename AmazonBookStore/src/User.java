import java.util.List;
import java.util.Objects;

class User
{
    private String username;
    private Address address;
    private String password;
    private String email;
    private List<Book> purchasedBooks;
    private List<Book> basket;

    public User(String username, Address address, String password, String email,
                List<Book> purchasedBooks, List<Book> basket) {
        this.username = username;
        this.address = address;
        this.password = password;
        this.email = email;
        this.purchasedBooks = purchasedBooks;
        this.basket = basket;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(List<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public List<Book> getBasket() {
        return basket;
    }

    public void setBasket(List<Book> basket) {
        this.basket = basket;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Extra methods
    public void displayDetails() {
        System.out.println("User Details:");
        System.out.println(toString());

        System.out.println("Purchased Books:");
        for (Book book : purchasedBooks) {
            System.out.println(book.toString());
        }

        System.out.println("Books in Basket:");
        for (Book book : basket) {
            System.out.println(book.toString());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address=" + address +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", purchaseHistory=" + purchasedBooks +
                ", basket=" + basket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.getUsername())
                && Objects.equals(address, user.getAddress())
                && Objects.equals(password, user.getPassword())
                && Objects.equals(email, user.getEmail())
                && Objects.equals(purchasedBooks, user.getPurchasedBooks())
                && Objects.equals(basket, user.getBasket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, address, password, email, purchasedBooks, basket);
    }
}