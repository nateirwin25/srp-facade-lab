package srpfacadelab;

public class Health {

    int maxHealth;
    int health;

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        this.health = h;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int h) {
        this.maxHealth = h;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void heal(int h) {
        health += h;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

}