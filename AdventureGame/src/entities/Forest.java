package entities;

import abstracts.Impl.LocationImpl.BattleLoc;

public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player, "forest", new Vampire(), "blood",3);
    }
}
