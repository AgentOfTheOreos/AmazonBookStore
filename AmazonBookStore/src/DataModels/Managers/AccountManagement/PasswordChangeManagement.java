package DataModels.Managers.AccountManagement;

import java.util.Scanner;

import DataModels.Managers.MenuManager;
import DataModels.Security.AttributeAccess;
import DataModels.User;
import DataModels.Visuals.ConsoleColors;
public class PasswordChangeManagement {
	public static final Scanner INPUT = new Scanner(System.in);
	public static String getCurrentPasswordFromUser() {
		System.out.print("Please enter your current password: ");
		return INPUT.next();
	}
	public static boolean validateCurrentPassword(User user, String currentPassword) {
		// Make sure user's password matches entered password
		return AttributeAccess.validatePassword(user, currentPassword);
	}
	public static void handleInvalidCurrentPassword(User user, MenuManager menuManager) {
		System.out.println("+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+==" + ConsoleColors.RED + "Incorrect Password" + ConsoleColors.RESET + "==+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+x/+");

		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("Would you like to try again?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = INPUT.nextInt();

			if (choice == 2) {
				invalidInput = false;
				System.out.println("........................................................" + ConsoleColors.WHITE + "Redirecting you to the main menu" + ConsoleColors.RESET + "............................................");
				menuManager.displayMainMenu(user);
			} else if (choice == 1) {
				invalidInput = false;
				menuManager.changePasswordPrompt(user);
			}
		}
	}
	public static String getNewPasswordFromUser() {
		System.out.print("Please enter a new password: ");
		return INPUT.next();
	}
	public static boolean isValidNewPassword(String newPassword) {
		return DataModels.CredentialValidation.PasswordValidator.isValid(newPassword);
	}
	public static void handleInvalidNewPassword(User user, MenuManager menuManager) {
		System.out.println("Invalid password format, must be between 1 and 100 characters and have at least one special character");

		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("Would you like to try again?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = INPUT.nextInt();

			if (choice == 2) {
				invalidInput = false;
				System.out.println("........................................................" + ConsoleColors.WHITE + "Redirecting you to the main menu" + ConsoleColors.RESET + "............................................");
				menuManager.displayMainMenu(user);
			} else if (choice == 1) {
				invalidInput = false;
				menuManager.changePasswordPrompt(user);
			}
		}
	}
	public static void handleSameOldAndNewPassword(User user, MenuManager menuManager) {
		System.out.println("Your old password and new password cannot be the same");

		boolean invalidInput = true;
		while (invalidInput) {
			System.out.println("Would you like to try again?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = INPUT.nextInt();

			if (choice == 2) {
				invalidInput = false;
				System.out.println("........................................................" + ConsoleColors.WHITE + "Redirecting you to the main menu" + ConsoleColors.RESET + "............................................");
				menuManager.displayMainMenu(user);
			} else if (choice == 1) {
				invalidInput = false;
				menuManager.changePasswordPrompt(user);
			}
		}
	}
}
