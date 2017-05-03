package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.RatingDAO;
import entities.Rating;

@RestController
public class RatingController {
	
	@Autowired
	RatingDAO ratingDAO;
	
	@RequestMapping(value="ratings/ping", method=RequestMethod.GET)
	public String ping(){
		return "PONG!";
	}
	
	@RequestMapping(value="players/{id}/ratings", method=RequestMethod.GET)
	public List<Rating> index(@PathVariable int playerId){
		
		return ratingDAO.index(playerId);
	}
	
	@RequestMapping(value="players/{id}/ratings/{ratingId}", method=RequestMethod.GET)
	public Rating show(@PathVariable int playerId, @PathVariable ("id") int ratingId){
		return ratingDAO.show(playerId, ratingId);
	}
	

}
