package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.Objects;

import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;
import jakarta.persistence.*;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private RoleName roleName;
	private String description;
	
	public Role(RoleName role, String description) {
		this.description = description;
		this.roleName = role;
		
	}
	
	public Role() {
	}
	
	
	public Long getId() {
		return this.id;
		}
	public RoleName getRole() {
		return this.roleName;
	}
	public String getDesctiption() {
		return this.description;
	}
	@Override
	public String toString() {
		return " id : "+this.id+
				"role :"+this.roleName+
				"description : "+this.description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(description, other.description) && id == other.id && roleName == other.roleName;
	}
	 
}
