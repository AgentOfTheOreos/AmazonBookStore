import Visuals.ConsoleColors;

import java.util.Scanner;

public class RegisterManager
{
	public static final Scanner INPUT = new Scanner(System.in);
	public static void displayWelcomeMessage() {
		System.out.println("══════⊹⊱≼≽⊰⊹═══⊹⊱" + ConsoleColors.BLUE + "Welcome to the family, buddy! Tell us a bit more about yourself!" + ConsoleColors.RESET + "═════════════⊹⊱");
	}

	public static String getValidUsername() {
		System.out.print("Please enter a cool username: ");
		return INPUT.next();
	}

	public static String getValidPassword() {
		System.out.print("Please enter a strong password: ");
		return INPUT.next();
	}

	public static String getValidEmail() {
		System.out.print("Please enter your e-mail address: ");
		return INPUT.next();
	}

	public static int getValidBirthYear() {
		System.out.print("Please enter your birth year: ");
		return Integer.parseInt(INPUT.next());
	}

	public static int getValidBirthMonth() {
		System.out.print("Please enter your birth month: ");
		return Integer.parseInt(INPUT.next());
	}

	public static int getValidBirthDay() {
		System.out.print("Please enter your birth day: ");
		return Integer.parseInt(INPUT.next());
	}

	public static String getCountry() {
		System.out.print("Please enter your country: ");
		return INPUT.next();
	}

	public static String getState() {
		System.out.print("Please enter your state/district: ");
		return INPUT.next();
	}

	public static String getCity() {
		System.out.print("Please enter your city: ");
		return INPUT.next();
	}

	public static String getPostalCode() {
		System.out.print("Please enter your postal code: ");
		return INPUT.next();
	}
	public static void handleInvalidCredentials(MenuManager menuManager) {
		boolean invalidInput = true;

		while (invalidInput) {
			System.out.println("Would you like to try again?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = INPUT.nextInt();

			if (choice == 2) {
				invalidInput = false;
				menuManager.displayHomeMenu();
			} else if (choice == 1) {
				invalidInput = false;
				menuManager.displayRegisterMenu();
			}
		}
	}

	public static void handleExistingAccount(MenuManager menuManager) {
		boolean invalidInput = true;

		while (invalidInput) {
			System.out.print("It appears you already have an account on Amazbooks, would you like to try signing in? ");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = INPUT.nextInt();

			if (choice == 2) {
				invalidInput = false;
				menuManager.displayHomeMenu();
			} else if (choice == 1) {
				invalidInput = false;
				menuManager.displayRegisterMenu();
			}
		}
	}

	public static void registerUser(User newUser, Bookstore bookstore) {
		bookstore.getUsers().add(newUser);
		bookstore.saveUsersToFile();
	}

	public static void displayRegistrationSuccessMessage() {
		System.out.println("══════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹════════════⊹⊱≼≽⊰⊹═════════");
		System.out.println("═⊹⊱" + ConsoleColors.BLACK_BRIGHT + "You have been successfully registered with Amazbooks! What a happy day! A gift of 200 Amazcoins have been added to your account balance!" + ConsoleColors.RESET + "⊰⊹═");
		System.out.println("/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/++/+x/==" + ConsoleColors.BLUE + "You will now be redirected to the home menu! It is possible to sign in now :)" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
		System.out.println("...................................." + ConsoleColors.WHITE + "Redirecting to home menu" + ConsoleColors.RESET + "....................................");
	}

	public static void handleInvalidInput() {
		System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/==" + ConsoleColors.RED + "Invalid input format!" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/++x/+x/x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x");
	}
}
