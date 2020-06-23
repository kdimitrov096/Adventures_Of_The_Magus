package Hero.Spells;

import Hero.Projectiles.Ball;
import city.cs.engine.Body;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arcane extends Spells implements ActionListener {

    private Timer t;


    public Arcane(Body o) {
        super(o);
        t = new Timer(50, this);

    }

    @Override
    public void fire() {

        Ball b = new Ball(getOwner().getWorld(), getOwner().getPosition(), getShootingDirection());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fire();
    }

    @Override
    public void startShooting(){
        t.start();
    }

    @Override
    public void stopShooting(){
        t.stop();
    }
}
