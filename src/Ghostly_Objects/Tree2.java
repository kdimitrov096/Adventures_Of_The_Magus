package Ghostly_Objects;

import city.cs.engine.*;

public class Tree2 extends StaticBody {
    public Tree2(World w) {
        super(w);

        Shape branches2 = new PolygonShape(
                -1.88f,-2.22f, -3.95f,-1.44f, -5.36f,0.07f, -1.82f,4.91f, 2.59f,3.73f, 4.69f,-0.06f, 0.71f,-2.11f);
        GhostlyFixture branches_fixture2 = new GhostlyFixture(this, branches2);
        Shape roots2 = new PolygonShape(-1.88f,-2.22f, 0.71f,-2.11f, 1.71f,-4.7f, -3.91f,-4.64f);
        GhostlyFixture roots_fixture2 = new GhostlyFixture(this, roots2);
        addImage(new BodyImage("data/Game_Parts/Ground/Level1/Tree.png", 10f));

    }
}