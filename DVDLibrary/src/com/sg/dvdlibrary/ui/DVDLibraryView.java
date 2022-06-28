package com.sg.dvdlibrary.ui;

public class DVDLibraryView {

	// ???private UserIO io = new UserIOConsoleImpl();
		private UserIO io;

		// private UserIO io;
		public DVDLibraryView(UserIO io) {
			this.io = io;
		}

		public Dvd getNewDvdInfo() {

			/* Does not work here */
			// io = new UserIOConsoleImpl();

			String dvdId = io.readString("Please enter Dvd ID");
			String firstName = io.readString("Please enter First Name");
			String lastName = io.readString("Please enter Last Name");
			String cohort = io.readString("Please enter Cohort");
			Dvd currentDvd = new Dvd(dvdId);
			currentDvd.setFirstName(firstName);
			currentDvd.setLastName(lastName);
			currentDvd.setCohort(cohort);
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
				String dvdInfo = String.format("#%s : %s %s", currentDvd.getDvdId(),
						currentDvd.getFirstName(), currentDvd.getLastName());
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

		public String getDvdIdChoice() {
			return io.readString("Please enter the Dvd ID.");
		}

		public void displayDvd(Dvd dvd) {
			if (dvd != null) {
				io.print(dvd.getDvdId());
				io.print(dvd.getFirstName() + " " + dvd.getLastName());
				io.print(dvd.getCohort());
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
			// TODO Auto-generated method stub
			return 0;
		}
		
		//Error
		//---------------
		
		public void displayErrorMessage(String errorMsg) {
			io.print("=== ERROR ===");
			io.print(errorMsg);
			}
}
