package weapon;

public class Dagger implements Weapon {
    int damage = 10;

    @Override
    public String getName() {
        return "Dagger";
    }

    @Override
    public WeaponType getType() {
        return WeaponType.DAGGER;
    }

    @Override
    public WeaponRange getRange() {
        return WeaponRange.DISTANCE;
    }

    @Override
    public int setDamage(int damage) {
        this.damage = damage;
        return damage;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
