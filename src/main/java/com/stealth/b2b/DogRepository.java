package com.stealth.b2b;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

	@Query("SELECT d FROM Dog d WHERE LOWER(d.breed) = LOWER(:breed)")

	List<Dog> findDogsByBreed(@Param("breed") String breed);

	@Query("SELECT d FROM Dog d ORDER BY d.breed")

	List<Dog> findDogsGroupByBreed();
	
	@Query("SELECT d FROM Dog d WHERE LOWER(d.dogPictureURL) = LOWER(:dogPictureURL)")

	Dog findDogsByPicture(@Param("dogPictureURL") String dogPictureURL);

	// List<Dog> findGroupByBreed();

	// void saveDog(Dog dog);

	// void findDogById(Long dogID);

}
