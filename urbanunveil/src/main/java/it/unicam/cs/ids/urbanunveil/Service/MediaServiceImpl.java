package it.unicam.cs.ids.urbanunveil.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Repository.MediaRepository;
import it.unicam.cs.ids.urbanunveil.Repository.RoleRepository;
import it.unicam.cs.ids.urbanunveil.Utilities.MediaEnum;

@Service
public class MediaServiceImpl implements MediaService {

	
	private MediaRepository r;
	
	@Autowired
	public MediaServiceImpl (MediaRepository r) {
		this.r=r;
	}
	
	public MediaServiceImpl() {
		
	}
	
	@Override
	public Media addMedia(String path, String title, String t) {
		Media m = new Media(path, title, MediaEnum.valueOf(t));
		return r.save(m);
	}

	@Override
	public boolean removeMedia(Long i) {
		Media m = this.getMediaById(i);
		r.delete(m);
		return r.existsById(i);
	}

	@Override
	public Media updateMedia(Long i, String path, String title) {
		Media m = this.getMediaById(i);
		m.setPath(path);
		m.setTitle(title);
		return r.saveAndFlush(m);
	}

	@Override
	public List<Media> getAllMedias() {
		return r.findAll();
	}

	@Override
	public Media getMediaById(Long i) {
		if(r.existsById(i)) {
			return r.findById(i).get();
		}
		return null;
	}
	
	@Override
	public Media getMediaByTitle(String title) {
		Media m = r.findByTitle(title);
		return m;
	}
	
	@Override
	public String getTextFromFile(Long i) throws FileNotFoundException {
		
		String result="";
		Media m = this.getMediaById(i);
		
		if(m.getType().equals(MediaEnum.FILE)) {
			if(m.getPath()==null) {
				System.out.println("No article has been written, create a file to start writing an article");
				return result;
			}
			File f = new File(m.getPath());
			Scanner myScanner = new Scanner(f);
			while(myScanner.hasNextLine()) {
				result = result +  myScanner.nextLine();
			}
			myScanner.close();
		}
		return result;
		
	}
	
	@Override
	public String writeArticle(Long i, String userInput) throws IOException  {
		Media m = this.getMediaById(i);
		String file="";
		
		File f = new File(System.getProperty("user.dir")+"/tmp", m.getTitle()+".txt");
		f.setWritable(true);
		f.setReadable(true);
		m = this.updateMedia(i, f.getCanonicalPath(), m.getTitle());
		if(!f.exists()) {
			f.createNewFile();
			System.out.println("The file has been created in the following path: "+f.getCanonicalPath());
		}
		else {
			 file = this.getTextFromFile(m.getId());
			System.out.println("The file already exists you add in it");
		}
		FileWriter writer = new FileWriter(f, true);
		System.out.println(file);
		writer.append(" "+userInput);
		writer.close();
		file = file+" "+userInput;
		
		return file;
	}
	
	

}
