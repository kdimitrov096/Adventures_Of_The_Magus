package Game;

import Hero.Wizard;
import Hero.WizardCollision;
import Mobs.*;
import Collectables.Shards;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public abstract class GameLevels extends World {
    private GameView view;
    private Wizard player;
    private Golem golem;
    private Goblin goblin;
    private Portal portal;

    private Body[] shards;
    private Body ground1;
    private Body ground2;
    private Body ground3;
    private Body ground4;
    private Body ground5;
    private Body ground6;
    private Body ground7;
    private Body ground8;
    private Body platform;
    private Body platformBridge1;

    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {

        player = new Wizard(game, this);
        System.out.println(player);
        player.setPosition(startPosition());

        golem = new Golem(this);
        golem.setPosition(golemPosition());
        golem.addCollisionListener(new GolemsCollision(game, player, this));


        goblin = new Goblin(this);
        goblin.setPosition(goblinPosition());
        goblin.addCollisionListener(new GoblinCollision(game, player,this));

        shards = new Shards[10];
        for (int i = 0; i < shards.length; i++) {
            shards[i] = new Shards(this);
            shards[i].setPosition(new Vec2(i * 15 - 91f, 25));
            shards[i].addCollisionListener(new Pickup(getPlayer()));
        }

        Shape dzone = new BoxShape(getDwidth(), getDheight());
        Body deathZone = new StaticBody(this, dzone);
        deathZone.addImage(getDimage());
        deathZone.setPosition(getDeathzonePosition());
//        deathZone.addCollisionListener(new WizardCollision(game, player, this));

        Shape leftWallShape = new BoxShape(getLWwidth(), getLWheight());
        Body leftWallBody = new StaticBody(this, leftWallShape);
        leftWallBody.addImage(getLWimage());
        leftWallBody.setPosition(getLeftWallPosition());

        Shape rightWallShape = new BoxShape(getRWwidth(), getRWheight());
        Body rightWallBody = new StaticBody(this, rightWallShape);
        rightWallBody.addImage(getRWimage());
        rightWallBody.setPosition(getRightWallPosition());

        portal = new Portal(this);
        portal.setPosition(nextlevelPosition());
        portal.addCollisionListener(new PortalListener(game));
        getView();


    }

    /**Dispose method for all bodies inside the world*/
    void dispose(Game game) {
        for (DynamicBody body : getDynamicBodies()){
            body.destroy();
            body.removeAllCollisionListeners();
        }
        for (StaticBody body : getStaticBodies()){
            body.destroy();
            body.removeAllCollisionListeners();
        }
    }

    /**Getter for the Player*/
    public void setPlayer(Wizard p){ player = p;}

    /**Getter for the Wizard*/
    public Wizard getPlayer() {return player;}

    /**Getter for the Golem*/
    Golem getGolem() { return  golem; }

    /**Getter for the Portal*/
    public Portal getPortal() { return  portal; }

    /**Getter for the Shards*/
    public Body[] getShards() { return  shards; }

    /**The Game Level Integer*/
    public abstract int getLevelNumber();

    /** The Game view in the levels */
    public abstract GameView getView();

    /** Level Background */
    public abstract Image getBackgroundImage();

    /** The initial position of the player. */
    public abstract Vec2 startPosition();

    /** The initial position of the golem. */
    public abstract Vec2 golemPosition();

    /** The initial position of the goblin. */
    public abstract Vec2 goblinPosition();

    /** Get the left wall position, body image, and size in the levels. */
    public abstract Vec2 getLeftWallPosition();
    public abstract BodyImage getLWimage();
    public abstract Float getLWwidth();
    public abstract Float getLWheight();

    /** Get the death zone position, body image and size in the levels. */
    public abstract Vec2 getDeathzonePosition();
    public abstract BodyImage getDimage();
    public abstract Float getDwidth();
    public abstract Float getDheight();

    /** Get the right wall position, body image and size in the levels. */
    public abstract Vec2 getRightWallPosition();
    public abstract BodyImage getRWimage();
    public abstract Float getRWwidth();
    public abstract Float getRWheight();

    /** The position of the portal in the Levels. */
    public abstract Vec2 nextlevelPosition();

    /** Is this level complete? */
    public abstract boolean isCompleted();
}
