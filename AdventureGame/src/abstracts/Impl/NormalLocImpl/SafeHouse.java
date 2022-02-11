package abstracts.Impl.NormalLocImpl;

import abstracts.Impl.LocationImpl.NormalLoc;
import entities.Player;

public class SafeHouse extends NormalLoc {


    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house!");
        System.out.println("Your health has been restored");
        this.getPlayer().setHealth(this.getPlayer().getHealth());
        return true;
    }

}

















