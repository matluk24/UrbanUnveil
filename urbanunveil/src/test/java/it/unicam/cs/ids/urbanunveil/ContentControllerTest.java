package it.unicam.cs.ids.urbanunveil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.unicam.cs.ids.urbanunveil.Controller.ContentController;
import it.unicam.cs.ids.urbanunveil.Controller.MediaController;
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
	@Autowired
	private MediaController mediaController;
	
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
	
	@Test
	void addPhotoToContestTest() {
		
		Role r = new Role(RoleName.CONTRIBUTOR, "Un utente che può gestire contenuti e feedbacks");
    	roleRepo.save(r);
    	User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", "1234", r);
    	userController.addUser(u);
    	Media m = mediaController.addMedia("/Photos/contest/1", "Foto della selva", "PHOTO").getBody();
    	
    	contentController.addContest("Un contest sulla selva di castelfidardo", u, "Gara foto selva", LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 15));
    	
    	contentController.addContestPhoto(Long.valueOf(1), m);
    	
    	assertThat(contentController.getContestPhoto(Long.valueOf(1)).getBody().contains(m));
    	
    	contentController.removeContestPhoto(Long.valueOf(1), m);
    	assertThat(contentController.getContestPhoto(Long.valueOf(1)).getBody().isEmpty());
    	
	}
}
