package entities;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id,String name ,int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon(1,"Pistol",140,1500);
        weapons[1] = new Weapon(2,"Gun",150,1550);
        weapons[2] = new Weapon(3,"Shutgun",250,1700);
        return weapons;
    }
    public static Weapon getWeaponById(int id){
        for (Weapon w : Weapon.weapons()){
            if (w.getId() == id){
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}






















