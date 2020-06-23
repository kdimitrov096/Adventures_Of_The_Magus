package Game;

import Ghostly_Objects.*;
import Mobs.Troll;
import Mobs.TrollCollision;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/*** Level 2 of the game*/
public class GameLevels2 extends GameLevels {
    private Image background;
    private GameView view;


    /*** Populate the world.*/
    @Override
    public void populate(Game game) {
        super.populate(game);

        view = game.getView();


        Shape platform_shape = new BoxShape(9, 3);
        Body platform = new StaticBody(this, platform_shape);
        platform.addImage(new BodyImage("data/Game_Parts/Ground/Level2/p.png", 6f));
        platform.setPosition(new Vec2(-80, -9.2f));

        Body platform1 = new StaticBody(this, platform_shape);
        platform1.addImage(new BodyImage("data/Game_Parts/Ground/Level2/p.png", 6f));
        platform1.setPosition(new Vec2(-80, 30f));

        Shape big_plat_shape = new BoxShape(9.5f, 9.4f);
        Body big_plat = new StaticBody(this, big_plat_shape);
        big_plat.addImage(new BodyImage("data/Game_Parts/Ground/Level2/g1.png", 18.8f));
        big_plat.setPosition(new Vec2(-100, -15.5f));

        Shape small_plat_shape = new BoxShape(2.95f, 3);
        Body[] small_plat = new Body[3];
        for (int i = 0; i < small_plat.length; i++){
            for (int j = 0; j < small_plat.length; j++) {
                if (i == j) {
                    small_plat[i] = new StaticBody(this, small_plat_shape);
                    small_plat[i].addImage(new BodyImage("data/Game_Parts/Ground/Level2/sp.png", 6f));
                    small_plat[i].setPosition(new Vec2(i * 10f - 65f, j * 5 - 9.2f));
                }
            }
        }


        Body[] small_plat1 = new Body[4];
        for (int i = 0; i < small_plat1.length; i++){
            for (int j = 0; j < small_plat1.length; j++) {
                if (i + j == small_plat1.length){
                    small_plat1[i] = new StaticBody(this, small_plat_shape);
                    small_plat1[i].addImage(new BodyImage("data/Game_Parts/Ground/Level2/sp.png", 6f));
                    small_plat1[i].setPosition(new Vec2(i * 10f - 75f, j * 5 + 9.2f));

                }
            }
        }

        Body[] small_plat2 = new Body[3];
        for (int i = 0; i < small_plat2.length; i++){
            for (int j = 0; j < small_plat2.length; j++) {
                if (i == j) {
                    small_plat2[i] = new StaticBody(this, small_plat_shape);
                    small_plat2[i].addImage(new BodyImage("data/Game_Parts/Ground/Level2/sp.png", 6f));
                    small_plat2[i].setPosition(new Vec2(i * 10f + 45f, j * 5 - 0f));
                }
            }
        }



        Low_Grass[] lgrass_plat1 = new Low_Grass[4];
        for (int i = 0; i < lgrass_plat1.length; i++){
            for (int j = 0; j < lgrass_plat1.length; j++){
                if (i + j == lgrass_plat1.length){
                    lgrass_plat1[i] = new Low_Grass(this);
                    lgrass_plat1[i].setPosition(new Vec2(i* 10f - 75f, j * 5 + 12.6f));
                }
            }
        }


        Low_Grass[] lgrass_plat = new Low_Grass[3];
        for (int i = 0; i < lgrass_plat.length; i++){
            for (int j = 0; j < lgrass_plat.length; j++){
                if (i == j){
                    lgrass_plat[i] = new Low_Grass(this);
                    lgrass_plat[i].setPosition(new Vec2(i* 10f - 65f, j * 5 - 5.75f));
                }
            }
        }

        Fence[] fence = new Fence[3];
        for (int i = 0; i < fence.length; i++){
            for (int j = 0; j < fence.length; j++){
                if (i == j){
                    fence[i] = new Fence(this);
                    fence[i].setPosition(new Vec2(i* 10f - 65f, j * 5 - 4.75f));
                }
            }
        }

        Low_Grass[] lgrass_start = new Low_Grass[3];
        for (int i = 0; i < lgrass_start.length ; i++) {
            lgrass_start[i] = new Low_Grass(this);
            lgrass_start[i].setPosition(new Vec2(i * 6- 106f, -5.66f));
        }

        Body big_plat2 = new StaticBody(this, platform_shape);
        big_plat2.addImage(new BodyImage("data/Game_Parts/Ground/Level2/p.png", 6f));
        big_plat2.setPosition(new Vec2(-30, 8));

        Low_Grass[] low_grasses_g2 = new Low_Grass[7];
        for (int i = 0; i < low_grasses_g2.length ; i++) {
            low_grasses_g2[i] = new Low_Grass(this);
            low_grasses_g2[i].setPosition(new Vec2(i * 6 - 10, 4.8f));
        }

        Tree[] tree_g2 = new Tree[2];
        for (int i = 0; i < tree_g2.length; i++){
            tree_g2[i] = new Tree(this);
            tree_g2[i].setPosition(new Vec2(i* 40 - 10, 9f));
        }

        Shape big_plat3_shape = new BoxShape(23f, 9.4f);
        Body big_plat3 = new StaticBody(this, big_plat3_shape);
        big_plat3.addImage( new BodyImage("data/Game_Parts/Ground/Level2/g2.png", 18.8f));
        big_plat3.setPosition(new Vec2(10, -5));

        Big_Rock bigRock2 = new Big_Rock(this);
        bigRock2.setPosition(new Vec2(10.5f, 7f ));

        Tree tree = new Tree(this);
        tree.setPosition(new Vec2(-78, -1.5f ));

        Big_Rock bigRock = new Big_Rock(this);
        bigRock.setPosition(new Vec2(-100, -3.5f));

        Low_Grass[] lgrass_ground = new Low_Grass[28];
        for (int i = 0; i < lgrass_ground.length; i++){
            lgrass_ground[i] = new Low_Grass(this);
            lgrass_ground[i].setPosition(new Vec2(i * 6 - 88, -24.5f));
        }

        Small_Rock[] small_rock = new Small_Rock[9];
        for (int i = 0; i < small_rock.length; i++){
            small_rock[i] = new Small_Rock(this);
            small_rock[i].setPosition(new Vec2(i * 17 - 70, -24.3f));
        }

        Tree[] gTree = new Tree[10];
        for (int i = 0; i < gTree.length; i++){
            gTree[i] = new Tree(this);
            gTree[i].setPosition(new Vec2(i * 17 - 80, -20.5f));

        }

        Troll troll = new Troll(this);
        troll.setPosition(new Vec2(-82.86576f,34f));
        troll.addCollisionListener(new TrollCollision(game, game.getPlayer(),this));

//        DebugViewer debugViewer = new DebugViewer(this, 500, 500);
        background = new ImageIcon("data/Game_Parts/Images/UserView/Background/background2.png").getImage();


    }

