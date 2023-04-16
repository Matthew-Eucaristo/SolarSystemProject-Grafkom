package Engine.planet;

import Engine.Curve;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;

public class Moon extends Sphere {
    public Moon(float[] rgba) {
        super(rgba, "ellipsoid");

        initMoonSurface();
    }

    private void initMoonSurface() {
        // create moon surface and water-mine-like decoration
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, 0.0f, 0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.1f)
                        .inlineScaleObject(0.3f,0.3f,1.2f)
                        .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineTranslateObject(0.0f, 0.0f, 0.8f)
        );

        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.5f)
                        .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineTranslateObject(0.0f, 0.0f, -0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.1f)
                .inlineScaleObject(0.3f,0.3f,1.2f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f, 0.8f, 0.0f)
        );

        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.3f, 0.0f, -0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.1f)
                .inlineScaleObject(0.3f,0.3f,1.2f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                .inlineTranslateObject(0.8f, 0.0f, 0.0f)
        );

        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(-0.3f, 0.0f, -0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.1f)
                .inlineScaleObject(0.3f,0.3f,1.2f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                .inlineTranslateObject(0.0f, 0.0f, -0.8f)
        );

        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, 0.3f, -0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.1f)
                .inlineScaleObject(0.3f,0.3f,1.2f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineTranslateObject(-0.8f, 0.0f, 0.0f)
        );

        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, -0.3f, -0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.MOON_SURFACE.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.1f)
                .inlineScaleObject(0.3f,0.3f,1.2f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                        .inlineRotateObject((float)Math.toRadians(90),1f,0f,0)
                .inlineTranslateObject(-0.0f, -0.8f, 0.0f)
        );



    }



}
