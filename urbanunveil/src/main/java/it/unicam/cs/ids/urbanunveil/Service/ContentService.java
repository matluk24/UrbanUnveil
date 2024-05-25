package it.unicam.cs.ids.urbanunveil.Service;

import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;

public interface ContentService {

	public Content getContentById(Long i);
	public List<Content> getAllContents();
	public Content addContent(String d, User p, List<Media> m);
	public StateEnum getContentState(Long i);
	public boolean changeContentStateToApproved(Long i);
	public boolean changeContentStateToRefused(Long i);
	public List<Content> getAllWaitingContent(StateEnum i);
	public List<Content> getAllApprovedContent(StateEnum i);
	public List<Content> getAllRefusedContent(StateEnum i);
	public Content updateContent(Long i, String d, Media m);
}
