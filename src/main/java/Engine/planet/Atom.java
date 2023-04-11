package Engine.planet;

import Engine.Circle;
import Engine.Sphere;

public class Atom extends Sphere {
    public Atom(float[] rgba) {
        super(rgba);
        createCircle();
    }
    private void createCircle(){
        getChildObject().add(new Circle(0,0,100,80,100,75,0,130,255,360,2));
    }
}
