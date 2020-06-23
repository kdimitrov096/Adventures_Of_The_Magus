package Game;

import Ghostly_Objects.*;
import Mobs.*;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/*** Level 3 of the game*/
public class GameLevels4 extends GameLevels {
    private static final int NUM_SHARDS = 5;
    private Image background;
    private GameView view;

    /*** Populate the world.*/
    @Override
    public void populate(Game game) {
        super.populate(game);
        DebugViewer debugViewer = new DebugViewer(this, 500, 500);

        view = game.getView();

        Shape platform_shape = new BoxShape(9, 3);
        Body platform = new StaticBody(this, platform_shape);
        platform.addImage(new BodyImage("data/Game_Parts/Ground/Level3/p.png", 6f));
        platform.setPosition(new Vec2(-79.31516f,-19.705336f));

        Body platform1 = new StaticBody(this, platform_shape);
        platform1.addImage(new BodyImage("data/Game_Parts/Ground/Level3/p.png", 6f));
        platform1.setPosition(new Vec2(-58, -15f));

        Body platform2 = new StaticBody(this, platform_shape);
        platform2.addImage(new BodyImage("data/Game_Parts/Ground/Level3/p.png", 6f));
        platform2.setPosition(new Vec2(-37, -10));

        Shape small_plat_shape = new BoxShape(2.95f, 3);
        Body[] small_plat = new Body[3];
        for (int i = 0; i < small_plat.length; i++){
            for (int j = 0; j < small_plat.length; j++) {
                if (i == j) {
                    small_plat[i] = new StaticBody(this, small_plat_shape);
                    small_plat[i].addImage(new BodyImage("data/Game_Parts/Ground/Level3/sp.png", 6f));
                    small_plat[i].setPosition(new Vec2(i * 10f - 36f, j * 5 - 4f));
                }
            }
        }

        Body platform3 = new StaticBody(this, platform_shape);
        platform3.addImage(new BodyImage("data/Game_Parts/Ground/Level3/p.png", 6f));
        platform3.setPosition(new Vec2(-37, 12));

        Body[] small_plat1 = new Body[4];
        for (int i = 0; i < small_plat1.length; i++){
            for (int j = 0; j < small_plat1.length; j++) {
                if (i + j == small_plat1.length){
                    small_plat1[i] = new StaticBody(this, small_plat_shape);
                    small_plat1[i].addImage(new BodyImage("data/Game_Parts/Ground/Level3/sp.png", 6f));
                    small_plat1[i].setPosition(new Vec2(i * 10f - 85f, j * 5 + 9.2f));

                }
            }
        }

        Body[] small_plat2 = new Body[3];
        for (int i = 0; i < small_plat2.length; i++){
            for (int j = 0; j < small_plat2.length; j++) {
                if (i == j) {
                    small_plat2[i] = new StaticBody(this, small_plat_shape);
                    small_plat2[i].addImage(new BodyImage("data/Game_Parts/Ground/Level3/sp.png", 6f));
                    small_plat2[i].setPosition(new Vec2(i * 10f + 45f, j * 5 - 0f));
                }
            }
        }

        Shape big_plat_shape = new BoxShape(9.5f, 9.4f);
        Body big_plat = new StaticBody(this, big_plat_shape);
        big_plat.addImage(new BodyImage("data/Game_Parts/Ground/Level3/g1.png", 18.8f));
        big_plat.setPosition(new Vec2(-100, -15.5f));

        Shape big_plat3_shape = new BoxShape(23f, 9.4f);
        Body big_plat3 = new StaticBody(this, big_plat3_shape);
        big_plat3.addImage( new BodyImage("data/Game_Parts/Ground/Level3/g2.png", 18.8f));
        big_plat3.setPosition(new Vec2(10, -5));

        Big_Rock bigRock2 = new Big_Rock(this);
        bigRock2.setPosition(new Vec2(10.5f, 7f ));

        Troll troll = new Troll(this);
        troll.setPosition(new Vec2(-65.537025f,14));
        troll.addCollisionListener(new TrollCollision(game, game.getPlayer(),this));


        Troll1 trol2 = new Troll1(this);
        trol2.setPosition(new Vec2(-37.3f, 16f));
        trol2.addCollisionListener(new Troll1Collision(game, game.getPlayer(),this));

        Troll2 trol3 = new Troll2(this);
        trol3.setPosition(new Vec2(-40.45466f,-5f));
        trol3.addCollisionListener(new Troll2Collision(game, game.getPlayer(),this));

        background = new ImageIcon("data/Game_Parts/Images/UserView/Background/background4.png").getImage();

    }

    @Override
    public int getLevelNumber() {
        return 3;
    }

    /** The Game view in Level 3 */
    @Override
    public GameView getView() { return view; }

    /** Level Background */
    @Override
    public Image getBackgroundImage() {
        return background;
    }

    /** The initial position of the golem in Level 2 */
    @Override
    public Vec2 startPosition() { return new Vec2(-100, -5); }

    /** The initial position of the golem in Level 3 */
    @Override
    public Vec2 golemPosition() { return new Vec2(-9.900723f,32f); }

    /** The initial position of the goblin in Level 3. */
    @Override
    public Vec2 goblinPosition() { return new Vec2(-100, 20); }

    /** Get the death zone position, body image, and size in Level 3. */
    @Override
    public Vec2 getDeathzonePosition() { return new Vec2(-15, -40); }
    @Override
    public BodyImage getDimage() { return  new BodyImage("data/Game_Parts/Ground/Level3/g.png", 30); }
    @Override
    public Float getDwidth() { return 125f; }
    @Override
    public Float getDheight() { return 15f; }


    /** Get the left wall position, body image, and size in Level 3. */
    @Override
    public Vec2 getLeftWallPosition() { return new Vec2(-125,19); }
    @Override
    public BodyImage getLWimage() { return  new BodyImage("data/Game_Parts/Ground/Level3/wl.png", 88f); }
    @Override
    public Float getLWwidth() { return 15f; }
    @Override
    public Float getLWheight() { return 44f; }


    /** Get the right wall position, body image, and size in Level 3. */
    @Override
    public Vec2 getRightWallPosition() { return new Vec2(94, 19); }
    @Override
    public BodyImage getRWimage() { return  new BodyImage("data/Game_Parts/Ground/Level3/wr.png", 88f); }
    @Override
    public Float getRWwidth() { return 15f; }
    @Override
    public Float getRWheight() { return 44f; }

    /**Get the Portal position in Level 3*/
    @Override
    public Vec2 nextlevelPosition() { return new Vec2(78.45f,14.4f); }

    /**Is Level 3 Completed?*/
    @Override
    public boolean isCompleted() { return true; }

}
