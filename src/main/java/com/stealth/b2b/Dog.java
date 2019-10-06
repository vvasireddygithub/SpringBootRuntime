package com.stealth.b2b;



import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Dog implements Serializable {
	private String breed;
	private String dogPictureURL;
	private int noOfUpVotesReceived;
	private int noOfDownVotesReceived;
	public int getNoOfUpVotesReceived() {
		return noOfUpVotesReceived;
	}
	public void setNoOfUpVotesReceived(int noOfUpVotesReceived) {
		this.noOfUpVotesReceived = noOfUpVotesReceived;
	}
	public int getNoOfDownVotesReceived() {
		return noOfDownVotesReceived;
	}
	public void setNoOfDownVotesReceived(int noOfDownVotesReceived) {
		this.noOfDownVotesReceived = noOfDownVotesReceived;
	}
	private String dogname;
	
	@Id
	@GeneratedValue
	
	private long dogID;
	
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getDogPictureURL() {
		return dogPictureURL;
	}
	public void setDogPictureURL(String dogPictureURL) {
		this.dogPictureURL = dogPictureURL;
	}
	public int getNoOfVotesReceived() {
		return noOfUpVotesReceived;
	}
	public void setNoOfVotesReceived(int noOfVotesReceived) {
		this.noOfUpVotesReceived = noOfVotesReceived;
	}
	public String getDogname() {
		return dogname;
	}
	public void setDogname(String dogname) {
		this.dogname = dogname;
	}
	public long getDogID() {
		return dogID;
	}
	public void setDogID(long dogID) {
		this.dogID = dogID;
	}
	

}
