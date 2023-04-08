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
import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

//Read orders class is created in order to read the data stored in json files
//I am using source path with JSON parser to acces this file
//The entire content of the .json file is read and written to the list of objects


public class ReadOrders {
    public List<OrderClass> orderClasses = new ArrayList<>();

    public ReadOrders(){
        JSONParser parser = new JSONParser();
        JSONArray a = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //a = (JSONArray) parser.parse(new FileReader("D:\\Kursy\\testOCADO\\self-test-data\\advanced-allocation\\orders.json"));
            System.out.println("Now please enter the source path to the orders.json file: ");
            a = (JSONArray) parser.parse(new FileReader(bufferedReader.readLine()));
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
