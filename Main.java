import java.util.Scanner;

class Character {
    protected String name;
    protected int health;
    protected int mana;
    protected int level;

    public Character(String name, int health, int mana, int level) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.level = level;
    }

    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.name);
        target.health -= 20;
        System.out.println(target.name + " loses 20 XP.");
        System.out.println(target.name + "'s health becomes " + target.health);
    }

    public void defend(Character target) {
        System.out.println(this.name + " is going into defence." + target.name + " was defeated successfully.");
        this.level += 1;
        System.out.println(this.name + " levels up to " + this.level);
    }

    public void castSpell(Character target) {
        System.out.println(this.name + " shakes " + target.name + " with a spell. ");
        System.out.println(this.name + " gains 10 XP");

    }

    public void levelUp() {
        this.level++;
        System.out.println(this.name + " gains enough XP and levels up to " + this.level);
    }
}

class Warrior extends Character {
    private int strength;
    private int armor;

    public Warrior(String name, int health, int mana, int level, int strength, int armor) {
        super(name, health, mana, level);
        this.strength = strength;
        this.armor = armor;
    }

    public void shieldSlam(Character target) {
        System.out.println(this.name + "throws a shield slam spell and destroys " + target.name + "'s armour");
        target.health -= (this.strength * 2);
        System.out.println(target.name + "'s health" + target.health );

    }
}

class Mage extends Character {
    private int intelligence;
    private int spellPower;

    public Mage(String name, int health, int mana, int level, int intelligence, int spellPower) {
        super(name, health, mana, level);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }

    public void fireball(Character target) {
        System.out.println(this.name + " casts a fireball at " + target.name);
        this.intelligence += 10;
        System.out.println("Intelligence: +" + this.intelligence);
        target.health -= 5;

    }
}

class Rogue extends Character {
    private final int agility;
    private final int dexterity;

    public Rogue(String name, int health, int mana, int level, int agility, int dexterity) {
        super(name, health, mana, level);
        this.agility = agility;
        this.dexterity = dexterity;
    }

    public void backstab(Character target) {
        System.out.println(this.name + " backstabs " + target.name + " with dexterity " + this.dexterity);
        target.health -= (this.dexterity * 2);
        System.out.println(target.name + "'s health drops to " + target.health);
        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Warrior starter pack:");
        System.out.println(" ");
        System.out.print("Name: ");
        String warriorName = scanner.nextLine();
        System.out.print("Health: ");
        int warriorHealth = scanner.nextInt();
        System.out.print("Mana: ");
        int warriorMana = scanner.nextInt();
        System.out.print("Level: ");
        int warriorLevel = scanner.nextInt();
        System.out.print("Strength: ");
        int warriorStrength = scanner.nextInt();
        System.out.print("Armor: ");
        int warriorArmor = scanner.nextInt();
        scanner.nextLine();

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Mage starter pack:");
        System.out.println(" ");
        System.out.print("Name: ");
        String mageName = scanner.nextLine();
        System.out.print("Health: ");
        int mageHealth = scanner.nextInt();
        System.out.print("Mana: ");
        int mageMana = scanner.nextInt();
        System.out.print("Level: ");
        int mageLevel = scanner.nextInt();
        System.out.print("Intelligence: ");
        int mageIntelligence = scanner.nextInt();
        System.out.print("Spell Power: ");
        int mageSpellPower = scanner.nextInt();
        scanner.nextLine();

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Rogue starter pack:");
        System.out.println(" ");
        System.out.print("Name: ");
        String rogueName = scanner.nextLine();
        System.out.print("Health: ");
        int rogueHealth = scanner.nextInt();
        System.out.print("Mana: ");
        int rogueMana = scanner.nextInt();
        System.out.print("Level: ");
        int rogueLevel = scanner.nextInt();
        System.out.print("Agility: ");
        int rogueAgility = scanner.nextInt();
        System.out.print("Dexterity: ");
        int rogueDexterity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");

        Warrior warrior = new Warrior(warriorName, warriorHealth, warriorMana, warriorLevel, warriorStrength, warriorArmor);
        Mage mage = new Mage(mageName, mageHealth, mageMana, mageLevel, mageIntelligence, mageSpellPower);
        Rogue rogue = new Rogue(rogueName, rogueHealth, rogueMana, rogueLevel, rogueAgility, rogueDexterity);

        warrior.attack(mage);
        System.out.println(" ");
        mage.defend(warrior);
        System.out.println(" ");
        mage.castSpell(warrior);
        System.out.println(" ");
        mage.levelUp();
        System.out.println(" ");
        rogue.attack(warrior);
        System.out.println(" ");
        warrior.shieldSlam(mage);
        System.out.println(" ");
        mage.fireball(rogue);
        System.out.println(" ");
        rogue.backstab(warrior);
        System.out.println(" ");


        scanner.close();
    }
}