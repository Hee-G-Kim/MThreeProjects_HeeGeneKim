package com.sg.dvdlibrary.app;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryFileImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
public class App {

	public static void main(String[] args) {
		UserIO myIo = new UserIOConsoleImpl();
		DVDLibraryView myView = new DVDLibraryView(myIo);
		DVDLibraryDao myDao = new DVDLibraryFileImpl();
		DVDLibraryController controller = new DVDLibraryController(myDao, myView,myIo);
		controller.run();

	}

}
