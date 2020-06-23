package Game;

import Hero.Wizard;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Listener for collision with the portal.  When the player collides with the portal,
 * if the current level is complete the game is advanced to the next level.
 */

public class PortalListener implements CollisionListener {
    private Game game;

    public PortalListener(Game game) {this.game = game; }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        Wizard player = game.getPlayer();
        if (collisionEvent.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to the next level. . .");
            game.goNextLevel();
        }

    }
}
