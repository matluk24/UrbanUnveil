package it.unicam.cs.ids.urbanunveil.Service;

import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Role;

@Service
public interface RoleService {

	public Role getRoleByName(String name);
	
}
