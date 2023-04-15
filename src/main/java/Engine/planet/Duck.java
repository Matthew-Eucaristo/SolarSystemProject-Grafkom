package Engine.planet;

import Engine.Sphere;

public class Duck extends Sphere {
    public Duck() {
        super(0,0,0,
                1f,0.5f,0.5f,
                100, 100,
                ColorPalette.DUCK_COLOR.getR(), ColorPalette.DUCK_COLOR.getG(), ColorPalette.DUCK_COLOR.getB(), ColorPalette.DUCK_COLOR.getA(),
                "ellipsoid");

        initHead();
        initLegs();

        initPoop();

        initTail();
    }

    private void initTail() {
        getChildObject().add(new Sphere(0.3f,0.3f,0.3f, ColorPalette.DUCK_TAIL_COLOR.getRGBA(), "tube")
                .inlineScaleObject(0.3f, 1.1f, 0.2f)
                .inlineTranslateObject(0.45f,0.9f,0)
                .inlineRotateObject((float) Math.toRadians(-45), 0, 0, 1)
        );
    }

    private void initLegs() {
        getChildObject().add(new Sphere(0.3f,0.3f,0.3f, ColorPalette.DUCK_NECK_COLOR.getRGBA(), "tube")
                .inlineScaleObject(0.5f, 1.3f, 0.5f)
                .inlineTranslateObject(0.35f,-0.7f,0)
        );
        getChildObject().add(new Sphere(0.3f,0.3f,0.3f, ColorPalette.DUCK_NECK_COLOR.getRGBA(), "tube")
                .inlineScaleObject(0.5f, 1.3f, 0.5f)
                .inlineTranslateObject(-0.35f,-0.7f,0)
                .inlineRotateObject((float) Math.toRadians(-10), 0, 0, 1)
        );

        initFeet();
    }

    private void initFeet() {
        getChildObject().get(3).getChildObject().add(new Sphere(0.1f,0.1f,0.1f, ColorPalette.DUCK_FEET_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.2f)
                        .inlineScaleObject(1.7f,0.5f,1.5f)
                .inlineRotateObject((float) Math.toRadians(90), 0, 1f, 0)
                        .inlineRotateObject((float) Math.toRadians(35), 0, 1, 0)
                .inlineTranslateObject(-1.2f,-1.1f,0.5f)
                .inlineRotateObject((float) Math.toRadians(-10), 0, 0, 1)
        );
        getChildObject().get(3).getChildObject().add(new Sphere(0.1f,0.1f,0.1f, ColorPalette.DUCK_FEET_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.2f)
                .inlineScaleObject(1.7f,0.5f,1.5f)
                .inlineRotateObject((float) Math.toRadians(90), 0, 1f, 0)
                .inlineRotateObject((float) Math.toRadians(-35), 0, 1, 0)
                .inlineTranslateObject(-0.5f,-1.1f,-0.6f)
        );
    }

    private void initPoop() {
        getChildObject().get(3).getChildObject().add(new Sphere(0.2f,0.2f,0.2f, ColorPalette.DUCK_POOP_COLOR.getRGBA(), "elliptic")
                .inlineTranslateObject(0f,-0.4f,0f));
    }

    private void initHead() {
        getChildObject().add(new Sphere(0.3f,0.3f,0.3f, ColorPalette.DUCK_NECK_COLOR.getRGBA(), "tube")
                .inlineScaleObject(0.5f, 1.3f, 0.5f)
                .inlineTranslateObject(-0.5f,0.7f,0));
        getChildObject().add(new Sphere(ColorPalette.DUCK_HEAD_COLOR.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(-0.55f,1.25f,0));
        getChildObject().add(new Sphere(0.07f,0.07f,0.07f,ColorPalette.DUCK_BEAK_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.4f,0.2f,0.3f)
                .inlineRotateObject((float) Math.toRadians(90), 0, 1f, 0)
                .inlineTranslateObject(-1.5f,1.25f,0)
        );
        initEyes();
    }

    private void initEyes() {
        // for the black eye
        getChildObject().get(1).getChildObject().add(new Sphere(ColorPalette.DUCK_EYE_COLOR.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.2f)
                .inlineTranslateObject(-0.7f,1.3f,0.42f));
        getChildObject().get(1).getChildObject().add(new Sphere(ColorPalette.DUCK_EYE_COLOR.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.2f)
                .inlineTranslateObject(-0.7f,1.3f,-0.42f));

        // for the white dot
        getChildObject().get(1).getChildObject().add(new Sphere(ColorPalette.DUCK_EYE_2_COLOR.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.13f)
                .inlineTranslateObject(-0.75f,1.3f,0.42f));
        getChildObject().get(1).getChildObject().add(new Sphere(ColorPalette.DUCK_EYE_2_COLOR.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.13f)
                .inlineTranslateObject(-0.75f,1.3f,-0.42f));
    }


}
