package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;

public interface UserService {

	
	public User updateUser(Long id, String c, String n, String s, Role r, String e);
	public User addUser(String name, String surname, String email, String CF, Role role);
	public User addUser(User u);
	public User getUserById(Long i);
	public List<User> getAllUsers();
	public boolean removeUser(Long i);
	
}
