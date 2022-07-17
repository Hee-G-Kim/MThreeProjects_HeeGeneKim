package main.java.com.sg.booktracker;

import main.java.com.sg.booktracker.controller.BookController;
import main.java.com.sg.booktracker.dao.BookDao;
import main.java.com.sg.booktracker.dao.BookDaoMemoryImpl;
import main.java.com.sg.booktracker.service.BookService;
import main.java.com.sg.booktracker.ui.BookView;
import main.java.com.sg.booktracker.ui.UserIO;
import main.java.com.sg.booktracker.ui.UserIOConsoleImpl;

/**
 *
 * @author Kyle David Rudy
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        BookView view = new BookView(io);
        
        BookDao dao = new BookDaoMemoryImpl();
        BookService service = new BookService(dao);
        
        BookController controller = new BookController(service, view);
        controller.run();
    }
}
