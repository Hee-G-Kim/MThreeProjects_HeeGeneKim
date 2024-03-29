package com.sg.dvdlibrary.ui;

import java.util.Date;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;

public interface UserIO {

	void print(String msg);
	double readDouble(String prompt);
	double readDouble(String prompt, double min, double max);
	float readFloat(String prompt);
	float readFloat(String prompt, float min, float max);
	int readInt(String prompt);
	int readInt(String prompt, int min, int max);
	long readLong(String prompt);
	long readLong(String prompt, long min, long max);
	String readString(String prompt);
	Date readDate(String string) throws DVDLibraryDaoException;
}
