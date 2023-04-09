package test2;

import org.joda.time.LocalTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//Read orders class is created in order to read the data stored in json files
//I am using source path with JSON parser to acces this file
//The entire content of the .json file is read and written to the list of objects


public class ReadOrders {
    public List<OrderClass> orderClasses = new ArrayList<>();

    public ReadOrders(String url){
        JSONParser parser = new JSONParser();
        JSONArray a;

        try {
            a = (JSONArray) parser.parse(new FileReader(url));
            for (Object o : a)
            {
                JSONObject order = (JSONObject) o;

                String orderId = (String) order.get("orderId");

                String orderValue = (String) order.get("orderValue");
                double d = Double.parseDouble(orderValue);

                String pickingTime = (String) order.get("pickingTime");
                Duration duration = Duration.parse(pickingTime);

                String completeBy = (String) order.get("completeBy");
                LocalTime t = LocalTime.parse(completeBy) ;

                orderClasses.add(new OrderClass(orderId, d, duration, t));

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
