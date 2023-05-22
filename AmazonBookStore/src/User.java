import CredentialValidation.PasswordValidator;
import ObjectCredentials.Address;
import ObjectCredentials.Date;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable
{
    private String username;
    private Address address;
    private String password;
    private String email;
    private double balance;
    private List<Book> purchasedBooks;
    private List<Book> basket;
    private boolean isAdmin;
    private Date birthDate;

    public User(String username, Address address, String password, String email, double balance, boolean isAdmin, Date birthdate) {
        this.username = username;
        this.address = address;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.purchasedBooks = new ArrayList<>();
        this.basket = new ArrayList<>();
        this.isAdmin = isAdmin;
        this.birthDate = birthdate;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Extra methods
    public void displayDetails() {
        System.out.println(this);
    }

    // In order to further enhance security, the possibility of displaying the user's sensitive
    // credentials such as passwords as a string is not included in the toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User {");
        sb.append("\nUsername: '").append(username).append('\'');
        sb.append("\n").append(address);
        sb.append("\nEmail Address: '").append(email).append('\'');
        sb.append("\nAccount Balance: ").append('$').append(balance);
        if (!purchasedBooks.isEmpty())
            sb.append("\nPurchased Books List: ").append(purchasedBooks);

        if (!basket.isEmpty()) {
            sb.append("\nBasket: [");
            for (int i = 0; i < basket.size(); i++) {
                Book book = basket.get(i);
                sb.append(book.getTitle());
                if (i < basket.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }

        sb.append("\nAdmin Status: ").append(isAdmin).append('\'');
        sb.append("\nBirth Date: '").append(birthDate).append('\'');
        sb.append("\n}");

        return sb.toString();
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
                && Objects.equals(basket, user.getBasket())
                && Objects.equals(balance, user.getBalance())
                && Objects.equals(isAdmin, user.isAdmin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, address, password, email, balance, purchasedBooks, basket, isAdmin);
    }

}