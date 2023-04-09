package test2;

import java.time.Duration;
import org.joda.time.LocalTime;



public class OrderClass {
    String orderId;
    Double orderValue;
    Duration pickingTime;
    LocalTime completeBy;
    Double profitability;

    public OrderClass(String orderId, Double orderValue, Duration pickingTime, LocalTime completeBy) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.pickingTime = pickingTime;
        this.completeBy = completeBy;
    }


    public OrderClass(String orderId, Double orderValue, Duration pickingTime, LocalTime completeBy, Double profitability) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.pickingTime = pickingTime;
        this.completeBy = completeBy;
        this.profitability = profitability;
    }

    public String getOrderId() {
        return orderId;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public Duration getPickingTime() {
        return pickingTime;
    }

    public LocalTime getCompleteBy() {
        return completeBy;
    }
    public Double getProfitability() {
        return profitability;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public void setPickingTime(Duration pickingTime) {
        this.pickingTime = pickingTime;
    }

    public void setCompleteBy(LocalTime completeBy) {
        this.completeBy = completeBy;
    }
}
