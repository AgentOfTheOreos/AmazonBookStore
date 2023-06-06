package DataModels.Messages;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message implements Serializable {
	private final String type;
	private final String senderEmail;
	private final String receiverEmail;
	private final LocalDateTime dateSent;
	private final String title;
	private final String content;
	private final int code;
	public Message(String senderEmail, String receiverEmail, String title, String content)
	{
		type = this instanceof TradeMessage ? "TRADE REQ" : "NORMAL";
		this.senderEmail = senderEmail;
		this.receiverEmail = receiverEmail;
		dateSent = LocalDateTime.now();
		this.title = title;
		this.content = content;
		this.code = getNextCode();
	}
	public String getType() {
		return type;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public LocalDateTime getDateSent() {
		return dateSent;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getCode() {
		return code;
	}
	private int getNextCode() {
		int nextCode = 0;
		try {
			// Read the last assigned code from a file
			File file = new File("ObjectFiles/last_assigned_code.txt");
			if (file.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				nextCode = Integer.parseInt(reader.readLine());
				reader.close();
			}
			// Increment the code and save it for the next message
			nextCode++;
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(String.valueOf(nextCode));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nextCode;
	}
	@Override
	public String toString() {
		return "Message{" +
				"Type: '" + type + '\n' +
				", Sender Name:'" + senderEmail + '\n' +
				", Receiver Name:'" + receiverEmail + '\n' +
				", Date Sent:'" + dateSent +
				", Title:'" + title + '\n' +
				", Content: '" + content + '\n' +
				", Code: " + code +
				'}' + '\n' +
				"----------------------------------------------------------------";
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Message message = (Message) o;
		return getCode() == message.getCode() && Objects.equals(getSenderEmail(), message.getSenderEmail()) &&
				Objects.equals(getReceiverEmail(), message.getReceiverEmail()) &&
				Objects.equals(getDateSent(), message.getDateSent()) &&
				Objects.equals(getTitle(), message.getTitle()) && Objects.equals(getContent(), message.getContent());
	}
	@Override
	public int hashCode() {
		return Objects.hash(getSenderEmail(), getReceiverEmail(), getDateSent(), getTitle(), getContent(), getCode());
	}
}
