package controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.AuthDAO;
import entities.Player;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthDAO aDao;

	@RequestMapping(value="/ping", method=RequestMethod.GET)
	public String ping(){
		return "PONG FROM AUTH CONTROLLER";
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public Player register(HttpSession session, @RequestBody Player player) {
		System.out.println(player);
		player = aDao.register(player);
		session.setAttribute("user", player);
		// TODO : Create the provided user, place the user in session, return
		// the user
		return player;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public Player login(HttpSession session, @RequestBody Player player) {
		player = aDao.login(player);
		session.setAttribute("user", player);
//		if (player.getStatus().equals("admin")) {
//			return null;
//		} else {
//		}
		return player;
	}
	

	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public Boolean logout(HttpSession session, HttpServletResponse res) {
		session.removeAttribute("player");
		return true;
	}

	@RequestMapping(path = "/unauthorized")
	public String unauth(HttpServletResponse response) {
		response.setStatus(401);
		return "unauthorized";
	}
}