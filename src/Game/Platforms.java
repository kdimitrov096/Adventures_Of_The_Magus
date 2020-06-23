package Game;

import city.cs.engine.StaticBody;
import city.cs.engine.*;

public class Platforms extends StaticBody {
    private float width;
    private float height;

    /**
     * The Constructor of the Platforms
     */
    public Platforms(World w, float width, float height){
        super(w);
        this.width = width;
        this.height = height;

        Shape s = new BoxShape(width, height);
        Fixture f = new SolidFixture(this, s);

    }

    /**
     * Getters for the Width and Height of the platform shape
     */

    public  float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }
}
