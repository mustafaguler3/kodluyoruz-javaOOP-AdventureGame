package entities;

import abstracts.Impl.NormalLocImpl.SafeHouse;
import abstracts.Impl.NormalLocImpl.ToolStore;
import abstracts.Location;

import java.util.Scanner;

public class Player {

    private Scanner scanner = new Scanner(System.in);

    private String name;
    private int damage;
    private int health;
    private int money;
    private String charName;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
        Character[] characters = {new Fighter(),new Archer()};
        for (Character ch : characters){
            System.out.println("entities.Character :" + ch.getName() +"\t"+
                    "Health :"+ch.getHealth()+"\t"+
                    "Damage :"+ch.getDamage()+"\t"+
                    "Money :"+ch.getMoney());
        }
        System.out.println("-----------------------");
        System.out.println("Please enter a character \n 1 - entities.Fighter\n 2 - entities.Archer");
        int selectChar = scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Fighter());
                break;
            case 2:
                initPlayer(new Archer());
                break;
        }
        System.out.println("entities.Character :"+this.getCharName()+" Damage: "+this.damage+ " Health :"+this.health+ " Money :"+this.money);
    }


    public void initPlayer(Character character){
        this.setCharName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }
    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getTotalDamage() {
        return this.damage;
    }
}
