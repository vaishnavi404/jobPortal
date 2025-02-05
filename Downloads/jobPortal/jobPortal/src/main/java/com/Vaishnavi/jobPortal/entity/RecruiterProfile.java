package com.Vaishnavi.jobPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="recruiter_profile")
public class RecruiterProfile {
	  @Id
	    private int userAccountId;

	    @OneToOne
	    @JoinColumn(name = "user_account_id")
	    @MapsId
	    private Users userId;

private String firstName;
private String lastName;
private String city;
private String State;
private String country;
private String company;
@Column(nullable=true,length=64) 
private String profilePhoto;
public RecruiterProfile() {
	super();
	// TODO Auto-generated constructor stub
}
public RecruiterProfile(int userAccountId, Users userId, String firstName, String lastName, String city, String state,
		String country, String company, String profilePhoto) {
	super();
	this.userAccountId = userAccountId;
	this.userId = userId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.city = city;
	this.State = state;
	this.country = country;
	this.company = company;
	this.profilePhoto = profilePhoto;
}
public RecruiterProfile(Users users) {
	// TODO Auto-generated constructor stub
this.userId=users;
}
public int getUserAccountId() {
	return userAccountId;
}
public void setUserAccountId(int userAccountId) {
	this.userAccountId = userAccountId;
}
public Users getUserId() {
	return userId;
}
public void setUserId(Users userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setfirstName(String firtsName) {
	this.firstName = firtsName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getProfilePhoto() {
	return profilePhoto;
}
public void setProfilePhoto(String profilePhoto) {
	this.profilePhoto = profilePhoto;
}

@Transient
public String getPhotosImagePath() {
	if(profilePhoto==null)return null;
	return "/photos/recruiter/"+userAccountId+"/"+profilePhoto;
}
@Override
public String toString() {
	return "RecruiterProfile [userAccountId=" + userAccountId + ", userId=" + userId + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", city=" + city + ", State=" + State + ", country=" + country + ", company="
			+ company + ", profilePhoto=" + profilePhoto + "]";
}

}
