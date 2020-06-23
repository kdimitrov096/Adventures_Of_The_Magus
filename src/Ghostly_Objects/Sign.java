package Ghostly_Objects;

import city.cs.engine.*;

public class Sign extends StaticBody {
    public Sign(World w) {
        super(w);

        Shape signShape = new PolygonShape(-0.546f,0.009f, -0.609f,0.552f, 0.591f,0.573f, 0.564f,0.012f);
        GhostlyFixture signFixture = new GhostlyFixture(this, signShape);

        Shape signTim = new PolygonShape(-0.069f,0.018f, 0.069f,0.018f, 0.075f,-0.63f, -0.045f,-0.624f);
        GhostlyFixture signTimFixture = new GhostlyFixture(this, signTim);

        addImage(new BodyImage("data/Game_Parts/Ground/Level1/sign.png", 1.5f));
    }
}
