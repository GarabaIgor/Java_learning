package Day_11;

public class TestWarehouse {
    public static void main(String[] args) {
        Warehouse warehouse_1 = new Warehouse(0,0);
        Picker picker_1 = new Picker(20000,warehouse_1);
        Courier courier_1 = new Courier(30000,warehouse_1);

        while (!picker_1.isBonusFlg()) {
            picker_1.doWork();
        }
        while (!courier_1.isBonusFlg()) {
            courier_1.doWork();
        }
        System.out.println("Warehouse balance: " + warehouse_1.getBalance());
        System.out.println("Warehouse orders count: " +warehouse_1.getCountOrder());
        System.out.println("Picker salary: " + picker_1.getSalary());
        System.out.println("Courier salary: " + courier_1.getSalary());
    }
}
