package Mobs;

import Collectables.Mushrooms;
import GUI.ControlPanel;
import Game.Game;
import Game.GameLevels;
import Hero.Wizard;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class TrollCollision implements CollisionListener {

    private Game game;
    private Wizard wizard;
    private GameLevels gameLevels;
    private ControlPanel controlPanel;

    public TrollCollision(Game game, Wizard wiz, GameLevels gameLevels){
        this.game = game;
        this.wizard = wiz;
        this.gameLevels = gameLevels;
        this.controlPanel = game.getControlPanel();
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof  Wizard){

            wizard.decrementLiveCount();

            if(wizard.getLiveCount() <= 0){
                game.restart();
                collisionEvent.getOtherBody().destroy();

                Mushrooms mush = new Mushrooms(gameLevels);
                mush.setPosition(collisionEvent.getOtherBody().getPosition());
            }
        }
    }
}
