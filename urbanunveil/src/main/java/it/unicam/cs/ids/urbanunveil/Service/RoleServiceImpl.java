package it.unicam.cs.ids.urbanunveil.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository r;
	
	@Autowired
	public RoleServiceImpl (RoleRepository roleRepository) {
		r=roleRepository;
	}
	
	public RoleServiceImpl () {
	}
	
	@Override
	public Role getRoleByName(String name) {
		return r.findRoleByRole(RoleName.valueOf(name));
	}

}
