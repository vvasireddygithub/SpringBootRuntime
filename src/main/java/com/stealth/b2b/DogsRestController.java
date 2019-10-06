package com.stealth.b2b;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
public class DogsRestController {
	
	@Autowired
	DogService dogservice;
	
	@GetMapping(path = "/findall", produces = {MediaType.APPLICATION_JSON_VALUE})
	 public List<Dog> getAllDogs()
	{
		return  dogservice.getAllDogs();
	}
	
	@GetMapping(path = "/findbybreed/{breed}", produces = {MediaType.APPLICATION_JSON_VALUE})
	 public List<Dog> getDogsByBreed(@PathVariable String breed)
	{
		return dogservice.getDogsByBreed(breed);
	}
	@GetMapping(path = "/dogpictures/{breed}", produces = {MediaType.APPLICATION_JSON_VALUE})
	 public List<String> getDogPicturesByBreed(@PathVariable String breed)
	{
		return dogservice.getDogsByBreed(breed).stream().map(dog->dog.getDogPictureURL()).collect(Collectors.toList());
	}
	
	@GetMapping(path = "/{dogID}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Dog getDogById(@PathVariable long dogID) {
        return dogservice.getDogById(dogID);
    }
	
	@GetMapping(path = "/picture/{picturename}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Dog getDogByPictureURL(@PathVariable String picturename) {
        return dogservice.getDogByPictureURL(picturename);
    }
	
	@GetMapping(path = "/dogspicturesgroupedbybreed", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getDogsPicturesGroupByBreed() {
        return  dogservice.getDogsGroupByBreed().stream().map(dog->dog.getDogPictureURL()).collect(Collectors.toList());
    }
	
	
	@GetMapping(path = "/findgroupbybreed", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Dog> getDogsGroupByBreed() {
        return  dogservice.getDogsGroupByBreed();
    }
	@GetMapping (path = "/{dogID}/voteup", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void inCrementVoteUp(@PathVariable long dogID) {
		dogservice.incrementVoteUp(dogID);
        
    }
	@GetMapping (path = "/{dogID}/votedown", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void incrementVoteDown(@PathVariable long dogID) {
		dogservice.incrementVoteDown(dogID);
        
    }
	@GetMapping(path = "/{dogID}/totalvotes", produces = {MediaType.APPLICATION_JSON_VALUE})
    public int getTotalVoteByDogID(@PathVariable long dogID) {
        return dogservice.getTotalNoOfVotesReceived(dogID);
    }

}
