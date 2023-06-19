package DataModels.Messages;

import DataModels.Book;
import DataModels.Bookstore;
import DataModels.User;
import DataModels.Visuals.ConsoleColors;


import java.util.List;

public class TradeManager {
	public static void sendMessage(User user, User userWithEmail, Message message, Bookstore bookstore) {
		user.getInbox().add(message);
		userWithEmail.getInbox().add(message);
		bookstore.saveUsersToFile();
		System.out.println(ConsoleColors.GREEN + "Message sent to user successfully!" + ConsoleColors.RESET);
	}
	public static boolean cancelTradeRequest(User user, int code, Bookstore bookstore) {
		Message messageWithCode = user.getInbox()
				.stream()
				.filter(aMessage -> aMessage.getCode() == code)
				.findFirst()
				.orElse(null);
		if (messageWithCode == null) {
			System.out.println("Message with entered code not found.");
			return false;
		} if (!(messageWithCode instanceof TradeMessage tradeMessage)){
			System.out.println("The message you want to cancel is not a trade request." +
					" Please consider the normal message deletion option.");
			return false;
		}
		User userThatSent = bookstore.getUsers()
				.stream()
				.filter(aUser -> aUser.getEmail().equals(messageWithCode.getSenderEmail()))
				.findFirst()
				.orElse(null);
		if (userThatSent == null) {
			System.out.println("It appears the sender's account does not exist in the system anymore." +
					" Please consider the normal message deletion option.");
			return false;
		}
		user.getInbox().remove(messageWithCode);
		userThatSent.getInbox().remove(messageWithCode);
		String cancelNotificationContent = "Dear user " + userThatSent.getUsername() + ". The user " + user.getUsername() +
				" has declined your trade request code " + messageWithCode.getCode() + " =, books to exchange: " + tradeMessage.getReceiverBookName() +
				" and " + tradeMessage.getSenderBookName() + '.';
		String cancelNotificationTitle = "Notification about the cancellation of the trade request code: " + messageWithCode.getCode() + '.';
		Message cancelNotification = new Message("amazbooks@amazon.com", userThatSent.getEmail(), cancelNotificationTitle,
				cancelNotificationContent);
		userThatSent.getInbox().add(cancelNotification);
		bookstore.saveUsersToFile();
		System.out.println("Trade request canceled successfully!");
		return true;
	}
	public static boolean acceptTradeRequest(User user, int code, Bookstore bookstore) {
		Message messageWithCode = user.getInbox()
				.stream()
				.filter(aMessage -> aMessage.getCode() == code)
				.findFirst()
				.orElse(null);
		if (messageWithCode == null){
			System.out.println("Message with entered code not found.");
			return false;
		} if (!(messageWithCode instanceof TradeMessage tradeMessage)) {
			System.out.println("The message you want to accept is not a trade request.");
			return false;
		}
		Book bookToGive = user.getPurchasedBooks()
				.stream()
				.filter(aBook -> aBook.getIsbn().equals((tradeMessage).getReceiverBookISBN()))
				.findFirst()
				.orElse(null);
		if (bookToGive == null) {
			System.out.println("It appears the book to give in the trade request does not exist in your inventory anymore.");
			return false;
		}
		User userThatSent = bookstore.getUsers()
				.stream()
				.filter(aUser -> aUser.getEmail().equals(tradeMessage.getSenderEmail()))
				.findFirst()
				.orElse(null);
		if (userThatSent == null) {
			System.out.println("It appears the sender's account does not exist in the system anymore.");
			return false;
		}
		Book bookToReceive = userThatSent.getPurchasedBooks()
				.stream()
				.filter(aBook -> aBook.getIsbn().equals((tradeMessage).getSenderBookISBN()))
				.findFirst()
				.orElse(null);
		if (bookToReceive == null) {
			System.out.println("It appears the book to receive in the trade request does not exist in the sender's inventory anymore.");
			return false;
		}
		user.getPurchasedBooks().add(bookToReceive);
		user.getPurchasedBooks().remove(bookToGive);
		userThatSent.getPurchasedBooks().add(bookToGive);
		userThatSent.getPurchasedBooks().remove(bookToReceive);
		user.getInbox().remove(messageWithCode);
		userThatSent.getInbox().remove(messageWithCode);
		bookstore.saveUsersToFile();
		System.out.println("Trade operation executed successfully!");
		return true;
	}
	public static void showSentMessages(User user) {
		List<Message> messages = user.getInbox();

		System.out.println("Sent Messages from user: " + user.getEmail());
		for (Message message : messages) {
			if (message.getSenderEmail().equals(user.getEmail()) && !message.getReceiverEmail().equals(user.getEmail())) {
				System.out.println(message);
			}
		}
	}
	public static void showReceivedMessages(User user) {
		List<Message> messages = user.getInbox();

		System.out.println("Received Messages for user: " + user.getEmail());
		for (Message message : messages) {
			if (message.getReceiverEmail().equals(user.getEmail()) && !message.getSenderEmail().equals(user.getEmail())) {
				System.out.println(message);
			}
		}
	}
	public static boolean deleteMessage(User user, int code, Bookstore bookstore) {
		boolean messageDeleted = user.getInbox()
				.stream()
				.filter(message -> message.getCode() == code)
				.findFirst()
				.map(message -> {
					user.getInbox().remove(message);
					return true;
				})
				.orElse(false);

		if (messageDeleted) {
			System.out.println("Message with code " + code + " deleted successfully.");
			bookstore.saveUsersToFile();
			return true;
		} else {
			System.out.println("Message with code " + code + " does not exist.");
			return false;
		}
	}
	public static void viewOtherUsersBooks(String email, Bookstore bookstore){
		User matchingUser = bookstore.getUsers()
				.stream()
				.filter(user -> user.getEmail().equals(email))
				.findFirst()
				.orElse(null);
		if (matchingUser == null){
			System.out.println(ConsoleColors.RED + "User not found!" + ConsoleColors.RESET);
		} else if (matchingUser.getPurchasedBooks().isEmpty()) {
			System.out.println(ConsoleColors.YELLOW + "The user has not purchased any books as of yet." + ConsoleColors.RESET);
		} else {
			matchingUser.printBooksList();
		}
	}
}