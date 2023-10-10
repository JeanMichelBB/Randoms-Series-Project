package com.example.randomsseriesproject.data;

import com.example.randomsseriesproject.models.SeriesModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class APIClient {
    public static ArrayList<SeriesModel> getSeries() throws IOException, JSONException {

        URL url = new URL("https://api.themoviedb.org/3/tv/top_rated?api_key=53e1583141045810cb1911af442d5981");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        ArrayList<SeriesModel> seriesList;
        int status = con.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(response);
            JSONArray series = jsonObject.getJSONArray("results");
            seriesList = new ArrayList<>();
            for (int i = 0; i < series.length(); i++) {
                JSONObject serie = series.getJSONObject(i);
                int id = serie.getInt("id");
                String name = serie.getString("name");
                String overview = serie.getString("overview");
                int popularity = serie.getInt("popularity");
                int vote_average = serie.getInt("vote_average");
                String key = getSeriesVideoId(id);
                SeriesModel seriesModel = new SeriesModel(id, name, overview, popularity, vote_average, key);
                seriesList.add(seriesModel);
            }
            return seriesList;
        }else {
            System.out.println("Error");
        }
        return null;
    }
    public static String getSeriesVideoId(int serieId) throws IOException, JSONException {

        URL url = new URL("https://api.themoviedb.org/3/tv/" + serieId + "/videos?api_key=53e1583141045810cb1911af442d5981");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(response);
            JSONArray series = jsonObject.getJSONArray("results");
            String key = "";
            for (int i = 0; i < series.length(); i++) {
                JSONObject serieVideo = series.getJSONObject(i);
                key = serieVideo.getString("key");
            }
            return key;
        }else {
            System.out.println("Error");
        }
        return null;
    }
}