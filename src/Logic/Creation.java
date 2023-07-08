package Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Creation {
    private static Scanner scanner = new Scanner(System.in);
    private static String name;
    private static String playerName;
    private static Integer attributePoints = 18;
    private static Map<String, Integer> attributeMap = new HashMap<>();
    private static Integer skillPoints = 7;
    private static Map<String, Integer> skillMap = new HashMap<>();
    private static List<Equipment> equipment = new ArrayList<>();

    private static Integer parseInteger(String input) {
        try {
            Integer output = Integer.parseInt(input);
            return output;
        } catch(Exception e) {
            return null;
        }
    }

    private static void nameEntry() {
        System.out.println("Enter your character's name:");
        name = scanner.nextLine();
        System.out.println("Enter your name:");
        playerName = scanner.nextLine();
    }

    private static void attributePointDistribution() {
        System.out.println("Is your character Force Sensitive? [y/n]");
        String choice = scanner.nextLine();

        String[] attributes = new String[] {"Dexterity", "Knowledge", "Mechanical", "Perception", "Strength", "Technical"};
        String[] forceAttributes = new String[] {"Control", "Sense", "Alter"};

        if (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y') {
            for (int i = 0; i < forceAttributes.length; i++) {
                System.out.println("You need to allocate at least 1D to any Force skill\nYou have " + attributePoints + "D remaining");
                System.out.println("How many D for the " + forceAttributes[i] + " attribute?");
                String forceDie = scanner.nextLine();

                Integer parsedInput = parseInteger(forceDie);

                if (parsedInput == null || parsedInput != 1) {
                    System.out.println("Invalid Entry, try again.");
                    i--;
                    continue;
                }

                attributeMap.put(forceAttributes[i], parsedInput);
                attributePoints -= parsedInput;
            }
        } else {
            for (int i = 0; i < attributes.length; i++) {
                System.out.println("You can allocate at minimum 2D per Attribute, but no larger than 4D.");
                System.out.println("You have " + attributePoints + "D remaining.");
                System.out.println("How many D for the " + attributes[i] + " attribute?");
                String attributeDie = scanner.nextLine();

                Integer parsedInput = parseInteger(attributeDie);

                if (parsedInput == null || parsedInput < 2 || parsedInput > 4) {
                    System.out.println("Invalid Entry, try again.");
                    i--;
                    continue;
                }

                attributeMap.put(attributes[i], parsedInput);
                attributePoints -= parsedInput;
            }
        }
    }

    private static void skillPointDistribution() {
        System.out.println("Enter the number of Skills you want to allocate points for:");
        String numOfSkills = scanner.nextLine();
        Integer parsedNumOfSkills = parseInteger(numOfSkills);

        if (parsedNumOfSkills == null || parsedNumOfSkills <= 0) {
            System.out.println("Invalid Entry, try again.");
            skillPointDistribution();
        }

        for (int i = 0; i < parsedNumOfSkills; i++) {
            System.out.println("You have " + skillPoints + "D remaining.");
            System.out.println("Enter the name of the Skill you wish to attribute points towards:");
            String skillName = scanner.nextLine();
            System.out.println("How many D do you wish to allocate to " + skillName + "?\nmin 2 max 4.");
            String allocatedPoints = scanner.nextLine();

            Integer parsedAllocatedPoints = parseInteger(allocatedPoints);

            if (parsedAllocatedPoints == null || parsedAllocatedPoints < 2 || parsedAllocatedPoints > 4) {
                System.out.println("Invalid Entry, try again");
                i--;
                continue;
            }

            skillMap.put(skillName, parsedAllocatedPoints);
            skillPoints -= parsedAllocatedPoints;
        }
    }

    private static void equipment() {
        System.out.println("Equipment Entry:");
        System.out.println("How many pieces of Equipment will you enter?");
        String numOfEquip = scanner.nextLine();

        Integer parsedNumOfEquip = parseInteger(numOfEquip);

        if (parsedNumOfEquip == null || parsedNumOfEquip < 1) {
            System.out.println("Invalid Entry, try again");
            equipment();
        }

        for (int i = 0; i < parsedNumOfEquip; i++) {
            System.out.println("Is this Equipment or a Weapon? [e/w]");
            String equipType = scanner.nextLine();

            switch (equipType) {
                case "w":
                case "W":
                    Integer parsedDamageCode = 0;
                    int[] parsedRanges = new int[3];
                    String[] ranges = new String[] {"Short", "Medium", "Long"};

                    System.out.println("Enter the name of the Weapon:");
                    String weaponName = scanner.nextLine();

                    do {
                        System.out.println("Enter the damage code for " + weaponName + ":");
                        String damageCode = scanner.nextLine();
                        parsedDamageCode = parseInteger(damageCode);

                        if (parsedDamageCode == null || parsedDamageCode <= 0) {
                            System.out.println("Invalid Entry, try again");
                        }

                    } while (parsedDamageCode == null || parsedDamageCode <= 0);

                    for (int j = 0; j < ranges.length; j++) {
                        System.out.println("Enter the max " + ranges[i] + " range of " + weaponName + ":");
                        Integer parsedRange = 0;

                        do {
                            String currentRange = scanner.nextLine();
                            parsedRange = parseInteger(currentRange);

                            if (parsedRange == null || parsedRange < 1) {
                                System.out.println("Invalid Entry, try again");
                            }

                        } while (parsedRange == null || parsedRange < 1);

                        parsedRanges[i] = parsedRange;
                    }

                    equipment.add(new Weapon(weaponName, parsedDamageCode, parsedRanges));
                    break;

                case "e":
                case "E":
                    System.out.println("Enter the name of the Equipment:");
                    String equipmentName = scanner.nextLine();

                    equipment.add(new Equipment(equipmentName));
                    break;

                default:
                    System.out.println("Invalid Entry, try again.");
                    i--;
                    break;
            }
        }
    }

    public static void writeCharacterToFile(PlayerCharacter newCharacter) {
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
                } else {
                    myWriter.write(equipment.getName() + "\n");
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

    public static void controlFlow() {
        nameEntry();
        attributePointDistribution();
        skillPointDistribution();
        equipment();

        PlayerCharacter newCh = new PlayerCharacter(name, playerName, attributeMap, skillMap);
        newCh.setEquipment(equipment);

        writeCharacterToFile(newCh);
    }
}
