package Engine.planet;

import Engine.Sphere;

public class Astronaut extends Sphere {
    public Astronaut(float[] rgba, String type) {
        super(rgba, type);
        initHead();
        initBody();
        initBag();
        initLegs();
        initArm();
    }
    private void initHead() {
        getChildObject().add(new Sphere(0.9f,0.9f,0.9f, ColorPalette.SPACESHIP_FLAME.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.45f, 0.45f, 0.4f)
                .inlineTranslateObject(0f,0f,0.17f)
        );

    }
    private void initBody() {
        getChildObject().add(new Sphere(0.4f,0.55f,0.1f,ColorPalette.SPACESHIP_FLAME.getRGBA(),"tube")
                .inlineScaleObject(1f,1f,0.5f)
                .inlineTranslateObject(0f,-0.8f,0f));
    }
    private void initBag() {
        getChildObject().add(new Sphere(0.4f,0.4f,0.1f,ColorPalette.ASTRONAUT_SUIT.getRGBA(),"tube")
                .inlineScaleObject(1f,1f,0.5f)
                .inlineTranslateObject(0f,-0.8f,-0.4f));
    }
    private void initArm(){
        // tangan kanan
        getChildObject().add(new Sphere(0.5f,0.5f,0.5f,ColorPalette.ASTRONAUT_SUIT.getRGBA(),"tube")
                .inlineScaleObject(0.3f,0.5f,0.3f)
                .inlineRotateObject((float) Math.toRadians(-10), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-30), 0f, 0f, 1f)
                .inlineTranslateObject(-0.45f,-0.8f,0f));
        getChildObject().add(new Sphere(0.5f,0.5f,0.5f,ColorPalette.SPACESHIP_FLAME.getRGBA(),"tube")
                .inlineScaleObject(0.3f,0.5f,0.3f)
                .inlineRotateObject((float) Math.toRadians(-70), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.55f,-1f,0.2f));

        //bahu kanan
        getChildObject().add(new Sphere(0.25f,0.25f,0.25f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.5f, 0.5f, 0.6f)
                .inlineTranslateObject(-0.37f,-0.6f,-0.04f)
        );
        //bahu kiri
        getChildObject().add(new Sphere(0.25f,0.25f,0.25f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.5f, 0.6f, 0.6f)
                .inlineTranslateObject(0.37f,-0.6f,-0.04f)
        );

        //tangan kiri
        getChildObject().add(new Sphere(0.5f,0.5f,0.5f,ColorPalette.ASTRONAUT_SUIT.getRGBA(),"tube")
                .inlineScaleObject(0.3f,0.5f,0.3f)
                .inlineRotateObject((float) Math.toRadians(-10), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(30), 0f, 0f, 1f)
                .inlineTranslateObject(0.45f,-0.8f,0f));
        getChildObject().add(new Sphere(0.5f,0.5f,0.5f,ColorPalette.SPACESHIP_FLAME.getRGBA(),"tube")
                .inlineScaleObject(0.3f,0.5f,0.3f)
                .inlineRotateObject((float) Math.toRadians(-70), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(10), 0f, 0f, 1f)
                .inlineTranslateObject(0.55f,-1f,0.2f));
    }

    private void initLegs() {
        // bokong
        getChildObject().add(new Sphere(0.25f,0.25f,0.33f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(1f, 1.f, 1f)
                .inlineTranslateObject(-0.15f,-1.4f,-0.02f)
        );
        getChildObject().add(new Sphere(0.25f,0.25f,0.33f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(1f, 1f, 1f)
                .inlineTranslateObject(0.15f,-1.4f,-0.02f)
        );

        //kaki kanan
        getChildObject().add(new Sphere(0.2f,0.25f,0.2f, ColorPalette.SPACESHIP_FLAME.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.2f, 0.2f, 0.09f)
                .inlineRotateObject((float) Math.toRadians(250), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.25f,-2.1f,0.25f)
        );
        getChildObject().add(new Sphere(0.16f,0.25f,1f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                .inlineScaleObject(1f, 1f, 0.7f)
//                .inlineRotateObject((float) Math.toRadians(-30), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.2f,-2.1f,0.18f)
        );

        //kaki kiri
        getChildObject().add(new Sphere(0.2f,0.25f,0.2f, ColorPalette.SPACESHIP_FLAME.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.2f, 0.2f, 0.09f)
                .inlineRotateObject((float) Math.toRadians(250), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(10), 0f, 0f, 1f)
                .inlineTranslateObject(0.25f,-2.1f,0.25f)
        );
        getChildObject().add(new Sphere(0.16f,0.25f,1f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                        .inlineScaleObject(1f, 1f, 0.7f)
//                .inlineRotateObject((float) Math.toRadians(-30), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                        .inlineTranslateObject(0.2f,-2.1f,0.18f)
        );
        //        getChildObject().add(new Sphere(0.2f,0.25f,0.2f, ColorPalette.ATOM_COLOR.getRGBA(), "tube")
//                .inlineScaleObject(1f, 1f, 1f)
//                .inlineRotateObject((float) Math.toRadians(-30), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(10), 0f, 0f, 1f)
//                .inlineTranslateObject(0.22f,-1.7f,0.2f)
//        );
//
//        getChildObject().add(new Sphere(0.2f,0.25f,0.2f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
//                .inlineScaleObject(1f, 1f, 1f)
////                .inlineRotateObject((float) Math.toRadians(-30), 1f, 0f, 0f)
////                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
//                .inlineTranslateObject(0.22f,-2.2f,0.2f)
//        );

//        initFeet();
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


}
