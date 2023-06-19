package DataModels;
//import DataModels.ObjectCredentials.*;

import DataModels.Managers.MenuManager;

public class Main {
    public static void main(String[] args) {
        // NOTE: If you want to run this project, you must first create a save file containing the required lists.
        // In order to create the file, uncomment lines from 11-64, as well as line 2. And then turn lines 65-66 to
        // Comment and run the program
        /*DataModels.User user = new DataModels.User("AlanWake", new Address("Atlanta", "NJ", "Texas",
                "4585000"), "122344", "alanwake@gmail.com", 4620.0, false, new Date(2, 5, 1990));
        DataModels.User user1 = new DataModels.User("HarmSake", new Address("Nevada", "NY", "Texas",
                "4585000"), "233455", "harmsake@gmail.com", 5730.0, false, new Date(5, 1, 1996));
        DataModels.User user2 = new DataModels.User("Harbormaster", new Address("ZooLand", "NoWhere", "Texas",
                "4585000"), "344566", "harbmast@gmail.com", 7210.0, true, new Date(3, 6, 2001));
        DataModels.User user3 = new DataModels.User("jesusScotty", new Address("Yorkshire shrine", "Wellington", "United Kingdom",
                "423212"), "455677", "jessie@gmail.com", 9043.0, false, new Date(12, 9, 1992));
        DataModels.User admin =  new DataModels.User("gilbertgrape", new Address("Antis", "New shireton", "Arkansas", "5232123"),
            "12345", "gilbert@gmail.com", 6500, true, new Date(4, 6, 1975));
        DataModels.Book book = new DataModels.Book("Harry Potter and the Philosopher's Stone", "J.K Rowling", "1212121212121", "Horror",
                "Once upon a time...", 49.99, new Date(12, 2, 1996), 25);
        DataModels.Book book1 = new DataModels.Book("Devils 'round the holy table", "Elyane Austin", "2323232323232", "Fantasy",
                "In the oldened kingdom of Alvin the great...", 59.99, new Date(27, 5, 1996), 35);
        DataModels.Book book2 = new DataModels.Book("Infinity Pool", "Scotty S. Michaele", "4545454545454", "Mystery",
                "It was time for us to...", 99.99, new Date(11, 12, 1980), 65);
        DataModels.Book book3 = new DataModels.Book("Blade runner 2099", "Suttner Albert", "5656565656565", "Crime Detective",
                "Skyscrapers as high as heaven...", 119.99, new Date(24, 4, 1971), 44);
        DataModels.Book book4 = new DataModels.Book("My life in a bottle", "Steven L. Casper", "6767676767676", "Drama",
                "Oh silly me...", 119.99, new Date(21, 7, 2005), 53);
        DataModels.Book book5 = new DataModels.Book("Julius Caesar's Legacy", "Herodotus", "7878787878787", "History",
                "In the capital of great Rome once...", 109.99, new Date(8, 7, 255), 31);
        DataModels.Book book6 = new DataModels.Book("The key to success - ignorance", "Patrick S. Schnapps", "8989898989898", "Social Study",
                "Ever knew the true meaning of...", 104.99, new Date(6, 6, 2011), 68);
        DataModels.Book book7 = new DataModels.Book("Turing Machines and Autonomous Systems", "James Heartland", "9090909090909", "Computer Science",
                "And we thought it impossible to...", 169.99, new Date(3, 4, 2015), 87);
        DataModels.Book book8 = new DataModels.Book("We come from the stars", "J. Luke Jameson", "1234567890123", "Physics",
                "Stardust is the essence of all of our...", 129.99, new Date(17, 7, 2017), 50);
        DataModels.Book book9 = new DataModels.Book("Flavours of irony", "Jerry Seinfeld", "2345678901234", "Comedy",
                "Let me start off by saying...", 94.99, new Date(13, 11, 2008), 115);
        DataModels.Book book10 = new DataModels.Book("13 Days of bliss", "Jane Jordan", "3456789012345", "Romance",
                "It was a pretty tame summer...", 184.99, new Date(14, 9, 2002), 120);
        DataModels.Book book11 = new DataModels.Book("Django the sharpshooter", "Luciano Adrianne", "4567890123456", "Western Spaghetti",
                "Arizona, the land of freedom...?", 104.99, new Date(17, 8, 1996), 111);
        DataModels.Bookstore bookstore = new DataModels.Bookstore();
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
    }
}