package it.unicam.cs.ids.urbanunveil.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;
import it.unicam.cs.ids.urbanunveil.Service.OSMService;

@RestController
public class OSMController {
	
	private OSMService OSMService;
	
	public OSMController(OSMService OSMService) {
		this.OSMService = OSMService;
	}
	
	@GetMapping("/map/search")
	public ResponseEntity<OSMNode> search(@RequestParam String query) {
		OSMNode node;
		try {
			node = OSMService.search(query);
			return new ResponseEntity<OSMNode>(node, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
}
