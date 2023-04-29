package Engine.planet;

import Engine.Sphere;
import org.joml.Vector3f;

import java.util.Random;

import static Engine.MathUtils.lerp;

public class Astronaut extends Sphere {
    private float newPlaceTimer = 0f;
    private float newPlaceTime = 200f;
    private Vector3f newPlace;

    public Astronaut(float[] rgba, String type) {
        super(rgba, type);
        initHead();
        initBody();
        initBag();
        initLegs();
        initArm();
        initFlag();
        initBelt();
    }

    private void initBelt() {
        // kotak
        getChildObject().add(new Sphere(ColorPalette.ASTRONAUT_BOX.getRGBA(), "box")
                .inlineScaleObjectXYZ(0.5f)
                .inlineScaleObject(1.3f,0.8f,0.3f)
                .inlineTranslateObject(0.0f, -0.95f, 0.3f)
        );
        // sabuk belakang ke jetpack
        getChildObject().add(new Sphere(ColorPalette.ASTRONAUT_BELT.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.8f)
                .inlineScaleObject(1.3f,0.1f,1.3f)
                .inlineTranslateObject(0.0f, -0.95f, -0.3f)
        );
        // sabuk ke depan
        getChildObject().add(new Sphere(ColorPalette.ASTRONAUT_BELT.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.8f)
                .inlineScaleObject(1.1f,0.1f,0.7f)
                .inlineTranslateObject(0.0f, -0.95f, 0.05f)
        );
        // bola kecil di kotak
        getChildObject().add(new Sphere(ColorPalette.ASTRONAUT_ORB.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0.1f)
                .inlineTranslateObject(0.08f, -0.95f, 0.35f)
        );
        // antena kecil di kotak
        getChildObject().add(new Sphere(ColorPalette.ASTRONAUT_ANTENNA.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.3f)
                .inlineScaleObject(0.1f,0.3f,0.1f)
                .inlineTranslateObject(-0.07f, -0.85f, 0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.ASTRONAUT_ANTENNA.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.3f)
                .inlineScaleObject(0.1f,0.5f,0.1f)
                .inlineTranslateObject(-0.12f, -0.85f, 0.3f)
        );
    }

    public void executeNewPlaceTimer() {
        if (newPlaceTimer < newPlaceTime) {
            newPlaceTimer++;
        } else {
            newPlaceTimer = 0f;

            generateNewPlace();
        }
    }

    private void generateNewPlace() {
        Random random = new Random();

        boolean posX = random.nextBoolean(), posY = random.nextBoolean();
        newPlace = new Vector3f(
                (posX) ? random.nextFloat() * 0.2f : random.nextFloat() * -0.2f,
                (posY) ? random.nextFloat() * 0.2f + 6f : random.nextFloat() * -0.2f + 6f,
                random.nextFloat() - 7f
        );
    }

    public void executeTravelToNewPlace() {
        // travel to new place using lerp
        if (newPlace != null){
            float lerpFactor = 0.01f;
            Vector3f newAstronautPosition = new Vector3f();
            newAstronautPosition.x = lerp(getCenterPoint().x, newPlace.x, lerpFactor);
            newAstronautPosition.y = lerp(getCenterPoint().y, newPlace.y, lerpFactor);
            newAstronautPosition.z = lerp(getCenterPoint().z, newPlace.z, lerpFactor);

            // go to the destinated location
            inlineTranslateObject(newAstronautPosition.x - getCenterPoint().x, newAstronautPosition.y - getCenterPoint().y, newAstronautPosition.z - getCenterPoint().z);
        }
    }

