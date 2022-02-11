package entities;

import abstracts.Impl.LocationImpl.BattleLoc;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "food",2);
    }

}





















