package it.unicam.cs.ids.urbanunveil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
	
	Role findRoleByRole(RoleName name);
	
}
