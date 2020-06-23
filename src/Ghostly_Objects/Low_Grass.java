package Ghostly_Objects;

import city.cs.engine.*;

public class Low_Grass extends StaticBody {
    public Low_Grass(World w) {
        super(w);

        Shape l_gras1_shape = new PolygonShape(-2.265f,-0.647f, -2.475f,-0.088f, -1.926f,0.461f, -1.577f,-0.028f, -1.786f,-0.657f);
        GhostlyFixture l_grass1_fix = new GhostlyFixture(this, l_gras1_shape);

        Shape l_gras2_shape = new PolygonShape(-0.898f,-0.627f, -1.118f,-0.028f, -0.699f,0.481f, -0.09f,-0.098f, -0.309f,-0.637f);
        GhostlyFixture l_grass2_fix = new GhostlyFixture(this, l_gras2_shape);

        Shape l_gras3_shape = new PolygonShape(1.108f,-0.537f, 0.828f,0.111f, 1.447f,0.72f, 1.936f,0.191f, 1.667f,-0.527f);
        GhostlyFixture l_grass3_fix = new GhostlyFixture(this, l_gras3_shape);

        Shape l_gras4_shape = new PolygonShape(1.886f,-0.478f, 1.756f,-0.088f, 2.036f,0.221f, 2.445f,-0.138f, 2.325f,-0.458f);
        GhostlyFixture l_grass4_fix = new GhostlyFixture(this, l_gras4_shape);

        addImage(new BodyImage("data/Game_Parts/Ground/Level2/lowgrass.png", 1.5f));


    }
}
