package com.stealth.b2b.unittest;



import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.stealth.b2b.Dog;
import com.stealth.b2b.DogRepository;
import com.stealth.b2b.DogService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DogsRestControllerTest {

		
	@Autowired
	DogService dogservice;
	
	@MockBean
	DogRepository dogRepository;

	

	
   @Test
	public void findAllDogs() throws Exception {
		Dog dog = new Dog();
		dog.setDogID(1l);
		dog.setBreed("Labrador");
		dog.setDogPictureURL("dsasdadsdsa.png");
		dog.setNoOfDownVotesReceived(8);
		
		

		Mockito.when(dogRepository.findAll()).thenReturn(Stream.of(dog,dog).collect(Collectors.toList()));
	    
		System.out.println(dogservice.getAllDogs().size());
		
		Assert.assertEquals(2,dogservice.getAllDogs().size());
	
	}
   @Test
  	public void findDogByID() throws Exception {
  		Dog dog = new Dog();
  		dog.setDogID(1l);
  		dog.setBreed("Labrador");
  		dog.setDogPictureURL("dsasdadsdsa.png");
  		dog.setNoOfDownVotesReceived(8);
  		
  		
  		
  		

  		Mockito.when(dogRepository.findById(1l)).thenReturn(Optional.of(dog));
  	    
  		
  		Assert.assertNotNull(dogservice.getDogById(1l));
  	
  	}
   @Test
 	public void incrementVoteUp() throws Exception {
 		Dog dog = new Dog();
 		dog.setDogID(1l);
 		dog.setBreed("Labrador");
 		dog.setDogPictureURL("dsasdadsdsa.png");
 		dog.setNoOfDownVotesReceived(8);
 		dog.setNoOfUpVotesReceived(2);
  		

 		Mockito.when(dogRepository.save(dog)).thenReturn(dog);
 	    
 		System.out.println("Total Votes" + dogservice.getTotalNoOfVotesReceived(1l));
 		//Assert.assertEquals(10,dogservice.getTotalNoOfVotesReceived(1l));
 	
 	}
  
 	

}
