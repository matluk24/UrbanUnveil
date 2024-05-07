package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Repository.UserRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

import java.util.LinkedList;

@Service
public class ManagerServiceImpl{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	private void upload() {
		//TODO upload information suddenly changed
	}
	
	private User getUser(Long id) {
		return userRepository.getReferenceById(id);
	}
	
	public List<User> getList(){
		return userRepository.findAll();
	}

}


