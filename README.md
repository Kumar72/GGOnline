# Summary
A web-app for users who want to find other individuals to play a game with or make a team. This a collaborative project developed with a MAMP stack consisting of Java JPA API, the Spring MVC framework, and MySQL database technologies with CRUD functionality as well as AngularJS for the front end. The database was created with MySQL Workbench.

We also wrote JUnit tests to ensure proper mapping of the entities before moving from JPA to SpringMVC. We then tested the DAO methods to ensure proper CRUD functionality and session persistence of a user.

|Role & Responsibilities                                          | Team Member        |
|-----------------------------------------------------------------|--------------------|
|Project Team Lead                                                | Chandan Thakur     |
|Assistant project programmer                                     | Dennis Carrasquillo|
|Assistant project programmer                                     | Stefan Fuller      |


Issues the team ran into:
- Creating a message/chat functionality for the application.
- Working with the Modals in AngularJS.
- Many To Many Relational Mapping.
- Setting up the Navigation Bar to map to individual pages.



If more time were available:
    - Created a chat feature.
    - Adding notification functionality.
    - Adding player rating functionality.
    - A direct messaging function.

<p align="center">
<img src="readmeimages/scrn1.png" height="245">
<img src="readmeimages/scrn2.png" height="245"></p>
<p align="center">
<img src="readmeimages/scrn3.png" height="245">
<img src="readmeimages/scrn4.png" height="245"></p>
<p align="center">
<img src="readmeimages/scrn5.png" height="245">
<img src="readmeimages/scrn6.png" height="245"></p>
<p align="center">
<img src="readmeimages/scrn7.png" height="245">
<img src="readmeimages/scrn8.png" height="245"></p>
<p align="center"><img src="readmeimages/scrn9.png" height="245"></p>

## In This Document
1. [How to Execute](#how-to-execute)
2. [Class Structure Overview](#class-structure-overview)

## How to Execute
- The web-app is hosted on my AWS server: <a href="http://www.chiangs.ninja:8080/TripLight/">**here**</a>
- Download the entire program as a .war file <a href="https://github.com/chiangs/TripLight/blob/master/TripLightMVC.war">**here**</a>

## Instructions
1. User arrives on landing page
2. User menu:
    - Login / Create Account
    - User Profile Actions (Add/Edit/Delete)
    - Post / Search reviews (Add/Edit/Delete)

## Project Flow & Structure Overview

<p align="center">
<img src="chart1.png" height="245">
<img src="chart2.png" height="245">
</p>

## Code Examples
Here's a snippit of the controller logic for login/logout. It first checks if the username/password entered are valid entries in the database and returns different views depending on the validation.
```Java
    @RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView executeLogin(@Valid Error errors, Model model, User user) {
		ModelAndView mv = new ModelAndView();
		try {
			User isValidUser = loginDelegate.isValidUser(user.getUsername(), user.getPassword());
			if (isValidUser != null) {
				System.out.println("User Login Successful");
				model.addAttribute("sessionUser", isValidUser);
				mv.addObject("loggedInUser",  isValidUser);
				mv.setViewName("userMain");
			}
			else {
				mv.addObject("loggedInUser", user);
				mv.addObject("message", "No such username/password");
				mv.setViewName("index");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public ModelAndView executeLogout(HttpSession session, SessionStatus status) {
	ModelAndView mv = new ModelAndView();
	session.setAttribute("sessionUser", new User());
	status.setComplete();
	mv.setViewName("index");
	return mv;
	}
```

## Technologies Used
- Java JPA API
- Spring MVC and Spring STS
- Gradle Managed Dependencies
- MySQL and MySQL Workbench
- Java Server Pages and JSTL/EL
- HTML
- CSS and Bootstrap
- JavaScript
- AngularJS
