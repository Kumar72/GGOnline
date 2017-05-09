package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.MessageDAO;
import entities.Message;

@RestController
public class MessageController {
	
	@Autowired
	MessageDAO messageDAO;
	
	
	

	@RequestMapping(value="messages/ping", method=RequestMethod.GET)
	public String ping(){
		return "PONG FROM GAME CONTROLLER";
	}
	
	
	@RequestMapping(value="messages", method=RequestMethod.GET)
	public List<Message> index(){
		return messageDAO.index();
		
	}
	
	@RequestMapping(value="messages/{id}", method=RequestMethod.GET)
	public Message show(@PathVariable int id){
		return messageDAO.show(id);
	}
	
	@RequestMapping(value = "messages", method = RequestMethod.POST)
	public Message createMessage(@RequestBody String messageJson, HttpServletResponse res) {

		try {
			
			ObjectMapper mapper = new ObjectMapper();
			Message mappedMessage = mapper.readValue(messageJson, Message.class);

			return messageDAO.createMessage(mappedMessage);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("YOU DON MESSED UP BROH!");
		}
		return null;

	}
	
	@RequestMapping(value="messages/{id}", method=RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res,@PathVariable int id) {
		  return messageDAO.destroy(id);
	}
	
	
	
	
	
}
