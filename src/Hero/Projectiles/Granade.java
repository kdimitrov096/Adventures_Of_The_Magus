package Hero.Projectiles;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Granade extends Projectiles implements ActionListener {
    private Fixture smallCircle;

    /**
     * The Constructor for the Granade
     */


    public Granade(World w, Vec2 from, Vec2 towards) {
        super(w, from, towards);
        CircleShape s = new CircleShape(0.5f);
        smallCircle = new SolidFixture(this, s);

        addImage(new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Attack/Spell_Bullet/spell_bullet.png", 1f));

        Timer t = new Timer(100, this);
        t.setInitialDelay(3000);
        t.start();
    }
    /**
     * Overridden method from the Projectile Class to assign a speed to the Ball
     */


    @Override
    public float getSpeed() {
        return 5;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (smallCircle != null) {
            smallCircle.destroy();
            smallCircle = null;
            CircleShape s = new CircleShape(2f);
            GhostlyFixture f = new GhostlyFixture(this, s);

            addImage(new BodyImage("data/Game_Parts/Images/Hero/Wizard_Final/Attack/Spell_Bullet/spell_bullet.png", 4f));
            Sensor sensor = new Sensor(this, s);
            sensor.addSensorListener(new GranadeCollision());
        } else {
            this.destroy();
        }
    }
}
