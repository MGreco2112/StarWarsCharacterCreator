package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerCharacter {
    private String name;
    private String playerName;
    private Integer forcePoints = 1;
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
        return name;
    }

    public String getWoundLevel() {
        if (woundStatus == 0) {
            return "Unwounded";
        } else if (woundStatus == 1) {
            return "Wounded";
        } else if (woundStatus == 2) {
            return "Incapacitated";
        } else {
            return "Mortally Wounded";
        }
    }

    public String outputFormatter() {
        return "{\n" +
                "\t\"name\": \"" + name + "\",\n" +
                "\t\"playerName\": \"" + playerName + "\",\n" +
                "\t\"attributes\": [\n" + attributeFormatter() + "\t],\n" +
                "\t\"skills\": [\n" + skillFormatter() + "\t],\n" +
                "\t\"equipment\": [\n" + equipmentFormatter() + "\t],\n" +
                "\t\"forcePoints\": " + forcePoints + ",\n" +
                "\t\"darkSidePoints\": " + darkSidePoints + ",\n" +
                "\t\"skillPoints\": " + skillPoints + ",\n" +
                "\t\"woundStatus\": " + woundStatus + "\n" +
                "}";
    }

    private String attributeFormatter() {
        String output = "";

        String[] attributes = new String[] {"Dexterity", "Technical", "Mechanical", "Perception", "Knowledge", "Strength"};

        for (int i = 0; i < attributes.length; i++) {
            if (i < attributes.length - 1) {
                output += "\t\t{\"" + attributes[i] + "\":" + attributeMap.get(attributes[i]) + "},\n";
            } else {
                output += "\t\t{\"" + attributes[i] + "\":" + attributeMap.get(attributes[i]) + "}\n";
            }
        }

        return output;
    }

    private String skillFormatter() {
        String output = "";

        for (int i = 0; i < skillMap.size(); i++) {
            if (i < skillMap.size() - 1) {
                output += "\t\t{\"" + skillMap.get(i).getName() + "\": " + skillMap.get(i).getValue() + "},\n";
            } else {
                output += "\t\t{\"" + skillMap.get(i).getName() + "\": " + skillMap.get(i).getValue() + "}\n";
            }
        }

        return output;
    }

    private String equipmentFormatter() {
        String output = "";

        for (int i = 0; i < equipment.size(); i++) {
            if (equipment.get(i) instanceof Weapon) {
                Weapon weapon = (Weapon) equipment.get(i);
                output += "\t\t{\"name\": \"" + weapon.getName() + "\", \"damageCode\": "
                        + weapon.getDamageCode() + ", \"maxShortRange\": " + weapon.getMaxShortRange() +
                        ", \"maxMediumRange\": " + weapon.getMaxMediumRange() + ", \"maxLongRange\": " +
                        weapon.getMaxLongRange() + "}";
            } else {
                output += "\t\t{\"name\": \"" + equipment.get(i).getName() + "\"}";
            }

            if (i < equipment.size() - 1) {
                output += ",\n";
            } else {
                output += "\n";
            }
        }

        return output;
    }
}
