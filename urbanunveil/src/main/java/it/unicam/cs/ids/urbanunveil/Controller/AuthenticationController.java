package it.unicam.cs.ids.urbanunveil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Service.UserService;

@RestController
public class AuthenticationController {

	
	private UserService userService;
	private UserController userController;
	
	@Autowired
	public AuthenticationController(UserService u, UserController uc) {
		this.userService= u;
		this.userController = uc;
	}
	public AuthenticationController() {
	}
	
	@PostMapping("/register") 
	public ResponseEntity<User> register(@RequestParam String name, @RequestParam  String surname, @RequestParam  String email, @RequestParam  String CF, @RequestParam  String password) {
		return userController.addUser(name, surname, email, CF, password);
	}
	
	@PostMapping("/login") 
	public ResponseEntity<User> login(String email, @RequestParam  String password) {
		if(userService.checkPassword(email, password)) {
			return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
		}
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.UNAUTHORIZED);
	}
}
