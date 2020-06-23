package Game;

import Collectables.Mushrooms;
import Collectables.Shards;
import Hero.Wizard;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Shape;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private  Wizard wiz;

    /**
     * The Constructor
     */
    public Pickup(Wizard wiz) {
        this.wiz = wiz;

    }

    /**
     * Overriding the Collision methods to allow the Hero to pick up collectables
     */
    @Override
    public void collide(CollisionEvent e) {
//        System.out.println(e);
        if (e.getOtherBody() == wiz && e.getReportingBody() instanceof Shards) {
            wiz.addOne();
            e.getReportingBody().destroy();
        }
        else if (e.getOtherBody() == wiz && e.getReportingBody() instanceof Mushrooms){
            wiz.addLives();
            e.getReportingBody();
        }
    }
}
