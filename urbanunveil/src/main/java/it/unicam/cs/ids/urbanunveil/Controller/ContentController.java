package it.unicam.cs.ids.urbanunveil.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;
import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Service.ContentService;
import it.unicam.cs.ids.urbanunveil.Service.OSMService;
import it.unicam.cs.ids.urbanunveil.Utilities.NotInWaitingStateException;
import it.unicam.cs.ids.urbanunveil.Utilities.RoleName;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

@RestController
public class ContentController {

	
	private ContentService contentService;
	private OSMService osmService;
	
	@Autowired
	public ContentController(ContentService c, OSMService o) {
		contentService = c;
		osmService = o;
	}
	public ContentController() {
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
	
	@GetMapping("/content/waiting")
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
		Content c = null;
		if(p.getRole().getRole().equals(RoleName.CONTRIBUTOR) || p.getRole().getRole().equals(RoleName.TRUSTEDCONTRIBUTOR) || p.getRole().getRole().equals(RoleName.CURATOR)) {
			c=contentService.addContent(d, p, m);
			return new ResponseEntity<Content>(c, HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<Content>(c, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/content/addPoi")
	public ResponseEntity<PointOfInterest> addPOI(@RequestParam String d, @RequestParam User p, @RequestParam List<Media> m, @RequestParam String location, @RequestParam String type) {
		OSMNode l= null;
		PointOfInterest c = null;
		if(p.getRole().getRole().equals(RoleName.CONTRIBUTOR) || p.getRole().getRole().equals(RoleName.TRUSTEDCONTRIBUTOR) || p.getRole().getRole().equals(RoleName.CURATOR)) {
			try {
				l =osmService.search(location);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c=contentService.addPOI(d, p, m, l, type);
			return new ResponseEntity<PointOfInterest>(c, HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<PointOfInterest>(c, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/content/addPoiwithoutmedia")
	public ResponseEntity<PointOfInterest> addPOI(@RequestParam String d, @RequestParam User p, @RequestParam String location, @RequestParam String type) {
		OSMNode l= null;
		PointOfInterest c = null;
		if(p.getRole().getRole().equals(RoleName.CONTRIBUTOR) || p.getRole().getRole().equals(RoleName.TRUSTEDCONTRIBUTOR) || p.getRole().getRole().equals(RoleName.CURATOR)) {
			try {
				l =osmService.search(location);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c=contentService.addPOI(d, p, l, type);
			return new ResponseEntity<PointOfInterest>(c, HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<PointOfInterest>(c, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/content/update/{id}")
	public ResponseEntity<Content> updateContent(@RequestParam User p, @RequestParam Long id, @RequestParam String d, @RequestParam List<Media> m) {
		Content c = null;
		if(p.getRole().getRole().equals(RoleName.CONTRIBUTOR) || p.getRole().getRole().equals(RoleName.TRUSTEDCONTRIBUTOR) || p.getRole().getRole().equals(RoleName.CURATOR)) {
			c=contentService.updateContent(id, d, m);
			return new ResponseEntity<Content>(c, HttpStatus.OK);	
		}
		else {
			return new ResponseEntity<Content>(c, HttpStatus.UNAUTHORIZED);
		}
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
	public StateEnum changeContentState(@RequestParam Long id, @RequestParam String s, @RequestParam User u) {
		if(u.getRole().getRole().equals(RoleName.CURATOR)) {
		if(StateEnum.valueOf(s).equals(StateEnum.APPROVED)) {
			try {
				contentService.changeContentStateToApproved(id);
				return StateEnum.valueOf(s);
			} catch (NotInWaitingStateException e) {
				e.printStackTrace();
			}
		}
		try {
			contentService.changeContentStateToRefused(id);
			return StateEnum.valueOf(s);
		} catch (NotInWaitingStateException e) {
			e.printStackTrace();
		}
		}
		return null;
	}
	
	@GetMapping("/contests")
	public ResponseEntity<List<Contest>> getContests() {
		List<Contest> c = contentService.getAllContests();
		
		return new ResponseEntity<List<Contest>>(c, HttpStatus.OK);
	}
	
	@GetMapping("/contests/{id}")
	public ResponseEntity<Contest> getContest(@RequestParam Long id) {
		Contest c = contentService.getContestById(id);
		if(c==null) {
			return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		return new ResponseEntity<Contest>(c, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/contests/{name}")
	public ResponseEntity<Contest> getContest(@RequestParam String name) {
		Contest c = contentService.getContestByName(name);
		if(c==null) {
			return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		return new ResponseEntity<Contest>(c, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/contest/{id}/photo")
	public ResponseEntity<List<Media>> getContestPhoto(@RequestParam Long id) {
		List<Media> c = contentService.getAllContestPhotosById(id);
		
		return new ResponseEntity<List<Media>>(c, HttpStatus.OK);
	}
	
	@GetMapping("/contest/{name}/photos")
	public ResponseEntity<List<Media>> getContestPhoto(@RequestParam String name) {
		List<Media> c = contentService.getAllContestPhotosByName(name);
		
		return new ResponseEntity<List<Media>>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/add")
	public ResponseEntity<Contest> addContest(@RequestParam String d, @RequestParam User u, @RequestParam String n, @RequestParam LocalDate s, @RequestParam LocalDate e) {
		Contest c =null;
		if(u.getRole().getRole().equals(RoleName.CONTRIBUTOR) || u.getRole().getRole().equals(RoleName.TRUSTEDCONTRIBUTOR) || u.getRole().getRole().equals(RoleName.CURATOR)) {
		c = contentService.addContest(d, u, n, s, e);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Contest>(c, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/contest/{id}/addphoto")
	public ResponseEntity<Contest> addContestPhoto(@RequestParam Long id, @RequestParam Media m) {
		Contest c = contentService.addPhotoToContest(id, m);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/{id}/addphotos")
	public ResponseEntity<Contest> addContestPhoto(@RequestParam Long id, @RequestParam List<Media> m) {
		Contest c = contentService.addPhotoToContest(id, m);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/{id}/removephotos")
	public ResponseEntity<Contest> removeContestPhoto(@RequestParam Long id, @RequestParam List<Media> m) {
		Contest c = contentService.removePhotoFromContest(id, m);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/{id}/removephoto")
	public ResponseEntity<Contest> removeContestPhoto(@RequestParam Long id, @RequestParam Media m) {
		Contest c = contentService.removePhotoFromContest(id, m);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/update/{id}")
	public ResponseEntity<Contest> updateContest(@RequestParam Long id, @RequestParam User u, @RequestParam String d, @RequestParam String n, @RequestParam LocalDate s, @RequestParam LocalDate e) {
		Contest c =null;
		if(u.getRole().getRole().equals(RoleName.CONTRIBUTOR) || u.getRole().getRole().equals(RoleName.ANIMATORE)) {
		c = contentService.updateContestById(id, d, n, s, e);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Contest>(c, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/contest/update/{name}")
	public ResponseEntity<Contest> updateContest(@RequestParam User u, @RequestParam String d, @RequestParam String n, @RequestParam LocalDate s, @RequestParam LocalDate e) {
		Contest c =null;
		if(u.getRole().getRole().equals(RoleName.CONTRIBUTOR)  || u.getRole().getRole().equals(RoleName.ANIMATORE)) {
		c = contentService.updateContestByName(d, n, s, e);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Contest>(c, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@DeleteMapping("/contest/remove/{id}")
	public HttpStatus removeContest(@RequestParam Long id, @RequestParam User u) {
			if(u.getRole().getRole().equals(RoleName.CONTRIBUTOR)  || u.getRole().getRole().equals(RoleName.ANIMATORE)) {
				if(contentService.removeContest(id)) {
					return HttpStatus.OK;
				}
				else {
					return HttpStatus.NOT_FOUND;
				}
			}
			else {
				return HttpStatus.UNAUTHORIZED;
			}
	}
	
	@DeleteMapping("/contest/remove/{name}")
	public HttpStatus removeContest(@RequestParam String name, @RequestParam User u) {
		if(u.getRole().getRole().equals(RoleName.CONTRIBUTOR)  || u.getRole().getRole().equals(RoleName.ANIMATORE)) {
			if(contentService.removeContest(name)) {
				return HttpStatus.OK;
			}
			else {
				return HttpStatus.NOT_FOUND;
			}
		}
		else {
			return HttpStatus.UNAUTHORIZED;
		}
	}
	
	@GetMapping("/contest/{id}/ended")
	public ResponseEntity<Boolean> isContestEnded(@RequestParam Long id) {
		return new ResponseEntity<Boolean>(contentService.isContestEnded(id), HttpStatus.OK);
	}
	
	@GetMapping("/contest/{name}/ended")
	public ResponseEntity<Boolean> isContestEnded(@RequestParam String name) {
		return new ResponseEntity<Boolean>(contentService.isContestEnded(name), HttpStatus.OK);
	}
	
	
}
