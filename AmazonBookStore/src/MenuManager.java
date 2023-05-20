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
    public static void displayWelcomeScreen()
    {
        System.out.println("=================================================================================================");
        System.out.println("_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_");
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "\n" +
                " _       __          __                                          __                 \n" +
                "| |     / /  ___    / /  _____  ____    ____ ___   ___          / /_  ____          \n" +
                "| | /| / /  / _ \\  / /  / ___/ / __ \\  / __ `__ \\ / _ \\        / __/ / __ \\         \n" +
                "| |/ |/ /  /  __/ / /  / /__  / /_/ / / / / / / //  __/       / /_  / /_/ / _  _  _ \n" +
                "|__/|__/   \\___/ /_/   \\___/  \\____/ /_/ /_/ /_/ \\___/        \\__/  \\____/ (_)(_)(_)\n" +
                "                                                                                    \n" + ConsoleColors.RESET);
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
        System.out.println(ConsoleColors.PURPLE_BOLD + """
                             .--.           .---.        .-.
                         .---|--|   .-.     | A |  .---. |~|    .--.
                      .--|===|Ch|---|_|--.__| S |--|:::| |~|-==-|==|---.
                      |%%|NT2|oc|===| |~~|%%| C |--|   |_|~|CATS|  |___|-.
                      |  |   |ah|===| |==|  | I |  |:::|=| |    |GB|---|=|
                      |  |   |ol|   |_|__|  | I |__|   | | |    |  |___| |
                      |~~|===|--|===|~|~~|%%|~~~|--|:::|=|~|----|==|---|=|
                      ^--^---'--^---^-^--^--^---'--^---^-^-^-==-^--^---^-'
                """ + ConsoleColors.RESET);
        System.out.println("^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^=-_-=^");
        System.out.println("=================================================================================================");


    }

    public void displayHomeMenu() {
        boolean isValidChoice = false;
        int choice;

        while (!isValidChoice) {
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+= Welcome! Please pick an option =+=+=++=+=+=+=+=+=+=+=+=+=+=+=+=");
            System.out.println("1. I would like to Login.");
            System.out.println("2. I would like to create a new Amazbooks account and become awesome!");
            System.out.println("3. I'm too busy to be awesome :( (Exit).");
            System.out.print("Enter your choice: ");
            choice = INPUT.nextInt();
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

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
                    System.out.println("                                    Thank you for using Amazbooks! 'Till next time, buddy!                                    ");
                    System.exit(0);
                }
                default -> System.out.println("                                    Invalid choice, please try again!                                    ");
            }
        }
    }

    public void displayLoginMenu() {
        boolean invalidInput = true;

            System.out.print("Please enter your email address: ");
            String email = INPUT.next();
            System.out.print("Please enter your password: ");
            String password = INPUT.next();
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

            User currentUser = LoginManager.login(bookstore, email, password);

            if (currentUser == null) {
                while (invalidInput) {
                System.out.println("Would you like to try again?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choice = INPUT.nextInt();
                if (choice == 2) {
                    invalidInput = false;
                    displayHomeMenu();
                }
                else if (choice == 1) {
                    invalidInput = false;
                    displayLoginMenu();
                }
            }
        }
            else displayMainMenu(currentUser);
    }


    public void displayMainMenu(User user) {
        System.out.println("=+=+=+=+=+=+=+=++=+=+= Welcome back " + user.getUsername() + "! How may we assist you today? +=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("1. I want to view my library.");
        System.out.println("2. I'm looking to purchase a book.");
        System.out.println("3. I want to view my details.");
        System.out.println("4. I want to logout of my account.");
        System.out.println("5. I want to change my password.");
        System.out.println("6. I want to delete my account.");
        System.out.print("Enter your choice: ");
        int choice = INPUT.nextInt();
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        // Handle user input for main menu
        switch (choice) {
            case 1 -> displaySearchMenu(bookstore);
            case 2 -> displayPurchaseMenu(bookstore, user);
            case 3 -> {
                System.out.println("                                    Loading up your details...                                    ");
                System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                displayUserDetails(user);
                System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                displayMainMenu(user);
            }
            case 4 -> {
                System.out.println("                                    Logging you out...                                    ");
                System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                displayHomeMenu();
            }
            default -> System.out.println("                                    Invalid choice, please try again!                                    ");
        }
    }

    public void displaySearchMenu(Bookstore bookstore) {
        // Implement search menu logic here
    }

    public void displayPurchaseMenu(Bookstore bookstore, User user) {
        // Implement purchase menu logic here
    }

    public void displayUserDetails(User user) {
        // Implement user details display logic here
        user.displayDetails();
        displayMainMenu(user);
    }
    public void displayRegisterMenu()
    {

    }
}
