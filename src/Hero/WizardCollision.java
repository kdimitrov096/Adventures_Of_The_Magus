package Hero;

import Game.Game;
import Game.GameLevels;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class WizardCollision implements CollisionListener {
    private Wizard wizard;
    private Game game;

    public WizardCollision(Game game, Wizard wizard, GameLevels gameLevels) {
        this.wizard = wizard;
        this.game = game;

    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() == wizard ){
            e.getOtherBody().destroy();
            game.restart();
        }

    }
}
