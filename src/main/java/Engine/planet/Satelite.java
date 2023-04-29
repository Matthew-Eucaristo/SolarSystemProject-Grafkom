package Engine.planet;

import Engine.Sphere;

public class Satelite extends Sphere {
    public Satelite(float[] rgba) {
        super(rgba, "box");
        initBody();
        initSolarPanel();
        initExtensionBody();
    }

    private void initExtensionBody() {
        // create extension body with parabola for satelite (using the ellipticparaboloid)
        // create extension body first
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(0.5f, 3.5f, 3.5f)
                .inlineTranslateObject(0.8f, 0.0f, 0.25f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(0.5f, 3.5f, 3.5f)
                .inlineTranslateObject(-0.8f, 0.0f, -0.25f)
        );
        // create a part of body
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SECONDARY_COLOR.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.0f, 2.0f, 1.0f)
                .inlineTranslateObject(0.0f, 0.0f, 0.0f)
        );
        // create the other part of body
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SECONDARY_COLOR.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(0.5f, 4.0f, 0.5f)
                .inlineTranslateObject(0.0f, 0.0f, 0.0f)
        );
        // create parabola (satelite)
        getChildObject().add(new Sphere(ColorPalette.SATELITE_PARABOLA.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.1f)
                        .inlineScaleObject(1.2f, 1.2f, 0.2f)
                        .inlineRotateObject((float) Math.toRadians(90), 1f, 0f, 0f)
                .inlineTranslateObject(0.0f, -1.0f, 0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_PARABOLA.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.1f)
                        .inlineScaleObject(1.2f, 1.2f, 0.2f)
                        .inlineRotateObject((float) Math.toRadians(-90), 1f, 0f, 0f)
                .inlineTranslateObject(0.0f, 1.0f, 0.0f)
        );
        // create a tube connecting the two panel on the side
        getChildObject().add(new Sphere(ColorPalette.SATELITE_ALTERNATE_COLOR.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(0.5f, 2.5f, 0.5f)
                        .inlineRotateObject((float) Math.toRadians(90), 1f, 0f, 0f)
                        .inlineRotateObject((float) Math.toRadians(90), 0f, 1f, 0f)
                .inlineTranslateObject(0.0f, 0.0f, 0.0f)
        );
    }

    private void initSolarPanel() {
        // create papan untuk memegang solar panelnya
        getChildObject().add(new Sphere(ColorPalette.SATELITE_MAIN_COLOR.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.8f)
                        .inlineScaleObject(2.5f, 0.5f, 5.5f)
                .inlineTranslateObject(0.0f, 0.0f, 1.5f)
        );
            //create for the other side
        getChildObject().add(new Sphere(ColorPalette.SATELITE_MAIN_COLOR.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.8f)
                        .inlineScaleObject(2.5f, 0.5f, 5.5f)
                .inlineTranslateObject(0.0f, 0.0f, -1.5f)
        );


        // create solar panel with boxes
            // for the front side
                // the cube part
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, 0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(-0.2f, 0.0f, 0.9f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, 1.2f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(-0.2f, 0.0f, 1.5f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, 1.8f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(-0.2f, 0.0f, 2.1f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, 2.4f)
        );
                // the panel part
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                        .inlineScaleObject(0.7f, 1.0f, 8.5f)
                .inlineTranslateObject(0.2f, 0.0f, 1.5f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                        .inlineScaleObject(0.7f, 1.0f, 8.5f)
                .inlineTranslateObject(-0.2f, 0.0f, 1.5f)
        );

            // for the back side
                // the cube part
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, -0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(-0.2f, 0.0f, -0.9f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, -1.2f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(-0.2f, 0.0f, -1.5f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, -1.8f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(-0.2f, 0.0f, -2.1f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.6f)
                        .inlineScaleObject(1.5f,1f,1f)
                .inlineTranslateObject(0.2f, 0.0f, -2.4f)
        );


                // the panel part
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                        .inlineScaleObject(0.7f, 1.0f, 8.5f)
                .inlineTranslateObject(0.2f, 0.0f, -1.5f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_SOLAR_PANEL.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                        .inlineScaleObject(0.7f, 1.0f, 8.5f)
                .inlineTranslateObject(-0.2f, 0.0f, -1.5f)
        );


    }

    private void initBody() {
        // create satelite body with boxes
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, 0.0f, 0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, 0.0f, -0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, 0.3f, 0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.0f, -0.3f, 0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(0.3f, 0.0f, 0.0f)
        );
        getChildObject().add(new Sphere(ColorPalette.SATELITE_BODY.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineTranslateObject(-0.3f, 0.0f, 0.0f)
        );
    }

}
