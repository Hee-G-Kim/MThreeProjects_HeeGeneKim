package com.sg.dvdlibrary.dao;

import java.util.List;

import com.sg.dvdlibrary.dto.Dvd;

public interface DVDLibraryDao {
	
	
	Dvd addDvd(String dvdtitle, Dvd dvd) throws DVDLibraryDaoException;

	List<Dvd> getAllDvds()throws DVDLibraryDaoException;

	Dvd getDvd(String dvdTitle)throws DVDLibraryDaoException;

	Dvd removeDvd(String dvdTitle)throws DVDLibraryDaoException;

}
