package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;

public interface UserService {

	
	public void updateUser(String c, String n, String s, String r);
	public void addUser(User u);
	public User getUserById(Long i);
	public List<User> getAllUsers();
	
}
