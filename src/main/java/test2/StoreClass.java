package test2;

import org.joda.time.LocalTime;

import java.util.List;

public class StoreClass {
    List<String> pickers;
    LocalTime pickingStartTime;
    LocalTime pickingEndTime;


    public StoreClass(List<String> pickers, LocalTime pickingStartTime, LocalTime pickingEndTime) {
        this.pickers = pickers;
        this.pickingStartTime = pickingStartTime;
        this.pickingEndTime = pickingEndTime;
    }

    public StoreClass() {
    }

    public List<String> getPickers() {
        return pickers;
    }

    public LocalTime getPickingStartTime() {
        return pickingStartTime;
    }

    public LocalTime getPickingEndTime() {
        return pickingEndTime;
    }

    public void setPickers(List<String> pickers) {
        this.pickers = pickers;
    }

    public void setPickingStartTime(LocalTime pickingStartTime) {
        this.pickingStartTime = pickingStartTime;
    }

    public void setPickingEndTime(LocalTime pickingEndTime) {
        this.pickingEndTime = pickingEndTime;
    }
}
