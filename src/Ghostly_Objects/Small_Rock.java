package Ghostly_Objects;

import city.cs.engine.*;

public class Small_Rock extends StaticBody {
    public Small_Rock(World w) {
        super(w);

        Shape rock_shape = new PolygonShape(-1.501f,-0.887f, -1.784f,-0.376f, -1.037f,1.226f, 0.079f,1.234f, 1.383f,0.441f, 1.933f,-0.62f, 0.684f,-1.021f);
        GhostlyFixture rock_fixture = new GhostlyFixture(this, rock_shape);
        addImage(new BodyImage("data/Game_Parts/Ground/Level2/rock.png", 2.5f));

    }
}
