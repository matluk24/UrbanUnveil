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
public class ManagerServiceImpl{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public void uploadUser(User u) {
		//TODO upload information suddenly changed
		//User temp = this.getUser(u.getId());
		//userRepository.save(temp);
	}
	
	public void addRole(Role r) {
		//TODO upload information suddenly changed
		Role temp = this.getRole(r.getId());
		roleRepository.save(temp);
	}
	
	
	private User getUser(Long id) {
		return userRepository.getReferenceById(id);
	}
	
	private Role getRole(Long id) {
		return roleRepository.getReferenceById(id);
	}
	
	public List<User> getList(){
		return userRepository.findAll();
	}

}
