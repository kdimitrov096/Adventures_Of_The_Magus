package Ghostly_Objects;

import city.cs.engine.*;

public class Big_Rock extends StaticBody {
    public Big_Rock(World w) {
        super(w);

        Shape rock_shape = new PolygonShape(-5.94f,-3.55f, -7.1f,-1.1f, -4.02f,4.81f, 0.47f,4.91f, 5.63f,1.64f, 7.57f,-2.79f, 3.9f,-4.08f);
        GhostlyFixture rock_fixture = new GhostlyFixture(this, rock_shape);
        addImage(new BodyImage("data/Game_Parts/Ground/Level2/rock.png", 10f));

    }
}
