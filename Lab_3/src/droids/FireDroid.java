package droids;

public class FireDroid extends Droid {
    public FireDroid(String name) {
        super(name, 65, 25);
    }
    public FireDroid(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public void specialAbility(Droid target) {
        System.out.println(name + " розпочинає вогневу атаку!");
        target.takeDamage(damage);
    }
}
