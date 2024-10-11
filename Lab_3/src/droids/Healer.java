package droids;

public class Healer extends Droid {
    public Healer(String name) {
        super(name, 70, 5);
    }
    public Healer(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public void specialAbility(Droid target) {
        System.out.println(name + " зцілює " + target.getName() + "!");
        target.takeDamage(-10); // Heal 10 health
    }
}
