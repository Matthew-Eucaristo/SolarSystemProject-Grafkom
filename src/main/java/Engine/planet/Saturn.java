package Engine.planet;

import Engine.Circle;
import Engine.Ring;
import Engine.Sphere;

public class Saturn extends Sphere {
    public Saturn(float[] rgba) {
        super(rgba);
        initRings();
    }

    public void initRings() {
        //function for creating the rings of Saturn
        //F Rings
        getChildObject().add(new Ring(ColorPalette.SATURN_RING_WHITE.getRGBA())
                .inlineScaleObject(2f, 1f, 2f));
    }
}
