package it.unicam.cs.ids.urbanunveil.Controller;

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

import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Service.ContestService;

@RestController
public class ContestController {

	
	private ContestService contestService;
	
	@Autowired
	public ContestController(ContestService c) {
		contestService = c;
	}
	
	public ContestController() {
	}
	
	@GetMapping("/contests")
	public ResponseEntity<List<Contest>> getContests() {
		List<Contest> c = contestService.getAllContests();
		
		return new ResponseEntity<List<Contest>>(c, HttpStatus.OK);
	}
	
	@GetMapping("/contests/{id}")
	public ResponseEntity<Contest> getContest(@RequestParam Long id) {
		Contest c = contestService.getContestById(id);
		if(c==null) {
			return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		return new ResponseEntity<Contest>(c, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/contests/{name}")
	public ResponseEntity<Contest> getContest(@RequestParam String name) {
		Contest c = contestService.getContestByName(name);
		if(c==null) {
			return new ResponseEntity<Contest>(c, HttpStatus.OK);
		}
		return new ResponseEntity<Contest>(c, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/contest/{id}/photos")
	public ResponseEntity<List<Media>> getContestPhoto(@RequestParam Long id) {
		List<Media> c = contestService.getAllContestPhotosById(id);
		
		return new ResponseEntity<List<Media>>(c, HttpStatus.OK);
	}
	
	@GetMapping("/contest/{name}/photos")
	public ResponseEntity<List<Media>> getContestPhoto(@RequestParam String name) {
		List<Media> c = contestService.getAllContestPhotosByName(name);
		
		return new ResponseEntity<List<Media>>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/add")
	public ResponseEntity<Contest> addContest(@RequestParam String n, @RequestParam LocalDate s, @RequestParam LocalDate e) {
		Contest c = contestService.addContest(n, s, e);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/update/{id}")
	public ResponseEntity<Contest> updateContest(@RequestParam Long id, @RequestParam String n, @RequestParam LocalDate s, @RequestParam LocalDate e) {
		Contest c = contestService.updateContestById(id, n, s, e);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@PostMapping("/contest/update/{name}")
	public ResponseEntity<Contest> updateContest(@RequestParam String n, @RequestParam LocalDate s, @RequestParam LocalDate e) {
		Contest c = contestService.updateContestByName(n, s, e);
		return new ResponseEntity<Contest>(c, HttpStatus.OK);
	}
	
	@DeleteMapping("/contest/remove/{id}")
	public HttpStatus removeContest(@RequestParam Long id) {
		if(contestService.removeContest(id)) {
			return HttpStatus.OK;
		}
		else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@DeleteMapping("/contest/remove/{name}")
	public HttpStatus removeContest(@RequestParam String name) {
		if(contestService.removeContest(name)) {
			return HttpStatus.OK;
		}
		else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@GetMapping("/contest/{id}/ended")
	public ResponseEntity<Boolean> isContestEnded(@RequestParam Long id) {
		return new ResponseEntity<Boolean>(contestService.isContestEnded(id), HttpStatus.OK);
	}
	
	@GetMapping("/contest/{name}/ended")
	public ResponseEntity<Boolean> isContestEnded(@RequestParam String name) {
		return new ResponseEntity<Boolean>(contestService.isContestEnded(name), HttpStatus.OK);
	}
	
}
