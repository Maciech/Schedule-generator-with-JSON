package test2;

import org.joda.time.LocalTime;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

//A class for creating schedules based on relevant data
//It takes into account the working hours of employees and the time to complete packages
//Two types of schedule have been created:
// - sorting by packing time
// - sorting by time to complete the order

public class Scheduler {
    public List<OrderClass> orderClasses;
    public StoreClass storeClass;
    //public List<OrderClass> minValues = new ArrayList<>();
    List<PurchaseOrder> purchaseOrder = new ArrayList<>();


    public Scheduler(List<OrderClass> orderClasses, StoreClass storeClass) {
        this.orderClasses = orderClasses;
        this.storeClass = storeClass;
    }
//Schedule sorted by smaller time of packing parameter
//Next is better so this one is unused during this phase
//Might be usefull with specified situation
    public void timeSortMin() {
       // minValues.removeAll(minValues);
        Comparator<OrderClass> compareByPickingTime = Comparator.comparing(OrderClass::getPickingTime);
        orderClasses.sort(compareByPickingTime);
        //minValues.addAll(orderClasses);
        //applyPurchaseOrder(minValues);

    }

//Schedule sorted by complete by parameter
    public void timeSortByCompleteBy() {
        //minValues.removeAll(minValues);
        Comparator<OrderClass> compareByCompleteBy = Comparator.comparing(OrderClass::getCompleteBy);
        orderClasses.sort(compareByCompleteBy);
        //minValues.addAll(orderClasses);
       // applyPurchaseOrder(minValues);
    }

    public void optimalSort(List<OrderClass> orderClasses){
        List<OrderClass> optimal1 = new ArrayList<>();
        double worthy = 0;
        for (OrderClass x : orderClasses){
            if (x.pickingTime.getSeconds() > 0){
                worthy = x.orderValue / x.pickingTime.getSeconds();
                int precision = 2;
                BigDecimal bigDecimal = new BigDecimal(worthy);
                bigDecimal = bigDecimal.setScale(precision, RoundingMode.HALF_UP);
                worthy = bigDecimal.doubleValue();
            } else {
                worthy = x.orderValue;
            }
            orderClasses.set(orderClasses.indexOf(x),new OrderClass(x.orderId, x.orderValue, x.pickingTime, x.completeBy, worthy));
        }
        Comparator<OrderClass> compareByValue = Comparator.comparing(OrderClass::getProfitability);
        orderClasses.sort(compareByValue);
        Collections.reverse(orderClasses);
        applyPurchaseOrder(orderClasses);


    }

//Method applying stored in array data to object formed from class PurchasedOrder
//Then with results printed in appropriate format
    public void applyPurchaseOrder(List<OrderClass> order) {
        StoreClass pickersList = storeClass;
        int i = 0;
        int y = 0;
        List<LocalTime> startTimesPickers = new ArrayList<>();
        for (String v : pickersList.pickers){
            startTimesPickers.add(LocalTime.parse("09:00"));
        }
        while (i < order.size()){
            for (String x : pickersList.pickers){
                int seconds = (int) order.get(i).pickingTime.getSeconds();
                LocalTime time = startTimesPickers.get(y).plusSeconds(seconds);
                if (time.compareTo(pickersList.pickingEndTime) <= 0
                        && time.compareTo(order.get(i).completeBy) <= 0) {
                    purchaseOrder.add(new PurchaseOrder(x, order.get(i).orderId, time, order.get(i).orderValue));
                    startTimesPickers.set(y, time);
                }
                    i++;
                    y++;
                    if (i >= order.size()-1){
                        break;
                    }
            }
            y=0;
        }
        for (PurchaseOrder x : purchaseOrder) {
            System.out.println(x.picker+ " " + x.orderId + " " + " " + x.pickingStopTime + " " + x.value);
        }
    }
}

