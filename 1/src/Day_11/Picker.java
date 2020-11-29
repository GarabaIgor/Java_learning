package Day_11;

public class Picker implements Worker {
    private double salary;
    private Warehouse warehouse;
    private boolean bonusFlg = false;

    public Picker(double salary, Warehouse warehouse) {
        this.salary = salary;
        this.warehouse = warehouse;
    }

    public boolean isBonusFlg() {
        return bonusFlg;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void doWork() {
        salary += 80;
        warehouse.setCountOrder(warehouse.getCountOrder() + 1);
        if (warehouse.getCountOrder() >= 1500 && !bonusFlg) {
            bonus();
        }
    }

    @Override
    public void bonus() {
        bonusFlg = true;
        salary *= 3;
    }
}
