package Engine.planet;

import Engine.Circle;
import Engine.Curve;
import Engine.Object;
import Engine.Sphere;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Saturn extends Sphere {
    public Saturn(float[] rgba) {
        super(rgba, "ellipsoid");
        createRings();
        createHat();
        createHourglass();
    }

    public void createRings() {
        //Function for creating the rings of Saturn
        //F Rings
        Random random = new Random();
        int deg;
        Circle circle;

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 100f, 100f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 100f, 100f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 99f, 99f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_WHITE.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 99f, 99f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_WHITE.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));


        deg = random.nextInt(360);
        circle = new Circle(0, 0, 98f, 98f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_WHITE.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 98f, 98f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_WHITE.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 97f, 97f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 97f, 97f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 97f, 97f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 96f, 96f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 88f, 88f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 88f, 88f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 88f, 88f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 87f, 87f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 86f, 86f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 85f, 85f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 85f, 85f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_LIGHT_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 83f, 83f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 82f, 82f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 82f, 82f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 81f, 81f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 81f, 81f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 80f, 80f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 79f, 79f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 78f, 78f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 78f, 78f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 78f, 78f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 77f, 77f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 76f, 76f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 74f, 74f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 73f, 73f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 73f, 73f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 72f, 72f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 71f, 71f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 71f, 71f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 70f, 70f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 69f, 69f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 69f, 69f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 68f, 68f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 68f, 68f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 67f, 67f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 66f, 66f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_BROWN.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 64f, 64f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 64f, 64f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 63f, 63f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 63f, 63f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 62f, 62f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 61f, 61f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 60f, 60f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 60f, 60f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 59f, 59f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 58f, 58f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 58f, 58f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 57f, 57f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 56f, 56f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));
        deg = random.nextInt(360);
        circle = new Circle(0, 0, 56f, 56f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1));

        deg = random.nextInt(360);
        circle = new Circle(0, 0, 55f, 55f, 0, 0, 0, 0, 0, 100);
        getChildObject().add(new Curve(circle.getVertices(), ColorPalette.SATURN_RING_DARK_GREY.getRGBA())
                .inlineScaleObjectXYZ(2f)
                .inlineRotateObject(deg, 0, 0, 1f));
    }

    public void createHat() {
        //"What a distinguished Gentleman" - Someone, 2023
        getChildObject().add(new Sphere(ColorPalette.SATURN_RING_GREY.getRGBA(), "tube")
                .inlineScaleObjectXYZ(0.6f)
                .inlineTranslateObject(0, -0.7f, 0)
                .inlineRotateObject((float) Math.toRadians(90), 1, 0, 0));
        getChildObject().add(new Circle(0, 0, 70, 70, 0,
                ColorPalette.SATURN_RING_GREY.getR(), ColorPalette.SATURN_RING_GREY.getG(),
                ColorPalette.SATURN_RING_GREY.getB(), ColorPalette.SATURN_RING_GREY.getA(), 100)
                .inlineTranslateObject(0, 0, -0.4f));
    }

    public void createHourglass() {
        //Hourglass decoration
        getChildObject().add(new Sphere(ColorPalette.HOURGLASS.getRGBA(), "ellipsoid")
                .inlineScaleObjectXYZ(0)
                .inlineTranslateObject(-2f, -1.5f, 0));
        getChildObject().get(getChildObject().size() - 1).getChildObject().add(new Sphere(ColorPalette.HOURGLASS.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.08f)
                .inlineTranslateObject(-2f, -1.5f, -0.015f));
        getChildObject().get(getChildObject().size() - 1).getChildObject().add(new Sphere(ColorPalette.HOURGLASS.getRGBA(), "ellipticcone")
                .inlineScaleObjectXYZ(0.08f)
                .inlineRotateObject((float) Math.toRadians(180), 0, 1, 0)
                .inlineTranslateObject(-2f, -1.5f, 0.015f));
    }

    public void rotateRings() {
        List<Object> childObjects = getChildObject();
        for (int i = 0; i < childObjects.size() - 3; i++) {
            Random random = new Random();

            int ran = random.nextInt(3);

            switch (ran) {
                case 0:
                    childObjects.get(i).selfRotate((float) Math.toRadians(1f), 1, 0, 0);
                case 1:
                    childObjects.get(i).selfRotate((float) Math.toRadians(1f), 0, 1, 0);
                case 2:
                    childObjects.get(i).selfRotate((float) Math.toRadians(1f), 0, 0, 1);
            }
        }
    }

    public void moveHourglass() {
        Random random = new Random();

        int ran = random.nextInt(3);

        getChildObject().get(getChildObject().size() - 1).scaleObjectXYZ(0.99f);
        switch (ran) {
            case 0:
                getChildObject().get(getChildObject().size() - 1).selfRotate((float) Math.toRadians(1f), 1, 0, 0);
            case 1:
                getChildObject().get(getChildObject().size() - 1).selfRotate((float) Math.toRadians(1f), 0, 1, 0);
            case 2:
                getChildObject().get(getChildObject().size() - 1).selfRotate((float) Math.toRadians(1f), 0, 0, 1);
        }
    }

    public void moveTophat() {
        List<Object> childObjects = getChildObject();
        for (int i = childObjects.size() - 3; i < childObjects.size() - 1; i++) {
//            getChildObject().get(i).selfRotate(1f, 1, 0, 0);
//            getChildObject().get(i).translateObject(0.1f, 0, 0);
            getChildObject().get(i).selfRotate(1f, 0, 1, 0);
            getChildObject().get(i).translateObject(0, 0.01f, 0);
        }
    }
}
