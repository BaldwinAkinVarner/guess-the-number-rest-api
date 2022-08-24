
# guess-the-number-rest-service

This is a REST API for a "Guess The Number" game. The API was built using Spring Boot and Maven. See the Description and Directory Layout below for more info on how the API works.

## Directory Layout

```bash
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── sg
│   │   │           └── guessthenumber
│   │   │               ├── controller
│   │   │               │   └── Controller.java                     // Application Controller
│   │   │               ├── dao
│   │   │               │   ├── Gamedao.java                        // Game DAO Interface
│   │   │               │   ├── GameDatabaseDao.java                // Game DAO Implementation
│   │   │               │   ├── RoundDao.java                       // Round DAO Interface
│   │   │               │   └── RoundDaoDatabase.java               // Round DAO Implementation
│   │   │               ├── dto
│   │   │               │   ├── Game.java                           // Game Object
│   │   │               │   └── Round.java                          // Round Object
│   │   │               ├── service
│   │   │               │   └── ServiceLayer.java                   // Application Service
│   │   │               ├── App.java                                // Entry Point
│   │   │               └── TestApplicationConfiguration.java       // Test Configuration Object
│   │   └── resources
│   │       └── application.properties                              // SQL Configuration
│   └── test
│       ├── java
│       │   └── com
│       │       └── sg
│       │           └── guessthenumber
│       │               └── dao
│       │                   ├── GameDatabaseDaoTest.java            // Test Game DAO
│       │                   └── RoundDatabaseDaoTest.java           // Test Round Dao
│       └── resources
│           └── application.properties                              // SQL Testing Configuration
├── guessthenumberdb.sql                                            // Database Script
├── guessthenumberdbtest.sql                                        // Test Database Script
└── pom.xml                                                         // App Configuration

```

## Description

This project is a REST API built using Spring Boot and Maven for a "Guess The Number" game. The application configurations can be changed using the pom.xml file in the root directory. All data is returned from the API in JSON format.

The game works by generating a random four digit number. The player's objective is to guess that number. Each guess by the user creates a round, and the user is told whether each character in their guess is either not a match, a partial match (p), or an exact match (e). The answer for the game is inaccessible until the user wins the game. 

**Games** : Each game has a unique game id as an integer, an answer as a string, and a finished status as a boolean.<br>
**Rounds** : Each round has a guess as a string, a time of guess as a localdatetime, a result as a string, a game id, and a unique round id.

## Routes

* http://localhost:3306/api

GET

* http://localhost:3306/api/game : *returns a list of all games*
* http://localhost:3306/api/game/gameId : *returns a single game*
* http://localhost:3306/api/rounds/gameId : *returns a list of rounds in a single game*

POST

* http://localhost:3306/api/begin : *creates a new game and returns the game id*
* http://localhost:3306/api/guess : *creates a guess for a game and accepts a round object*


---
Made by Baldwin-Akin Varner

##### This project was done through Wiley Edge Academy as part of a bootcamp