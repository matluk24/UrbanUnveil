package it.unicam.cs.ids.urbanunveil.Controller;

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
	
	@DeleteMapping("/media/delete/{id}")
	public HttpStatus deleteMedia(@RequestParam Long id) {
		if(mediaService.removeMedia(id)) {
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}
	
	@PostMapping("/media/add")
	public ResponseEntity<Media> addMedia(@RequestParam String path) {
		Media m =mediaService.addMedia(path);
		return new ResponseEntity<Media>(m, HttpStatus.OK);
	}
	
	@PostMapping("/media/update/{id}")
	public ResponseEntity<Media> addMedia(@RequestParam Long id, @RequestParam String path) {
		Media m =mediaService.updateMedia(id, path);
		return new ResponseEntity<Media>(m, HttpStatus.OK);
	}
	
}
