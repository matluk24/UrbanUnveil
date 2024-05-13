package it.unicam.cs.ids.urbanunveil.Entity;

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
	    @OneToOne
	    private Role role;

	    public User(long id, String name, String surname, String email, String CF, Role role) {
	        this.userID = id;
	        this.name = name;
	        this.surname = surname;
	        this.email = email;
	        this.CF = CF;
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
}
