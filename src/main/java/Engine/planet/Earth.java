package Engine.planet;

import Engine.Sphere;

public class Earth extends Sphere {
    public Earth(float red, float green, float blue, float alpha) {
        super(red, green, blue, alpha);

        initDekorasi();
    }

    public void initDekorasi(){
        // all decoration for Earth
        // land (green land to represent the land)
        getChildObject().add(new Sphere(0,255,0,255)
                .inlineTranslateObject(0.1f,0f,0f)
                .inlineScaleObjectXYZ(0.95f));
        // water (blue water to represent the water)

        // clouds (white clouds to represent the clouds)


    }


}
