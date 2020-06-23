package Hero.Spells;

import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

public abstract class Spells {

    private Body owner;
    private Vec2 towards;

    Spells(Body owner) {
        this.owner = owner;
    }

    Body getOwner(){
        return owner;
    }

    public abstract void fire();

    public void startShooting(){}
    public void stopShooting(){}

    void setShootingDirection(Vec2 towards) {
        this.towards = towards;
    }
    Vec2 getShootingDirection() { return this.towards; }

}
