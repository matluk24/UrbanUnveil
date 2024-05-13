package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;

public interface ManagerService {

	
	public void uploadUser(User u);
	public void addRole(Role r);
	public List<User> getList();
	
}
