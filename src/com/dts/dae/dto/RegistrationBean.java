/*
 * RegistrationBean.java
 *
 * 
 */

package com.dts.dae.dto;


public class RegistrationBean {

	private String UserID;
	private String Password;
	private String UserName;
	private String UserEmail;
	private String UserMobile;
	private String UserDOB;
	private String UserGender;
	private String UserType;
	private String UserAddress;
	
	


	private String OldPassword;
	
	
	public void setUserID(String userID) {
		UserID = userID;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public void setUserMobile(String userMobile) {
		UserMobile = userMobile;
	}
	public void setUserDOB(String userDOB) {
		UserDOB = userDOB;
	}
	public void setUserGender(String userGender) {
		UserGender = userGender;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}
	//////////////////
	
	
	public String getUserID() {
		return UserID;
	}
	public String getPassword() {
		return Password;
	}
	public String getUserName() {
		return UserName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public String getUserMobile() {
		return UserMobile;
	}
	public String getUserDOB() {
		return UserDOB;
	}
	public String getUserGender() {
		return UserGender;
	}
	public String getUserType() {
		return UserType;
	}
	public String getUserAddress() {
		return UserAddress;
	}

	public String getOldPassword() {
		return OldPassword;
	}

////////////////////
	
	private String Distance;
	private String Sprovider;

	public void setSprovider(String sprovider) {
		Sprovider = sprovider;
	}
	public void setDistance(String distance) {
		Distance = distance;
	}

	public String getSprovider() {
		return Sprovider;
	}
	public String getDistance() {
		return Distance;
	}
	private String Pname;


	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	private String Venue;


	public void setVenue(String venue) {
		Venue = venue;
	}
	public String getVenue() {
		return Venue;
	}
	
	private String CountVenue;
	public void setCountVenue(String CountVenue){
		this.CountVenue=CountVenue;		
	}
	public String getCountVenue(){
		
		return CountVenue;
	}
}
