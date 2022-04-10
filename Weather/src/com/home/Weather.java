package com.home;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Weather {
    static final String API_KEY = "09643a6d8cc6d35312848ce872b2bf0b";
    public static void main(String[] args){
        new GUI();
    }
    public static Hashtable<String, String> request(String city){
        try {
            URL mainUrl = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY +
                    "&units=metric");
            URLConnection con = mainUrl.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String input;
            Object obj = null;

            while ((input = br.readLine()) != null) {
                obj = new JSONParser().parse(input);
            }
            br.close();

            JSONObject jo = (JSONObject) obj;

            Hashtable<String, String> ht = new Hashtable<>();
            ht.put("Температура", Weather.numbToStr(((JSONObject) jo.get("main")).get("temp")));
            ht.put("Погода", (String) ((JSONObject) ((JSONArray) jo.get("weather")).get(0)).get("description"));
            ht.put("Скорость ветра", Weather.numbToStr(((JSONObject) jo.get("wind")).get("speed")));
            ht.put("Облака", Weather.numbToStr(((JSONObject) jo.get("clouds")).get("all")));

            return ht;
        } catch (Exception e) {

            return null;
        }
    }
    public static String numbToStr(Object numb) {
        String res = null;
        try {
            res = Double.toString((Double) numb);
        } catch(Exception e) {}
        try {
            res = Long.toString((Long) numb);
        } catch(Exception e) {}
        return res;
    }
}
