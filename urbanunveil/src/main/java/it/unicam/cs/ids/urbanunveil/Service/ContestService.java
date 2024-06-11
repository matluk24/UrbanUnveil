package it.unicam.cs.ids.urbanunveil.Service;

import java.time.LocalDate;
import java.util.List;

import it.unicam.cs.ids.urbanunveil.Entity.Contest;
import it.unicam.cs.ids.urbanunveil.Entity.Media;

public interface ContestService {

	public Contest addContest(String n, LocalDate s, LocalDate e);
	public boolean removeContest(String n);
	public boolean removeContest(Long i);
	public boolean isContestEnded(Long i);
	public boolean isContestEnded(String n);
	public Contest addPhotoToContest(Long i, Media m);
	public Contest addPhotoToContest(Long i, List<Media> m);
	public Contest updateContestById(Long i, String n, LocalDate s, LocalDate e);
	public Contest updateContestByName(String n, LocalDate s, LocalDate e);
	public Contest getContestById(Long i);
	public Contest getContestByName(String n);
	public List<Contest> getAllContests();
	public List<Media> getAllContestPhotosById(Long i);
	public List<Media> getAllContestPhotosByName(String n);
}

