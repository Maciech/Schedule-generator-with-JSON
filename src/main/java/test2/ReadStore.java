package test2;

import org.joda.time.LocalTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Read store class is created in order to read the data stored in json files
//I am using source path with JSON parser to acces this file
//The entire content of the .json file is read and written to the list of objects


public class ReadStore {
    public StoreClass storeClass;

    public ReadStore(){
        JSONParser parser = new JSONParser();
        JSONObject a = null;
        List<String> pickersString = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //JSONObject store = (JSONObject) parser.parse(new FileReader("D:\\Kursy\\testOCADO\\self-test-data\\advanced-allocation\\store.json"));
            System.out.println("Welcome in the schedule creator");
            System.out.println("Please enter the source path to the store.json file: ");
            JSONObject store = (JSONObject) parser.parse(new FileReader(bufferedReader.readLine()));

                JSONArray pickers = (JSONArray) store.get("pickers");
                for (Object c : pickers){
                    pickersString.add(c+"");
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
