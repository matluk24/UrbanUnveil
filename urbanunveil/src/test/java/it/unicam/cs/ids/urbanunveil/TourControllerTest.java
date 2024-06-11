package it.unicam.cs.ids.urbanunveil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import it.unicam.cs.ids.urbanunveil.Controller.OSMController;
import it.unicam.cs.ids.urbanunveil.Controller.TourController;
import it.unicam.cs.ids.urbanunveil.Controller.UserController;
import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.POIEnum;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;

@SpringBootTest
public class TourControllerTest {

	
	@Autowired
	private UserController userController;
	@Autowired
	private RoleRepository roleRepo;
    @Autowired
    private TourController tourController;
    @Autowired
    private OSMController osmController;

    @Test
    void getTourTest() {
    	
    	Role r = new Role(RoleName.CONTRIBUTOR, "Un utente che può aggiungere contenuti e itinerari");
    	roleRepo.save(r);
    	User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", "1234", r);
    	userController.addUser(u);
    	
    	
    	PointOfInterest p = new PointOfInterest("La selva di castelfidardo", u, new ArrayList<Media>(), osmController.search("Selva di castelfidardo").getBody(), POIEnum.PHISICAL);
    	
    	List<PointOfInterest> l = new ArrayList<PointOfInterest>();
    	l.add(p);
    
    	assertEquals(tourController.addTour("Giro di osimo", l, u).getBody(), tourController.getTour("Giro di osimo"));
    	
    	
    }
}
