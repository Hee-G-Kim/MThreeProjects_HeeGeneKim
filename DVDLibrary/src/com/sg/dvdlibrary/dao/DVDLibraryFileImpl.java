package com.sg.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class DVDLibraryFileImpl implements DVDLibraryDao {

	UserIOConsoleImpl io;

	public DVDLibraryFileImpl(UserIOConsoleImpl io) {
		super();
		this.io = io;
	}

	public DVDLibraryFileImpl() {

	}

	private Map<String, Dvd> dvds = new HashMap<>();
	public static final String DVD_FILE = "dvd.txt";
	public static final String DELIMITER = "::";

	// unmarshalling
	private Dvd unmarshallDvd(String dvdAsText) throws DVDLibraryDaoException {

		String[] dvdTokens = dvdAsText.split(DELIMITER);
		String dvdName = dvdTokens[0];
		//System.out.println(dvdTokens[1]);
		Dvd dvdFromFile = new Dvd(dvdName);
		try {
			dvdFromFile.setReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse(dvdTokens[1]));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		dvdFromFile.setMPAARating(Integer.parseInt(dvdTokens[2]));
		dvdFromFile.setDirectorsName(dvdTokens[3]);
		dvdFromFile.setStudio(dvdTokens[3]);
		dvdFromFile.setUserReview(dvdTokens[3]);
		return dvdFromFile;
	}

	// load from the text file "dvd.txt"
	private void loadDvdLibrary() throws DVDLibraryDaoException {
		Scanner scanner;
		try {
			// Create Scanner for reading the file
			scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
		} catch (FileNotFoundException e) {
			throw new DVDLibraryDaoException("-_- Could not load roster data into memory.", e);
		}
		// currentLine holds the most recent line read from the file
		String currentLine;

		Dvd currentDvd;

		while (scanner.hasNextLine()) {
			// get the next line in the file
			currentLine = scanner.nextLine();
			currentDvd = unmarshallDvd(currentLine);
			// We are going to use the student id as the map key
			// for our student object.
			// Put currentStudent into the map using student id as the key
			dvds.put(currentDvd.getDvdTitle(), currentDvd);
		}
		// close scanner
		scanner.close();
	}

	// Marshalling
	private String marshallDvd(Dvd aDvd) {

		String dvdAsText = aDvd.getDvdTitle() + DELIMITER;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		dvdAsText += formatter.format(aDvd.getReleaseDate()) + DELIMITER; /// ???
		dvdAsText += aDvd.getMPAARating() + DELIMITER;
		dvdAsText += aDvd.getDirectorsName() + DELIMITER;
		dvdAsText += aDvd.getStudio() + DELIMITER;
		dvdAsText += aDvd.getUserReview();

		return dvdAsText;
	}

	// * Writes to file
	private void writeDvdLibrary() throws DVDLibraryDaoException {

		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(DVD_FILE));
		} catch (IOException e) {
			throw new DVDLibraryDaoException("Could not save dvd data.", e);
		}

		String dvdtAsText;
		List<Dvd> dvdList = this.getAllDvds();
		for (Dvd currentDvd : dvdList) {
			// turn a Dvd into a String
			dvdtAsText = marshallDvd(currentDvd);
			out.println(dvdtAsText);
			// force PrintWriter to write line to the file
			out.flush();
		}
		// Clean up
		out.close();
	}

	// ------

	@Override
	public Dvd addDvd(String dvdtitle, Dvd dvd) throws DVDLibraryDaoException {
		loadDvdLibrary();
		Dvd newDvd = dvds.put(dvdtitle, dvd);
		writeDvdLibrary();
		return newDvd;
	}

	@Override
	public List<Dvd> getAllDvds() throws DVDLibraryDaoException {
		loadDvdLibrary();
		return new ArrayList(dvds.values());
	}

	@Override
	public Dvd getDvd(String dvdTitle) throws DVDLibraryDaoException {
		loadDvdLibrary();
		return dvds.get(dvdTitle);
	}

	@Override
	public Dvd removeDvd(String dvdTitle) throws DVDLibraryDaoException {
		loadDvdLibrary();
		Dvd removedDvd = dvds.remove(dvdTitle);
		writeDvdLibrary();
		return removedDvd;
	}

	// ----Exercise: DVD Library Lambdas and Streams:

	// Find all movies released in the last N years
	@Override
	public void findAllMoviesWithinYears() throws DVDLibraryDaoException {
		
		loadDvdLibrary();
		 
		//.filter((dvds) -> dvds.getReleaseDate().getYear() >=2000)
		
		dvds.forEach((id, dvd ) -> 
		{ 
			Calendar c = new GregorianCalendar();
			c.setTime(dvd.getReleaseDate());
			if(c.get(Calendar.YEAR) >= 2000) {
		 System.out.println(dvd.getDvdTitle());
		  System.out.println(dvd.getReleaseDate()); } });
		 
//		dvds.values().stream().filter(dvd -> dvd.getReleaseDate().getYear() >=2000).forEach(dvd ->
//				{System.out.println(dvd.getDvdTitle());
//				System.out.println(dvd.getReleaseDate());
//				});
		
		
		//return new ArrayList(dvds.values());
	}

	// Find all the movies with a given MPAA rating
	@Override
	public List<Dvd> findAllMoviesWithMPAARating() throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Find all the movies by a given director
	@Override
	public List<Dvd> findAllMoviesOfDirector() throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	// When searching by director, the movies should be sorted into separate data
	// structures by MPAA rating.
	@Override
	public List<Dvd> findAllMoviesOfDirectorSortMPAA() throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Find all the movies released by a particular studio
	@Override
	public List<Dvd> findAllMoviesOfStudio() throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Find the average age of the movies in the collection
	@Override
	public void getAverageAgeMovies() throws DVDLibraryDaoException {
		loadDvdLibrary();
		OptionalDouble year= ((Collection<Dvd>) dvds).stream()
		.mapToInt((dvds) -> dvds.getReleaseDate().getYear())
		.average();
		System.out.println(year);
		
	}
	
	//Find the newest movie in your collection
	@Override
	public Dvd getNewwestMovie(String dvdTitle) throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Find the oldest movie in your collection
	@Override
	public Dvd getOldestMovie(String dvdTitle) throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Find the average number of notes associated with movies in your collection
	@Override
	public Dvd getAverageNumNotes(int numOfNotes) throws DVDLibraryDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
