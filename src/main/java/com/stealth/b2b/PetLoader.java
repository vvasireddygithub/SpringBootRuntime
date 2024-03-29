package com.stealth.b2b;



import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PetLoader implements InitializingBean {

    private static final Logger LOGGER = getLogger(PetLoader.class);

    // Resources to the different files we need to load.
    @Value("classpath:data/labrador.txt")
    private Resource labradors;

    @Value("classpath:data/pug.txt")
    private Resource pugs;

    @Value("classpath:data/retriever.txt")
    private Resource retrievers;

    @Value("classpath:data/yorkie.txt")
    private Resource yorkies;

    @Autowired
    DataSource dataSource;
    
    @Autowired
	DogRepository dogRepository;
    
    @Autowired
	DogService dogservice;
    
   
    /**
     * Load the different breeds into the data source after
     * the application is ready.
     *
     * @throws Exception In case something goes wrong while we load the breeds.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
    	if (dogRepository == null)
    	{
    		LOGGER.info("JPA REPOSITORY NOT initialized");
    	}
    	//DogService.setDogRepository(dogRepository);
        loadBreed("Labrador", labradors);
        loadBreed("Pug", pugs);
        loadBreed("Retriever", retrievers);
        loadBreed("Yorkie", yorkies);
    }

    /**
     * Reads the list of dogs in a category and (eventually) add
     * them to the data source.
     * @param breed The breed that we are loading.
     * @param source The file holding the breeds.
     * @throws IOException In case things go horribly, horribly wrong.
     */
    private void loadBreed(String breed, Resource source) throws IOException {
        LOGGER.debug("Loading breed {}", breed);
        
        if (dataSource != null) LOGGER.info("Data source not Null");
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
            	
            	LOGGER.info("This is DB persistence");
                LOGGER.info(line);
                // TODO: Create appropriate objects and save them to the datasource.
                //dataSource.
                
                //dataSource.getConnection().
                
                Dog dog = new Dog();
                dog.setDogPictureURL(line);
                dog.setBreed(breed);
                dog.setDogname("dogname");
                dogservice.saveDog(dog);
            }
        }
    }
}
