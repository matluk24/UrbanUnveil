package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Repository.UserRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

import java.util.LinkedList;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public void updateUser(String cf, String name, String surname, String role) {
		//TODO upload information suddenly changed
		
		//userRepository.;
	}
	
	public void addUser(User u) {
		userRepository.save(u);
	}
	
	public User getUserById(Long id) {
		return userRepository.getReferenceById(id);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

}
