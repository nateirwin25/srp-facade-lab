package srpfacadelab;

import java.util.List;

public class Inventory {

    private List<Item> inventory;

    private int carryingCapacity;

    public Inventory(int maxCapacity) {
        this.carryingCapacity = maxCapacity;
    }

    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }
    
    private void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public int calculateStats() {
        int armour = 0;
        for (Item i: inventory) {
            armour += i.getArmour();
        }
        return armour;
    }

    public boolean doesItemExist(Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public boolean canPickUp(Item item) {
        return item.isUnique() && doesItemExist(item) ||
            (calculateInventoryWeight() + item.getWeight()) > carryingCapacity;

     }

}