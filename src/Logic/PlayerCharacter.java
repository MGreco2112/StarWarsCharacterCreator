package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerCharacter {
    private String name;
    private String playerName;
    private Integer forcePoints;
    private Integer darkSidePoints;
    private Integer woundStatus = 0;
    private Integer skillPoints;
    private Map<String, Integer> attributeMap;
    private Map<String, Integer> skillMap;
    private List<String> equipment;

    public PlayerCharacter(String name, String playerName, Map<String, Integer> attributeMap, Map<String, Integer> skillMap) {
        this.name = name;
        this.playerName = playerName;
        forcePoints = 0;
        darkSidePoints = 0;
        skillPoints = 0;
        this.attributeMap = attributeMap;
        this.skillMap = skillMap;
        equipment = new ArrayList<>();
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

    public Map<String, Integer> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(Map<String, Integer> skillMap) {
        this.skillMap = skillMap;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }
}
