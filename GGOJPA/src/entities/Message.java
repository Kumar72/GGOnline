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

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setMessAge(Message messAge) {
		this.messAge = messAge;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", createdDate=" + createdDate + ", messAge=" + messAge
				+ ", messages=" + messages + ", players=" + players + "]";
	}

	


}
