package weapon;

public class Axe implements Weapon {
    int damage = 10;

    @Override
    public String getName() {
        return "Axe";
    }

    @Override
    public WeaponType getType() {
        return WeaponType.AXE;
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
