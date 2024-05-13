package it.unicam.cs.ids.urbanunveil.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OSMController {

	
	@GetMapping("/map/search")
	public ResponseEntity<String> search(@RequestParam String query) {
		RestTemplate r = new RestTemplate();
		String url =String.format("%s?q=%s&format=json", "https://nominatim.openstreetmap.org/search", query);
		String response = r.getForObject(url, String.class);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
