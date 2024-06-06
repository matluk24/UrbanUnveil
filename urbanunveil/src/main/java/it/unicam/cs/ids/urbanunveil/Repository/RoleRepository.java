package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

public interface RoleRepository extends JpaRepository<Role,Long>{
	
	Role findRoleByroleName(RoleName name);
	
}
