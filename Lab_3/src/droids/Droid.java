package droids;

import utils.Color;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public abstract void specialAbility(Droid target);

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        String healthColor = health > 50 ? Color.GREEN : Color.RED;
        return String.format("%s (Здоров'я: %s%d%s, Шкода: %d)", name, healthColor, health, Color.RESET, damage);
    }
}
