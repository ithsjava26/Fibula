package weapon;

public class Sword implements Weapon {
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
    public StrengthLevel getStrengthLevel() {
        return StrengthLevel.HARD;
    }

    @Override
    public int getStrength() {
        return 4;
    }
}
