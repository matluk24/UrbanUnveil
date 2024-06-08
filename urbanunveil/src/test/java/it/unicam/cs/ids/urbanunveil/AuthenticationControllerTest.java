package it.unicam.cs.ids.urbanunveil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import it.unicam.cs.ids.urbanunveil.Controller.AuthenticationController;

@SpringBootTest
public class AuthenticationControllerTest {

	@Autowired
	private AuthenticationController authController;
	
	@Test
	void loginTest() {
		
		assertEquals(HttpStatus.OK, authController.register("Mattia", "Luciani", "mattia01.luciani@studenti.unicam.it", "MNUBUBF7878", "Ciao1234").getStatusCode());
		
		assertEquals(HttpStatus.OK, authController.login("mattia01.luciani@studenti.unicam.it", "Ciao1234").getStatusCode());
		assertEquals(HttpStatus.UNAUTHORIZED, authController.login("mattia01.luciani@studenti.unicam.it", "boh").getStatusCode());
	}
}
