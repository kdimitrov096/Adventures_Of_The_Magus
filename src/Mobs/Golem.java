package Mobs;

import Game.GameLevels;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.HashMap;

public class Golem extends Walker implements StepListener{
    /**
     * V A R I A B L E S
     */
    private GameLevels gameLevels;
    private static float DETECTION_RANGE = 15;
    private static float ATTACK_RANGE = 5;

    private State state;
    private float WALKING_SPEED = 4;
    private String currentState = "";
    private int golLiveCount;

    /**H A S H M A P*/
    private static final HashMap<String, BodyImage> sprite_images = new HashMap<String, BodyImage>();

    /**B O D Y  S H A P E*/
    private static final PolygonShape golShape = new PolygonShape(
            -1.49f, -1.49f, -1.49f, 0.31f, -1.22f, 1.46f, 1.03f, 1.48f, 1.47f, 0.31f, 1.48f, -1.48f, -1.49f, -1.49f);

    /** G O L E M  S T A T E S*/
    private enum State{
        WALK_LEFT, WALK_RIGHT, STAND_STILL, ATTACK_LEFT, ATTACK_RIGHT, DEATH_LEFT, DEATH_RIGHT
    }

    /** G O L E M  C O N S T R U C T O R*/
    public Golem(GameLevels world) {
        super(world, golShape);
        this.gameLevels = world;
        state = State.STAND_STILL;
        golLiveCount = 10;

        /**SPRITE IMAGES*/
        sprite_images.put("idle_right", new BodyImage("data/Game_Parts/Images/Mobs/Golem/R.png", 3f));
        sprite_images.put("idle_left", new BodyImage("data/Game_Parts/Images/Mobs/Golem/L.png", 3f));
        sprite_images.put("walk_right", new BodyImage("data/Game_Parts/Images/Mobs/Golem/golem_walking_R.gif", 3f));
        sprite_images.put("walk_left", new BodyImage("data/Game_Parts/Images/Mobs/Golem/golem_walking_L.gif", 3f));
        sprite_images.put("attack_right", new BodyImage("data/Game_Parts/Images/Mobs/Golem/golem_att_R.gif", 4f));
        sprite_images.put("attack_left", new BodyImage("data/Game_Parts/Images/Mobs/Golem/golem_att_L.gif", 4f));
        sprite_images.put("death_right", new BodyImage("data/Game_Parts/Images/Mobs/Golem/golem_death_R.gif", 3f));
        sprite_images.put("death_left", new BodyImage("data/Game_Parts/Images/Mobs/Golem/golem_death_L.gif", 3f));


        getWorld().addStepListener(this);
        addImage(Golem.sprite_images.get("idle_left"));
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

    public boolean inAttackRangeLeft(){
        Body a = gameLevels.getPlayer();
        float gap = getPosition().x = a.getPosition().x;
        return gap < ATTACK_RANGE && gap > 0;
    }

    public boolean inAttackRangeRight(){
        Body a = gameLevels.getPlayer();
        float gap = getPosition().x = a.getPosition().x;
        return gap > -ATTACK_RANGE && gap < 0;
    }

    // update state
    public void preStep(StepEvent e) {

//        System.out.println(getCurrentState());
        if (inRangeRight()) {
            if (state != State.WALK_RIGHT) {
                state = State.WALK_RIGHT;
            }
        } else if (inRangeLeft()) {
            if (state != State.WALK_LEFT) {
                state = State.WALK_LEFT;
            }
        }
//        }  else if (inAttackRangeLeft()){
//            if (state != State.ATTACK_LEFT) {
//                state = State.ATTACK_LEFT;
//            }
//
//        } else if (inAttackRangeRight()){
//            if (state != State.ATTACK_RIGHT){
//                state = State.ATTACK_RIGHT;
//            }
//        }
        else
         {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
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

    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
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
//            case ATTACK_LEFT:
//                setCurrentState("attack_left");
//                stopWalking();
//                removeAllImages();
//                addImage(getImage("attack_left"));
//            case ATTACK_RIGHT:
//                setCurrentState("attack_right");
//                stopWalking();
//                removeAllImages();
//                addImage(getImage("attack_right"));

            default: // nothing to do
        }
    }

    public void postStep(StepEvent e) { }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public static BodyImage getImage(String direction) {
        return Golem.sprite_images.getOrDefault(direction, null);
    }

    public int getGolLiveCount() {
        return golLiveCount;
    }

    public void decrementGolliveCount() {
        golLiveCount--;
        System.out.println("Golem Remaining lives: " + golLiveCount);
    }
}