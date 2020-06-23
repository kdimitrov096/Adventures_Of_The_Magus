package Hero.Projectiles;

import Collectables.Mushrooms;
import Game.GameLevels;
import Mobs.*;
import Collectables.Shards;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class GranadeCollision implements SensorListener {
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof Shards){
            sensorEvent.getContactBody().destroy();
        }
        else if ((sensorEvent.getContactBody() instanceof Golem)){
            ((Golem) sensorEvent.getContactBody()).decrementGolliveCount();
            ((Golem) sensorEvent.getContactBody()).decrementGolliveCount();
            ((Golem) sensorEvent.getContactBody()).decrementGolliveCount();
            ((Golem) sensorEvent.getContactBody()).decrementGolliveCount();
            ((Golem) sensorEvent.getContactBody()).decrementGolliveCount();
            if (((Golem) sensorEvent.getContactBody()).getGolLiveCount() <= 1){

                Mushrooms mush = new Mushrooms((GameLevels) sensorEvent.getContactBody().getWorld());
                mush.setPosition(sensorEvent.getContactBody().getPosition());
                sensorEvent.getContactBody().destroy();
            }
        }
        else if ((sensorEvent.getContactBody() instanceof Goblin)){
            ((Goblin) sensorEvent.getContactBody()).decrementGobliveCount();
            ((Goblin) sensorEvent.getContactBody()).decrementGobliveCount();
            ((Goblin) sensorEvent.getContactBody()).decrementGobliveCount();
            ((Goblin) sensorEvent.getContactBody()).decrementGobliveCount();
            ((Goblin) sensorEvent.getContactBody()).decrementGobliveCount();

            if ((((Goblin) sensorEvent.getContactBody()).getGobLiveCount()) <= 1){
                Mushrooms mush = new Mushrooms((GameLevels) sensorEvent.getContactBody().getWorld());
                mush.setPosition(sensorEvent.getContactBody().getPosition());
                sensorEvent.getContactBody().destroy();
            }
        }
        else if ((sensorEvent.getContactBody() instanceof Troll)){
            ((Troll) sensorEvent.getContactBody()).decrementTroliveCount();
            ((Troll) sensorEvent.getContactBody()).decrementTroliveCount();
            ((Troll) sensorEvent.getContactBody()).decrementTroliveCount();
            ((Troll) sensorEvent.getContactBody()).decrementTroliveCount();
            ((Troll) sensorEvent.getContactBody()).decrementTroliveCount();

            if (((Troll) sensorEvent.getContactBody()).getTrollLiveCount() <= 1){
                Mushrooms mush = new Mushrooms((GameLevels) sensorEvent.getContactBody().getWorld());
                mush.setPosition(sensorEvent.getContactBody().getPosition());
                sensorEvent.getContactBody().destroy();
            }
        }
        else if ((sensorEvent.getContactBody() instanceof Troll1)){
            ((Troll1) sensorEvent.getContactBody()).decrementTro1liveCount();
            ((Troll1) sensorEvent.getContactBody()).decrementTro1liveCount();
            ((Troll1) sensorEvent.getContactBody()).decrementTro1liveCount();
            ((Troll1) sensorEvent.getContactBody()).decrementTro1liveCount();
            ((Troll1) sensorEvent.getContactBody()).decrementTro1liveCount();

            if (((Troll1) sensorEvent.getContactBody()).getTroll1LiveCount() <= 1){
                Mushrooms mush = new Mushrooms((GameLevels) sensorEvent.getContactBody().getWorld());
                mush.setPosition(sensorEvent.getContactBody().getPosition());
                sensorEvent.getContactBody().destroy();
            }
        }
        else if ((sensorEvent.getContactBody() instanceof Troll2)){
            ((Troll2) sensorEvent.getContactBody()).decrementTro2liveCount();
            ((Troll2) sensorEvent.getContactBody()).decrementTro2liveCount();
            ((Troll2) sensorEvent.getContactBody()).decrementTro2liveCount();
            ((Troll2) sensorEvent.getContactBody()).decrementTro2liveCount();
            ((Troll2) sensorEvent.getContactBody()).decrementTro2liveCount();

            if (((Troll2) sensorEvent.getContactBody()).getTroll2LiveCountt() <= 1){
                Mushrooms mush = new Mushrooms((GameLevels) sensorEvent.getContactBody().getWorld());
                mush.setPosition(sensorEvent.getContactBody().getPosition());
                sensorEvent.getContactBody().destroy();
            }
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
