package it.unicam.cs.ids.urbanunveil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import it.unicam.cs.ids.urbanunveil.Controller.ContentController;
import it.unicam.cs.ids.urbanunveil.Controller.TourController;
import it.unicam.cs.ids.urbanunveil.Controller.UserController;
import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.Role;
import it.unicam.cs.ids.urbanunveil.Entity.Tour;
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
    private ContentController contentController;

    @Test
    void getTourTest() {
    	
    	Role r = new Role(RoleName.CONTRIBUTOR, "Un utente che può aggiungere contenuti e itinerari");
    	roleRepo.save(r);
    	User u = new User("Mattia", "Luciani", "boh@studenti.unicam.it", "MTLC7187Y1834", "1234", r);
    	userController.addUser(u);
    	
    	PointOfInterest p = contentController.addPOI("La selva di castelfidardo", u, "Selva di castelfidardo", "PHISICAL").getBody();
    	
    	List<PointOfInterest> l = new ArrayList<PointOfInterest>();
    	l.add(p);
    	
    	assertEquals(tourController.addTour("Giro di osimo", l, u).getBody().toString(), tourController.getTour("Giro di osimo").getBody().toString());
    	
    	
    }
    
    @Test
    void updateTourStops() {
    	
    	Tour t = tourController.getTour("Giro di osimo").getBody();
    	
    	PointOfInterest p = contentController.addPOI("New York", userController.getUser(Long.valueOf(1)).getBody(), "New York", "PHISICAL").getBody();
    	
    	tourController.addTourStop(t.getId(), p);
    	
    	t=tourController.getTour("Giro di osimo").getBody();
    	
    	assertEquals(t.getStops().size(), 2);
    	
    	tourController.removeTourStop(t.getId(), p);
    	
    	t=tourController.getTour("Giro di osimo").getBody();
    	
    	assertEquals(t.getStops().size(), 1);
    	
    	
    }
}
