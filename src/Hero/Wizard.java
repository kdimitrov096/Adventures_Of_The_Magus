package Hero;

import GUI.ControlPanel;
import Game.Game;
import Hero.Spells.Arcane;
import Hero.Spells.Bomb;
import Hero.Spells.Arca;
import Hero.Spells.Spells;
import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;
import java.util.HashMap;

public class Wizard extends Walker implements StepListener{
    /*** H A S H M A P*/
    private static final HashMap<String, BodyImage> sprite_images = new HashMap<>();

    /*** B O D Y  S H A P E*/
    private static final Shape wizardShape = new PolygonShape(
            -0.479f, -0.882f, -0.698f, -0.32f, -0.695f, 0.886f, 0.716f, 0.889f, 0.709f, -0.328f, 0.482f, -0.878f);

    private Game game;
    private String currentDirection = " ";
    private Spells[] spells;
    private int activeSpell;
    private int health;
    private int shardcount;
    private int enemiesSlain;

    /*** C O N S T R U C T O R*/
    public Wizard(Game game, World world) {
        super(world, wizardShape);
        this.game = game;
        ControlPanel controlPanel = game.getControlPanel();

        spells = new Spells[3];
        spells[0] = new Arcane(this);
        spells[1] = new Bomb(this);
        spells[2] = new Arca(this);

        health = 10;
        shardcount = 0;
        enemiesSlain = 0;

        /**SPRITE IMAGES*/
        sprite_images.put("idle_right", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Idle/Right_Idle/IdleRight.gif", 1.80f));
        sprite_images.put("idle_left", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Idle/Left_Idle/idleLeft.gif", 1.80f));
        sprite_images.put("jump_right", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Jump/Jump_Right/1.png", 1.80f));
        sprite_images.put("jump_left", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Jump/Jump_Left/1.png", 1.80f));
        sprite_images.put("run_right", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Run/Run_Right/Run_Right.gif", 1.80f));
        sprite_images.put("run_left", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Run/Run_Left/Run_Left.gif", 1.80f));
        sprite_images.put("attack_right", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Attack/Attack/Spell_Right.gif", 2.2f));
        sprite_images.put("attack_left", new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Attack/Attack/Spell_Left.gif", 2.2f));

        addImage(Wizard.sprite_images.get("idle_right"));

        setGravityScale(9.8f);

    }

    public void preStep(StepEvent e){

    }
    public void postStep(StepEvent e) {

    }

    public Spells getActiveSpell() {
        return spells[activeSpell];
    }


    void setActiveSpells(int i) {
        activeSpell = i;
    }


    static BodyImage getImage(String direction) {
        return Wizard.sprite_images.getOrDefault(direction, null);
    }

    String getCurrentDirection() {
        return currentDirection;
    }

    void setCurrentDirection(String currentDirection) {
        this.currentDirection = currentDirection;
    }

    public int getShardcount() {
        return shardcount;
    }

    public int getLiveCount() {
        return health;
    }

    public int getEnemiesSlain() {
        return enemiesSlain;
    }

    public void setShardcount(int shardcount) {
        this.shardcount = shardcount;
    }

    public void incrementEnemyKills(){
        enemiesSlain++;
        System.out.println("Enemies slain: " + enemiesSlain);
    }

    public void decrementShardsCount() {
        shardcount--;
        game.getControlPanel().getShardsBar().setValue(shardcount);
        System.out.println("Remaining shards: " + shardcount);
    }

    public void decrementLiveCount() {
        health--;

        game.getControlPanel().getHealthBar().setValue(health);
        if(health< 3){
            game.getControlPanel().getHealthBar().setForeground(Color.RED);
        }
        if(health < 6){
            game.getControlPanel().getHealthBar().setForeground(Color.ORANGE);
        } else {
            game.getControlPanel().getHealthBar().setForeground(Color.GREEN);
        }

        System.out.println("Wizard Remaining lives: " + health);
    }

    public void addOne() {
        shardcount++;
        game.getControlPanel().getShardsBar().setValue(shardcount);
    }

    public void addLives(){
        health++;
        game.getControlPanel().getHealthBar().setValue(health);
    }
}
