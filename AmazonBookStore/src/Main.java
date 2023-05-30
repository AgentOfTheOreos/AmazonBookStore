//import ObjectCredentials.*;

public class Main
{
    public static void main(String[] args)
    {
        /*User user = new User("AlanWake", new Address("Atlanta", "NJ", "Texas",
                "4585000"), "122344", "alanwake@gmail.com", 4620.0, false, new Date(2, 5, 1990));
        User user1 = new User("HarmSake", new Address("Nevada", "NY", "Texas",
                "4585000"), "233455", "harmsake@gmail.com", 5730.0, false, new Date(5, 1, 1996));
        User user2 = new User("Harbormaster", new Address("ZooLand", "NoWhere", "Texas",
                "4585000"), "344566", "harbmast@gmail.com", 7210.0, true, new Date(3, 6, 2001));
        User user3 = new User("jesusScotty", new Address("Yorkshire shrine", "Wellington", "United Kingdom",
                "423212"), "455677", "jessie@gmail.com", 9043.0, false, new Date(12, 9, 1992));
        User admin =  new User("gilbertgrape", new Address("Antis", "New shireton", "Arkansas", "5232123"),
            "12345", "gilbert@gmail.com", 6500, true, new Date(4, 6, 1975));
        Book book = new Book("Harry Potter and the Philosopher's Stone", "J.K Rowling", "1212121212121", "Horror",
                "Once upon a time...", 49.99, new Date(12, 2, 1996), 25);
        Book book1 = new Book("Devils 'round the holy table", "Elyane Austin", "2323232323232", "Fantasy",
                "In the oldened kingdom of Alvin the great...", 59.99, new Date(27, 5, 1996), 35);
        Book book2 = new Book("Infinity Pool", "Scotty S. Michaele", "4545454545454", "Mystery",
                "It was time for us to...", 99.99, new Date(11, 12, 1980), 65);
        Book book3 = new Book("Blade runner 2099", "Suttner Albert", "5656565656565", "Crime Detective",
                "Skyscrapers as high as heaven...", 119.99, new Date(24, 4, 1971), 44);
        Book book4 = new Book("My life in a bottle", "Steven L. Casper", "6767676767676", "Drama",
                "Oh silly me...", 119.99, new Date(21, 7, 2005), 53);
        Book book5 = new Book("Julius Caesar's Legacy", "Herodotus", "7878787878787", "History",
                "In the capital of great Rome once...", 109.99, new Date(8, 7, 255), 31);
        Book book6 = new Book("The key to success - ignorance", "Patrick S. Schnapps", "8989898989898", "Social Study",
                "Ever knew the true meaning of...", 104.99, new Date(6, 6, 2011), 68);
        Book book7 = new Book("Turing Machines and Autonomous Systems", "James Heartland", "9090909090909", "Computer Science",
                "And we thought it impossible to...", 169.99, new Date(3, 4, 2015), 87);
        Book book8 = new Book("We come from the stars", "J. Luke Jameson", "1234567890123", "Physics",
                "Stardust is the essence of all of our...", 129.99, new Date(17, 7, 2017), 50);
        Book book9 = new Book("Flavours of irony", "Jerry Seinfeld", "2345678901234", "Comedy",
                "Let me start off by saying...", 94.99, new Date(13, 11, 2008), 115);
        Book book10 = new Book("13 Days of bliss", "Jane Jordan", "3456789012345", "Romance",
                "It was a pretty tame summer...", 184.99, new Date(14, 9, 2002), 120);
        Book book11 = new Book("Django the sharpshooter", "Luciano Adrianne", "4567890123456", "Western Spaghetti",
                "Arizona, the land of freedom...?", 104.99, new Date(17, 8, 1996), 111);
        Bookstore bookstore = new Bookstore();
        bookstore.getBooks().add(book);
        bookstore.getBooks().add(book1);
        bookstore.getBooks().add(book2);
        bookstore.getBooks().add(book3);
        bookstore.getBooks().add(book4);
        bookstore.getBooks().add(book5);
        bookstore.getBooks().add(book6);
        bookstore.getBooks().add(book7);
        bookstore.getBooks().add(book8);
        bookstore.getBooks().add(book9);
        bookstore.getBooks().add(book10);
        bookstore.getBooks().add(book11);
        bookstore.getUsers().add(user);
        bookstore.getUsers().add(user1);
        bookstore.getUsers().add(user2);
        bookstore.getUsers().add(user3);
        bookstore.getUsers().add(admin);
        bookstore.saveBooksToFile();
        bookstore.saveUsersToFile();*/
       MenuManager menuManager = new MenuManager();
       menuManager.initializeStore();
        /*int[][] mat = new int[][]
                {
                {1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2},
                {1, 2, 3, 3, 3},
                {1, 2, 3, 4, 4},
                {1, 2, 3, 4, 5}};
        System.out.println(isSquareMatrixAlt(mat, 0, 0));*/
    }

    /*public static int isSquareMatrix(int[][] mat, int corner) {
        if (corner == mat.length - 1)
            return mat[corner][corner];
        for (int row = corner; row < mat.length; row++) {
            if (mat[row][corner] != mat[corner][corner])
                return -1;
        }
        for (int column = corner; column < mat[corner].length; column++){
            if (mat[corner][column] != mat[corner][corner])
                return -1;
        }
        return isSquareMatrix(mat, corner+1);
    }
    public static boolean isSquareMatrixAlt(int[][] mat, int row, int col) {
        if (row == mat.length - 1 && col == mat[0].length - 1)
            return true;

        if (row >= mat.length || col >= mat[0].length || mat[row][col] != mat[0][0])
            return false;

        return isSquareMatrixAlt(mat, row, col + 1) && isSquareMatrixAlt(mat, row + 1, col);
    }*/
}