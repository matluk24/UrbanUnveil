package it.unicam.cs.ids.urbanunveil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.unicam.cs.ids.urbanunveil.Controller.OSMController;
import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;

@SpringBootTest
public class OSMControllerTest {

	@Autowired
	private OSMController osmController;
	
	
	@Test
	void getCityTest() {
		
		OSMNode ny = new OSMNode(Long.valueOf(175905), 40.7127281, -74.0060152, "City of New York, New York, United States");
		
		assertEquals(ny, osmController.search("New York").getBody());
		
		
	}
}
