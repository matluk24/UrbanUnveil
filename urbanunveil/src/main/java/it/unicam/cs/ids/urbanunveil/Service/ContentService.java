package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Content;
import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;
import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;
import it.unicam.cs.ids.urbanunveil.Entity.PointOfInterest;
import it.unicam.cs.ids.urbanunveil.Entity.User;
import it.unicam.cs.ids.urbanunveil.Utilities.StateEnum;
import it.unicam.cs.ids.urbanunveil.Utilities.NotInWaitingStateException;

public interface ContentService {

	public Content getContentById(Long i);
	public List<Content> getAllContents();
	public Content addContent(String d, User p, List<Media> m);
	public PointOfInterest addPOI(String d, User p, List<Media> m, OSMNode l, String type);
	public PointOfInterest addPOI(String d, User p, OSMNode l, String type);
	public boolean removeContent(Long i);
	public boolean removePOI(Long i);
	public StateEnum getContentState(Long i);
	public boolean changeContentStateToApproved(Long i) throws NotInWaitingStateException;
	public boolean changeContentStateToRefused(Long i) throws NotInWaitingStateException;
	public List<Content> getAllWaitingContent();
	public List<Content> getAllApprovedContent();
	public List<Content> getAllRefusedContent();
	public Content updateContent(Long i, String d, List<Media> m);
	public Contest addContest(String d, User u, String n, LocalDate s, LocalDate e);
	public boolean removeContest(String n);
	public boolean removeContest(Long i);
	public boolean isContestEnded(Long i);
	public boolean isContestEnded(String n);
	public Contest addPhotoToContest(Long i, Media m);
	public Contest addPhotoToContest(Long i, List<Media> m);
	public Contest removePhotoFromContest(Long i, Media m);
	public Contest removePhotoFromContest(Long i, List<Media> m);
	public Contest updateContestById(Long i, String d, String n, LocalDate s, LocalDate e);
	public Contest updateContestByName(String d, String n, LocalDate s, LocalDate e);
	public Contest getContestById(Long i);
	public Contest getContestByName(String n);
	public List<Contest> getAllContests();
	public List<Media> getAllContestPhotosById(Long i);
	public List<Media> getAllContestPhotosByName(String n);
}
