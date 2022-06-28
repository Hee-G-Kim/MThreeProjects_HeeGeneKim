package com.sg.dvdlibrary.dto;

public class Dvd {

	private String title;
	private String releaseDate;
	private int MPAARating;
	private String directorsName;
	private String studio;
	private String userReview;
	
	public Dvd() {
		super();
	}
	public Dvd(String title, String releaseDate, int mPAARating, String directorsName, String studio,
			String userReview) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		MPAARating = mPAARating;
		this.directorsName = directorsName;
		this.studio = studio;
		this.userReview = userReview;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
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
