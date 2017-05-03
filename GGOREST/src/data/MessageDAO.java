package data;

import java.util.List;

import entities.Message;

public interface MessageDAO {
	
	public List<Message> index();	
	
	public Message show();
	
	public Message create(Message message);

}
