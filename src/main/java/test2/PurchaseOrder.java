package test2;

import org.joda.time.LocalTime;

public class PurchaseOrder {
    String picker;
    String orderId;
    LocalTime pickingStopTime;

    public PurchaseOrder(String picker, String orderId, LocalTime pickingStopTime) {
        this.picker = picker;
        this.orderId = orderId;
        this.pickingStopTime = pickingStopTime;
    }
}
