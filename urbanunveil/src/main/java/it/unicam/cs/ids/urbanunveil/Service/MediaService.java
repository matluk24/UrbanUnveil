package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Media;

public interface MediaService {

	public Media addMedia(String path);
	public boolean removeMedia(Long i);
	public Media updateMedia(Long i, String path);
	public List<Media> getAllMedias();
	public Media getMediaById(Long i);
	
}
