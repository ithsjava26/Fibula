package weapon;

public class Axe implements Weapon {
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
}
