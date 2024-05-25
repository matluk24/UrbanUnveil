package it.unicam.cs.ids.urbanunveil.Service;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import org.json.JSONArray;

import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;
import it.unicam.cs.ids.urbanunveil.Utilities.JsonAdapterToOSMNode;

@Service
public class OSMServiceImp implements OSMService {
	
	private JsonAdapterToOSMNode a = new JsonAdapterToOSMNode();

	public OSMServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public OSMNode search(String query) {
		RestTemplate r = new RestTemplate();
		String url =String.format("%s?q=%s&format=json", "https://nominatim.openstreetmap.org/search", query);
		try{
			ResponseEntity<String> responce =  r.getForEntity(url, String.class);
			System.out.println(responce.getBody());
			JSONArray json = new JSONArray(responce.getBody());
			return a.JsonToOSMNode(json);
			
		}catch(RestClientException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
