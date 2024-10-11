package droids;

public class Mage extends Droid {
    public Mage(String name) {
        super(name, 60, 20);
    }
    // Перевантажений конструктор, який дозволяє передавати індивідуальні параметри
    public Mage(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void specialAbility(Droid target) {
        System.out.println(name + " кидає вогняну кулю!");
        target.takeDamage(damage);
    }
}
