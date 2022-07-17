package com.sg.dvdlibrary.dao;

import java.util.List;

import com.sg.dvdlibrary.dto.Dvd;

public interface DVDLibraryDao {
	
	
	Dvd addDvd(String dvdtitle, Dvd dvd) throws DVDLibraryDaoException;

	List<Dvd> getAllDvds()throws DVDLibraryDaoException;

	Dvd getDvd(String dvdTitle)throws DVDLibraryDaoException;

	Dvd removeDvd(String dvdTitle)throws DVDLibraryDaoException;
	
	//-Exercise: DVD Library Lambdas and Streams:
	
	void findAllMoviesWithinYears()throws DVDLibraryDaoException;
	List<Dvd> findAllMoviesWithMPAARating()throws DVDLibraryDaoException;
	List<Dvd> findAllMoviesOfDirector()throws DVDLibraryDaoException;
	List<Dvd> findAllMoviesOfDirectorSortMPAA()throws DVDLibraryDaoException;
	List<Dvd> findAllMoviesOfStudio()throws DVDLibraryDaoException;
	
	void getAverageAgeMovies()throws DVDLibraryDaoException;
	Dvd getNewwestMovie(String dvdTitle)throws DVDLibraryDaoException;
	Dvd getOldestMovie(String dvdTitle)throws DVDLibraryDaoException;
	Dvd getAverageNumNotes(int numOfNotes)throws DVDLibraryDaoException;

}
