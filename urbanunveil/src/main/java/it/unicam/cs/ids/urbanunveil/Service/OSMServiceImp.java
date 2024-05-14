package it.unicam.cs.ids.urbanunveil.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;

@Service
public class OSMServiceImp implements OSMService {
	
	

	public OSMServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public OSMNode search(String query) {
		RestTemplate r = new RestTemplate();
		String url =String.format("%s?q=%s&format=json", "https://nominatim.openstreetmap.org/search", query);
		try{
			ResponseEntity<String> responce =  r.getForEntity(url, String.class);;
			String json = responce.getBody();
			ObjectMapper mapper = new ObjectMapper();
			return 	mapper.readValue(json, OSMNode.class);
			
		}catch(RestClientException ex) {
			ex.printStackTrace();
		}catch(JsonMappingException ex) {
			ex.printStackTrace();
		}catch(JsonProcessingException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
