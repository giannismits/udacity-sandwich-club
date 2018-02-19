package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) throws JSONException {
        //create the arraylists for the alsoknownas and ingredients
        ArrayList<String> alsoKnown = new ArrayList<>();
        ArrayList<String> ingred = new ArrayList<>();
        //initialize tha JSONObject
        JSONObject jsonObject = new JSONObject(json);
        //parse the place of origin
        String placeOfOrigin = jsonObject.getString("placeOfOrigin");
        JSONObject name = jsonObject.getJSONObject("name");
        //parse JSON for also known as and add it in the arraylist
        String mainName=name.getString("mainName");
        JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
        for (int i=0; i<=alsoKnownAs.length();i++){
            String s = alsoKnownAs.optString(i);
            alsoKnown.add(s);
        }
        //parse description
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");
        //parse JSON for ingredients and add it in the arraylist
        JSONArray ingredients = jsonObject.getJSONArray("ingredients");
        for (int i=0; i<=ingredients.length();i++){
            String si = ingredients.optString(i);
            ingred.add(si);
        }

        //call the constuctor of the Sandwich class to pass the data
        Sandwich sandwich = new Sandwich(mainName,alsoKnown,placeOfOrigin,description,image,ingred);


        //return the sandwich object.
        return sandwich;
    }
}
