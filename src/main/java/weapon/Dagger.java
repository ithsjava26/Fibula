package weapon;

public class Dagger implements Weapon {
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
    public StrengthLevel getStrengthLevel() {
        return StrengthLevel.MEDIUM;
    }

    @Override
    public int getStrength() {
        return 3;
    }
}
