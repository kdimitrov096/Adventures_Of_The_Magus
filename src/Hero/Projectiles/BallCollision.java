package Hero.Projectiles;

import Collectables.Shards;
import Mobs.*;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BallCollision implements CollisionListener {
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getReportingBody() instanceof Shards){
            collisionEvent.getReportingBody().destroy();
            collisionEvent.getOtherBody().destroy();
        }
        else if (collisionEvent.getReportingBody() instanceof Golem){
            ((Golem) collisionEvent.getReportingBody()).decrementGolliveCount();

            if (((Golem) collisionEvent.getReportingBody()).getGolLiveCount() <= 1){
                collisionEvent.getReportingBody().destroy();
            }
        }
        else if (collisionEvent.getReportingBody() instanceof Goblin){
            System.out.println(((Goblin) collisionEvent.getReportingBody()).getGobLiveCount());
            ((Goblin) collisionEvent.getReportingBody()).decrementGobliveCount();

            if (((Goblin) collisionEvent.getReportingBody()).getGobLiveCount() <= 1){
                collisionEvent.getReportingBody().destroy();
            }

        }
        else if (collisionEvent.getReportingBody() instanceof  Troll){
            ((Troll) collisionEvent.getReportingBody()).decrementTroliveCount();

            if (((Troll) collisionEvent.getReportingBody()).getTrollLiveCount() <= 1){
                collisionEvent.getReportingBody().destroy();
            }
        }
        else if (collisionEvent.getReportingBody() instanceof Troll1){
            ((Troll1) collisionEvent.getReportingBody()).decrementTro1liveCount();

            if (((Troll1) collisionEvent.getReportingBody()).getTroll1LiveCount() <= 1){
                collisionEvent.getReportingBody().destroy();
            }
        }
        else if (collisionEvent.getReportingBody() instanceof Troll2){
            ((Troll2) collisionEvent.getReportingBody()).decrementTro2liveCount();

            if (((Troll2) collisionEvent.getReportingBody()).getTroll2LiveCountt() <= 1){
                collisionEvent.getReportingBody().destroy();
            }

        }
        else collisionEvent.getReportingBody().destroy();
    }
}
