package Hero.Projectiles;

import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class Projectiles extends DynamicBody {

    /**
     * Abstract Class Projectiles
     */


    Projectiles(World w, Vec2 from, Vec2 towards) {
        super(w);
        this.setPosition(from.add(towards.mul(2)));
        this.setLinearVelocity(towards.mul(getSpeed()));

    }

    /**
     * Abstract method to assign a speed to various projectiles
     */


    public abstract float getSpeed();
}
