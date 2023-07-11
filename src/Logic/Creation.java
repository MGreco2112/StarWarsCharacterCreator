package Logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Creation {

    private static String weapons =
            """
                    A) Hold-Out Blaster, B) Sporting Blaster, C) Blaster Pistol
                    D) Heavy Blaster Pistol, E) Hunting Blaster, F) Blaster Rifle
                    G) Blaster Carbine, H) Medium Repeating Blaster, I) Heavy Repeating Blaster
                    J) Crossbow, K) Longbow, L) Black Powder Pistol
                    M) Musket, N) Rifle, O) Submachinegun
                    P) Wookie Bowcaster, Q) Grenade, R) Thermal Detonator
            """
            ;
    private static String dexteritySkills =
            """
                    A) Blaster, B) Brawling Pary, C) Dodge
                    D) Grenade, E) Heavy Weapons, F) Melee Parry,
                    H) Melee Weapons
                    0) Exit
            """
            ;
    private static String knowledgeSkills =
            """
                    A) Alien Races, B) Bureaucracy, C Languages
                    D) Planetary Systems, E) Streetwise, F) Survival
                    G) Technology
                    0) Exit
            """
            ;
    private static String mechanicalSkills =
            """
                    A) Astrogation, B) Beast Riding, C) Repulsorlift Operation
                    D) Starship Gunnery, E) Starship Piloting, F) Starshift Shields
                    0) Exit
            """
            ;
    private static String perceptionSkills =
            """
                    A) Command, B) Con, C) Gambling
                    D) Hide/Sneak, E) Search
                    0) Exit
            """
            ;

    private static String strengthSkills =
            """
                    A) Brawling, B) Climbing & Jumping, C) Lifting
                    D) Stamina, E) Swimming
                    0) Exit
            """
            ;

    private static String technicalSkills =
            """
                    A) Computer Programming & Repair, B) Demolition
                    C) Droid Programming & Repair, D) Medicine
                    E) Repulsorlift Repair, F) Security, G) Starship Repair
                    0) Exit
            """
            ;

    private static Scanner scanner = new Scanner(System.in);
    private static String name;
    private static String playerName;
    //TODO implement a system to disallow more points to be added than are available
    private static Integer attributePoints = 18;
    private static Map<String, Integer> attributeMap = new HashMap<>();
    private static Integer skillPoints = 7;
    private static List<Skill> skills;
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
        //TODO implement splitting up dice into individual modifiers as an option
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
        //TODO build list of skills based on Attribute class
        //Have parent Attribute die code added to child Skill die code
        //TODO implement splitting up dice into added modifiers
        String[] attributes = new String[] {"Dexterity", "Knowledge", "Mechanical", "Perception", "Strength", "Technical"};
        String continueLoop = "Y";
        System.out.println("Skill Point Distribution");
        for (int i = 0; i < attributes.length; i++) {
            do {
                System.out.println("Do you wish to allocate Skill Points toward any " + attributes[i] + "Skills? [y/n]");
                String decision = scanner.nextLine();

                if (decision.equalsIgnoreCase("n")) {
                    System.out.println("No skills for this attribute.");
                    break;
                }

                System.out.println("You have " + skillPoints + "D remaining.");
                System.out.println("Enter the name of the " + attributes[i] + " Skill you wish to attribute points towards:");
                String skillName = scanner.nextLine();
                System.out.println("How many D do you wish to allocate to " + skillName + "?\nmin 2 max 4.");
                String allocatedPoints = scanner.nextLine();

                Integer parsedAllocatedPoints = parseInteger(allocatedPoints);

                if (parsedAllocatedPoints == null || parsedAllocatedPoints < 2 || parsedAllocatedPoints > 4) {
                    System.out.println("Invalid Entry, try again");
                    break;
                }

                parsedAllocatedPoints += attributeMap.get(attributes[i]);

                skills.add(new Skill(skillName, attributes[i], parsedAllocatedPoints));
                skillPoints -= parsedAllocatedPoints;

                System.out.println("Do you want to add points to another skill? [y/n]");
                String choice = scanner.nextLine();

                if (!choice.equalsIgnoreCase("y")) {
                    continueLoop = "N";
                }
            } while (continueLoop.equals("Y"));
        }

    }

    private static void customWeaponCreation() {
        Integer parsedDamageCode = 0;
        Integer parsedShortRange = 0;
        Integer parsedMediumRange = 0;
        Integer parsedLongRange = 0;
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
            System.out.println("Enter the max " + ranges[j] + " range of " + weaponName + ":");
            Integer parsedRange = 0;

            do {
                String currentRange = scanner.nextLine();
                parsedRange = parseInteger(currentRange);

                if (parsedRange == null || parsedRange < 1) {
                    System.out.println("Invalid Entry, try again");
                }

            } while (parsedRange == null || parsedRange < 1);

            if (j == 0) {
                parsedShortRange = parsedRange;
            } else if (j == 1) {
                parsedMediumRange = parsedRange;
            } else {
                parsedLongRange = parsedRange;
            }
        }

        equipment.add(new Weapon(weaponName, parsedDamageCode, parsedShortRange, parsedMediumRange, parsedLongRange));
    }

    private static void equipment() {
        //TODO refactor to prompt user for any equipment to enter rather than frontload with hard number
        String continueLoop = "Y";

        do {
            System.out.println("Equipment");
            System.out.println("Is this Equipment or a Weapon? [e/w]");
            String equipType = scanner.nextLine();

            switch (equipType) {
                case "w":
                case "W":
                    System.out.println("Either choose a letter from the list or create custom.");
                    System.out.println("Enter 0 for custom weapon creation");
                    System.out.println(weapons);
                    String choice = scanner.nextLine();

                    switch (choice.toUpperCase()) {
                        case "0":
                            customWeaponCreation();
                            break;
                        case "A":
                            System.out.println("Hold-Out Blaster added");
                            equipment.add(WeaponFactory.holdOutBlaster());
                            break;
                        case "B":
                            System.out.println("Sporting Blaster added");
                            equipment.add(WeaponFactory.sportingBlaster());
                            break;
                        case "C":
                            System.out.println("Blaster Pistol added");
                            equipment.add(WeaponFactory.blasterPistol());
                            break;
                        case "D":
                            System.out.println("Heavy Blaster Pistol added");
                            equipment.add(WeaponFactory.heavyBlasterPistol());
                            break;
                        case "E":
                            System.out.println("Hunting Blaster added");
                            equipment.add(WeaponFactory.huntingBlaster());
                            break;
                        case "F":
                            System.out.println("Blaster Rifle added");
                            equipment.add(WeaponFactory.blasterRifle());
                            break;
                        case "G":
                            System.out.println("Blaster Carbine added");
                            equipment.add(WeaponFactory.blasterCarbine());
                            break;
                        case "H":
                            System.out.println("Medium Repeating Blaster added");
                            equipment.add(WeaponFactory.mediumRepeatingBlaster());
                            break;
                        case "I":
                            System.out.println("Heavy Repeating Blaster added");
                            equipment.add(WeaponFactory.heavyRepeatingBlaster());
                            break;
                        case "J":
                            System.out.println("Crossbow added");
                            equipment.add(WeaponFactory.crossbow());
                            break;
                        case "K":
                            System.out.println("Longbow added");
                            equipment.add(WeaponFactory.longbow());
                            break;
                        case "L":
                            System.out.println("Black Powder Pistol added");
                            equipment.add(WeaponFactory.blackPowderPistol());
                            break;
                        case "M":
                            System.out.println("Musket added");
                            equipment.add(WeaponFactory.musket());
                            break;
                        case "N":
                            System.out.println("Rifle added");
                            equipment.add(WeaponFactory.rifle());
                            break;
                        case "O":
                            System.out.println("Submachinegun added");
                            equipment.add(WeaponFactory.submachinegun());
                            break;
                        case "P":
                            System.out.println("Wookie Bowcaster Added");
                            equipment.add(WeaponFactory.wookieBowcaster());
                            break;
                        case "Q":
                            System.out.println("Grenade Added");
                            equipment.add(WeaponFactory.grenade());
                            break;
                        case "R":
                            System.out.println("Thermal Detonator added");
                            equipment.add(WeaponFactory.thermalDetonator());
                            break;
                    }
                    break;

                case "e":
                case "E":
                    System.out.println("Enter the name of the Equipment:");
                    String equipmentName = scanner.nextLine();

                    equipment.add(new Equipment(equipmentName));
                    break;

                default:
                    System.out.println("Invalid Entry, try again.");
                    break;
            }

            System.out.println("Do you wish to add more equipment? [y/n]");
            String result = scanner.nextLine();

            if (!result.substring(0, 1).equalsIgnoreCase("y")) {
                continueLoop = "N";
            }
        } while (continueLoop.equals("Y"));
    }

    public static void writeCharacterToFile(PlayerCharacter newCharacter) {
        try {
            FileWriter myWriter = new FileWriter(newCharacter.getName() + ".txt");
            myWriter.write("Name: " + newCharacter.getName() + "\n");
            myWriter.write("Player Name: " + newCharacter.getPlayerName() + "\n");
            myWriter.write("Attributes:\n");
            for (String attribute : newCharacter.getAttributeMap().keySet()) {
                myWriter.write("\t" + attribute + ": " + newCharacter.getAttributeMap().get(attribute) + "D\n");
            }
            myWriter.write("Skills:\n");
            for (int i = 0; i < skills.size(); i++) {
                myWriter.write("\t" + skills.get(i).getName() + ": " + newCharacter.getSkillMap().get(i).getValue() + "D\n");
            }
            myWriter.write("Equipment:\n");
            for (Equipment equipment : newCharacter.getEquipment()) {
                if (equipment instanceof Weapon) {
                    myWriter.write("\t" + equipment.getName() + ", ");
                    myWriter.write(((Weapon) equipment).getDamageCode() + "D, ");
                    myWriter.write("Range: (");
                    myWriter.write(((Weapon) equipment).getMaxShortRange() + ", ");
                    myWriter.write(((Weapon) equipment).getMaxMediumRange() + ", ");
                    myWriter.write(((Weapon) equipment).getMaxLongRange() + ")\n");
                } else {
                    myWriter.write("\t" + equipment.getName() + "\n");
                }
            }
            myWriter.write("Force Points: " + newCharacter.getForcePoints() + "\n");
            myWriter.write("Dark Side Points: " + newCharacter.getDarkSidePoints() + "\n");
            myWriter.write("Skill Points: " + newCharacter.getSkillPoints() + "\n");
            myWriter.write("Wound Status: " + newCharacter.getWoundStatus() + "\n");
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

        PlayerCharacter newCh = new PlayerCharacter(name, playerName, attributeMap, skills);
        newCh.setEquipment(equipment);

        writeCharacterToFile(newCh);
    }
}
