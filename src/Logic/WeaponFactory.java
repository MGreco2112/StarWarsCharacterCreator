package Logic;

public class WeaponFactory {
    public static Weapon holdOutBlaster() {
        return new Weapon("Hold-out Blaster", 3, 4, 8, 12);
    }

    public static Weapon sportingBlaster() {
        return new Weapon("Sporting Blaster", 3, 10, 30, 120);
    }

    public static Weapon blasterPistol() {
        return new Weapon("Blaster Pistol", 4, 10, 30, 120);
    }

    public static Weapon heavyBlasterPistol() {
        return new Weapon("Heavy Blaster Pistol", 5, 7, 25, 50);
    }

    public static Weapon huntingBlaster() {
        return new Weapon("Hunting Blaster", 4, 30, 100, 300);
    }

    public static Weapon blasterRifle() {
        return new Weapon("Blaster Rifle", 5, 30, 100, 300);
    }

    public static Weapon blasterCarbine() {
        return new Weapon("Blaster Carbine", 5, 25, 60, 250);
    }

    public static Weapon mediumRepeatingBlaster() {
        return new Weapon("Medium Repeating Blaster", 7, 60, 150, 400);
    }

    public static Weapon heavyRepeatingBlaster() {
        return new Weapon("Heavy Repeating Blaster", 8, 75, 200, 500);
    }

    public static Weapon crossbow() {
        return new Weapon("Crossbow", 2, 10, 30, 50);
    }

    public static Weapon longbow() {
        return new Weapon("Longbow", 2, 10, 30, 100);
    }

    public static Weapon blackPowderPistol() {
        return new Weapon("Black Powder Pistol", 2, 4, 8, 12);
    }

    public static Weapon musket() {
        return new Weapon("Musket", 3, 10, 30, 100);
    }

    public static Weapon rifle() {
        return new Weapon("Rifle", 3, 30, 100, 300);
    }

    public static Weapon submachinegun() {
        return new Weapon("Submachinegun", 4, 10, 50, 100);
    }

    public static Weapon wookieBowcaster() {
        return new Weapon("Wookie Bowcaster", 4, 10, 30, 50);
    }

    public static Weapon grenade() {
        return new Weapon("Grenade", null, 7, 20, 40, 5, 4, 3, 2);
    }

    public static Weapon thermalDetonator() {
        return new Weapon("Thermal Detonator", null, 4, 7, 12, 10, 8, 5, 2);
    }
}

