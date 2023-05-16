import java.util.ArrayList;
import java.util.List;

class User
{
    private String username;
    private String password;
    private List<Book> purchaseHistory;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.purchaseHistory = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}