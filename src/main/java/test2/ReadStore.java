package test2;

import org.joda.time.LocalTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Read store class is created in order to read the data stored in json files
//I am using source path with JSON parser to acces this file
//The entire content of the .json file is read and written to the list of objects

//src/main/resources/advanced-allocation/store.json

public class ReadStore {
    public StoreClass storeClass;

    public ReadStore(String url){

        JSONParser parser = new JSONParser();
        List<String> pickersString = new ArrayList<>();
        try {
            JSONObject store = (JSONObject) parser.parse(new FileReader(url));
            System.out.println("Welcome in the schedule creator");

                JSONArray pickers = (JSONArray) store.get("pickers");
                for (Object c : pickers){
                    pickersString.add((String) c);
                }

                String pickingStartTime = (String) store.get("pickingStartTime");
                LocalTime t1 = LocalTime.parse(pickingStartTime) ;

                String pickingEndTime = (String) store.get("pickingEndTime");
                LocalTime t2 = LocalTime.parse(pickingEndTime) ;

                storeClass = new StoreClass(pickersString, t1, t2);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