    private void initFlag() {
        // create Indonesian flag on the suit (body)
        getChildObject().add(new Sphere(255f, 0f, 0f, 255f, "box")
                .inlineScaleObjectXYZ(0.2f)
                .inlineScaleObject(0.3f, 0.3f, 1.2f)
                .inlineRotateObject((float) Math.toRadians(180), 0f, 1f, 0f)
                .inlineRotateObject((float) Math.toRadians(90), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(90), 0f, 0f, 1f)
                .inlineTranslateObject(0.2f, -0.6f, 0.265f)
        );
        getChildObject().add(new Sphere(255f, 255f, 255f, 255f, "box")
                .inlineScaleObjectXYZ(0.2f)
                .inlineScaleObject(0.3f, 0.3f, 1.2f)
                .inlineRotateObject((float) Math.toRadians(180), 0f, 1f, 0f)
                .inlineRotateObject((float) Math.toRadians(90), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(90), 0f, 0f, 1f)
                .inlineTranslateObject(0.2f, -0.622f, 0.265f)
        );
    }

    private void initHead() {
        getChildObject().add(new Sphere(0.9f, 0.9f, 0.9f, ColorPalette.ASTRONAUT_HEAD.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.45f, 0.45f, 0.4f)
                .inlineTranslateObject(0f, 0f, 0.17f)
        );

    }

    private void initBody() {
        getChildObject().add(new Sphere(0.4f, 0.55f, 0.1f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                .inlineScaleObject(1f, 1f, 0.5f)
                .inlineTranslateObject(0f, -0.8f, 0f));
    }

    private void initBag() {
        getChildObject().add(new Sphere(0.4f, 0.4f, 0.1f, ColorPalette.ASTRONAUT_BAG.getRGBA(), "tube")
                .inlineScaleObject(1f, 1f, 0.5f)
                .inlineTranslateObject(0f, -0.8f, -0.4f));
    }

    private void initArm() {
        // tangan kanan
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                .inlineScaleObject(0.3f, 0.5f, 0.3f)
                .inlineRotateObject((float) Math.toRadians(-10), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-30), 0f, 0f, 1f)
                .inlineTranslateObject(-0.45f, -0.8f, 0f));
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_ARMS.getRGBA(), "tube")
                .inlineScaleObject(0.3f, 0.4f, 0.3f)
                .inlineRotateObject((float) Math.toRadians(-70), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.55f, -1f, 0.2f));

        //tangan kiri
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                .inlineScaleObject(0.3f, 0.4f, 0.3f)
                .inlineRotateObject((float) Math.toRadians(-10), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(30), 0f, 0f, 1f)
                .inlineTranslateObject(0.45f, -0.8f, 0f));
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_ARMS.getRGBA(), "tube")
                .inlineScaleObject(0.3f, 0.4f, 0.3f)
                .inlineRotateObject((float) Math.toRadians(-70), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(10), 0f, 0f, 1f)
                .inlineTranslateObject(0.55f, -1f, 0.2f));

        //bahu kanan
        getChildObject().add(new Sphere(0.25f, 0.25f, 0.25f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.5f, 0.5f, 0.6f)
                .inlineTranslateObject(-0.37f, -0.6f, -0.04f)
        );
        //bahu kiri
        getChildObject().add(new Sphere(0.25f, 0.25f, 0.25f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.5f, 0.6f, 0.6f)
                .inlineTranslateObject(0.37f, -0.6f, -0.04f)
        );

