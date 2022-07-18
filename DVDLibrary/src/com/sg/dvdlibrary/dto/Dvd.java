package com.sg.dvdlibrary.dto;

import java.util.Date;

public class Dvd {

	private String dvdTitle;
	private Date releaseDate;
	private int MPAARating;
	private String directorsName;
	private String studio;
	private String userReview;

	public Dvd() {
		super();
	}

	public Dvd(String title) {
		super();
		this.dvdTitle = title;

	}

	public String getDvdTitle() {
		return dvdTitle;
	}

	public void setDvdTitle(String title) {
		this.dvdTitle = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getMPAARating() {
		return MPAARating;
	}

	public void setMPAARating(int mPAARating) {
		MPAARating = mPAARating;
	}

	public String getDirectorsName() {
		return directorsName;
	}

	public void setDirectorsName(String directorsName) {
		this.directorsName = directorsName;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

}
