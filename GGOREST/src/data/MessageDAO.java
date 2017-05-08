package data;

import java.util.List;

import entities.Message;

public interface MessageDAO {
	
	public List<Message> index();	
	
	public Message show(int messageId);
	
	public Message createMessage(Message message);
	
	public boolean destroy(int messageId);

}
