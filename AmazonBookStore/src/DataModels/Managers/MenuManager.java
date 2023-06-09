package DataModels.Managers;

import DataModels.Book;
import DataModels.Bookstore;
import DataModels.Managers.AccountManagement.*;
import DataModels.Messages.*;
import DataModels.ObjectCredentials.*;
import DataModels.Security.AttributeAccess;
import DataModels.User;
import DataModels.Visuals.ConsoleColors;

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
    } // DataModels.Managers.MenuManager constructor that constructs its own instance of the bookstore
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
    } // Simple welcome message
    public void displayHomeMenu() {
            boolean isValidChoice = false;
            int choice = 0;

            while (!isValidChoice) {
                System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰" + ConsoleColors.BLUE_BRIGHT + "Welcome! Please pick an option" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹══");
                System.out.println("1. I would like to Login.");
                System.out.println("2. I would like to create a new Amazbooks account and become awesome!");
                System.out.println("3. I'm too busy to be awesome :( (Exit).");
                System.out.print("Enter your choice: ");
                try {
                    choice = INPUT.nextInt();
                    isValidChoice = true;
                } catch (InputMismatchException | NumberFormatException e ) {
                    RegisterManager.handleInvalidInput();
                    INPUT.nextLine();
                }
                System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

                switch (choice) {
                    case 1 -> // Perform login logic
                            displayLoginMenu();
                    case 2 -> // Perform register logic
                            displayRegisterMenu();
                    case 3 -> {
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.YELLOW + "Thank you for using Amazbooks! 'Till next time, buddy!" + ConsoleColors.RESET + "==x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/");
                        System.out.println("............................................................." + ConsoleColors.WHITE + "Exiting" + ConsoleColors.RESET + "..........................................................");
                        System.exit(0);
                    }
                    default -> displayHomeMenu();
                }
            }
    } // DataModels.Main menu with options to log in, register and exit program
    public void displayLoginMenu() {
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
                } else displayHomeMenu();
            } else displayMainMenu(currentUser);
    } // Login menu if user has chosen to log in
    public void displayMainMenu(User user) {
            int choice = 0;
            boolean isValidChoice = false;
            while (!isValidChoice) {
                System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Welcome back " + ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + "! How may we assist you today?" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
                System.out.println("1. I want to view my library.");
                System.out.println("2. I want to browse the store.");
                System.out.println("3. I want to view my details.");
                System.out.println("4. I want to logout of my account.");
                System.out.println("5. I want to change my password.");
                System.out.println("6. I want to delete my account.");
                System.out.println("7. I'm an administrator and want to access advanced settings.");
                System.out.print("Enter your choice: ");
                try {
                    choice = INPUT.nextInt();
                    isValidChoice = true;
                } catch (NumberFormatException | InputMismatchException e) {
                    RegisterManager.handleInvalidInput();
                    INPUT.nextLine();
                }                System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

                // Handle user input for main menu
                switch (choice) {
                    case 1 -> {
                        if (user.getPurchasedBooks().isEmpty()) {
                            System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "It would seem your library's empty :(" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                            displayMainMenu(user);
                        } else displaySearchMenu(user);
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
                        } else displayAdminMenu(user);
                    }
                    default -> displayMainMenu(user);
                }
            }
    } // If user has successfully logged in, he can choose to view his books,
    // browse the store, view his user details, logout of his account,
    // change his password or delete his account, or maybe even access admin menu if he has enough permissions
    public void displaySearchMenu(User user) {
        int choice = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Welcome to your awesome collection " + ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + '!' + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. Display my collection.");
            System.out.println("2. I want to read one of my books.");
            System.out.println("3. I want to view my messages section!");
            System.out.println("4. Return to main menu.");
            System.out.print("Enter your choice: ");
            try {
                choice = INPUT.nextInt();
                isValidChoice = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            // Handle user input for main menu
            switch (choice) {
                case 1 -> displayCollection(user);
                case 2 -> openBookContent(user);
                case 3 -> displayMessageMenu(user);
                case 4 -> displayMainMenu(user);
                default -> displaySearchMenu(user);
            }
        }
    } // Allows the user to browse his library of books,
    // or maybe even trade with another user
    public void displayCollection(User user) {
        System.out.println(user.getPurchasedBooks());
        displaySearchMenu(user);
    } // Displays the book collection of the user
    public void openBookContent(User user){
            INPUT.nextLine();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼" + ConsoleColors.BLUE + "Time to escape reality!" + ConsoleColors.RESET + "≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
            System.out.print("Please enter the book's ISBN: ");
            String isbn = INPUT.nextLine();
            if (!DataModels.CredentialValidation.ISBNValidator.isValid(isbn)) {
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
    } // Opens the book content and displays it to the user
    public void displayMessageMenu(User user) {
        int choice = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Time to chat (or trade)! " + ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + '!' + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. I want to send a message/trade request to another user.");
            System.out.println("2. I want to cancel a trade request I've created.");
            System.out.println("3. I want to view the collection of another user.");
            System.out.println("4. I want to accept a trade request.");
            System.out.println("5. I want to view my sent messages.");
            System.out.println("6. I want to view my received messages.");
            System.out.println("7. I want to delete a message.");
            System.out.println("8. I want to go back to my library menu.");
            System.out.print("Enter your choice: ");
            try {
                choice = INPUT.nextInt();
                isValidChoice = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            // Handle user input for messages menu
            switch (choice) {
                case 1 -> sendMessagePrompt(user);
                case 2 -> {
                    if (user.getInbox().isEmpty()){
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Your inbox is empty!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/++x/+x/x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMessageMenu(user);
                        return;
                    }
                    cancelTradeRequestPrompt(user);
                }
                case 3 -> viewOtherUserBooksPrompt(user);
                case 4 -> {
                    if (user.getInbox().isEmpty()){
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Your inbox is empty!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/++x/+x/x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMessageMenu(user);
                        return;
                    }
                    acceptTradeRequestPrompt(user);
                }
                case 5 -> {
                    if (user.getInbox().isEmpty()){
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Your inbox is empty!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/++x/+x/x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMessageMenu(user);
                        return;
                    }
                    TradeManager.showSentMessages(user);
                    displayMessageMenu(user);
                }
                case 6 -> {
                    if (user.getInbox().isEmpty()){
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Your inbox is empty!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/++x/+x/x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMessageMenu(user);
                        return;
                    }
                    TradeManager.showReceivedMessages(user);
                    displayMessageMenu(user);
                }
                case 7 -> {
                    if (user.getInbox().isEmpty()){
                        System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Your inbox is empty!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/++x/+x/x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                        displayMessageMenu(user);
                        return;
                    }
                    deleteMessagePrompt(user);
                }
                case 8 -> displaySearchMenu(user);
                default -> displayMessageMenu(user);
            }
        }
    }
    public void sendMessagePrompt(User user) {
        INPUT.nextLine();
        boolean isValidInput = false;
        int choice = 0;
        while (!isValidInput) {
            System.out.print("Please enter the title of the message. Must be between 1 and 40 characters long: ");
            String title = INPUT.nextLine();
            if (title.length() < 1 || title.length() > 40) {
                System.out.println("Title length must be between 1 and 40 characters long.");
                if (promptRetryBool()) {
                    sendMessagePrompt(user);
                } else displayMessageMenu(user);
            }
            System.out.print("Please enter the email address of the user you wish to send the message to: ");
            String ReceiverEmail = INPUT.nextLine();
            if (!DataModels.CredentialValidation.EmailValidator.isValid(ReceiverEmail)) {
                System.out.println("Invalid email address format, must follow recognized standards. I.E.: someone@example.com");
                if (promptRetryBool()) {
                    sendMessagePrompt(user);
                } else displayMessageMenu(user);
            }
            User matchingUser = bookstore.getUsers()
                    .stream()
                    .filter(aUser -> aUser.getEmail().equals(ReceiverEmail))
                    .findFirst()
                    .orElse(null);
            if (matchingUser == null) {
                System.out.println(ConsoleColors.RED + "User not found!" + ConsoleColors.RESET);
                if (promptRetryBool()) {
                    sendMessagePrompt(user);
                } else displayMessageMenu(user);
            }
            System.out.println("Please enter the content of the message, must be between 1 and 256 characters long: ");
            String content = INPUT.nextLine();
            if (content.length() < 1 || content.length() > 256) {
                System.out.println("Content length must be between 1 and 256 characters long.");
                if (promptRetryBool()) {
                    sendMessagePrompt(user);
                } else displayMessageMenu(user);
            }
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
            System.out.println("Is this a trade request or a normal message?");
            System.out.println("1. Normal Message.");
            System.out.println("2. Trade Request.");
            System.out.println("3. Cancel process.");
            System.out.print("Enter your choice: ");
            try {
                choice = INPUT.nextInt();
                isValidInput = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            INPUT.nextLine();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");
            switch (choice){
                case 1 -> {
                    Message message = new Message(user.getEmail(), ReceiverEmail, title, content);
                    assert matchingUser != null;
                    TradeManager.sendMessage(user, matchingUser, message, bookstore);
                    displayMessageMenu(user);
                }
                case 2 -> {
                    System.out.print("Please enter the ISBN of the book you wish to send: ");
                    String senderISBN = INPUT.nextLine();
                    if (!DataModels.CredentialValidation.ISBNValidator.isValid(senderISBN)){
                        System.out.println("Invalid ISBN format, must be 13 digits long.");
                        if (promptRetryBool()) {
                            sendMessagePrompt(user);
                        } else displayMessageMenu(user);
                    }
                    Book senderBook = user.getPurchasedBooks()
                            .stream()
                            .filter(aBook -> aBook.getIsbn().equals(senderISBN))
                            .findFirst()
                            .orElse(null);
                    if (senderBook == null) {
                        System.out.println("You do not have any books with entered ISBN code.");
                        if (promptRetryBool()) {
                            sendMessagePrompt(user);
                        } else displayMessageMenu(user);
                    }
                    System.out.print("Please enter the ISBN of the book you wish to receive: ");
                    String receiverISBN = INPUT.nextLine();
                    if (!DataModels.CredentialValidation.ISBNValidator.isValid(receiverISBN)){
                        System.out.println("Invalid ISBN format, must be 13 digits long.");
                        if (promptRetryBool()) {
                            sendMessagePrompt(user);
                        } else displayMessageMenu(user);
                    } if (senderISBN.equals(receiverISBN)) {
                        System.out.println("The book you want to receive is already in your collection!");
                        if (promptRetryBool()) {
                            sendMessagePrompt(user);
                        } else displayMessageMenu(user);
                    }
                    assert matchingUser != null;
                    Book receiverBook = matchingUser.getPurchasedBooks()
                            .stream()
                            .filter(aBook -> aBook.getIsbn().equals(receiverISBN))
                            .findFirst()
                            .orElse(null);
                    if (receiverBook == null) {
                        System.out.println("The recipient does not have any books matching the entered ISBN code.");
                        if (promptRetryBool()) {
                            sendMessagePrompt(user);
                        } else displayMessageMenu(user);
                    }
                    assert receiverBook != null;
                    assert senderBook != null;
                    TradeMessage tradeMessage = new TradeMessage(user.getEmail(), matchingUser.getEmail(), title, content,
                            senderISBN, receiverISBN, senderBook.getTitle(), receiverBook.getTitle());
                    TradeManager.sendMessage(user, matchingUser, tradeMessage, bookstore);
                    displayMessageMenu(user);
                }
                case 3 -> displayMessageMenu(user);
                default -> {
                    System.out.println("Invalid choice.");
                    if (promptRetryBool()) {
                        sendMessagePrompt(user);
                    } else displayMessageMenu(user);
                }
            }
        }
    }
    public void viewOtherUserBooksPrompt(User user) {
        INPUT.nextLine();
        System.out.print("Please enter the email address of the user you wish to view the collection of: ");
        String userEmail = INPUT.nextLine();
        if (!DataModels.CredentialValidation.EmailValidator.isValid(userEmail)) {
            System.out.println("Invalid email address format, must follow recognized standards. I.E.: someone@example.com");
            if (promptRetryBool()) {
                viewOtherUserBooksPrompt(user);
            } else displayMessageMenu(user);
        }
        TradeManager.viewOtherUsersBooks(userEmail, bookstore);
        displayMessageMenu(user);
    }
    public void cancelTradeRequestPrompt(User user) {
        INPUT.nextLine();
        boolean isValidInput = false;
        int code = 0;
        while (!isValidInput) {
            System.out.print("Please enter the code of the trade request you wish to cancel");
            try {
                code = INPUT.nextInt();
                isValidInput = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            if (TradeManager.cancelTradeRequest(user, code, bookstore)){
                displayMessageMenu(user);
            } else {
                if (promptRetryBool()){
                    cancelTradeRequestPrompt(user);
                } else displayMessageMenu(user);
            }
        }
    }
    public void acceptTradeRequestPrompt(User user) {
        INPUT.nextLine();
        boolean isValidInput = false;
        int code = 0;
        while (!isValidInput) {
            System.out.print("Please enter the code of the trade request you want to accept: ");
            try {
                code = INPUT.nextInt();
                isValidInput = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            if (TradeManager.acceptTradeRequest(user, code, bookstore)){
                displayMessageMenu(user);
            } else {
                if (promptRetryBool()){
                    acceptTradeRequestPrompt(user);
                } else displayMessageMenu(user);
            }
        }
    }
    public void deleteMessagePrompt(User user) {
        INPUT.nextLine();
        boolean isValidInput = false;
        int code = 0;
        while (!isValidInput) {
            System.out.println("Please enter the code of the message you wish to delete");
            try {
                code = INPUT.nextInt();
                isValidInput = true;
            } catch (InputMismatchException | NumberFormatException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            if (TradeManager.deleteMessage(user, code, bookstore)){
                displayMessageMenu(user);
            }
            else{
                if (promptRetryBool()){
                    deleteMessagePrompt(user);
                } else displayMessageMenu(user);
            }
        }
    }
    public void displayPurchaseMenu(User user) {
        int choice = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "We've got some great deals for you today! " + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. Display all books in the store.");
            System.out.println("2. Filter books by category and query.");
            System.out.println("3. Filter books by price/year range.");
            System.out.println("4. Search a book by ISBN.");
            System.out.println("5. I want to purchase a book.");
            System.out.println("6. I want to add a book to my basket.");
            System.out.println("7. I want to return to the main menu.");
            System.out.print("Enter your choice: ");
            try {
                choice = INPUT.nextInt();
                isValidChoice = true;
            } catch (InputMismatchException | NumberFormatException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
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
    } // Purchase menu that will give the users the option to display all
    // books in the store, filter by category and query
    // i.e.: Title -> Harry Potter. filter by price/year range, display book with matching ISBN, purchase book by ISBN
    // Adding books to the user's basket or simply returning to main menu
    public void categoryQueryPrompt(User user) {
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
    } // Prompt to facilitate the process of retrieving books that match
    // the given category and given query
    public void rangeQueryPrompt(User user) {
        int min = 0;
        int max = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            INPUT.nextLine();
            System.out.println("Please enter a category to filter by: ");
            String category = INPUT.nextLine();
            try {
                System.out.println("Please enter a minimum query value: ");
                min = INPUT.nextInt();
                System.out.println("Please enter a maximum query value: ");
                max = INPUT.nextInt();
                isValidChoice = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            List<Book> matchingBooks = bookstore.searchBooksByRange(category, min, max);
            if (matchingBooks == null) {
                System.out.println("Invalid category / no matching books were found within the given range");
                if (promptRetryBool()) {
                    rangeQueryPrompt(user);
                } else displayPurchaseMenu(user);
            } else {
                System.out.println(matchingBooks);
                displayPurchaseMenu(user);
            }
        }
    } // Prompt to facilitate the process of retrieving books that have
    // price/year fields within the given range min-max inclusive
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
    } // Prompt to facilitate the process of retrieving book
    // with matching ISBN code
    public void purchasePrompt(User user) {
        INPUT.nextLine();
        System.out.println("Please enter the ISBN code of the book you wish to purchase: ");
        String code = INPUT.nextLine();
        if (!DataModels.CredentialValidation.ISBNValidator.isValid(code)){
            System.out.println("Invalid code format, must be 13 digits long");
            if (promptRetryBool()) {
                purchasePrompt(user);
            } else displayPurchaseMenu(user);
        }
        Book foundBook = bookstore
                .getBooks()
                .stream()
                .filter(aBook -> aBook.getIsbn().equals(code))
                .findFirst()
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
    } // Menu to facilitate the purchase process of the books
    public void addToBasketPrompt(User user) {
        System.out.println("Please enter the ISBN code of the book you wish to add to your basket: ");
        String code = INPUT.nextLine();
        if (!DataModels.CredentialValidation.ISBNValidator.isValid(code)){
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
            System.out.println("DataModels.Book not found in the system, are you sure you've entered the correct code?" +
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
    }  // Menu to allow user to add books to their basket
    public void displayRegisterMenu() {
        boolean isValidInput = false;
        int birthYear = 0;
        int birthMonth = 0 ;
        int birthDay = 0;
        while (!isValidInput) {
            boolean isValidCredential = true;
            RegisterManager.displayWelcomeMessage();

            String username = RegisterManager.getValidUsername();
            String password = RegisterManager.getValidPassword();
            System.out.print("Please reenter your password: ");
            String password2 = INPUT.next();
            String email = RegisterManager.getValidEmail();
            try {
                birthYear = RegisterManager.getValidBirthYear();
                birthMonth = RegisterManager.getValidBirthMonth();
                birthDay = RegisterManager.getValidBirthDay();
                isValidInput = true;
            } catch (InputMismatchException | NumberFormatException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
            String country = RegisterManager.getCountry();
            String state = RegisterManager.getState();
            String city = RegisterManager.getCity();
            String postalCode = RegisterManager.getPostalCode();

            if (!DataModels.CredentialValidation.UsernameValidator.isValid(username)) {
                System.out.println("Invalid username format, must be between 1 and 25 characters.");
                isValidCredential = false;
            }
            if (!DataModels.CredentialValidation.EmailValidator.isValid(email)) {
                System.out.println("Invalid email address format.");
                isValidCredential = false;
            }
            if (!DataModels.CredentialValidation.PasswordValidator.isValid(password)) {
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
                if (promptRetryBool())
                    displayRegisterMenu();
                else displayHomeMenu();
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
        }
    } // Menu to facilitate the registration process
    public void displayAdminMenu(User user) {
        int choice = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Nice afternoon " +  ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. Add a book to the store.");
            System.out.println("2. Remove a book from the store.");
            System.out.println("3. Delete a user's account.");
            System.out.println("4. Change a user's account details.");
            System.out.println("5. Change a book's details.");
            System.out.println("6. Display all users in the store.");
            System.out.println("7. Display all books in the store.");
            System.out.println("8. Return to main menu.");
            System.out.print("Enter your choice: ");
            try {
                choice = INPUT.nextInt();
                isValidInput = true;
            } catch (NumberFormatException | InputMismatchException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

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
    } // Menu that will allow admin to add books to the store,
    // or delete/change/display all the books/users in the store
    public void changeBookDetails(User user) {
        String isbn = promptValidInput(
                DataModels.CredentialValidation.ISBNValidator::isValid
        );
        if (isbn == null) {
            if (promptRetryBool())
                changeBookDetails(user);
            else displayAdminMenu(user);
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
                System.out.println("DataModels.Book not found in the system. Double check your input");
                if (!promptRetryBool()) {
                    displayAdminMenu(user);
                    return;
                }
                isbn = promptValidInput(
                        DataModels.CredentialValidation.ISBNValidator::isValid
                );
                if (isbn == null) {
                    if (promptRetryBool())
                        changeBookDetails(user);
                    else displayAdminMenu(user);
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
                        DataModels.CredentialValidation.ISBNValidator::isValid
                );
                if (value == null) {
                    if (promptRetryBool())
                        changeBookDetails(user);
                    else displayAdminMenu(user);
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
                        case "title", "author", "isbn", "genre", "content", "price", "release date", "stock" ->
                                invalidInput = false;
                        default -> System.out.println("Invalid field!");
                    }
                }
            }
        }

        System.out.println("Field updated successfully!");
        bookstore.saveBooksToFile();
        displayAdminMenu(user);
    } // Prompt to allow admins to change book from the store's info
    public void changeUserDetails(User user) {
            System.out.print("Please enter the email address of the account you wish to edit: ");
            INPUT.nextLine();
            String email = INPUT.nextLine();

            while (!DataModels.CredentialValidation.EmailValidator.isValid(email)) {
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
                            DataModels.CredentialValidation.UsernameValidator::isValid,
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
                            DataModels.CredentialValidation.PasswordValidator::isValid,
                            "Invalid password format, must contain between 1 and 100 characters and at least one special character", user);
                    userToEdit.setPassword(value);
                }
                case "email" -> {
                    String value = promptValidInput(
                            DataModels.CredentialValidation.EmailValidator::isValid,
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
    } // Prompt to allow admins to change user from the store's info
    public void deleteUser(User user) {
            System.out.print("Please enter the email address of the account you wish to delete: ");
            String email = INPUT.next();

            while (!DataModels.CredentialValidation.EmailValidator.isValid(email)) {
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
    } // Prompt to allow admins to remove users from the store
    public void displayAllUsers(User user) {
        System.out.println(bookstore.getUsers());
        displayAdminMenu(user);
    } // Prompt for admin to view all users in the store
    public void displayAllBooks() {
        System.out.println(bookstore.getBooks());
    } // Prompt to display all books in the store
    public void addBook(User user) {
        int year = 0;
        int month = 0;
        int day = 0;
        int stock = 0;
        double price = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
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
                try {
                    price = INPUT.nextDouble();
                    System.out.print("Enter book release year: ");
                    year = INPUT.nextInt();
                    System.out.print("Enter book release month: ");
                    month = INPUT.nextInt();
                    System.out.print("Enter book release day: ");
                    day = INPUT.nextInt();
                    System.out.print("Enter book stock: ");
                    stock = INPUT.nextInt();
                    isValidInput = true;
                } catch (NumberFormatException | InputMismatchException e) {
                    RegisterManager.handleInvalidInput();
                    INPUT.nextLine();
                }

            if (!DataModels.CredentialValidation.ISBNValidator.isValid(isbn)) {
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
        }
    } // Prompt to allow admins to add books to the store
    public void removeBook(User user) {
        try {
            System.out.print("Please enter the ISBN of the book you wish to delete: ");
            String code = INPUT.next();

            while (!DataModels.CredentialValidation.ISBNValidator.isValid(code)) {
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
                System.out.println("DataModels.Book removed successfully!");
                bookstore.saveBooksToFile();
            } else {
                System.out.println("DataModels.Book does not exist in the store, double check your input.");
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
    } // Prompt to allow admins to remove books from the store
    public void deleteAccountPrompt(User user) {
        int choice = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰" + ConsoleColors.BLUE_BRIGHT + "Are you sure you want to leave the family?...:(" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹══");
            System.out.println("1. Yes");
            System.out.println("2. No");
            try {
                choice = INPUT.nextInt();
                isValidChoice = true;
            } catch (InputMismatchException | NumberFormatException e){
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
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
    } // Prompt to facilitate the deletion of the user account
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
    } // Prompt to facilitate the password change of the user account
    // Helper methods to properly manage special cases of int/double/bool type input, and to reload the current menu if the
    // user has entered any incorrect/invalid input
    private boolean promptRetryBool() {
        int choice = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.println("Would you like to try again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            try {
                choice = INPUT.nextInt();
                isValidChoice = true;
            } catch (InputMismatchException | NumberFormatException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
        }
        return choice == 1;
    }
    private static String promptValidInput(Predicate<String> validator) {
        String input;
        boolean isValid;
        INPUT.nextLine();
            System.out.print("Please enter the ISBN Code of the book you wish to edit: ");
            input = INPUT.nextLine();
            isValid = validator.test(input);
            if (!isValid) {
                System.out.println("Invalid input! Please try again.");
                input = null;
            }
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
        double value = 0;
        boolean isValidChoice = false;
        while (!isValidChoice) {
            System.out.print("Please enter the value you wish to update to: ");
            try {
                value = INPUT.nextDouble();
                isValidChoice = true;
            } catch (InputMismatchException | NumberFormatException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
        }
        return value;
    }
    private boolean promptBooleanInput() {
        System.out.println("Please enter the value you wish to update to, any value that is not false or true will be automatically interpreted as false: ");
        boolean bool = INPUT.nextBoolean();
        INPUT.nextLine();
        return bool;
    }
    private int promptIntInput(String prompt) {
        boolean isValidChoice = false;
        int value = 0;
        while (!isValidChoice) {
            System.out.println(prompt);
            try {
                value = INPUT.nextInt();
                isValidChoice = true;
            } catch (InputMismatchException | NumberFormatException e) {
                RegisterManager.handleInvalidInput();
                INPUT.nextLine();
            }
        }
        return  value;
    }
}