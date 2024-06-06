package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;
import it.unicam.cs.ids.urbanunveil.Utilities.NotInWaitingStateException;

public interface ContentService {

	public Content getContentById(Long i);
	public List<Content> getAllContents();
	public Content addContent(String d, User p, List<Media> m);
	public boolean removeContent(Long i);
	public StateEnum getContentState(Long i);
	public boolean changeContentStateToApproved(Long i) throws NotInWaitingStateException;
	public boolean changeContentStateToRefused(Long i) throws NotInWaitingStateException;
	public List<Content> getAllWaitingContent();
	public List<Content> getAllApprovedContent();
	public List<Content> getAllRefusedContent();
	public Content updateContent(Long i, String d, List<Media> m);
}
