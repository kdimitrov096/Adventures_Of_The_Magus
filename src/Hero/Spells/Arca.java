package Hero.Spells;

import Hero.Projectiles.Ball;
import city.cs.engine.Body;

public class Arca extends Spells {
    public Arca(Body o) {
        super(o);
    }

    @Override
    public void fire() {
        Ball g = new Ball(getOwner().getWorld(), getOwner().getPosition(), getShootingDirection());
    }
}
