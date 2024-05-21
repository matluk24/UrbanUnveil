package it.unicam.cs.ids.urbanunveil.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface OSMService {
	
	public <OMSNode> OMSNode search(String query) throws IOException;
	
}
