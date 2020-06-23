package Mobs;

import Game.GameLevels;
import city.cs.engine.*;

import java.util.HashMap;

public class Troll extends Walker implements StepListener {

    /**
     * V A R I A B L E S
     */
    private GameLevels gameLevels;
    private static float DETECTION_RANGE = 15;
    private static float ATTACK_RANGE = 5;

    private State state;
    private float WALKING_SPEED = 4;
    private String currentState = "";
    private int trollLiveCount;

    /**H A S H M A P*/
    private static final HashMap<String, BodyImage> sprite_images = new HashMap<String, BodyImage>();

    /**B O D Y  S H A P E*/
    private static final PolygonShape trollShape = new PolygonShape(
            -0.72f,-2.55f, -2.67f,-1.14f, -0.45f,1.06f, 1.64f,1.1f, 3.67f,-0.96f, 1.25f,-2.55f);

    /** G O L E M  S T A T E S*/
    private enum State{
        WALK_LEFT, WALK_RIGHT, STAND_STILL, ATTACK_LEFT, ATTACK_RIGHT, DEATH_LEFT, DEATH_RIGHT
    }

    public Troll(GameLevels world) {
        super(world, trollShape);
        this.gameLevels = world;
        state = State.STAND_STILL;
        trollLiveCount = 10;


        /**SPRITE IMAGES*/
        sprite_images.put("idle_right", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_idle_right.gif", 7f));
        sprite_images.put("idle_left", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_idle_right.gif", 7f));
        sprite_images.put("walk_right", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_walk_right.gif", 7f));
        sprite_images.put("walk_left", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_walk_left.gif", 7f));
        sprite_images.put("run_right", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_run_right.gif", 7f));
        sprite_images.put("run_left", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_run_left.gif", 7f));
        sprite_images.put("attack_right", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_att_right.gif", 7f));
        sprite_images.put("attack_left", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_att_left.gif", 7f));
        sprite_images.put("death_right", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_death_right.gif", 7f));
        sprite_images.put("death_left", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_death_left.gif", 7f));
        sprite_images.put("hurt_right", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_hurt_right.gif", 7f));
        sprite_images.put("hurt_left", new BodyImage("data/Game_Parts/Images/Mobs/Troll/troll_hurt_left.gif", 7f));


        getWorld().addStepListener(this);
        addImage(Troll.sprite_images.get("idle_left"));
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

    private void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public static BodyImage getImage(String direction) {
        return Troll.sprite_images.getOrDefault(direction, null);
    }

    public void decrementTroliveCount() {
        trollLiveCount--;
        System.out.println("Golem Remaining lives: " + trollLiveCount);
    }

    public int getTrollLiveCount() {
        return trollLiveCount;
    }

    // update state
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != Troll.State.WALK_RIGHT) {
                state = Troll.State.WALK_RIGHT;
            }
        } else if (inRangeLeft()) {
            if (state != Troll.State.WALK_LEFT) {
                state = Troll.State.WALK_LEFT;
            }
        } else {
            if (state != Troll.State.STAND_STILL) {
                state = Troll.State.STAND_STILL;
                stopWalking();
                if (currentState.equals("walk_left")){
                    removeAllImages();
                    addImage(getImage("idle_left"));
                }
                else if (currentState.equals("walk_right")){
                    removeAllImages();
                    addImage(getImage("idle_right"));
                }
            }
        }
        refreshRoll();
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
