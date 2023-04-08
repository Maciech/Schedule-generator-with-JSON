package test2;

import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//A class for creating schedules based on relevant data
//It takes into account the working hours of employees and the time to complete packages
//Two types of schedule have been created:
// - sorting by packing time
// - sorting by time to complete the order

public class Scheduler {
    public List<OrderClass> orderClasses;
    public StoreClass storeClass;
    public List<OrderClass> minValues = new ArrayList<>();
    List<PurchaseOrder> purchaseOrder = new ArrayList<>();


    public Scheduler(List<OrderClass> orderClasses, StoreClass storeClass) {
        this.orderClasses = orderClasses;
        this.storeClass = storeClass;
    }
//Schedule sorted by smaller time of packing parameter
//Next is better so this one is unused during this phase
//Might be usefull with specified situation
    public void timeSortMin() {
        minValues.removeAll(minValues);
        Comparator<OrderClass> compareByPickingTime = Comparator.comparing(OrderClass::getPickingTime);
        orderClasses.sort(compareByPickingTime);
        minValues.addAll(orderClasses);
        applyPurchaseOrder();

    }

//Schedule sorted by complete by parameter
    public void timeSortByCompleteBy() {
        minValues.removeAll(minValues);
        Comparator<OrderClass> compareByCompleteBy = Comparator.comparing(OrderClass::getCompleteBy);
        orderClasses.sort(compareByCompleteBy);
        minValues.addAll(orderClasses);
        applyPurchaseOrder();
    }

//Method applying stored in array data to object formed from class PurchasedOrder
//Then with results printed in appropriate format
    public void applyPurchaseOrder() {
        StoreClass pickersList = storeClass;
        int i = 0;
        int y = 0;
        List<LocalTime> startTimesPickers = new ArrayList<>();
        for (String v : pickersList.pickers){
            startTimesPickers.add(LocalTime.parse("09:00"));
        }
        while (i < minValues.size()){
            for (String x : pickersList.pickers){
                int seconds = (int) minValues.get(i).pickingTime.getSeconds();
                LocalTime time = startTimesPickers.get(y).plusSeconds(seconds);
                if (time.compareTo(pickersList.pickingEndTime) <= 0
                        && time.compareTo(minValues.get(i).completeBy) <= 0) {
                    purchaseOrder.add(new PurchaseOrder(x, minValues.get(i).orderId, time));
                    startTimesPickers.set(y, time);
                }
                    i++;
                    y++;
                    if (i >= minValues.size()-1){
                        break;
                    }
            }
            y=0;
        }
        for (PurchaseOrder x : purchaseOrder) {
            System.out.println(x.picker+ " " + x.orderId + " " + " " + x.pickingStopTime);
        }
    }
}

