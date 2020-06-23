package Hero;

import Game.Game;
import Game.GameLevels;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter{
    private static  float JUMPING_SPEED = 30;
    private static  float WALKING_SPEED = 10;

    private Wizard wizard;

    public Controller(Wizard wizard, GameLevels gameLevels, Game game){
        this.wizard = wizard;
    }

    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("Hero.Wizard current position: " +  wizard.getPosition());
        switch (e.getKeyCode()) {

            case KeyEvent.VK_Q:
                System.exit(0);
                break;
            case KeyEvent.VK_SPACE:
                Vec2 v = wizard.getLinearVelocity();
                if(Math.abs(v.y) < 0.1f) { wizard.jump(JUMPING_SPEED); }
                if(wizard.getCurrentDirection().equals("RIGHT")){
                    wizard.removeAllImages();
                    wizard.addImage(Wizard.getImage("jump_right"));
                }
                if(wizard.getCurrentDirection().equals("LEFT")){
                    wizard.removeAllImages();
                    wizard.addImage(Wizard.getImage("jump_left"));
                }
                break;
            case KeyEvent.VK_A:
                wizard.startWalking(-WALKING_SPEED); // A = walk left
                wizard.removeAllImages();
                wizard.addImage(Wizard.getImage("run_left"));
                wizard.setCurrentDirection("LEFT");
                break;
            case KeyEvent.VK_D:
                wizard.startWalking(WALKING_SPEED); // D = walk right
                wizard.removeAllImages();
                wizard.addImage(Wizard.getImage("run_right"));
                wizard.setCurrentDirection("RIGHT");
                break;
            case KeyEvent.VK_SHIFT:
                WALKING_SPEED = 14;
                JUMPING_SPEED = 40;
                break;
            case KeyEvent.VK_1:
                wizard.setActiveSpells(0);
                break;
            case KeyEvent.VK_2:
                wizard.setActiveSpells(1);
                break;
            case KeyEvent.VK_3:
                wizard.setActiveSpells(2);
                break;
        }
    }

    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Hero.Wizard current position: " + wizard.getPosition());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                wizard.stopWalking();
                wizard.removeAllImages();
                wizard.addImage(Wizard.getImage("idle_left"));
                break;
            case KeyEvent.VK_D:
                wizard.stopWalking();
                wizard.removeAllImages();
                wizard.addImage(Wizard.getImage("idle_right"));
                break;
            case KeyEvent.VK_SPACE:
                wizard.stopWalking();
                if(wizard.getCurrentDirection().equals("RIGHT")){
                    wizard.removeAllImages();
                    wizard.addImage(Wizard.getImage("idle_right"));
                }
                if(wizard.getCurrentDirection().equals("LEFT")){
                    wizard.removeAllImages();
                    wizard.addImage(Wizard.getImage("idle_left"));
                }
                break;
            case KeyEvent.VK_SHIFT:
                WALKING_SPEED = 10;
                JUMPING_SPEED = 30;
                break;
            case KeyEvent.VK_1:

                if (wizard.getCurrentDirection().equals("RIGHT")){
                    wizard.removeAllImages();
                    wizard.addImage(Wizard.getImage("idle_right"));

                }
                else if (wizard.getCurrentDirection().equals("LEFT")){
                    wizard.removeAllImages();
                    wizard.addImage(Wizard.getImage("idle_left"));
                }
            default:
        }
    }

    public void setWorld(GameLevels level) {
    }

    public void setBody(Wizard wizard, GameLevels gameLevels) { this.wizard = wizard;
    }

}

