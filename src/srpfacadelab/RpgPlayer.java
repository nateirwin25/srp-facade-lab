package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;

    private Health health;

    private int armour;

    private Inventory inventory;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new Inventory(MAX_CARRYING_CAPACITY);
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public boolean pickUpItem(Item item) {

        if (!inventory.canPickUp(item))
            return false;

        item.pickUp(gameEngine, health);

        inventory.addItem(item);

        armour = inventory.calculateStats();

        return true;
    }

    public void takeDamage(int damage) {

        if (inventory.calculateInventoryWeight() < 0.5 * inventory.getCarryingCapacity()) {
            damage *= 0.75;
        }

        if (damage < armour) {
            gameEngine.playSpecialEffect("parry");
        }

        health.takeDamage(damage-armour);

        gameEngine.playSpecialEffect("lots_of_gore");
    }


    // Stat retrieval API
    public int getHealth() {
        return health.getHealth();
    }

    public void setHealth(int h) {
        health.setHealth(h);
    }

    public int getMaxHealth() {
        return health.getMaxHealth();
    }

    public void setMaxHealth(int h) {
        health.setMaxHealth(h);
    }

    public int getArmour() {
        return armour;
    }

    private void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return inventory.getCarryingCapacity();
    }

    
}