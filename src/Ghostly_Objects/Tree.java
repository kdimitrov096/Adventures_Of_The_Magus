package Ghostly_Objects;

import city.cs.engine.*;

public class Tree extends StaticBody {
    public Tree(World w) {
        super(w);

        Shape branches = new PolygonShape(-1.23f,-1.32f, 0.91f,-1.42f, 3.83f,0.0f, 3.47f,3.32f, -0.53f,4.5f, -3.55f,2.56f, -3.37f,-0.04f);
        GhostlyFixture branches_fixture = new GhostlyFixture(this, branches);
        Shape roots = new PolygonShape(-1.45f,-4.6f, -1.23f,-1.32f, 0.91f,-1.42f, 1.01f,-4.62f);
        GhostlyFixture roots_fixture = new GhostlyFixture(this, roots);
        addImage(new BodyImage("data/Game_Parts/Ground/Level2/tree.png", 10f));

    }
}
