package Hero.Spells;

import Game.GameView;
import Hero.Wizard;
import org.jbox2d.common.Vec2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

public class SpellController implements MouseListener, MouseMotionListener {

    private Wizard player;
    private GameView view;

    public SpellController(GameView view, Wizard player){
        this.player = player;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        player.getActiveSpell().fire();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(), e.getY()));
        Vec2 direction = p.sub(player.getPosition());
        direction.normalize();
        player.getActiveSpell().setShootingDirection(direction);
        player.getActiveSpell().startShooting();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        player.getActiveSpell().stopShooting();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(), e.getY()));
        Vec2 direction = p.sub(player.getPosition());
        direction.normalize();
        player.getActiveSpell().setShootingDirection(direction);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(), e.getY()));
        Vec2 direction = p.sub(player.getPosition());
        direction.normalize();
        player.getActiveSpell().setShootingDirection(direction);
    }
}
