package droids;

public class Intimidator extends Droid {
    public Intimidator(String name) {
        super(name, 75, 10);
    }
    public Intimidator(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void specialAbility(Droid target) {
        System.out.println(name + " залякує ворога!");
        target.takeDamage(damage);
    }
}
