package Game;

import city.cs.engine.*;

/**
 * Portals in a game . When the actor collides with the portal, if
 * the current level is complete the game is advanced to the
 * next level.
 */

public class Portal extends StaticBody {
    /**
     * The Constructor of the Portal
     */
    public Portal(World w) {
        super(w, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/Game_Parts/Ground/Portal/portal.png", 2.8f));
    }
}
