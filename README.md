# Build RESTfululAPIs

Design and create a RESTful API that could be used to manage a list of dog images. 

# Requirements

The operations would be:

* List all of the available dog pictures grouped by breed
* List all of the available dog pictures of a particular breed
* Vote up and down a dog picture
* The details associated with a dog picture

The information the Dog Breed App needs to function is:

* A URL to a dog picture
* The number of votes a picture has received
* The dog's breed
* Any other information required to identify a specific dog

The Dog Breed App expects the response to be sorted by the number of votes a picture has received.

The API responses must be in JSON.

## Additional Voting Requirements

Each client is allowed to vote once for any particular dog picture.

# Setup

Spring Boot project. The project is  configured go use Spring MVC and talks to an 
in memory HSQLDB to store the results. Jackson is  included to provide JSON serialization and deserialization.

The Spring Boot Starter Test module is included to facilitate both unit and integration tests.



## Dependencies

- Maven
- Java 8

## Checking Out the Project


```

## Building

```
$ mvn package
```

## Running

You can run the app through Maven:

```
$ mvn spring-boot:run
```

or you can run the jar file from the build:

```
$ java -jar target/api_interview-0.1.0.jar
```

# Build, Deployment and Running


* How would you package this for deployment?
* How and where would you deploy this app?
* How can you tell that the app is up and running?
* How would you configure the app as it goes from dev, to qa and finally to production?
* How would you insulate the app from a downstream API if it had one.

# Submitting the Project



************** REST TEST URL (GET URL) =========

http://localhost:8080/dog/findgroupbybreed   ( ORDER BY BREED)
http://localhost:8080/dog/findbybreed/Labrador ( FIND BY PERTICULAR BREED)
http://localhost:8080/dog/findall  (FIND ALL DOGS)
http://localhost:8080/dog/{DOGID}  (FIND DOG BY dog ID)
http://localhost:8080/dog/totalvotes/{id}  (FIND total votes by ID)

http://localhost:8080/dog/dogpictures/Labrador  (Dog pictures by BREED)

http://localhost:8080/dog/dogspicturesgroupedbybreed (DOG PICTURES GROUPED BY BREED)


============= VOTE UP/DOWN ======
http://localhost:8080/dog//{dogid}/voteup
http://localhost:8080/dog//{dogid}/votedown

=============

http://localhost:8080/dog/findbybreed/Labrador
[{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/eE29vX4.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":1,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/xX2AeDR.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":2,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/hBFRUuW.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":3,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/WDWK4nF.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":4,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/zxtD5Zw.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":5,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/MrkAGKR.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":6,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/o3Nyw4R.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":7,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/SzP5370.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":8,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/oHaP6I3.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":9,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/kSU7Zca.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":10,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/SAJJ1oH.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":11,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/BYvRbs8.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":12,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/VzFTsGg.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":13,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/qigJZWa.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":14,"noOfVotesReceived":0},{"breed":"Labrador","dogPictureURL":"http://i.imgur.com/gskym.png","noOfUpVotesReceived":0,"noOfDownVotesReceived":0,"dogname":"dogname","dogID":15,"noOfVotesReceived":0}]


