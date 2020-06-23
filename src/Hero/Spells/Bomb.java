package Hero.Spells;

import Hero.Projectiles.Granade;
import city.cs.engine.Body;

public class Bomb extends Spells {
    public Bomb(Body o) {
        super(o);
    }

    @Override
    public void fire() {
        Granade g = new Granade(getOwner().getWorld(), getOwner().getPosition(), getShootingDirection());
    }
}
