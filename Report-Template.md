# Movie Aggregator

An app that, well, aggregates movies...

## Description
- You can use it to search for movies and see ~~all~~(really few) details about them. 

- Start by searching the name of the movie, and then choose any actor of that movie to see the related information
- Lastly, just search the movie in google; that's much better.



## About this app
So, this my first Java console application that uses APIs. I had worked with APIs before this, but never once with Java. So I knew the basics, therefor the hard part was figuring how to do it with Java.

This is the step-by-step report of my process:

1. I first needed the API key for the Movies and Actors APIs. You can find the links in README.md 
2. I tested the APIs using Postman to understand the structure of the JSON files.

This is an example:
    ```
    {
        "Title": "The Maze Runner",
        "Year": "2014",
        "Rated": "PG-13",
        "Released": "19 Sep 2014",
        "Runtime": "113 min",
        "Genre": "Action, Mystery, Sci-Fi",
        "Director": "Wes Ball",
        "Writer": "Noah Oppenheim, Grant Pierce Myers, T.S. Nowlin",
        "Actors": "Dylan O'Brien, Kaya Scodelario, Will Poulter",
        "Plot": "Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow \"runners\" for a shot at escape.",
        "Language": "English",
        "Country": "United Kingdom, United States",
        "Awards": "4 wins & 12 nominations",
        "Poster": "https://m.media-amazon.com/images/M/MV5BMjUyNTA3MTAyM15BMl5BanBnXkFtZTgwOTEyMTkyMjE@._V1_SX300.jpg",
        "Ratings": [
            {
                "Source": "Internet Movie Database",
                "Value": "6.8/10"
            },
            {
                "Source": "Rotten Tomatoes",
                "Value": "65%"
            },
            {
                "Source": "Metacritic",
                "Value": "57/100"
            }
        ],
        "Metascore": "57",
        "imdbRating": "6.8",
        "imdbVotes": "502,247",
        "imdbID": "tt1790864",
        "Type": "movie",
        "DVD": "02 Dec 2014",
        "BoxOffice": "$102,427,862",
        "Production": "N/A",
        "Website": "N/A",
        "Response": "True"
    }
    ```
3. The next thing to do was completing the movie and actor classes. I struggled a bit with installing the packages that were needed to work with JSONObject, but I finally managed to do it. Refer to the link provided down below, in the Acknowldgement section.

4. The last and the easiest part was making the menu. The project is basically a loop that will contiue loading and asking the user to search for movies, until the user decides to step out of the program.


### Dependencies

* Windows 10 / 11
* IntelliJ IDEA 2022
* JDK 21
* Gradle


### Installing
* Install IntelliJ IDEA 2022
* No  modifications needs to be made to files/folders

### Executing program

* Open the project in IntelliJ
* Press the run button



## Help

Read README if you needed more help. 

You could contact the authors down below for more help. 


## Authors



ex. Mehrdad Shirvani  
    [Email Me](mailto:mehrdadsh0901@gmail.com)

## Version History
* 0.3 Created the Main Menu and all the other searching and viewing movies and actors pages
* 0.2
    * Completed the Connection to API and the retreival of data and information
    * See [commit change](https://github.com/MehrdadShirvani/Second-Assignment-CineScribe/commits/main/) 
* 0.1
    * Initial Release

## License

This project is licensed under the [CC BY] License - see the LICENSE.md file for details

## Acknowledgments


* [How to write markdowns](https://www.freecodecamp.org/news/markdown-cheat-sheet/)
* [Getting JSON Data From a RESTful API Using JAVA](https://medium.com/swlh/getting-json-data-from-a-restful-api-using-java-b327aafb3751)