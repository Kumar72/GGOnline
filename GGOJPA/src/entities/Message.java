package entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	
//	@Column(name="user_id")
//	private int userId;
//	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="message_id")
	private int messageId;
	
	@ManyToOne
	  @JoinColumn(name="message_id")
	  private Message messAge;

	  @OneToMany(mappedBy="messAge")
	  private List<Message> messages;
	
	@ManyToMany(mappedBy="messages")
	  private List<Player> players;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", createdDate=" + createdDate
				+ ", messageId=" + messageId + "]";
	}
	


}
