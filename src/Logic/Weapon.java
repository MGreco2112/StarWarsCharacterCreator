package Logic;

import java.util.List;

public class Weapon extends Equipment {

    private boolean isGrenade = false;
    private Integer damageCode;
    private Integer maxShortRange;
    private Integer maxMediumRange;
    private Integer maxLongRange;

    private Integer pointBlankDamage;
    private Integer shortDamage;
    private Integer mediumDamage;
    private Integer longDamage;

    public Weapon(String name, Integer damageCode, Integer maxShortRange, Integer maxMediumRange, Integer maxLongRange) {
        super(name);
        this.damageCode = damageCode;
        this.maxShortRange = maxShortRange;
        this.maxMediumRange = maxMediumRange;
        this.maxLongRange = maxLongRange;
    }

    public Weapon(String name, Integer damageCode, Integer maxShortRange, Integer maxMediumRange, Integer maxLongRange, Integer pointBlankDamage, Integer shortDamage, Integer mediumDamage, Integer longDamage) {
        super(name);
        this.damageCode = damageCode;
        this.maxShortRange = maxShortRange;
        this.maxMediumRange = maxMediumRange;
        this.maxLongRange = maxLongRange;
        this.pointBlankDamage = pointBlankDamage;
        this.shortDamage = shortDamage;
        this.mediumDamage = mediumDamage;
        this.longDamage = longDamage;
        this.isGrenade = true;
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

    public Integer getPointBlankDamage() {
        if (isGrenade) {
            return pointBlankDamage;
        } else {
            return null;
        }
    }

    public void setPointBlankDamage(Integer pointBlankDamage) {
        this.pointBlankDamage = pointBlankDamage;
    }

    public Integer getShortDamage() {
        if (isGrenade) {
            return shortDamage;
        } else {
            return null;
        }
    }

    public void setShortDamage(Integer shortDamage) {
        this.shortDamage = shortDamage;
    }

    public Integer getMediumDamage() {
        if (isGrenade) {
            return mediumDamage;
        } else {
            return null;
        }
    }

    public void setMediumDamage(Integer mediumDamage) {
        this.mediumDamage = mediumDamage;
    }

    public Integer getLongDamage() {
        if (isGrenade) {
            return longDamage;
        } else {
            return null;
        }
    }

    public void setLongDamage(Integer longDamage) {
        this.longDamage = longDamage;
    }
}
