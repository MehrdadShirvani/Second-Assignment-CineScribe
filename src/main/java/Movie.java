import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;

import  org.json.JSONObject;
public class Movie {
    public static final String API_KEY = "b8a113e0";

    public String title;
    public String description;

    //region Fields
    int imdbVotes;
    String runtime;
    String rating;
    public String director;
    String publishedDate;
    ArrayList<Actors> Actors;
    //endregion
    public Movie(String title) throws IOException
    {

        String movieJsonInfo = getMovieData(title);
        this.title = title;
        description = getMovieDescriptionViaApi(movieJsonInfo);
        director = getMovieDirectorViaApi(movieJsonInfo);
        imdbVotes = getImdbVotesViaApi(movieJsonInfo);
        rating = getRatingViaApi(movieJsonInfo);
        getActorListViaApi(movieJsonInfo);
        runtime = getRuntimeViaApi(movieJsonInfo);
    }
    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes)
    {
        //Could not understand the purpose of sending information and then ignoring them and then replacing them with +
        //info from the api.
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public static String getMovieData(String title) throws IOException
    {

        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line = reader.readLine()) != null)
        {
            stringBuilder.append(line);
        }

        reader.close();

        JSONObject jsonMovieObject = new JSONObject(stringBuilder.toString());
        Iterator<String> theKeys = jsonMovieObject.keys();
        while(theKeys.hasNext())
        {
            String key = theKeys.next();
            if(key.equals("Response") && jsonMovieObject.get("Response").toString().equals("False"))
            {
                throw new IOException();
            }
        }

        return stringBuilder.toString();
    }

    private String getMovieDescriptionViaApi(String movieInfoJson)
    {
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        description = jsonObject.get("Plot").toString();
        return description;
    }
    private String getMovieDirectorViaApi(String movieInfoJson)
    {
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        director = jsonObject.get("Director").toString();
        return director;
    }
    public int getImdbVotesViaApi(String movieInfoJson)
    {
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        imdbVotes = Integer.parseInt(jsonObject.get("imdbVotes").toString().replace(",",""));
        return imdbVotes;
    }

    public String getRatingViaApi(String movieInfoJson)
    {
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        rating = jsonObject.get("imdbRating").toString()+"/10";
        return rating;
    }

    public String getRuntimeViaApi(String movieInfoJson)
    {
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        runtime = jsonObject.get("Runtime").toString();
        return runtime;
    }

    public void getActorListViaApi(String movieInfoJson)
    {
        JSONObject jsonObject = new JSONObject(movieInfoJson);
        String actorsString = jsonObject.get("Actors").toString();
        String[] actorNames = actorsString.split(",");
        Actors = new ArrayList<>();
        for(String actorName : actorNames)
        {
            try
            {
                Actors.add(new Actors(actorName.trim()));
            }
            catch(Exception exception)
            {

            }
        }
    }
}