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

    @Override
    public StrengthLevel getStrengthLevel() {
        return StrengthLevel.EASY;
    }

    @Override
    public int getStrength() {
        return 2;
    }
}
