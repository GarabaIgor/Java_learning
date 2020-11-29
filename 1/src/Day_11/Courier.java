package Day_11;

public class Courier implements Worker{
    private double salary;
    private Warehouse warehouse;
    private boolean bonusFlg = false;

    public Courier(double salary, Warehouse warehouse) {
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
        salary += 100;
        warehouse.setBalance(warehouse.getBalance() + 1000);
        if (warehouse.getBalance() >= 1000000 && !bonusFlg) {
            bonus();
        }
    }

    @Override
    public void bonus() {
        bonusFlg = true;
        salary *= 2;
    }
}
