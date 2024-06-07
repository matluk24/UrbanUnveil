package it.unicam.cs.ids.urbanunveil.Entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 	private long userID;
	    private String name;
	    private String surname;
	    private String email;
		private String CF;
		@ManyToOne
	    @JoinColumn(name = "role_id")
	    private Role role;

	    public User(String name, String surname, String email, String CF, Role role) {
	        this.name = name;
	        this.surname = surname;
	        this.email = email;
	        this.CF = CF;
	        this.role = role;
	    }
	    
	    public User() {
	    }
	    
		public void setName(String name) {
			this.name = name;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setCF(String cF) {
			CF = cF;
		}

		public void setRole(Role role) {
			this.role = role;
		}

	    public long getId() {
	        return userID;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getCF() {
	        return CF;
	    }

	    public Role getRole() {
	        return role;
	    }

	    @java.lang.Override
	    public java.lang.String toString() {
	        return "User{" +
	                "id=" + userID +
	                ", name=" + name +
	                ", surname=" + surname +
	                ", email='" + email + '\'' +
	                ", CF='" + CF + '\'' +
	                ", role=" + role +
	                '}';
	    }

		@Override
		public int hashCode() {
			return Objects.hash(CF, email, name, role, surname, userID);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(CF, other.CF) && Objects.equals(email, other.email)
					&& Objects.equals(name, other.name) && Objects.equals(role, other.role)
					&& Objects.equals(surname, other.surname) && userID == other.userID;
		}
	    
	    
}
