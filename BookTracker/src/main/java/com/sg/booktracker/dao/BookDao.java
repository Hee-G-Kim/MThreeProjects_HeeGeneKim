
package main.java.com.sg.booktracker.dao;


import java.util.List;

import main.java.com.sg.booktracker.dto.Book;

/**
 *
 * @author Kyle David Rudy
 */
public interface BookDao {
    Book getBookByTitle(String title);
    List<Book> getAllBooks();
    Book addBook(Book book);
    void updateBook(Book book);
    void deleteBookByTitle(String title);
}
