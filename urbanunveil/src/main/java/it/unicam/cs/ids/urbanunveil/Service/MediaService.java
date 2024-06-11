package it.unicam.cs.ids.urbanunveil.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Media;

public interface MediaService {

	public Media addMedia(String path, String title, String t);
	public boolean removeMedia(Long i);
	public Media updateMedia(Long i, String path, String title);
	public List<Media> getAllMedias();
	public Media getMediaById(Long i);
	public Media getMediaByTitle(String title);
	public String getTextFromFile(Long i) throws FileNotFoundException;
	public String writeArticle(Long i, String userInput) throws IOException;
	
}
