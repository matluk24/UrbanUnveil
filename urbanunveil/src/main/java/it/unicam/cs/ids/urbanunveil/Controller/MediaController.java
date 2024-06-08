package it.unicam.cs.ids.urbanunveil.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Service.MediaService;
import it.unicam.cs.ids.urbanunveil.Entity.Media;

@RestController
public class MediaController {

	
	private MediaService mediaService;
	@Autowired
	public MediaController(MediaService m) {
		mediaService=m;
	}
	
	public MediaController() {
	}
	
	@GetMapping("/media")
	public ResponseEntity<List<Media>> getAllMedias() {
		List<Media> medias;
		medias = mediaService.getAllMedias();
		return new ResponseEntity<List<Media>>(medias, HttpStatus.OK);
	}
	
	@GetMapping("/media/{id}")
	public ResponseEntity<Media> getMedia(@RequestParam Long id) {
		Media m = mediaService.getMediaById(id);
		if(m==null) {
			return new ResponseEntity<Media>(m, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Media>(m, HttpStatus.OK);
	}
	
	@GetMapping("/media/{title}")
	public ResponseEntity<Media> getMedia(@RequestParam String title) {
		Media m = mediaService.getMediaByTitle(title);
		if(m==null) {
			return new ResponseEntity<Media>(m, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Media>(m, HttpStatus.OK);
	}
	
	@GetMapping("/media/{title}/readarticle")
	public ResponseEntity<String> getTextFromArticle(@RequestParam Long id) {
		String s="";
		try {
			s= mediaService.getTextFromFile(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>(s, HttpStatus.OK);
	}
	
	@DeleteMapping("/media/delete/{id}")
	public HttpStatus deleteMedia(@RequestParam Long id) {
		if(mediaService.removeMedia(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}
	
	@PostMapping("/media/add")
	public ResponseEntity<Media> addMedia(@RequestParam String path, @RequestParam String title, @RequestParam String t) {
		Media m =mediaService.addMedia(path, title, t);
		return new ResponseEntity<Media>(m, HttpStatus.OK);
	}
	
	@PostMapping("/media/update/{id}")
	public ResponseEntity<Media> updateMedia(@RequestParam Long id, @RequestParam String path, @RequestParam String title) {
		Media m =mediaService.updateMedia(id, path, title);
		return new ResponseEntity<Media>(m, HttpStatus.OK);
	}
	
	@PostMapping("/media/{id}/writearticle")
	public HttpStatus writeArticle(@RequestParam Long id, @RequestParam String userInput) {
		
		try {
			if(mediaService.writeArticle(id, userInput)!="") {
				return HttpStatus.OK;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.NOT_IMPLEMENTED;
		
	}
	
}
