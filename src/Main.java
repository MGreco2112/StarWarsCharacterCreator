import Logic.Creation;
import Logic.Equipment;
import Logic.PlayerCharacter;
import Logic.Weapon;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PlayerCharacter newCharacter = Creation.controlFlow();

        try {
            FileWriter myWriter = new FileWriter(newCharacter.getName() + ".txt");
            myWriter.write("Name:" + newCharacter.getName() + "\n");
            myWriter.write("Player Name:" + newCharacter.getPlayerName() + "\n");
            myWriter.write("Attributes:\n");
            for (String attribute : newCharacter.getAttributeMap().keySet()) {
                myWriter.write(attribute + ": " + newCharacter.getAttributeMap().get(attribute) + "\n");
            }
            myWriter.write("Skills:\n");
            for (String skill : newCharacter.getSkillMap().keySet()) {
                myWriter.write(skill + ": " + newCharacter.getSkillMap().get(skill) + "\n");
            }
            myWriter.write("Equipment:\n");
            for (Equipment equipment : newCharacter.getEquipment()) {
                if (equipment instanceof Weapon) {
                    myWriter.write(equipment.getName() + ", ");
                    myWriter.write(((Weapon) equipment).getDamageCode() + ", ");
                    myWriter.write("Range: (");
                    for (int i = 0; i < ((Weapon) equipment).getRange().length; i++) {
                        myWriter.write(((Weapon) equipment).getRange()[i]);
                        if (i < 2) {
                            myWriter.write(", ");
                        } else {
                            myWriter.write(")\n");
                        }
                    }
                }
            }
            myWriter.write("Force Points:" + newCharacter.getForcePoints() + "\n");
            myWriter.write("Dark Side Points:" + newCharacter.getDarkSidePoints() + "\n");
            myWriter.write("Skill Points:" + newCharacter.getSkillPoints() + "\n");
            myWriter.write("Wound Status" + newCharacter.getWoundStatus() + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}