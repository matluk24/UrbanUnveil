package it.unicam.cs.ids.urbanunveil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.unicam.cs.ids.urbanunveil.Controller.MediaController;
import it.unicam.cs.ids.urbanunveil.Entity.Media;

@SpringBootTest
public class MediaControllerTest {

	@Autowired
	private MediaController mediaController;
	
	@Test
	void addAndGetMediaTest() {
		
		ResponseEntity<Media> m = mediaController.addMedia("/boh/test", "Articolodiprova", "FILE");
		
		assertEquals(HttpStatus.OK, m.getStatusCode());
		assertEquals(m.getBody(), mediaController.getMedia(m.getBody().getId()).getBody());
	}
	
	@Test
	void writeArticle() {
		
		
		Media m = mediaController.getMedia("Articolodiprova").getBody();
		
		mediaController.writeArticle(m.getId(), "Facciamo questa prova va");
		
		
		System.out.println(mediaController.getTextFromArticle(m.getId()));
		
	}
}
