package abstracts.Impl.NormalLocImpl;

import abstracts.Impl.LocationImpl.NormalLoc;
import abstracts.Location;
import entities.Armor;
import entities.Player;
import entities.Weapon;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Store");
    }
    @Override
    public boolean onLocation() {
        System.out.println("---Welcome to store---");
        System.out.println("1 - Guns");
        System.out.println("2 - Armors");
        System.out.println("3 - Exit");
        System.out.println("Your choice? :");
        int select = scanner.nextInt();
        while (select > 1){
            System.out.println("No valid value ");
            select = scanner.nextInt();
        }
        switch (select){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buArmor();
                break;
            case 3:
                System.out.println("see you again");
                break;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("--Guns--");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " Money :"+w.getPrice()+ " Damage :"+w.getDamage());
        }


    }
    public void buyWeapon(){
        System.out.println("Enter a gun :");
        int select = scanner.nextInt();
        while (select < 1 || select > Weapon.weapons().length){
            System.out.println("No valid value : ");
            select = scanner.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponById(select);

        if (selectedWeapon !=null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You have not enough money");
            }else {
                System.out.println("you bought "+selectedWeapon.getName() + " gun");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("your balance left :"+this.getPlayer().getMoney());
                System.out.println("previous gun : "+this.getPlayer().getInventory().getWeapon().getName());

                this.getPlayer().getInventory().setWeapon(selectedWeapon);


            }
        }
    }
    public void printArmors(){
        System.out.println("--Armors--");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() +" Name : "+ a.getName()+" Block :"+a.getBlock()+" Price :"+a.getPrice());
        }
    }

    public void buArmor(){
        System.out.println("select a armor :");
        int select = scanner.nextInt();
        while (select < 1 || select > Armor.armors().length ){
            System.out.println("Not valid value");
            select = scanner.nextInt();
        }

        Armor selectedArmor = Armor.getArmorById(select);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You have not a enough money");
            }else {
                System.out.println(selectedArmor.getName() +" ");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Balance remaining :"+this.getPlayer().getMoney());
            }
        }
    }
}


















