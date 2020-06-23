package Game;

import Ghostly_Objects.Big_Rock;
import Ghostly_Objects.Low_Grass;
import Ghostly_Objects.Sign;
import Ghostly_Objects.Tree2;
import Sounds.Sounds;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*** Level 1 of the game*/
public class GameLevels1 extends GameLevels  implements ActionListener {

    private static final int NUM_SHARDS = 1;
    private Image background;
    private GameView view;


    public GameLevels1() {
    }

    /*** Populate the world.*/
    @Override
    public void populate(Game game ) {
        super.populate(game);

        Sign sign = new Sign(this);
        sign.setPosition(new Vec2(-103, 19.5f));

        Body ground1 = new Platforms(this, 10, 22);
        ground1.addImage(new BodyImage("data/Game_Parts/Ground/Level1/ground1.png", 44));
        ground1.setPosition(new Vec2(-100.5f, -3));

        Low_Grass grass0 = new Low_Grass(this);
        grass0.setPosition(new Vec2(-106, 19.5f));

        Tree2 tree = new Tree2(this);
        tree.setPosition(new Vec2(-97, 23.7f));

        Body ground2 = new Platforms(this, 7, 20);
        ground2.addImage(new BodyImage("data/Game_Parts/Ground/Level1/ground2.png", 40));
        ground2.setPosition(new Vec2(-80, -5));

        Low_Grass grass = new Low_Grass(this);
        grass.setPosition(new Vec2(-80, 15.5f));

        Body ground3 = new Platforms(this, 9, 23);
        ground3.addImage(new BodyImage("data/Game_Parts/Ground/Level1/ground3.png", 46));
        ground3.setPosition(new Vec2(-61, -2));

        Tree2 tree2 = new Tree2(this);
        tree2.setPosition(new Vec2(-60, 25.7f));

        Body ground4 = new Platforms(this, 5, 25);
        ground4.addImage( new BodyImage("data/Game_Parts/Ground/Level1/ground4.png", 50));
        ground4.setPosition(new Vec2(-44, 0));

        Low_Grass grass1 = new Low_Grass(this);
        grass1.setPosition(new Vec2(-44.16f, 25.5f));

        Body ground5 = new Platforms(this, 15, 27);
        ground5.addImage(new BodyImage("data/Game_Parts/Ground/Level1/ground5.png", 54));
        ground5.setPosition(new Vec2(-21f, 2));

        Tree2 tree3 = new Tree2(this);
        tree3.setPosition(new Vec2(-30, 33.7f));

        Tree2 tree4 = new Tree2(this);
        tree4.setPosition(new Vec2(-9, 33.7f));

        Big_Rock rock = new Big_Rock(this);
        rock.setPosition(new Vec2(-20, 31.8f));

        Body ground6 = new Platforms(this, 9, 21);
        ground6.addImage( new BodyImage("data/Game_Parts/Ground/Level1/ground6.png", 42));
        ground6.setPosition(new Vec2(6, -4));

        Low_Grass grass2 = new Low_Grass(this);
        grass2.setPosition(new Vec2(7.3f, 17.5f));

        Body ground7 = new Platforms(this, 6, 23);
        ground7.addImage(new BodyImage("data/Game_Parts/Ground/Level1/ground7.png", 46));
        ground7.setPosition(new Vec2(24f, -2));

        Tree2 tree5 = new Tree2(this);
        tree5.setPosition(new Vec2(24.72f, 25.7f));

        Body platform = new Platforms(this, 9, 3);
        platform.addImage(new BodyImage("data/Game_Parts/Ground/Level1/platform1.png", 6f));
        platform.setPosition(new Vec2(48, 4));

        Big_Rock rock2 = new Big_Rock(this);
        rock2.setPosition(new Vec2(48.35f, 9f));


        Body ground8 = new Platforms(this, 5, 19);
        ground8.addImage(new BodyImage("data/Game_Parts/Ground/Level1/ground8.png", 38));
        ground8.setPosition(new Vec2(70.1f, -6));

        background = new ImageIcon("data/Game_Parts/Images/UserView/Background/background1.png").getImage();

//        Sounds.getBackground().loop();

//        Timer t = new Timer(2000,this );
//        t.start();


    }


    @Override
    public int getLevelNumber() {
        return 1;
    }

    @Override
    public void stop() {
        super.stop();
        Sounds.getBackground().stop();
    }

    /** The Game view in Level 1 */
    @Override
    public GameView getView() { return view; }

    /** Level Background */
    @Override
    public Image getBackgroundImage() {
        return background;
    }

    /** The initial position of the player in Level 1 */
    @Override
    public Vec2 startPosition() { return new Vec2(-107.11819f,19.897005f); }

    /** The initial position of the golem in Level 1 */
    @Override
    public Vec2 golemPosition() { return new Vec2(50.145527f,7.899549f); }

    /** The initial position of the goblin in Level 1 */
    @Override
    public Vec2 goblinPosition() { return new Vec2(-25, 29); }


    /** Get the death zone position, body image, and size in Level 1. */
    @Override
    public Vec2 getDeathzonePosition() { return new Vec2(-15, -40); }
    @Override
    public BodyImage getDimage() { return  new BodyImage("data/Game_Parts/Ground/Level1/ground.png", 30); }
    @Override
    public Float getDwidth() { return 125f; }
    @Override
    public Float getDheight() { return 15f; }


    /** Get the left wall position, body image, and size in Level 1. */
    @Override
    public Vec2 getLeftWallPosition() { return new Vec2(-125,19); }
    @Override
    public BodyImage getLWimage() { return  new BodyImage("data/Game_Parts/Ground/Level1/leftWall.png", 88f); }
    @Override
    public Float getLWwidth() { return 15f; }
    @Override
    public Float getLWheight() { return 44f; }


    /** Get the right wall position, body image, and size in Level 1. */
    @Override
    public Vec2 getRightWallPosition() { return new Vec2(94, 19); }
    @Override
    public BodyImage getRWimage() { return  new BodyImage("data/Game_Parts/Ground/Level1/rightWall.png", 88f); }
    @Override
    public Float getRWwidth() { return 15f; }
    @Override
    public Float getRWheight() { return 44f; }

    /**Get the Portal position in Level 1*/
    @Override
    public Vec2 nextlevelPosition() { return new Vec2(72f,14.4f); }

    /**Is Level 1 Completed?*/
    @Override
    public boolean isCompleted() { return true; }


    @Override
    public void actionPerformed(ActionEvent e) { }
}
