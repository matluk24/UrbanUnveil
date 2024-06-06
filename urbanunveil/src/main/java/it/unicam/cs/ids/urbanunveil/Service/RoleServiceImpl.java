package it.unicam.cs.ids.urbanunveil.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

public class RoleServiceImpl implements RoleService {

	RoleRepository r;
	
	@Override
	public Role getRoleByName(String name) {
		RoleName role = RoleName.valueOf(name);
		return r.findRoleByroleName(role);
	}

}
