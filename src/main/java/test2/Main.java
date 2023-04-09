package test2;

// D:\Kursy\testOCADO\self-test-data\logic-bomb\store.json
// D:\Kursy\testOCADO\self-test-data\logic-bomb\orders.json

public class Main {
    public static void main(String[] args) {
        //Basing on read data stored in objects preparing schedules for order packing
        Scheduler scheduler = new Scheduler(new ReadOrders("src/main/resources/logic-bomb/orders.json").orderClasses,
                new ReadStore("src/main/resources/logic-bomb/store.json").storeClass);

        //Chosen type of sorting by
        //scheduler.timeSortByCompleteBy();
        scheduler.optimalSort(scheduler.orderClasses);
    }

}