    @Override
    public int getLevelNumber() {
        return 2;
    }

    /** The Game view in Level 2 */
    @Override
    public GameView getView() { return view; }

    /** Level Background */
    @Override
    public Image getBackgroundImage() {
        return background;
    }

    /** The initial position of the player in Level 2 */
    @Override
    public Vec2 startPosition() { return new Vec2(-100, -5); }

    /** The initial position of the golem in Level 2. */
    @Override
    public Vec2 golemPosition() { return new Vec2(12,6); }

    /** The initial position of the goblin in Level 2. */
    @Override
    public Vec2 goblinPosition() { return new Vec2(-73.25f, -3f); }

    /** Get the death zone position, body image, and size in Level 2. */
    @Override
    public Vec2 getDeathzonePosition() { return new Vec2(-15, -40); }
    @Override
    public BodyImage getDimage() { return  new BodyImage("data/Game_Parts/Ground/Level2/g.png", 30); }
    @Override
    public Float getDwidth() { return 125f; }
    @Override
    public Float getDheight() { return 15f; }

    /** Get the left wall position, body image, and size in Level 2. */
    @Override
    public Vec2 getLeftWallPosition() { return new Vec2(-125,19); }
    @Override
    public BodyImage getLWimage() { return  new BodyImage("data/Game_Parts/Ground/Level2/wl.png", 88f); }
    @Override
    public Float getLWwidth() { return 15f; }
    @Override
    public Float getLWheight() { return 44f; }

    /** Get the right wall position, body image, and size in Level 2. */
    @Override
    public Vec2 getRightWallPosition() { return new Vec2(94, 19); }
    @Override
    public BodyImage getRWimage() { return  new BodyImage("data/Game_Parts/Ground/Level2/wr.png", 88f); }
    @Override
    public Float getRWwidth() { return 15f; }
    @Override
    public Float getRWheight() { return 44f; }

    /** Get the Portal position in Level 2*/
    @Override
    public Vec2 nextlevelPosition() { return new Vec2(78.45f,14.4f); }

    /** Is Level 2 Completed?*/
    @Override
    public boolean isCompleted() { return true; }
}
