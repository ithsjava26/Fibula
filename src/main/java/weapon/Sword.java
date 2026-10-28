package weapon;

public class Sword implements Weapon {
    int damage = 10;

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public WeaponType getType() {
        return WeaponType.SWORD;
    }

    @Override
    public WeaponRange getRange() {
        return WeaponRange.MELEE;
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
