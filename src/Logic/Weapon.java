package Logic;

import java.util.List;

public class Weapon extends Equipment{
    private Integer damageCode;
    private Integer maxShortRange;
    private Integer maxMediumRange;
    private Integer maxLongRange;

    public Weapon(String name, Integer damageCode, Integer maxShortRange, Integer maxMediumRange, Integer maxLongRange) {
        super(name);
        this.damageCode = damageCode;
        this.maxShortRange = maxShortRange;
        this.maxMediumRange = maxMediumRange;
        this.maxLongRange = maxLongRange;
    }

    public Integer getDamageCode() {
        return damageCode;
    }

    public void setDamageCode(Integer damageCode) {
        this.damageCode = damageCode;
    }

    public Integer getMaxShortRange() {
        return maxShortRange;
    }

    public void setMaxShortRange(Integer maxShortRange) {
        this.maxShortRange = maxShortRange;
    }

    public Integer getMaxMediumRange() {
        return maxMediumRange;
    }

    public void setMaxMediumRange(Integer maxMediumRange) {
        this.maxMediumRange = maxMediumRange;
    }

    public Integer getMaxLongRange() {
        return maxLongRange;
    }

    public void setMaxLongRange(Integer maxLongRange) {
        this.maxLongRange = maxLongRange;
    }
}
