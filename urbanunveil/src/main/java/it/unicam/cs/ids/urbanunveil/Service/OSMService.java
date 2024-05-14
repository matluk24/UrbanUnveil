package it.unicam.cs.ids.urbanunveil.Service;

import java.io.IOException;

public interface OSMService {
	
	public <OMSNode> OMSNode search(String query) throws IOException;
	
}
