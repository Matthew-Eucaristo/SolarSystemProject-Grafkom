package Engine.planet;

import Engine.Curve;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Earth extends Sphere {
    public Earth(float[] rgba){
        super(rgba, "ellipsoid");
        initDekorasi();

    }
    public void initDekorasi(){
        // all decoration for Earth
        // land (green land to represent the land)
        createLand();

        // clouds (white clouds to represent the clouds)
        createClouds();

        // different water (darker water to represent the depth)
        createWater();

        // mud (just to decorate more)
        createMud();

        // darker land (just to decorate)
        createDarkerLand();

        // lighter land (just to decorate)
        createLighterLand();

        // wind (using bezier curve)
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();
        createWind();


    }

    private void createWind(){
        // create wind
        // get random vector around the planet and then create a curve

        // Randomly get 5 points around the planet, use the vertices available
        Random random = new Random();
        int[] choices = new int[5];

        for (int i = 0; i < 5; i++) {
            int choice = random.nextInt(getVertices().size());
            choices[i] = choice;
        }

        // for the first point
        Vector3f point1 = getVertices().get(choices[0]);

        // for the second point
        Vector3f point2 = getVertices().get(choices[1]);
        point2.x = point2.x * 2.4f;
        point2.y = point2.y * 2.4f;
        point2.z = point2.z * 2.4f;

        // for the third point
        Vector3f point3 = getVertices().get(choices[2]);
        point3.x = point3.x * 2.4f;
        point3.y = point3.y * 2.4f;
        point3.z = point3.z * 2.4f;

        // for the fourth point
        Vector3f point4 = getVertices().get(choices[3]);
        point4.x = point4.x * 2.4f;
        point4.y = point4.y * 2.4f;
        point4.z = point4.z * 2.4f;

        // for the fifth point
        Vector3f point5 = getVertices().get(choices[4]);

        // create curve
        getChildObject().add(new Curve(List.of(new Vector3f[]{point1, point2, point3, point4, point5}),
                ColorPalette.EARTH_WIND.getRGBA()
        ));
    }
    private void createLighterLand(){
        // create lighter land
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(1.2f,0.15f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-1.2f,0.15f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.8f,1.1f,0f)
                .inlineScaleObjectXYZ(0.3f)
        );
    }
    private void createDarkerLand(){
        // create darker land
        getChildObject().add(new Sphere(ColorPalette.EARTH_DARKER_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.3f,1.05f,0.1f)
                .inlineScaleObjectXYZ(0.2f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DARKER_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-0.3f,-1.05f,0.1f)
                .inlineScaleObjectXYZ(0.2f)
        );
    }
    private void createMud(){
        // create mud
        getChildObject().add(new Sphere(ColorPalette.EARTH_MUD.getRGBA(), "ellipsoid")
                .inlineTranslateObject(2.3f,0.05f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.2f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_MUD.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-2.3f,0.05f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.2f)
        );

        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "tube").inlineTranslateObject(1,1,1));
    }

    private void createClouds(){
        // create clouds
        getChildObject().add(new Sphere(ColorPalette.CLOUDS.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.3f,0.05f,1.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
                .inlineRotateObject((float)Math.toRadians(75),0f,0f,1f)
        );
        getChildObject().add(new Sphere(ColorPalette.CLOUDS.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.3f,0.05f,-1.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
                .inlineRotateObject((float)Math.toRadians(255),0f,0f,1f)
        );
        getChildObject().add(new Sphere(ColorPalette.CLOUDS.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-1.2f,-0.03f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.3f)
                .inlineRotateObject((float)Math.toRadians(-35),0f,0f,1f)
        );
    }

    private void createWater(){
    // create deep water using the DEEP in enums
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA(), "ellipsoid")
                .inlineTranslateObject(1.1f,-0.35f,0.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.1f,-1.35f,0.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.6f,-0.75f,0.15f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-0.6f,-0.75f,0.15f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
    }

    private void createLand(){
        // create land
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-0.7f,0.05f,0.25f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.7f,0.05f,0.25f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.1f,0.05f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.05f,0.15f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.15f,0.25f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );

        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.5f,0.5f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.5f,0.5f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );

        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(-0.5f,0.5f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.5f,0.5f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );


        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.5f,-0.5f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA(), "ellipsoid")
                .inlineTranslateObject(0.5f,0.5f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );

    }

    public List<Moon> getMoons(){
        List<Moon> moons = new ArrayList<>();
        for (Object child : getChildObject()) {
            if (child instanceof Moon) {
                moons.add((Moon) child);
            }
        }
        return moons;
    }

}
