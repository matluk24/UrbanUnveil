package it.unicam.cs.ids.urbanunveil.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Service.TourService;
import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.Tour;
import it.unicam.cs.ids.urbanunveil.Entity.User;

@RestController
public class TourController {

	TourService tourService;
	
	public TourController(TourService t) {
		tourService=t;
	}
	
	@GetMapping("/tours")
	public ResponseEntity<List<Tour>> getTours() {
		List<Tour> t = tourService.getAllTours();
		return new ResponseEntity<List<Tour>>(t, HttpStatus.OK);
	}
	
	@GetMapping("/tours/{id}")
	public ResponseEntity<Tour> getTour(@RequestParam Long id) {
		Tour t = tourService.getTourById(id);
		if(t==null) {
			return new ResponseEntity<Tour>(t, HttpStatus.OK);
		}
		return new ResponseEntity<Tour>(t, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/tours/{name}")
	public ResponseEntity<Tour> getTour(@RequestParam String name) {
		Tour t = tourService.getTourByName(name);
		if(t==null) {
			return new ResponseEntity<Tour>(t, HttpStatus.OK);
		}
		return new ResponseEntity<Tour>(t, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/tours/{user}")
	public ResponseEntity<List<Tour>> getTour(@RequestParam User u) {
		List<Tour> t = tourService.getAllUserTours(u);
		if(t==null) {
			return new ResponseEntity<List<Tour>>(t, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tour>>(t, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/tours/add")
	public ResponseEntity<Tour> addTour(@RequestParam String n, @RequestParam List<PointOfInterest> s, @RequestParam User c) {
		Tour t = tourService.addTour(n, s, c);
		return new ResponseEntity<Tour>(t, HttpStatus.OK);
	}
	
	@PostMapping("/tours/update/{id}") 
	public ResponseEntity<Tour> updateTour(@RequestParam Long i, @RequestParam String n, @RequestParam List<PointOfInterest> s) {
		Tour t = tourService.updateTour(i, n, s);
		return new ResponseEntity<Tour>(t, HttpStatus.OK);
	}
	
	@PostMapping("/tours/addStop/{id}")
	public ResponseEntity<Tour> addTourStop(@RequestParam Long id, @RequestParam PointOfInterest s) {
		Tour t = tourService.addStop(id, s);
		return new ResponseEntity<Tour>(t, HttpStatus.OK);
	}
	
	@PostMapping("/tours/addStops/{id}")
	public ResponseEntity<Tour> addTourStop(@RequestParam Long id, @RequestParam List<PointOfInterest> s) {
		Tour t = tourService.addStop(id,s);
		return new ResponseEntity<Tour>(t, HttpStatus.OK);
	}
	
	@PostMapping("/tours/removeStop/{id}")
	public ResponseEntity<Tour> removeTourStop(@RequestParam Long id, @RequestParam PointOfInterest s) {
		Tour t = tourService.removeStop(id, s);
		return new ResponseEntity<Tour>(t, HttpStatus.OK);
	}
	@PostMapping("/tours/removeStops/{id}")
	public ResponseEntity<Tour> removeTourStop(@RequestParam Long id, @RequestParam List<PointOfInterest> s) {
		Tour t = tourService.removeStop(id, s);
		return new ResponseEntity<Tour>(t, HttpStatus.OK);
	}
	
	@DeleteMapping("/tours/{id}")
	public HttpStatus removeTour(@RequestParam Long id) {
		if(tourService.removeTour(id)) {
			return HttpStatus.OK;
		}
		else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	
	
}
