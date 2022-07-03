package com.sg.dvdlibrary.controller;

import java.util.List;


import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;

public class DVDLibraryController {


		private DVDLibraryView view ;
		private DVDLibraryDao dao ;
		private UserIO io;
		
	public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view, UserIO io) {
		this.dao = dao;
		this.view = view;
		this.io = io;
	}

	public void run() {

		boolean keepGoing = true;
		int menuSelection = 0;

		try {
			while (keepGoing) {

				
				  io.print("Main Menu"); 
				  io.print("1. List DVD Titles");
				  io.print("2. Create New Dvd"); 
				  io.print("3. View a Dvd");
				  io.print("4. Remove a Dvd"); 
				  io.print("5. Exit");
				

				 menuSelection = io.readInt("Please select from the" +
				 " above choices.", 1, 5);
				//menuSelection = getMenuSelection();

				switch (menuSelection) {
				case 1:
					io.print(">");
					io.print("LISTING DVDS");
					listDvds();
					break;

				case 2:
					io.print(">");
					io.print("CREATE DVD");
					createDvd();
					io.print("Dvd success");
					break;
				case 3:
					io.print(">");
					io.print("VIEW DVD");
					viewDvd();
					break;

				case 4:
					io.print(">");
					io.print("REMOVE DVD");
					removeDvd();

					break;
				case 5:
					keepGoing = false;
					break;
				default:
					io.print(">");
					io.print("UNKNOWN COMMAND");
					unknownCommand();

				}

			}
			exitMessage();
			// io.print("GOOD BYE");
		} catch (DVDLibraryDaoException e) {
			// e.printStackTrace();
			view.displayErrorMessage(e.getMessage());
		}

	}

	// ----------------------------------
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}

	private void createDvd() throws DVDLibraryDaoException {
		view.displayCreateDvdBanner();
		Dvd newDvd;
		try {
			newDvd = view.getNewDvdInfo();
		} catch (Exception e) {
			throw new DVDLibraryDaoException("-_- date format error", e);
		}
		dao.addDvd(newDvd.getDvdTitle(), newDvd);
		view.displayCreateSuccessBanner();
	}

	private void listDvds() throws DVDLibraryDaoException {
		view.displayDisplayAllBanner();
		List<Dvd> dvdList = dao.getAllDvds();
		view.displayDvdList(dvdList);
	}

	private void viewDvd() throws DVDLibraryDaoException {
		view.displayDisplayDvdBanner();
		String dvdTitle = view.getDvdTitleChoice();
		Dvd dvd = dao.getDvd(dvdTitle);
		view.displayDvd(dvd);
	}

	private void removeDvd() throws DVDLibraryDaoException {
		view.displayRemoveDvdBanner();
		String dvdTitle = view.getDvdTitleChoice();
		Dvd removedDvd = dao.removeDvd(dvdTitle);
		view.displayRemoveResult(removedDvd);
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		view.displayExitBanner();
	}

}
