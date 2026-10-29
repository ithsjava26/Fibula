package weapon;

public interface Weapon {
    String getName();
    WeaponType getType();
    WeaponRange getRange();
    StrengthLevel getStrengthLevel();
    int getStrength();

    static Weapon createWeapon(WeaponType type) {
        return switch (type) {
            case AXE -> new Axe();
            case SWORD -> new Sword();
            case DAGGER -> new Dagger();
        };
    }
}
