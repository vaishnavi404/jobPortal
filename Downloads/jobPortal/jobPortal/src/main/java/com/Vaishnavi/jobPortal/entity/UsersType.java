package com.Vaishnavi.jobPortal.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users_type")
public class UsersType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int userTypeId;
private String userTypeName;
@OneToMany(targetEntity=Users.class,mappedBy="userTypeId")
private List<Users>users;
public UsersType() {
	super();
	// TODO Auto-generated constructor stub
}
public UsersType(int userTypeId, String userTypeName, List<Users> users) {
	super();
	this.userTypeId = userTypeId;
	this.userTypeName = userTypeName;
	this.users = users;
}
public int getUserTypeId() {
	return userTypeId;
}
public void setUserTypeId(int userTypeId) {
	this.userTypeId = userTypeId;
}
public String getUserTypeName() {
	return userTypeName;
}
public void setUserTypeName(String userTypeName) {
	this.userTypeName = userTypeName;
}
public List<Users> getUsers() {
	return users;
}
public void setUsers(List<Users> users) {
	this.users = users;
}
@Override
public String toString() {
	return "UsersType [userTypeId=" + userTypeId + ", userTypeName=" + userTypeName + "]";
}


}
