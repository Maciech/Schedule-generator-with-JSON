package test2;

// D:\Kursy\testOCADO\self-test-data\logic-bomb\store.json
// D:\Kursy\testOCADO\self-test-data\logic-bomb\orders.json

public class Main {
    public static void main(String[] args) {
        //Read store data drom Json file
        ReadStore readStore = new ReadStore();
        //Read orders data from Json file
        ReadOrders readOrders = new ReadOrders();
        //Basing on read data stored in objects preparing schedules for order packing
        Scheduler scheduler = new Scheduler(readOrders.orderClasses, readStore.storeClass);
        //Chosen type of sorting by
        scheduler.timeSortByCompleteBy();
    }

}

