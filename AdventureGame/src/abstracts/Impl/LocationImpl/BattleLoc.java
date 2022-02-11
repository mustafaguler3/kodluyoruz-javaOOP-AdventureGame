package abstracts.Impl.LocationImpl;

import abstracts.Location;
import entities.Obstacle;
import entities.Player;

import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.obstacle = obstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("you are here now : "+this.getName());
        System.out.println("look out! "+obsNumber+" lives "+this.getObstacle().getName()+" in here");
        System.out.println("<f>fight or <r>run");

        String selectCase = scanner.nextLine();
        //selectCase = selectCase.toUpperCase();
        if (selectCase.equalsIgnoreCase("f")){
            if(combat(obsNumber)){
                System.out.println(this.getName() + " defeated all enemies");
                return true;
            }
        }
        if(this.getPlayer().getHealth() < 0){
            System.out.println("You died!");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for(int i = 1; i <= obsNumber; i++){
            playerStats();
            obstacleStats();
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.println("<f>fight or <r>run");
                String select = scanner.nextLine();

                if(select.equalsIgnoreCase("f")){
                    System.out.println("You fighted");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());

                    afterHit();
                    if(this.getObstacle().getHealth() > 0){
                        System.out.println();
                        System.out.println("Monster hit you!");
                        int obsDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obsDamage < 0){
                            obsDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obsDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
        }
        if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
            System.out.println("you defeated enemie");
            System.out.println(this.getObstacle().getAward() + " win money");
            System.out.println("Current money : "+this.getPlayer().getMoney());
        }
        return false;
    }
    public void afterHit(){
        System.out.println("Your health : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " health "+this.getObstacle().getHealth());
    }

    public void playerStats(){
        System.out.println("Player Information");
        System.out.println("---------------------");
        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println("Damage : "+this.getPlayer().getDamage());
        System.out.println("Money : "+this.getPlayer().getMoney());

        if(this.getPlayer().getInventory().getWeapon().getDamage() > 0){
            System.out.println("Gun : "+this.getPlayer().getInventory().getWeapon().getName());
        }

    }
    public void obstacleStats(){
        System.out.println(this.getObstacle().getName() + " ");
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.maxObstacle) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}




















