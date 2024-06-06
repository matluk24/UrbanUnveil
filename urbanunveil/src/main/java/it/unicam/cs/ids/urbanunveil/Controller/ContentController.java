package it.unicam.cs.ids.urbanunveil.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Service.ContentService;
import it.unicam.cs.ids.urbanunveil.Utilities.NotInWaitingStateException;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

@RestController
public class ContentController {

	
	ContentService contentService;
	
	public ContentController(ContentService c) {
		contentService = c;
	}
	
	@GetMapping("/content")
	public ResponseEntity<List<Content>> getContent() {
		
		List<Content> c = contentService.getAllContents();
		if (c==null) {
			return new ResponseEntity<List<Content>>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Content>>(c, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/content/{id}")
	public ResponseEntity<Content> getContent(@RequestParam Long id) {
		
		Content c = contentService.getContentById(id);
		if (c==null) {
			return new ResponseEntity<Content>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Content>(c, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/content/approved")
	public ResponseEntity<List<Content>> getApprovedContents() {
		
		List<Content> c = contentService.getAllApprovedContent();
		if (c==null) {
			return new ResponseEntity<List<Content>>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Content>>(c, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/content/refused")
	public ResponseEntity<List<Content>> getRefusedContent() {
		
		List<Content> c = contentService.getAllRefusedContent();
		if (c==null) {
			return new ResponseEntity<List<Content>>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Content>>(c, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/content/refused")
	public ResponseEntity<List<Content>> getWaitingContent() {
		
		List<Content> c = contentService.getAllWaitingContent();
		if (c==null) {
			return new ResponseEntity<List<Content>>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Content>>(c, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/content/{id}/state")
	public ResponseEntity<StateEnum> getContentState(@RequestParam Long id) {
		
		StateEnum c = contentService.getContentState(id);
		if (c==null) {
			return new ResponseEntity<StateEnum>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<StateEnum>(c, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/content/add")
	public ResponseEntity<Content> addContent(@RequestParam String d, @RequestParam User p, @RequestParam List<Media> m) {
		Content c = contentService.addContent(d, p, m);
		return new ResponseEntity<Content>(c, HttpStatus.OK);
	}
	
	@PostMapping("/content/update/{id}")
	public ResponseEntity<Content> addContent(@RequestParam Long id, @RequestParam String d, @RequestParam List<Media> m) {
		Content c = contentService.updateContent(id, d, m);
		return new ResponseEntity<Content>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/content/remove/{id}")
	public HttpStatus removeContent(@RequestParam Long id) {
		if(contentService.removeContent(id)) {
			return HttpStatus.OK;
		}
		else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@GetMapping("/content/{id}/changestate")
	public StateEnum changeContentState(@RequestParam Long id, @RequestParam StateEnum s) {
		if(s==StateEnum.APPROVED) {
			try {
				contentService.changeContentStateToApproved(id);
				return s;
			} catch (NotInWaitingStateException e) {
				e.printStackTrace();
			}
		}
		try {
			contentService.changeContentStateToRefused(id);
			return s;
		} catch (NotInWaitingStateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
