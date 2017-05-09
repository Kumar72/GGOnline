package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message_recipient")
public class MessageRecipient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="message_id")
	private int messageId;
	
//	@Column(name="user_team_id")
//	private int userTeamId;
	
	@Column(name="is_read")
	private Boolean isRead;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "MessageRecipient [id=" + id + ", userId=" + userId + ", messageId=" + messageId + ", isRead=" + isRead
				+ "]";
	}
	
	
	
}