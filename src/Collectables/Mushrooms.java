package Collectables;

import Game.GameLevels;
import Game.Pickup;
import city.cs.engine.*;

public class Mushrooms extends DynamicBody {
    /*** Create the shape
     * @param shape the shape of the body .
     */
    private static final Shape shape = new CircleShape(0.5f);

    /*** Load the image for the mushroom
     * @param mushImage the Image of the body .
     */
    private static final BodyImage mushImage =
            new BodyImage("data/Game_Parts/Images/Collectables/Mushrooms/mushroom.gif", 1.25f);

    /*** Construct a shard
     * @param world the world in which this body exists.
     */
    public Mushrooms(GameLevels world) {
        super(world, shape);
        addImage(mushImage);

        addCollisionListener(new Pickup(world.getPlayer()));
    }
}
