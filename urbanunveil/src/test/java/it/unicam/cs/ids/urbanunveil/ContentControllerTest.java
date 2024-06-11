package it.unicam.cs.ids.urbanunveil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.unicam.cs.ids.urbanunveil.Controller.ContentController;
import it.unicam.cs.ids.urbanunveil.Controller.UserController;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

@SpringBootTest
public class ContentControllerTest {

	@Autowired
	private ContentController contentController;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserController userController;
	
	@Test
	void changeStateTest() {
		
		Role r = new Role(RoleName.CURATOR, "Un utente che può gestire contenuti e feedbacks");
    	roleRepo.save(r);
    	User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", "1234", r);
    	userController.addUser(u);
		
		contentController.addContent("boh", u, new ArrayList<Media>());
		
		contentController.changeContentState(Long.valueOf(1), "APPROVED", u);
		
		assertEquals(contentController.getContent(Long.valueOf(1)).getBody().getState(), StateEnum.APPROVED);
	}
}
