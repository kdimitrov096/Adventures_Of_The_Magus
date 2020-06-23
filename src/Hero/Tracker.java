package Hero;

import Game.GameView;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {
    /** The view */
    private GameView view;

    /** The body */
    private Wizard wiz;

    public Tracker(Wizard wiz, GameView view) {
        this.wiz = wiz;
        this.view = view;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {
        Vec2 wizPosition = new Vec2(wiz.getPosition().x, wiz.getPosition().y + 8.0f);
        view.setCentre(wizPosition);
    }

    /**
     * Setter for the current walker
     */

    public void setBody(Wizard wizard, GameView view) { this.wiz = wizard; this.view = view; }
}
