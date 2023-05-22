import ObjectCredentials.Address;
import ObjectCredentials.Date;
import Visuals.ConsoleColors;

import java.util.Scanner;

public class MenuManager
{
    public static final Scanner INPUT = new Scanner(System.in);
    private Bookstore bookstore;
    public MenuManager() {
        bookstore = new Bookstore();
        bookstore.loadUsersFromFile();
        bookstore.loadBooksFromFile();
    }
    public void initializeStore()
    {
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
                    default -> System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
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
            boolean invalidInput = true;

            System.out.print("Please enter your email address: ");
            String email = INPUT.next();
            System.out.print("Please enter your password: ");
            String password = INPUT.next();
            System.out.println("........................................................" + ConsoleColors.WHITE + "Verifying your credentials, one moment" + ConsoleColors.RESET + "............................................");
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            User currentUser = LoginManager.login(bookstore, email, password);

            if (currentUser == null) {
                while (invalidInput) {
                    System.out.println("Would you like to try again?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int choice = INPUT.nextInt();
                    if (choice == 2) {
                        invalidInput = false;
                        System.out.println("........................................................" + ConsoleColors.WHITE + "Redirecting you to the home menu" + ConsoleColors.RESET + "............................................");
                        displayHomeMenu();
                    } else if (choice == 1) {
                        invalidInput = false;
                        displayLoginMenu();
                    }
                }
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
                case 2 -> displayPurchaseMenu(bookstore, user);
                case 3 -> {
                    System.out.println("...................................." + ConsoleColors.WHITE + "Loading up your details" + ConsoleColors.RESET + ".....................................");
                    System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════");
                    displayUserDetails(user);
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
                default -> System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
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
            System.out.println("3. Return to main menu.");
            System.out.print("Enter your choice: ");
            int choice = INPUT.nextInt();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            // Handle user input for main menu
            switch (choice) {
                case 1 -> displayCollection(user);
                case 2 -> openBookContent(user);
                case 3 -> displayMainMenu(user);
                default -> System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
            }
        }
        catch (Exception e){
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }

    public void displayCollection(User user) {
        for (Book book : user.getPurchasedBooks())
            System.out.println(book);
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
                        String asciiArt = "    /\\                                                      \\\n" +
                                "(O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)\n" +
                                "    \\/''''''''''''''''''''''''''''''''''''''''''''''''''''''/\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "\n" +
                                "    (                                                      (\n" +
                                "     )                                                      )\n" +
                                "    (                                                      (\n" +
                                "    /\\''''''''''''''''''''''''''''''''''''''''''''''''''''''\\    \n" +
                                "(O)===)><><><><><><><><><><><><><><><><><><><><><><><><><><><)==(O)\n" +
                                "    \\/______________________________________________________/";

                        asciiArt = asciiArt.replaceFirst("\\( ", "(" + book.getContent());

                        System.out.println(asciiArt);
                        displaySearchMenu(user);
                    }
                    if (!foundBook) {
                        boolean invalidInput = true;
                        System.out.println("That book does not seem to be in your library, are you sure you've entered the code correctly?");
                        while (invalidInput) {
                            System.out.println("Would you like to try again?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int choice = INPUT.nextInt();
                            if (choice == 2) {
                                invalidInput = false;
                                System.out.println("........................................................" + ConsoleColors.WHITE + "Redirecting you to the home menu" + ConsoleColors.RESET + "............................................");
                                displaySearchMenu(user);
                            } else if (choice == 1) {
                                invalidInput = false;
                                openBookContent(user);
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }

    public void displayPurchaseMenu(Bookstore bookstore, User user) {
        // Implement purchase menu logic here
    }

    public void displayUserDetails(@org.jetbrains.annotations.NotNull User user) {
        user.displayDetails();
        displayMainMenu(user);
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
            System.out.println("══════⊹⊱≼≽⊰⊹════════ " + ConsoleColors.BLUE_BRIGHT + "Nice afternoon" +  ConsoleColors.RESET + ConsoleColors.CYAN_BRIGHT + user.getUsername() + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + "! How may we assist you today?" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════");
            System.out.println("1. Add books to the store.");
            System.out.println("2. Remove books from the store.");
            System.out.println("3. Delete a user's account.");
            System.out.println("4. Change a user's account details.");
            System.out.println("5. Change a book's details.");
            System.out.print("Enter your choice: ");
            int choice = INPUT.nextInt();
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═══════");

            // Handle user input for main menu
            /*switch (choice) {
                case 1 -> addBook(bookstore);
                case 2 -> removeBook(bookstore, user);
                case 3 -> deleteUser();
                case 4 -> changeUserDetails();
                case 5 -> changeBookDetails();
                default -> System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid choice, please try again!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
            }*/
        }
        catch (Exception e){
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
    public void deleteAccountPrompt(User user) {
        try {
            boolean invalidInput = true;
            System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰" + ConsoleColors.BLUE_BRIGHT + "Are you sure you want to leave the family?...:(" + ConsoleColors.RESET + "══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹══");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int choice = INPUT.nextInt();
            while (invalidInput) {
                if (choice == 1) {
                    invalidInput = false;
                    bookstore.getUsers().remove(user);
                    System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.BLUE + "Account deleted successfully..." + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
                    System.out.println("........................................" + ConsoleColors.WHITE + "Redirecting you to the home menu" + ConsoleColors.RESET + "............................");
                    displayHomeMenu();
                } else if (choice == 2) {
                    invalidInput = false;
                    System.out.println("........................................" + ConsoleColors.WHITE + "Redirecting you to the main menu" + ConsoleColors.RESET + "............................");
                    displayMainMenu(user);
                }
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

            String currentPassword = PasswordChangeManagement.getCurrentPasswordFromUser(user);
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
            System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.YELLOW + "Password change successful!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");
            displayMainMenu(user);
        } catch (Exception e) {
            RegisterManager.handleInvalidInput();
            throw e;
        }
    }
}
