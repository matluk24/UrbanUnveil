package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Media;

public interface MediaService {

	public Media addMedia(String path, String title, String t);
	public boolean removeMedia(Long i);
	public Media updateMedia(Long i, String path, String title);
	public List<Media> getAllMedias();
	public Media getMediaById(Long i);
	
}
