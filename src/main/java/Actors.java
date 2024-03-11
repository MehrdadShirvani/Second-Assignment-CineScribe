import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class Actors {
    public static final String API_KEY = "ZJl90h5GIP3KTWEuN5pM9A==UcG1frgxjmDAHSEX";
    //region Fields
    double netWorth;
    Boolean isAlive;
    String deathDate;
    String nationality;
    String name;
    //endregion

    public Actors(String actorName) throws Exception
    {
        String actorInfoJson = getActorData(actorName);
        name = actorName;
        getNetWorthViaApi(actorInfoJson);
        getNationality(actorInfoJson);
        isAlive(actorInfoJson);
        getDateOfDeathViaApi(actorInfoJson);

    }
    public Actors(String netWorth, boolean isAlive)
    {

    }

    @SuppressWarnings("deprecation")
    public String getActorData(String name)
    {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ","+"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            //System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString();
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson)
    {
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = new JSONObject(array.get(0).toString());
        netWorth = Double.parseDouble(jsonObject.get("net_worth").toString());
        return netWorth;
    }

    public String getNationality(String actorsInfoJson)
    {
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = new JSONObject(array.get(0).toString());
        nationality = jsonObject.get("nationality").toString();
        return nationality;
    }

    public String getName(String actorsInfoJson)
    {
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = new JSONObject(array.get(0).toString());
        name = jsonObject.get("name").toString();
        return name;
    }
    public boolean isAlive(String actorsInfoJson)
    {
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = new JSONObject(array.get(0).toString());
        isAlive = Boolean.parseBoolean(jsonObject.get("is_alive").toString());
        return isAlive;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson)
    {
        JSONArray array = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = new JSONObject(array.get(0).toString());
        deathDate = "";
        if(isAlive(actorsInfoJson) == false)
        {
            deathDate = jsonObject.get("death").toString();
            return deathDate;
        }
        return "";
    }
}