//        //siku kanan
//        getChildObject().add(new Sphere(0.27f, 0.27f, 0.27f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
//                .inlineScaleObject(0.5f, 0.5f, 0.6f)
//                .inlineTranslateObject(-0.58f, -0.83f, 0f)
//        );
//
//        //siku kir
//        getChildObject().add(new Sphere(0.27f, 0.27f, 0.27f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
//                .inlineScaleObject(0.5f, 0.5f, 0.6f)
//                .inlineTranslateObject(0.58f, -0.83f, 0f)
//        );

        initPalm();
    }

    private void initPalm() {
        // telapak kanan
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                .inlineScaleObject(0.31f, 0.17f, 0.31f)
                .inlineRotateObject((float) Math.toRadians(-70), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.565f, -1.09f, 0.45f));
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.32f, 0.31f, 0.32f)
                .inlineTranslateObject(-0.568f, -1.11f, 0.5f));
        getChildObject().add(new Sphere(0.1f,0.1f,0.05f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.2f,0.14f,0.08f)
                .inlineRotateObject((float) Math.toRadians(130), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.56f,-0.87f,0.58f));

        // telapak kiri
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "tube")
                .inlineScaleObject(0.31f, 0.17f, 0.31f)
                .inlineRotateObject((float) Math.toRadians(-70), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(10), 0f, 0f, 1f)
                .inlineTranslateObject(0.565f, -1.09f, 0.45f));
        getChildObject().add(new Sphere(0.5f, 0.5f, 0.5f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(0.32f, 0.31f, 0.32f)
                .inlineTranslateObject(0.568f, -1.11f, 0.5f));
        getChildObject().add(new Sphere(0.1f,0.1f,0.05f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.2f,0.14f,0.08f)
                .inlineRotateObject((float) Math.toRadians(130), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(0.56f,-0.87f,0.58f));
    }

    private void initLegs() {
        // bokong
        getChildObject().add(new Sphere(0.25f, 0.25f, 0.33f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(1f, 1.f, 1f)
                .inlineTranslateObject(-0.15f, -1.4f, -0.02f)
        );
        getChildObject().add(new Sphere(0.25f, 0.25f, 0.33f, ColorPalette.ASTRONAUT_SUIT.getRGBA(), "ellipsoid")
                .inlineScaleObject(1f, 1f, 1f)
                .inlineTranslateObject(0.15f, -1.4f, -0.02f)
        );

        //kaki kanan
        getChildObject().add(new Sphere(0.2f, 0.25f, 0.2f, ColorPalette.ASTRONAUT_JOINTS.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.2f, 0.2f, 0.09f)
                .inlineRotateObject((float) Math.toRadians(250), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                .inlineTranslateObject(-0.25f, -2.1f, 0.25f)
        );
        getChildObject().add(new Sphere(0.16f, 0.25f, 1f, ColorPalette.ASTRONAUT_LEGS.getRGBA(), "tube")
                        .inlineScaleObject(1f, 1f, 0.7f)
//                .inlineRotateObject((float) Math.toRadians(-30), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                        .inlineTranslateObject(-0.2f, -2.1f, 0.18f)
        );

        //kaki kiri
        getChildObject().add(new Sphere(0.2f, 0.25f, 0.2f, ColorPalette.ASTRONAUT_JOINTS.getRGBA(), "ellipticparaboloid")
                .inlineScaleObject(0.2f, 0.2f, 0.09f)
                .inlineRotateObject((float) Math.toRadians(250), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(10), 0f, 0f, 1f)
                .inlineTranslateObject(0.25f, -2.1f, 0.25f)
        );
        getChildObject().add(new Sphere(0.16f, 0.25f, 1f, ColorPalette.ASTRONAUT_LEGS.getRGBA(), "tube")
                        .inlineScaleObject(1f, 1f, 0.7f)
//                .inlineRotateObject((float) Math.toRadians(-30), 1f, 0f, 0f)
//                .inlineRotateObject((float) Math.toRadians(-10), 0f, 0f, 1f)
                        .inlineTranslateObject(0.2f, -2.1f, 0.18f)
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
        getChildObject().get(3).getChildObject().add(new Sphere(0.1f, 0.1f, 0.1f, ColorPalette.DUCK_FEET_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.2f)
                .inlineScaleObject(1.7f, 0.5f, 1.5f)
                .inlineRotateObject((float) Math.toRadians(90), 0, 1f, 0)
                .inlineRotateObject((float) Math.toRadians(35), 0, 1, 0)
                .inlineTranslateObject(-1.2f, -1.1f, 0.5f)
                .inlineRotateObject((float) Math.toRadians(-10), 0, 0, 1)
        );
        getChildObject().get(3).getChildObject().add(new Sphere(0.1f, 0.1f, 0.1f, ColorPalette.DUCK_FEET_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.2f)
                .inlineScaleObject(1.7f, 0.5f, 1.5f)
                .inlineRotateObject((float) Math.toRadians(90), 0, 1f, 0)
                .inlineRotateObject((float) Math.toRadians(-35), 0, 1, 0)
                .inlineTranslateObject(-0.5f, -1.1f, -0.6f)
        );
    }


}
