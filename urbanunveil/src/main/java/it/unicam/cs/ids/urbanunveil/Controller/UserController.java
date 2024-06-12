package it.unicam.cs.ids.urbanunveil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Service.RoleService;
import it.unicam.cs.ids.urbanunveil.Service.UserService;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

@RestController
public class UserController {

	private UserService userService;
	private RoleService roleService;
	
	@Autowired
	public UserController(UserService u, RoleService r) {
		this.userService= u;
		this.roleService= r;
	}
	public UserController() {
	}
	
	@PostMapping("/register") 
	public ResponseEntity<User> register(@RequestParam String name, @RequestParam  String surname, @RequestParam  String email, @RequestParam  String CF, @RequestParam  String password) {
		Role r = roleService.getRoleByName("TOURIST");
		User u = userService.addUser(name, surname, email, CF, password, r);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("/login") 
	public ResponseEntity<User> login(String email, @RequestParam  String password) {
		if(userService.checkPassword(email, password)) {
			return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
		}
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/userlist")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users;
		users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@RequestParam Long id) {
		User u=  userService.getUserById(id);
		if(u==null) {
			return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestParam String name, @RequestParam  String surname, @RequestParam  String email, @RequestParam  String CF, @RequestParam  String password) {
		Role r = roleService.getRoleByName("TOURIST");
		User u = userService.addUser(name, surname, email, CF, password, r);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("/user/addUser")
	public ResponseEntity<User> addUser(@RequestParam User u) {
		return new ResponseEntity<User>(userService.addUser(u), HttpStatus.OK);
	}
	
	@PostMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestParam Long i, @RequestParam String name, @RequestParam  String surname, @RequestParam  String email, @RequestParam  String CF, @RequestParam String role) {
		Role r = roleService.getRoleByName(role);
		User u = userService.updateUser(i, CF, name, surname, r, email);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public HttpStatus removeUser(@RequestParam Long id) {
		userService.removeUser(id);
		if(userService.getUserById(id)==null) {
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
