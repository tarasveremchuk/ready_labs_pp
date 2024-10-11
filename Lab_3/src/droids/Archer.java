package droids;

public class Archer extends Droid {
    public Archer(String name) {
        super(name, 80, 15);
    }
    public Archer(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public void specialAbility(Droid target) {
        System.out.println(name + " випускає стрілу!");
        target.takeDamage(damage);
    }
}
