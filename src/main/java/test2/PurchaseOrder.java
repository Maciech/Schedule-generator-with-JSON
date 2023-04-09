package test2;

import org.joda.time.LocalTime;

public class PurchaseOrder {
    String picker;
    String orderId;
    LocalTime pickingStopTime;
    Double value;

    public PurchaseOrder(String picker, String orderId, LocalTime pickingStopTime, Double value) {
        this.picker = picker;
        this.orderId = orderId;
        this.pickingStopTime = pickingStopTime;
        this.value = value;
    }
}
