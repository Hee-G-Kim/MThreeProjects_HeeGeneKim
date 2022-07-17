package com.sg.dvdlibrary.ui;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;

public class DVDLibraryView {

	// ?private UserIO io = new UserIOConsoleImpl();
		private UserIO io;

		// private UserIO io;
		public DVDLibraryView(UserIO io) {
			this.io = io;
		}

		public Dvd getNewDvdInfo() throws DVDLibraryDaoException {

			/* Does not work here */
			// io = new UserIOConsoleImpl();

			String dvdTitle = io.readString("Please enter Dvd title");
			Date releaseDate;
			try {
				releaseDate = io.readDate("Please enter release date");
			} catch (Exception e) {
				throw new DVDLibraryDaoException("-_- date format error.", e);
			}
			int MPAARating = io.readInt("Please enter MPAA Rating");
			String directorsName = io.readString("Please enter directors name ");
			String studio= io.readString("Please enter  studio name");
			String userReview= io.readString("Please enter user review");
			
			Dvd currentDvd = new Dvd(dvdTitle);
			currentDvd.setReleaseDate(releaseDate);
			currentDvd.setMPAARating(MPAARating);
			currentDvd.setDirectorsName(directorsName);
			currentDvd.setStudio(studio);
			currentDvd.setUserReview(userReview);
			
			return currentDvd;
		}

		public void displayCreateDvdBanner() {
			io.print("=== Create Dvd ===");
		}

		public void displayCreateSuccessBanner() {
			io.readString("Dvd successfully created.  Please hit enter to continue");
		}

		public void displayDvdList(List<Dvd> dvdList) {
			for (Dvd currentDvd : dvdList) {
				String dvdInfo = String.format("#%s : %s %s", currentDvd.getDvdTitle(),
						currentDvd.getReleaseDate(), currentDvd.getMPAARating());
				io.print(dvdInfo);
			}
			io.readString("Please hit enter to continue.");
		}

		public void displayDisplayAllBanner() {
			io.print("=== Display All Dvds ===");
		}

		public void displayDisplayDvdBanner() {
			io.print("=== Display Dvd ===");
		}

		public String getDvdTitleChoice() {
			return io.readString("Please enter the Dvd Title.");
		}

		public void displayDvd(Dvd dvd) {
			if (dvd != null) {
				io.print(dvd.getDvdTitle());
				io.print(dvd.getReleaseDate() + " " + dvd.getMPAARating());
				io.print(dvd.getStudio());
				io.print(dvd.getUserReview());
				io.print("");
			} else {
				io.print("No such dvd.");
			}
			io.readString("Please hit enter to continue.");
		}

		public void displayRemoveDvdBanner() {
			io.print("=== Remove Dvd ===");
		}

		public void displayRemoveResult(Dvd dvdRecord) {
			if (dvdRecord != null) {
				io.print("Dvd successfully removed.");
			} else {
				io.print("No such dvd.");
			}
			io.readString("Please hit enter to continue.");
		}

		public void displayExitBanner() {
			io.print("Good Bye!!!");
		}

		public void displayUnknownCommandBanner() {
			io.print("Unknown Command!!!");
		}

		public int printMenuAndGetSelection() {
			return 0;
		}
		
		//Error
		//---------------
		
		public void displayErrorMessage(String errorMsg) {
			io.print("=== ERROR ===");
			io.print(errorMsg);
			}
		
		//-----Exercise: DVD Library Lambdas and Streams:
		public void displayShowMoviesFromYearsDvdBanner(String year) {
		io.print("=== Movies from " + year +" ===");
		}
}
