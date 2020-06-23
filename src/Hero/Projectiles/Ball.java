package Hero.Projectiles;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends Projectiles implements ActionListener {
    /**
     * The Constructor of the Ball
     */
    public Ball(World w, Vec2 from, Vec2 towards) {
        super(w, from, towards);
        CircleShape s = new CircleShape(0.5f);
        Fixture f = new SolidFixture(this, s);

        this.addCollisionListener(new BallCollision());

        addImage(new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Attack/Spell_Bullet/spell_bullet.png", 1f));

        Timer t = new Timer(1000, this);
        t.setInitialDelay(1000);
        t.start();
    }

    /**
     * Overridden method from the Projectile Class to assign a speed to the Ball
     */

    @Override
    public float getSpeed() {
        return 20;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
