package Logic;

public class Weapon extends Equipment{
    private Integer damageCode;
    private int[] range;

    public Weapon(String name, Integer damageCode, int[] range) {
        super(name);
        this.damageCode = damageCode;
        this.range = range;
    }

    public Integer getDamageCode() {
        return damageCode;
    }

    public void setDamageCode(Integer damageCode) {
        this.damageCode = damageCode;
    }

    public int[] getRange() {
        return range;
    }

    public void setRange(int[] range) {
        this.range = range;
    }
}
