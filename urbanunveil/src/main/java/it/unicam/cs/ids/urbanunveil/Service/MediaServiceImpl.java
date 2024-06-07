package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

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
		this.removeMedia(i);
		return r.save(m);
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

}
