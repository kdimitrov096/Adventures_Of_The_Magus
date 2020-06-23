package Ghostly_Objects;

import city.cs.engine.*;

public class Fence extends StaticBody {
    public Fence(World w) {
        super(w);

        Shape v_board1_shape = new PolygonShape(-2.25f,-1.46f, -2.24f,1.12f, -2.12f,1.27f, -1.98f,1.26f, -1.86f,1.13f, -1.83f,-1.47f);
        GhostlyFixture v_board1_fix = new GhostlyFixture(this, v_board1_shape);

        Shape v_board2_shape = new PolygonShape(-1.43f,-1.46f, -1.42f,1.12f, -1.3f,1.27f, -1.14f,1.27f, -1.02f,1.11f, -1.02f,-1.46f);
        GhostlyFixture v_board2_fix = new GhostlyFixture(this, v_board2_shape);

        Shape v_board3_shape = new PolygonShape(-0.59f,-1.46f, -0.6f,1.1f, -0.5f,1.27f, -0.32f,1.26f, -0.21f,1.14f, -0.18f,-1.46f);
        GhostlyFixture v_board3_fix = new GhostlyFixture(this, v_board3_shape);

        Shape v_board4_shape = new PolygonShape(0.22f,-1.46f, 0.23f,1.13f, 0.36f,1.27f, 0.49f,1.27f, 0.63f,1.1f, 0.64f,-1.47f);
        GhostlyFixture v_board4_fix = new GhostlyFixture(this, v_board4_shape);

        Shape v_board5_shape = new PolygonShape(1.04f,-1.45f, 1.04f,1.1f, 1.16f,1.26f, 1.33f,1.26f, 1.46f,1.11f, 1.47f,-1.45f);
        GhostlyFixture v_board5_fix = new GhostlyFixture(this, v_board5_shape);

        Shape v_board6_shape = new PolygonShape(1.87f,-1.47f, 1.89f,1.09f, 1.98f,1.25f, 2.18f,1.24f, 2.29f,1.09f, 2.29f,-1.46f);
        GhostlyFixture v_board6_fix = new GhostlyFixture(this, v_board6_shape);

        Shape h_boardT_shape = new PolygonShape(-2.55f,0.48f, 2.52f,0.48f, 2.53f,0.32f, -2.55f,0.31f);
        GhostlyFixture h_boardT_fix = new GhostlyFixture(this, h_boardT_shape);

        Shape h_boardB_shape = new PolygonShape(-2.55f,-1.17f, 2.53f,-1.17f, 2.53f,-1.33f, -2.55f,-1.32f);
        GhostlyFixture h_boardB_fix = new GhostlyFixture(this, h_boardB_shape);

        addImage(new BodyImage("data/Game_Parts/Ground/Level2/fence.png", 3f));
    }
}
