package Game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import java.awt.*;

public class GameView extends UserView {
    private Game game;

    /**
     * The Constructor of the UserView
     */
    GameView(Game game, World w, int width, int height) {
        super(w, width, height);
        this.game = game;

    }

    /**
     * Overriding the Graphics2d methods to pain the background
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);
        g.drawImage(((GameLevels)this.getWorld()).getBackgroundImage(), getX(), getY(), game.getFrame());

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);

    }
}

