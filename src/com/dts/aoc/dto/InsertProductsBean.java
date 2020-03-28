package com.dts.aoc.dto;

public class InsertProductsBean {
	

	private String BookName;
	private String BookCost;
	private String BookAuthor;
	private String BookPublication;
	private String BookCategory;
	private String BookPicture;
	private String BookServiceProvider;
	private String Distance;
	private int BookID;
	private String BookDescription;
	private String Venue;
	
	
	
	public void setVenue(String venue) {
		Venue = venue;
	}
	public String getVenue() {
		return Venue;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public void setBookCost(String bookCost) {
		BookCost = bookCost;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public void setBookPublication(String bookPublication) {
		BookPublication = bookPublication;
	}
	public void setBookCategory(String bookCategory) {
		BookCategory = bookCategory;
	}
	public void setBookServiceProvider(String bookServiceProvider) {
		BookServiceProvider = bookServiceProvider;
	}
	public void setDistance(String distance) {
		Distance = distance;
	}
	public void setBookPicture(String bookPicture) {
		BookPicture = bookPicture;
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}
	public void setBookDescription(String bookDescription) {
		BookDescription = bookDescription;
	}
	
	// get method
	

	public String getBookName() {
		return BookName;
	}
	public String getBookCost() {
		return BookCost;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public String getBookPublication() {
		return BookPublication;
	}
	public String getBookCategory() {
		return BookCategory;
	}
	public String getBookServiceProvider() {
		return BookServiceProvider;
	}
	public String getDistance() {
		return Distance;
	}
	public String getBookPicture() {
		return BookPicture;
	}

	public int getBookID() {
		return BookID;
	}
	public String getBookDescription() {
		return BookDescription;
	}
	
	//
	
	private String ProdutsRating;


	public String getProdutsRating() {
		return ProdutsRating;
	}
	public void setProdutsRating(String produtsRating) {
		ProdutsRating = produtsRating;
	}
}
