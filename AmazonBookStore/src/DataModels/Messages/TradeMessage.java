package DataModels.Messages;

import java.io.Serializable;
import java.util.Objects;

public class TradeMessage extends Message implements Serializable {
	private final String senderBookISBN;
	private final String receiverBookISBN;
	private final String senderBookName;
	private final String receiverBookName;
	public TradeMessage(String senderEmail, String receiverEmail, String title, String content,
	                    String senderBookISBN, String receiverBookISBN, String senderBookName, String receiverBookName) {
		super(senderEmail, receiverEmail, title, content);
		this.senderBookISBN = senderBookISBN;
		this.receiverBookISBN = receiverBookISBN;
		this.senderBookName = senderBookName;
		this.receiverBookName = receiverBookName;
	}
	public String getSenderBookISBN() {
		return senderBookISBN;
	}
	public String getReceiverBookISBN() {
		return receiverBookISBN;
	}
	public String getSenderBookName() {
		return senderBookName;
	}
	public String getReceiverBookName() {
		return receiverBookName;
	}
	@Override
	public String toString() {
		return "TradeMessage{" +
				"Type: '" + getType() + '\n' +
				", Sender Email:'" + getSenderEmail() + '\n' +
				", Receiver Email:'" + getReceiverEmail() + '\n' +
				", Date Sent:'" + getDateSent() +
				", Title:'" + getTitle() + '\n' +
				", Content: '" + getContent() + '\n' +
				", Code: " + getCode() +
				", Sender Book ISBN: '" + senderBookISBN + '\n' +
				", Sender Book Name: '" + senderBookName + '\n' +
				", Receiver Book ISBN: '" + receiverBookISBN + '\n' +
				", Receiver Book Name: '" + receiverBookName + '\n' +
				'}' + '\n' +
				"----------------------------------------------------------------";
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		TradeMessage that = (TradeMessage) o;
		return Objects.equals(senderBookISBN, that.senderBookISBN) &&
				Objects.equals(receiverBookISBN, that.receiverBookISBN) &&
				Objects.equals(senderBookName, that.senderBookName) &&
				Objects.equals(receiverBookName, that.receiverBookName);
	}
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), senderBookISBN, receiverBookISBN, senderBookName, receiverBookName);
	}
}

