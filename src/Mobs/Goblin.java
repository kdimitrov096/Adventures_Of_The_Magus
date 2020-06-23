package Mobs;

import Game.GameLevels;
import city.cs.engine.*;
import java.util.HashMap;

public class Goblin extends Walker implements StepListener {
    private GameLevels gameLevels;
    private static float DETECTION_RANGE = 15;
    private static float ATTACK_RANGE = 5;

    private State state;
    private float WALKING_SPEED = 4;
    private String currentState = "";
    private int gobLivesCount;

    /**H A S H M A P*/
    private static final HashMap<String, BodyImage> sprite_images = new HashMap<String, BodyImage>();

    /**B O D Y  S H A P E*/
    private static final PolygonShape gobShape = new PolygonShape(
            -1.16f,-1.49f, -1.34f,-0.31f, -1.07f,1.29f, 0.03f,1.46f, 1.11f,1.27f, 1.34f,-0.32f, 1.18f,-1.49f);

    /** G O B L I N   S T A T E S*/
    private enum State{
        WALK_LEFT, WALK_RIGHT
    }

    /**C O N S T R U C T O R */
    public Goblin(GameLevels world) {
        super(world, gobShape);
        this.gameLevels = world;
        state = State.WALK_LEFT;
        gobLivesCount = 10;

        sprite_images.put("walk_right", new BodyImage("data/Game_Parts/Images/Mobs/Goblin/goblin_walking_right.gif", 3f));
        sprite_images.put("walk_left", new BodyImage("data/Game_Parts/Images/Mobs/Goblin/goblin_walking_left.gif", 3f));

        getWorld().addStepListener(this);
        addImage(Goblin.sprite_images.get("walk_left"));


    }

    public boolean inRangeLeft() {
        Body a = gameLevels.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap < DETECTION_RANGE && gap > 0;
    }

    public boolean inRangeRight() {
        Body a = gameLevels.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -DETECTION_RANGE && gap < 0;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (inRangeRight()) {
            if (state != Goblin.State.WALK_RIGHT) {
                state = Goblin.State.WALK_RIGHT;
            }
        } else if (inRangeLeft()) {
            if (state != Goblin.State.WALK_LEFT) {
                state = Goblin.State.WALK_LEFT;
            }
        } else {
        }
        refreshRoll();

    }

    private void refreshRoll() {
        switch (state) {
            case WALK_LEFT:
                setCurrentState("walk_left");
                removeAllImages();
                addImage(getImage("walk_left"));
                startWalking(-WALKING_SPEED);
                break;
            case WALK_RIGHT:
                setCurrentState("walk_right");
                removeAllImages();
                addImage(getImage("walk_right"));
                startWalking(WALKING_SPEED);
                break;
            default: // nothing to do
        }
    }

    public static BodyImage getImage(String direction) {
        return Goblin.sprite_images.getOrDefault(direction, null);
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public int getGobLiveCount() {
        return gobLivesCount;
    }

    public void decrementGobliveCount() {
        gobLivesCount--;
        System.out.println("Goblin Remaining lives: " + gobLivesCount);
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
