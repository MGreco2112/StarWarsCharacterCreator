package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerCharacter {
    private String name;
    private String playerName;
    private Integer forcePoints = 0;
    private Integer darkSidePoints = 0;
    private Integer woundStatus = 0;
    private Integer skillPoints = 0;
    private Map<String, Integer> attributeMap;
    private List<Skill> skillMap;
    private List<Equipment> equipment;

    public PlayerCharacter(String name, String playerName, Map<String, Integer> attributeMap, List<Skill> skillMap) {
        this.name = name;
        this.playerName = playerName;
        forcePoints = 0;
        darkSidePoints = 0;
        skillPoints = 0;
        this.attributeMap = attributeMap;
        this.skillMap = skillMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getForcePoints() {
        return forcePoints;
    }

    public void setForcePoints(Integer forcePoints) {
        this.forcePoints = forcePoints;
    }

    public Integer getDarkSidePoints() {
        return darkSidePoints;
    }

    public void setDarkSidePoints(Integer darkSidePoints) {
        this.darkSidePoints = darkSidePoints;
    }

    public Integer getWoundStatus() {
        return woundStatus;
    }

    public void setWoundStatus(Integer woundStatus) {
        this.woundStatus = woundStatus;
    }

    public Integer getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(Integer skillPoints) {
        this.skillPoints = skillPoints;
    }

    public Map<String, Integer> getAttributeMap() {
        return attributeMap;
    }

    public void setAttributeMap(Map<String, Integer> attributeMap) {
        this.attributeMap = attributeMap;
    }

    public List<Skill> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(List<Skill> skillMap) {
        this.skillMap = skillMap;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public String toString() {
        return name + "\n";
    }
}
