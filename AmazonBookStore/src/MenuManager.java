import ObjectCredentials.Address;
import ObjectCredentials.Date;
import Visuals.ConsoleColors;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MenuManager
{
    public static final Scanner INPUT = new Scanner(System.in);
    private final Bookstore bookstore;
    public MenuManager() {
        bookstore = new Bookstore();
        bookstore.loadUsersFromFile();
        bookstore.loadBooksFromFile();
    }
    public void initializeStore() {
        System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
        System.out.println("_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_");
        System.out.println("^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^");
        System.out.println("""
                                       d8b                                                      \s
                                       88P                                            d8P       \s
                                      d88                                          d888888P     \s
                 ?88   d8P  d8P d8888b888   d8888b d8888b   88bd8b,d88b  d8888b      ?88' d8888b\s
                 d88  d8P' d8P'd8b_,dP?88  d8P' `Pd8P' ?88  88P'`?8P'?8bd8b_,dP      88P d8P' ?88
                 ?8b ,88b ,88' 88b     88b 88b    88b  d88 d88  d88  88P88b          88b 88b  d88
                 `?888P'888P'  `?888P'  88b`?888P'`?8888P'd88' d88'  88b`?888P'      `?8b`?8888P'\
                """);
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + """
                                                                                          ,,                                                 \s
                                              db                                         *MM                            `7MM               OO\s
                                             ;MM:                                         MM                              MM               88\s
                                            ,V^MM.    `7MMpMMMb.pMMMb.   ,6"Yb.  M""\"MMV  MM,dMMb.   ,pW"Wq.   ,pW"Wq.    MM  ,MP',pP"Ybd  ||\s
                                           ,M  `MM      MM    MM    MM  8)   MM  '  AMV   MM    `Mb 6W'   `Wb 6W'   `Wb   MM ;Y   8I   `"  ||\s
                                           AbmmmqMA     MM    MM    MM   ,pm9MM    AMV    MM     M8 8M     M8 8M     M8   MM;Mm   `YMMMa.  `'\s
                                          A'     VML    MM    MM    MM  8M   MM   AMV  ,  MM.   ,M9 YA.   ,A9 YA.   ,A9   MM `Mb. L.   I8  ,,\s
                                        .AMA.   .AMMA..JMML  JMML  JMML.`Moo9^Yo.AMMmmmM  P^YbmdP'   `Ybmd9'   `Ybmd9'  .JMML. YA.M9mmmP'  db \s
                """ + ConsoleColors.RESET);
        System.out.println("""
                                                            ||-------------------------------------------------------||
                                                            ||.--.    .-._                        .----.             ||
                                                            |||==|____| |H|___            .---.___|""\""|_____.--.___ ||
                                                            |||  |====| | |xxx|_          |+++|=-=|_  _|-=+=-|==|---|||
                                                            |||==|    | | |   | \\         |   |   |_\\/_|Black|  | ^ |||
                                                            |||  |    | | |   |\\ \\   .--. |   |=-=|_/\\_|-=+=-|  | ^ |||
                                                            |||  |    | | |   |_\\ \\_( oo )|   |   |    |Magus|  | ^ |||
                                                            |||==|====| |H|xxx|  \\ \\ |''| |+++|=-=|""\""|-=+=-|==|---|||
                                                            ||`--^----'-^-^---'   `-' ""  '---^---^----^-----^--^---^||
                                                            ||-------------------------------------------------------||
                                                            ||-------------------------------------------------------||
                                                            ||               ___                   .-.__.-----. .---.||
                                                            ||              |===| .---.   __   .---| |XX|<(*)>|_|^^^|||
                                                            ||         ,  /(|   |_|III|__|''|__|:x:|=|  |     |=| Q |||
                                                            ||      _a'{ / (|===|+|   |++|  |==|   | |  |Illum| | R |||
                                                            ||      '/\\\\/ _(|===|-|   |  |''|  |:x:|=|  |inati| | Y |||
                                                            ||_____  -\\{___(|   |-|   |  |  |  |   | |  |     | | Z |||
                                                            ||       _(____)|===|+|[I]|DK|''|==|:x:|=|XX|<(*)>|=|^^^|||
                                                            ||              `---^-^---^--^--'--^---^-^--^-----^-^---^||
                                                            ||-------------------------------------------------------||
                                                            ||_______________________________________________________||
                """);
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "Provided by \uD835\uDD38\uD835\uDD5E\uD835\uDD52\uD835\uDD6B\uD835\uDD60\uD835\uDD5F®" + ConsoleColors.RESET);
        System.out.println("_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_");
        System.out.println("^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^");
        System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
        displayHomeMenu();
    }
    public void displayHomeMenu() {
        try {
            boolean isValidChoice = false;
            int choice;

            while (!isValidChoice) {
                System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰" + ConsoleColors.BLUE_BRIGHT + "Welcome! Please pick an option" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹══");
                System.out.println("1. I would like to Login.");
                System.out.println("2. I would like to create a new Amazbooks account and become awesome!");
                System.out.println("3. I'm too busy to be awesome :( (Exit).");
                System.out.print("Enter your choice: ");
                choice = INPUT.nextInt();
                System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

                switch (choice) {
                    case 1 -> {
                        // Perform login logic
                        displayLoginMenu();
                        isValidChoice = true;
                    }
                    case 2 -> {
                        // Perform register logic
                        displayRegisterMenu();
                        isValidChoice = true;
                    }
                    case 3 -> {
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.YELLOW + "Thank you for using Amazbooks! 'Till next time, buddy!" + ConsoleColors.RESET + "==x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/");
                        System.out.println("............................................................." + ConsoleColors.WHITE + "Exiting" + ConsoleColors.RESET + "..........................................................");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayHomeMenu();
                    }
                }
            }
        }
        catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void displayLoginMenu() {
        try {
            System.out.print("Please enter your email address: ");
            String email = INPUT.next();
            System.out.print("Please enter your password: ");
            String password = INPUT.next();
            System.out.println("........................................................" + ConsoleColors.WHITE + "Verifying your credentials, one moment" + ConsoleColors.RESET + "............................................");
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            User currentUser = LoginManager.login(bookstore, email, password);

            if (currentUser == null) {
                if (promptRetryBool()) {
                    displayLoginMenu();
                }
                else displayHomeMenu();
            } else displayMainMenu(currentUser);
        }
        catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void displayMainMenu(User user) {
        try {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Welcome back " +  ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + "! How may we assist you today?" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. I want to view my library.");
            System.out.println("2. I want to browse the store.");
            System.out.println("3. I want to view my details.");
            System.out.println("4. I want to logout of my account.");
            System.out.println("5. I want to change my password.");
            System.out.println("6. I want to delete my account.");
            System.out.println("7. I'm an administrator and want to access advanced settings.");
            System.out.print("Enter your choice: ");
            int choice = INPUT.nextInt();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            // Handle user input for main menu
            switch (choice) {
                case 1 -> {
                    if (user.getPurchasedBooks().isEmpty()) {
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "It would seem your library's empty :(" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMainMenu(user);
                    }
                    else displaySearchMenu(user);
                }
                case 2 -> displayPurchaseMenu(user);
                case 3 -> {
                    System.out.println("...................................." + ConsoleColors.WHITE + "Loading up your details" + ConsoleColors.RESET + ".....................................");
                    System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════");
                    user.displayDetails();
                    System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════");
                    displayMainMenu(user);
                }
                case 4 -> {
                    System.out.println("...................................." + ConsoleColors.WHITE + "Logging you out" + ConsoleColors.RESET + ".....................................");
                    System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════");
                    displayHomeMenu();
                }
                case 5 -> changePasswordPrompt(user);
                case 6 -> deleteAccountPrompt(user);
                case 7 -> {
                    if (!user.isAdmin()) {
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "You do not have administrator privileges!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMainMenu(user);
                    }
                    else displayAdminMenu(user);
                }
                default -> {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                    displayMainMenu(user);
                }
            }
        }
        catch (Exception e){
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void displaySearchMenu(User user) {
        try {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Welcome to your awesome collection " +  ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + '!' + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. Display my collection.");
            System.out.println("2. I want to read one of my books.");
            System.out.println("3. I want to trade with another user!");
            System.out.println("4. Return to main menu.");
            System.out.print("Enter your choice: ");
            int choice = INPUT.nextInt();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            // Handle user input for main menu
            switch (choice) {
                case 1 -> displayCollection(user);
                case 2 -> openBookContent(user);
                case 3 -> displayTradeMenu(user);
                case 4 -> displayMainMenu(user);
                default -> {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                    displaySearchMenu(user);
                }
            }
        }
        catch (Exception e){
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void displayCollection(User user) {
        System.out.println(user.getPurchasedBooks());
        displaySearchMenu(user);
    }
    public void openBookContent(User user){
        try {
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼" + ConsoleColors.BLUE + "Time to escape reality!" + ConsoleColors.RESET + "≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
            System.out.print("Please enter the book's ISBN: ");
            String isbn = INPUT.next();
            if (!CredentialValidation.ISBNValidator.isValid(isbn)) {
                System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid ISBN Format!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                displaySearchMenu(user);
            }
                else {
                boolean foundBook = false;
                for (Book book : user.getPurchasedBooks()) {
                    if (book.getIsbn().equals(isbn)) {
                        foundBook = true;
                        System.out.println("........................................................" + ConsoleColors.WHITE + "Loading your book's content" + ConsoleColors.RESET + "............................................");
                        String asciiArt = """
                                .-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.
                                |                                                                       |
                                |                                                                       |
                                |                                                                       |
                                |                                                                       |
                                |                                                                       |
                                !                                                                       !
                                :                                                                       :
                                :                                                                       :
                                .                                                                       .
                                .                                                                       .
                                :                                                                       :
                                :                                                                       :
                                !                                                                       !
                                |                                                                       |
                                |                                                                       |
                                |                                                                       |
                                |                                                                       |
                                |                                                                       |
                                `-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'""";

                        asciiArt = asciiArt.replaceFirst(" ", "(" + book.getContent());

                        System.out.println(asciiArt);
                        displaySearchMenu(user);
                    }
                    if (!foundBook) {
                        System.out.println("That book does not seem to be in your library, are you sure you've entered the code correctly?");
                        if (promptRetryBool()) {
                            openBookContent(user);
                        }
                        else displayCollection(user);
                    }
                    return;
                }
            }
        }
        catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void displayTradeMenu(User user) {} // TODO
    public void displayPurchaseMenu(User user) {
        System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "We've got some great deals for you today! " +  ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
        System.out.println("1. Display all books in the store.");
        System.out.println("2. Filter books by category and query.");
        System.out.println("3. Filter books by price/year range.");
        System.out.println("4. Search a book by ISBN.");
        System.out.println("5. I want to purchase a book.");
        System.out.println("6. I want to add a book to my basket.");
        System.out.println("7. I want to return to the main menu.");
        System.out.print("Enter your choice: ");
        int choice;
        try {
            choice = INPUT.nextInt();
        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
        System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
        switch (choice) {
            case 1 -> {
                displayAllBooks();
                displayPurchaseMenu(user);
            }
            case 2 -> categoryQueryPrompt(user);
            case 3 -> rangeQueryPrompt(user);
            case 4 -> queryByISBNPrompt(user);
            case 5 -> purchasePrompt(user);
            case 6 -> addToBasketPrompt(user);
            case 7 -> displayMainMenu(user);
            default -> {
                System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                displayPurchaseMenu(user);
            }
        }
    }
    public void categoryQueryPrompt(User user) {
        INPUT.nextLine();
        System.out.print("Please enter a category to filter by: ");
        String category = INPUT.nextLine();
        System.out.print("Please enter a query to filter by: ");
        String query = INPUT.nextLine();
        List<Book> matchingBooks = bookstore.searchBooks(category, query);
        if (matchingBooks == null) {
            System.out.println("Invalid category / No books with given query were found /" +
                    " Textual input entered in numerical field");
            if (promptRetryBool()){
                categoryQueryPrompt(user);
            }
            else displayPurchaseMenu(user);
        }
        else { System.out.println(matchingBooks);
        displayPurchaseMenu(user); }
    }
    public void rangeQueryPrompt(User user) {
        INPUT.nextLine();
        System.out.println("Please enter a category to filter by: ");
        String category = INPUT.nextLine();
        System.out.println("Please enter a minimum query value: ");
        int min = 0;
        try {
            min = INPUT.nextInt();
            INPUT.nextLine();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            if (promptRetryBool()) {
                rangeQueryPrompt(user);
            } else displayPurchaseMenu(user);
        }
        System.out.println("Please enter a maximum query value: ");
        int max = 0;
        try {
            max = INPUT.nextInt();
            INPUT.nextLine();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            if (promptRetryBool()) {
                rangeQueryPrompt(user);
            } else displayPurchaseMenu(user);
        }
        List<Book> matchingBooks = bookstore.searchBooksByRange(category, min, max);
        if (matchingBooks == null) {
            System.out.println("Invalid category / no matching books were found within the given range");
            if (promptRetryBool()) {
                rangeQueryPrompt(user);
            } else displayPurchaseMenu(user);
        }
        else {System.out.println(matchingBooks);
        displayPurchaseMenu(user);}
    }
    public void queryByISBNPrompt(User user) {
        INPUT.nextLine();
        System.out.print("Please enter the ISBN code of the book you wish to display: ");
        String code = INPUT.nextLine();
        Book matchingBook = bookstore.searchBookByISBN(code);
        if (matchingBook == null) {
            System.out.println("Could not find any book with the given ISBN code.");
            if (promptRetryBool()){
                queryByISBNPrompt(user);
            }
            else displayPurchaseMenu(user);
        }
        else {System.out.println(matchingBook);
        displayPurchaseMenu(user);}
    }
    public void purchasePrompt(User user) {
        System.out.println("Please enter the ISBN code of the book you wish to purchase: ");
        String code = INPUT.nextLine();
        if (!CredentialValidation.ISBNValidator.isValid(code)){
            System.out.println("Invalid code format, must be 13 digits long");
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
        Book foundBook = bookstore
                .getBooks()
                .stream()
                .filter(aBook -> aBook.getIsbn().equals(code))
                .findAny()
                .orElse(null);
        if (foundBook == null){
            System.out.println("Book not found in the system, are you sure you've entered the correct code?" +
                    " It's recommended to browse the store for the book you're looking for :)");
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
        else if (bookstore.purchaseBook(user, foundBook)) {
            bookstore.saveBooksToFile();
            bookstore.saveUsersToFile();
            displayPurchaseMenu(user);
        }
        else {
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
    }
    public void addToBasketPrompt(User user) {
        System.out.println("Please enter the ISBN code of the book you wish to add to your basket: ");
        String code = INPUT.nextLine();
        if (!CredentialValidation.ISBNValidator.isValid(code)){
            System.out.println("Invalid code format, must be 13 digits long.");
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
        Book foundBook = bookstore
                .getBooks()
                .stream()
                .filter(aBook -> aBook.getIsbn().equals(code))
                .findAny()
                .orElse(null);
        if (foundBook == null){
            System.out.println("Book not found in the system, are you sure you've entered the correct code?" +
                    " It's recommended to browse the store for the book you're looking for :)");
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
        else if (bookstore.addToBasket(user, foundBook)) {
            bookstore.saveUsersToFile();
            displayPurchaseMenu(user);
        }
        else {
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
    }
    public void displayRegisterMenu() {
        try {
            boolean isValidCredential = true;
            RegisterManager.displayWelcomeMessage();

            String username = RegisterManager.getValidUsername();
            String password = RegisterManager.getValidPassword();
            System.out.print("Please reenter your password: ");
            String password2 = INPUT.next();
            String email = RegisterManager.getValidEmail();
            int birthYear = RegisterManager.getValidBirthYear();
            int birthMonth = RegisterManager.getValidBirthMonth();
            int birthDay = RegisterManager.getValidBirthDay();
            String country = RegisterManager.getCountry();
            String state = RegisterManager.getState();
            String city = RegisterManager.getCity();
            String postalCode = RegisterManager.getPostalCode();

            if (!CredentialValidation.UsernameValidator.isValid(username)) {
                System.out.println("Invalid username format, must be between 1 and 25 characters.");
                isValidCredential = false;
            }
            if (!CredentialValidation.EmailValidator.isValid(email)) {
                System.out.println("Invalid email address format.");
                isValidCredential = false;
            }
            if (!CredentialValidation.PasswordValidator.isValid(password)) {
                System.out.println("Invalid password format, must be between 1 and 100 characters and have at least one special character.");
                isValidCredential = false;
            }
            if (!password2.equals(password)) {
                System.out.println("Your password confirmation is incorrect.");
                isValidCredential = false;
            }
            if (birthDay > 31 || birthDay < 0) {
                System.out.println("Birth day must be between 0 and 31.");
                isValidCredential = false;
            }
            if (birthMonth > 12 || birthMonth < 0) {
                System.out.println("Birth month must be between 0 and 12.");
                isValidCredential = false;
            }
            if (birthYear > 2023 || birthYear < 1900) {
                System.out.println("Birth year must be between 1900 and 2023.");
                isValidCredential = false;
            }

            if (!isValidCredential) {
                RegisterManager.handleInvalidCredentials(this);
            } else {
                User newUser = new User(username, new Address(country, state, city, postalCode), password, email,
                        200, false, new Date(birthDay, birthMonth, birthYear));
                if (bookstore.getUsers().contains(newUser)) {
                    RegisterManager.handleExistingAccount(this);
                } else {
                    RegisterManager.registerUser(newUser, this.bookstore);
                    RegisterManager.displayRegistrationSuccessMessage();
                    displayHomeMenu();
                }
            }
        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
        }
    }
    public void displayAdminMenu(User user) {
        try {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Nice afternoon " +  ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. Add book to the store.");
            System.out.println("2. Remove book from the store.");
            System.out.println("3. Delete a user's account.");
            System.out.println("4. Change a user's account details.");
            System.out.println("5. Change a book's details.");
            System.out.println("6. Display all users in the store.");
            System.out.println("7. Display all books in the store.");
            System.out.println("8. Return to main menu.");
            System.out.print("Enter your choice: ");
            int choice = INPUT.nextInt();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            switch (choice) {
                case 1 -> addBook(user);
                case 2 -> removeBook(user);
                case 3 -> deleteUser(user);
                case 4 -> changeUserDetails(user);
                case 5 -> changeBookDetails(user);
                case 6 -> displayAllUsers(user);
                case 7 -> {
                    displayAllBooks();
                    displayAdminMenu(user);
                }
                case 8 -> displayMainMenu(user);
                default -> {
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                    displayAdminMenu(user);
                }
            }
        }
        catch (Exception e){
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void changeBookDetails(User user) {
        String isbn = promptValidInput(
                CredentialValidation.ISBNValidator::isValid
        );
        if (isbn == null) {
            return;
        }

        String finalIsbn = isbn;
        Book bookToEdit = bookstore.getBooks()
                .stream()
                .filter(aBook -> aBook.getIsbn().equals(finalIsbn))
                .findFirst()
                .orElse(null);
        if (bookToEdit == null) {
            boolean invalidInput = true;
            while (invalidInput) {
                System.out.println("Book not found in the system. Double check your input");
                if (!promptRetryBool()) {
                    displayAdminMenu(user);
                    return;
                }
                isbn = promptValidInput(
                        CredentialValidation.ISBNValidator::isValid
                );
                if (isbn == null) {
                    return;
                }
                String finalIsbn1 = isbn;
                bookToEdit = bookstore.getBooks()
                        .stream()
                        .filter(aBook -> aBook.getIsbn().equals(finalIsbn1))
                        .findFirst()
                        .orElse(null);
                if (bookToEdit != null) {
                    invalidInput = false;
                }
            }
        }

        System.out.print("Please enter the field you wish to edit: ");
        String field = INPUT.nextLine();
        String fieldLowerCase = field.toLowerCase();
        switch (fieldLowerCase) {
            case "title" -> {
                System.out.print("Please enter the value you wish to update to: ");
                String value = INPUT.nextLine();
                bookToEdit.setTitle(value);
            }
            case "author" -> {
                System.out.print("Please enter the value you wish to update to: ");
                String value = INPUT.nextLine();
                bookToEdit.setAuthor(value);
            }
            case "isbn" -> {
                System.out.print("Please enter the value you wish to update to: ");
                String value = promptValidInput(
                        CredentialValidation.ISBNValidator::isValid
                );
                if (value == null) {
                    return;
                }
                bookToEdit.setIsbn(value);
            }
            case "genre" -> {
                System.out.print("Please enter the value you wish to update to: ");
                String value = INPUT.nextLine();
                bookToEdit.setGenre(value);
            }
            case "content" -> {
                System.out.print("Please enter the value you wish to update to: ");
                String value = INPUT.nextLine();
                bookToEdit.setContent(value);
            }
            case "price" -> {
                double value = promptDoubleInput();
                if (value < 0) {
                    System.out.println("Price cannot be negative!");
                    if (promptRetryBool()) {
                        changeBookDetails(user);
                    } else displayAdminMenu(user);
                }
                bookToEdit.setPrice(value);
            }
            case "release date" -> {
                System.out.print("Please enter the release day you wish to update to: ");
                int day = promptIntInput("Please enter the release day you wish to update to: ");
                if (day <= 0 || day > 31) {
                    System.out.println("Invalid release date! Must be between 1 and 31 inclusive.");
                    if (promptRetryBool()) {
                        changeBookDetails(user);
                    } else displayAdminMenu(user);
                }
                System.out.print("Please enter the release month you wish to update to: ");
                int month = promptIntInput("Please enter the release month you wish to update to: ");
                if (month <= 0 || month > 12) {
                    System.out.println("Invalid release month! Must be between 1 and 12 inclusive.");
                    if (promptRetryBool()) {
                        changeBookDetails(user);
                    } else displayAdminMenu(user);
                }
                System.out.print("Please enter the release year you wish to update to: ");
                int year = promptIntInput("Please enter the release year you wish to update to: ");
                if (year > 2023) {
                    System.out.println("Invalid release year! Cannot be newer than 2023.");
                    if (promptRetryBool()) {
                        changeBookDetails(user);
                    } else displayAdminMenu(user);
                }
                bookToEdit.setReleaseDate(new Date(day, month, year));
            }
            case "stock" -> {
                System.out.print("Please enter the value you wish to update to: ");
                int value = promptIntInput("Please enter the value you wish to update to: ");
                if (value < 0) {
                    System.out.println("Stock cannot be negative!");
                    if (promptRetryBool()) {
                        changeBookDetails(user);
                    } else displayAdminMenu(user);
                }
                bookToEdit.setStock(value);
            }
            default -> {
                System.out.println("Invalid field!");
                boolean invalidInput = true;
                while (invalidInput) {
                    if (!promptRetryBool()) {
                        displayAdminMenu(user);
                        return;
                    }
                    System.out.print("Please enter the field you wish to edit: ");
                    field = INPUT.next().strip();
                    fieldLowerCase = field.toLowerCase();
                    switch (fieldLowerCase) {
                        case "title", "author", "isbn", "genre", "content", "price", "release date", "stock" -> invalidInput = false;
                        default -> System.out.println("Invalid field!");
                    }
                }
            }
        }

        System.out.println("Field updated successfully!");
        bookstore.saveBooksToFile();
        displayAdminMenu(user);
    }
    public void changeUserDetails(User user) {
        System.out.print("Please enter the email address of the account you wish to edit: ");
        INPUT.nextLine();
        String email = INPUT.nextLine();

        while (!CredentialValidation.EmailValidator.isValid(email)) {
            System.out.println("Invalid Email address format, must follow the standards, i.e: example@anemail.com");
            if (!promptRetryBool()) {
                displayAdminMenu(user);
                return;
            }
            System.out.print("Please enter the email address of the account you wish to edit: ");
            email = INPUT.nextLine();
        }

        String finalEmail = email;
        User userToEdit = bookstore.getUsers()
                .stream()
                .filter(aUser -> aUser.getEmail().equals(finalEmail))
                .findFirst()
                .orElse(null);

        if (userToEdit == null) {
            System.out.println("Account not found in the system. Double check your input.");
            if (promptRetryBool()) {
                changeUserDetails(user);
                return;
            }
            displayAdminMenu(user);
            return;
        }

        System.out.print("Please enter the field you wish to edit: ");
        String field = INPUT.nextLine();
        String fieldLowerCase = field.toLowerCase();

        switch (fieldLowerCase) {
            case "username" -> {
                String value = promptValidInput(
                        CredentialValidation.UsernameValidator::isValid,
                        "Invalid username format, must contain between 1 and 25 characters and no spaces", user);
                userToEdit.setUsername(value);
            }
            case "address" -> {
                System.out.print("Please enter the street to update to: ");
                String street = INPUT.nextLine();
                System.out.print("Please enter the city to update to: ");
                String city = INPUT.nextLine();
                System.out.print("Please enter the state/country to update to: ");
                String state = INPUT.nextLine();
                System.out.print("Please enter the postal code to update to: ");
                String postalCode = INPUT.nextLine();
                userToEdit.setAddress(new Address(street, city, state, postalCode));
            }
            case "password" -> {
                String value = promptValidInput(
                        CredentialValidation.PasswordValidator::isValid,
                        "Invalid password format, must contain between 1 and 100 characters and at least one special character", user);
                userToEdit.setPassword(value);
            }
            case "email" -> {
                String value = promptValidInput(
                        CredentialValidation.EmailValidator::isValid,
                        "Invalid email format, must follow the standards, i.e: example@anemail.com", user);
                userToEdit.setEmail(value);
            }
            case "balance" -> {
                double value = promptDoubleInput();
                if (value < 0) {
                    System.out.println("Balance cannot be negative!");
                    if (promptRetryBool()) {
                        changeUserDetails(user);
                    } else displayAdminMenu(user);
                }
                userToEdit.setBalance(value);
            }
            case "admin status" -> {
                boolean value = promptBooleanInput();
                userToEdit.setAdmin(value);
            }
            case "birth date" -> {
                int day = promptIntInput("Please enter the birth date you wish to update to: ");
                if (day <= 0 || day > 31) {
                    System.out.println("Invalid birth date! Must be between 1 and 31 inclusive.");
                    if (promptRetryBool()) {
                        changeUserDetails(user);
                    } else displayAdminMenu(user);
                }
                int month = promptIntInput("Please enter the birth month you wish to update to: ");
                if (month <= 0 || month > 12) {
                    System.out.println("Invalid birth month! Must be between 1 and 12 inclusive.");
                    if (promptRetryBool()) {
                        changeUserDetails(user);
                    } else displayAdminMenu(user);
                }
                int year = promptIntInput("Please enter the birth year you wish to update to: ");
                if (year < 1900 || year > 2023) {
                    System.out.println("Invalid birth year! Must be between 1900 and 2023 inclusive.");
                    if (promptRetryBool()) {
                        changeUserDetails(user);
                    } else displayAdminMenu(user);
                }
                userToEdit.setBirthDate(new Date(day, month, year));
            }
            default -> {
                System.out.println("Invalid field!");
                if (promptRetryBool()) {
                    changeUserDetails(user);
                    return;
                }
                displayAdminMenu(user);
                return;
            }
        }
            System.out.println("Field updated successfully!");
            bookstore.saveUsersToFile();
            displayAdminMenu(user);
    }
    public void deleteUser(User user) {
        try {
            System.out.print("Please enter the email address of the account you wish to delete: ");
            String email = INPUT.next();

            while (!CredentialValidation.EmailValidator.isValid(email)) {
                System.out.println("Invalid Email address format, must follow the standards, i.e: example@anemail.com");
                if (!promptRetryBool()) {
                    displayAdminMenu(user);
                    return;
                }
                email = INPUT.next();
            }

            String finalEmail = email;
            boolean userRemoved = bookstore.getUsers().removeIf(aUser -> aUser.getEmail().equals(finalEmail));
            if (userRemoved) {
                System.out.println("Account deleted successfully!");
                bookstore.saveUsersToFile();
            } else {
                System.out.println("User account does not exist in the system, double check your input.");
                if (promptRetryBool()) {
                    deleteUser(user);
                    return;
                }
            }

            displayAdminMenu(user);
        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void displayAllUsers(User user) {
        System.out.println(bookstore.getUsers());
        displayAdminMenu(user);
    }
    public void displayAllBooks() {
        System.out.println(bookstore.getBooks());
    }
    public void addBook(User user) {
        try {
            boolean isValidCredential = true;

            System.out.print("Enter book title: ");
            String title = INPUT.next();
            System.out.print("Enter book author: ");
            String author = INPUT.next();
            System.out.print("Enter book ISBN Code: ");
            String isbn = INPUT.next();
            System.out.print("Enter book genre: ");
            String genre = INPUT.next();
            System.out.print("Enter book content: ");
            String content = INPUT.next();
            System.out.print("Enter book price: ");
            double price = INPUT.nextDouble();
            System.out.print("Enter book release year: ");
            int year = INPUT.nextInt();
            System.out.print("Enter book release month: ");
            int month = INPUT.nextInt();
            System.out.print("Enter book release day: ");
            int day = INPUT.nextInt();
            System.out.print("Enter book stock: ");
            int stock = INPUT.nextInt();

            if (!CredentialValidation.ISBNValidator.isValid(isbn)) {
                System.out.println("Invalid ISBN Code, must be 13 digits long");
                isValidCredential = false;
            }
            if (day > 31 || day < 0) {
                System.out.println("Release day must be between 0 and 31.");
                isValidCredential = false;
            }
            if (month > 12 || month < 0) {
                System.out.println("Release month must be between 0 and 12.");
                isValidCredential = false;
            }

            if (!isValidCredential) {
                if (promptRetryBool()) {
                    addBook(user);
                } else {
                    displayAdminMenu(user);
                }
                return;
            }

            Book newBook = new Book(title, author, isbn, genre, content, price, new Date(day, month, year), stock);

            if (bookstore.getBooks().contains(newBook)) {
                System.out.println("This book already exists in the store!");
                if (promptRetryBool()) {
                    addBook(user);
                } else {
                    displayAdminMenu(user);
                }
                return;
            }

            bookstore.getBooks().add(newBook);
            bookstore.saveBooksToFile();
                    System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═════════");
                    System.out.println("═⊹⊱" + ConsoleColors.BLACK_BRIGHT + "The book has successfully been added to the store!" + ConsoleColors.RESET + "⊰⊹═");
                    System.out.println("/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/++/+x/==" + ConsoleColors.BLUE + "You will now be redirected to the admin menu!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                    System.out.println("...................................." + ConsoleColors.WHITE + "Redirecting to admin menu now" + ConsoleColors.RESET + "....................................");
                    displayAdminMenu(user);

        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void removeBook(User user) {
        try {
            System.out.print("Please enter the ISBN of the book you wish to delete: ");
            String code = INPUT.next();

            while (!CredentialValidation.ISBNValidator.isValid(code)) {
                System.out.println("Invalid ISBN format, must be 13 digits long.");
                if (!promptRetryBool()) {
                    displayAdminMenu(user);
                    return;
                }
                code = INPUT.next();
            }

            String finalCode = code;
            boolean bookRemoved = bookstore.getBooks().removeIf(book -> book.getIsbn().equals(finalCode));
            if (bookRemoved) {
                System.out.println("Book removed successfully!");
                bookstore.saveBooksToFile();
            } else {
                System.out.println("Book does not exist in the store, double check your input.");
                if (promptRetryBool()) {
                    removeBook(user);
                    return;
                }
            }

            displayAdminMenu(user);
        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void deleteAccountPrompt(User user) {
        try {
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰" + ConsoleColors.BLUE_BRIGHT + "Are you sure you want to leave the family?...:(" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹══");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = INPUT.nextInt();
                if (choice == 1) {
                    System.out.print("Please enter your password: ");
                    String password = INPUT.next();
                    while (!AttributeAccess.validatePassword(user, password)) {
                        System.out.println("Incorrect password");
                        if (!promptRetryBool())
                            displayAdminMenu(user);
                    }
                        bookstore.getUsers().remove(user);
                        bookstore.saveUsersToFile();
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.BLUE + "Account deleted successfully..." + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        System.out.println("........................................" + ConsoleColors.WHITE + "Redirecting you to the home menu" + ConsoleColors.RESET + "............................");
                        displayHomeMenu();
                } else if (choice == 2) {
                    System.out.println("........................................" + ConsoleColors.WHITE + "Redirecting you to the main menu" + ConsoleColors.RESET + "............................");
                    displayMainMenu(user);
                }
            }
        catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void changePasswordPrompt(User user) {
        try {
            System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.BLUE + "Let's change your password!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");

            String currentPassword = PasswordChangeManagement.getCurrentPasswordFromUser();
            if (!PasswordChangeManagement.validateCurrentPassword(user, currentPassword)) {
                PasswordChangeManagement.handleInvalidCurrentPassword(user, this);
                return;
            }

            String newPassword = PasswordChangeManagement.getNewPasswordFromUser();
            if (!PasswordChangeManagement.isValidNewPassword(newPassword)) {
                PasswordChangeManagement.handleInvalidNewPassword(user, this);
                return;
            }

            if (currentPassword.equals(newPassword)) {
                PasswordChangeManagement.handleSameOldAndNewPassword(user, this);
                return;
            }

            user.setPassword(newPassword);
            bookstore.saveUsersToFile();
            System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.YELLOW + "Password change successful!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
            displayMainMenu(user);
        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    private boolean promptRetryBool() {
        System.out.println("Would you like to try again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = INPUT.nextInt();
        INPUT.nextLine();
        return choice == 1;
    }
    private static String promptValidInput(Predicate<String> validator) {
        String input;
        boolean isValid;
        INPUT.nextLine();
        do {
            System.out.print("Please enter the ISBN Code of the book you wish to edit: ");
            input = INPUT.nextLine();
            isValid = validator.test(input);
            if (!isValid) {
                System.out.println("Invalid input! Please try again.");
            }
        } while (!isValid);
        return input;
    }
    private String promptValidInput(Predicate<String> validator, String errorMessage, User user) {
        System.out.println("Please enter the value you wish to update to: ");
        INPUT.nextLine();
        String value = INPUT.nextLine();

        while (!validator.test(value)) {
            System.out.println(errorMessage);
            if (!promptRetryBool()) {
                displayAdminMenu(user);
                return null;
            }
            System.out.println("Please enter the value you wish to update to: ");
            value = INPUT.nextLine();
        }

        return value;
    }
    private double promptDoubleInput() {
        System.out.print("Please enter the value you wish to update to: ");
        try {
            double value = INPUT.nextDouble();
            INPUT.nextLine();
            return value;
        } catch (InputMismatchException e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    private boolean promptBooleanInput() {
        System.out.println("Please enter the value you wish to update to, any value that is not false or true will be automatically interpreted as false: ");
        boolean bool = INPUT.nextBoolean();
        INPUT.nextLine();
        return bool;
    }
    private int promptIntInput(String prompt) {
        System.out.println(prompt);
        try {
            int value = INPUT.nextInt();
            INPUT.nextLine();
            return value;
        } catch (InputMismatchException e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
}