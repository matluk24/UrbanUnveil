package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	public User updateUser(Long id, String cf, String name, String surname, Role role, String email) {
		User u = this.getUserById(id);
		u.setCF(cf);
		u.setName(name);
		u.setSurname(surname);
		u.setEmail(email);
		return userRepository.saveAndFlush(u);
	}
	
	public User addUser(String name, String surname, String email, String CF, Role role) {
		User u = new User(name, surname, email, CF, role);
		return userRepository.save(u);
	}
	
	public User getUserById(Long id) {
		if(userRepository.existsById(id)) {
			return userRepository.getReferenceById(id);
		}
		return null;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

}
