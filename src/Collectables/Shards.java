package Collectables;

import city.cs.engine.*;

public class Shards extends DynamicBody {
    /*** Create the shape
     * @param shape the shape of the body .
     */
    private static final Shape shape = new CircleShape(0.5f);

    /*** Load the image for the shard
     * @param Shard_Image the Image of the body .
     */
    private static final BodyImage Shard_Image =
            new BodyImage("data/Game_Parts/Images/Collectables/Mana_Shards/mana_shard.png", 1.25f);

    /*** Construct a shard
     * @param world the world in which this body exists.
     */
    public Shards(World world) {
        super(world, shape);
        addImage(Shard_Image);
    }
}
