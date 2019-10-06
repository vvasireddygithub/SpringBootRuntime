package com.stealth.b2b;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public  class DogService {


	//private static DogRepository dogRepository1;
	
	@Autowired
	DogRepository dogRepository;
	
	/*
	 * public static void setDogRepository(DogRepository dogRepo) { dogRepository1 =
	 * dogRepo;
	 * 
	 * 
	 * }
	 */

	public  List<Dog> getAllDogs() {
		List<Dog> dogList = dogRepository.findAll();

		if (dogList.size() > 0) {
			return dogList;
		} else {
			return new ArrayList<Dog>();
		}
	}
	public  List<Dog> getDogsByBreed(String breed) {
		List<Dog> dogList = dogRepository.findDogsByBreed(breed);

		if (dogList.size() > 0) {
			return dogList;
		} else {
			return new ArrayList<Dog>();
		}
	}
	public  List<Dog> getDogsGroupByBreed() {
		List<Dog> dogList = dogRepository.findDogsGroupByBreed();

		if (dogList.size() > 0) {
			return dogList;
		} else {
			return new ArrayList<Dog>();
		}
	}
	public  void saveDog(Dog dog) {
		dogRepository.saveAndFlush(dog);
		//dogRepository.flush();
		
	}
	public  Dog getDogById(long dogID) {
		Optional<Dog>  found = dogRepository.findById(dogID);
		if (found.isPresent()) return found.get();
		return null;
		
	}
	
	public  Dog getDogByPictureURL(String pictureURL) {
		return dogRepository.findDogsByPicture("http://i.imgur.com/"+pictureURL+".png");
			
	}
	
	public  void incrementVoteUp(long dogID) {
		Optional<Dog>  found = dogRepository.findById(dogID);
		if (found.isPresent()) {
			Dog dog = found.get();
			dog.setNoOfUpVotesReceived(dog.getNoOfUpVotesReceived()+1);
			dogRepository.save(dog);
			
		}
		
	}
	
	public  void incrementVoteDown(long dogID) {
		Optional<Dog>  found = dogRepository.findById(dogID);
		if (found.isPresent()) {
			Dog dog = found.get();
			dog.setNoOfDownVotesReceived(dog.getNoOfDownVotesReceived()+1);
			dogRepository.save(dog);
			
		}
		
	}
	
	public  int getTotalNoOfVotesReceived(long dogID) {
		Optional<Dog>  found = dogRepository.findById(dogID);
		if (found.isPresent()) {
			Dog dog = found.get();
			return dog.getNoOfDownVotesReceived()+dog.getNoOfUpVotesReceived();
			
		}
		return 0;
		
	}
	
	
	

}
