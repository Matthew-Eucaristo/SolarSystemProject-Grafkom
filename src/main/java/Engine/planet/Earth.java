package Engine.planet;

import Engine.Sphere;

public class Earth extends Sphere {
    public Earth(float red, float green, float blue, float alpha) {
        super(red, green, blue, alpha);
        initDekorasi();
    }
    public Earth(float[] rgba){
        super(rgba);
        initDekorasi();
    }
    public void initDekorasi(){
        // all decoration for Earth
        // land (green land to represent the land)
        getChildObject().add(new Sphere(ColorPaletteSpace.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.1f,0.05f,0.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.7f)
        );
        // water (blue water to represent the water)

        // clouds (white clouds to represent the clouds)


    }


}
