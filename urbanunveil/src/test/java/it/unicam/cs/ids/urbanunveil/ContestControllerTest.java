package it.unicam.cs.ids.urbanunveil;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import it.unicam.cs.ids.urbanunveil.Controller.ContestController;
import it.unicam.cs.ids.urbanunveil.Controller.MediaController;
import it.unicam.cs.ids.urbanunveil.Controller.UserController;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.MediaEnum;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

@SpringBootTest
public class ContestControllerTest {

	@Autowired
	private ContestController contestController;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private MediaController mediaController;
	@Autowired
	private UserController userController;
	
	@Test
	void addPhotoToContestTest() {
		
		Role r = new Role(RoleName.CONTRIBUTOR, "Un utente che può gestire contenuti e feedbacks");
    	roleRepo.save(r);
    	User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", "1234", r);
    	userController.addUser(u);
    	Media m = mediaController.addMedia("/Photos/contest/1", "Foto della selva", "PHOTO").getBody();
    	
    	contestController.addContest("Gara foto selva", LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 15), u);
    	
    	contestController.addContestPhoto(Long.valueOf(1), m);
    	
    	assertThat(contestController.getContestPhoto(Long.valueOf(1)).getBody().contains(m));
    	
    	contestController.removeContestPhoto(Long.valueOf(1), m);
    	assertThat(contestController.getContestPhoto(Long.valueOf(1)).getBody().isEmpty());
    	
	}
		
		
}
