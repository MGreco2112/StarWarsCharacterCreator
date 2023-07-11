package Logic;

public class Skill {
    private String name;
    private String parentSkill;
    private Integer value;

    public Skill(String name, String parentSkill, Integer value) {
        this.name = name;
        this.parentSkill = parentSkill;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentSkill() {
        return parentSkill;
    }

    public void setParentSkill(String parentSkill) {
        this.parentSkill = parentSkill;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
