package Engine.planet;

import Engine.Sphere;

public class Earth extends Sphere {
    public Earth(float[] rgba){
        super(rgba);
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


    }
    private void createLighterLand(){
        // create lighter land
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA())
                .inlineTranslateObject(1.2f,0.15f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA())
                .inlineTranslateObject(-1.2f,0.15f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA())
                .inlineTranslateObject(0.8f,1.1f,0f)
                .inlineScaleObjectXYZ(0.3f)
        );
    }
    private void createDarkerLand(){
        // create darker land
        getChildObject().add(new Sphere(ColorPalette.EARTH_DARKER_LAND.getRGBA())
                .inlineTranslateObject(0.3f,1.05f,0.1f)
                .inlineScaleObjectXYZ(0.2f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DARKER_LAND.getRGBA())
                .inlineTranslateObject(-0.3f,-1.05f,0.1f)
                .inlineScaleObjectXYZ(0.2f)
        );
    }
    private void createMud(){
        // create mud
        getChildObject().add(new Sphere(ColorPalette.EARTH_MUD.getRGBA())
                .inlineTranslateObject(2.3f,0.05f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.2f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_MUD.getRGBA())
                .inlineTranslateObject(-2.3f,0.05f,0.1f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.2f)
        );
    }

    private void createClouds(){
        // create clouds
        getChildObject().add(new Sphere(ColorPalette.CLOUDS.getRGBA())
                .inlineTranslateObject(0.3f,0.05f,1.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
                .inlineRotateObject((float)Math.toRadians(75),0f,0f,1f)
        );
        getChildObject().add(new Sphere(ColorPalette.CLOUDS.getRGBA())
                .inlineTranslateObject(0.3f,0.05f,-1.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
                .inlineRotateObject((float)Math.toRadians(255),0f,0f,1f)
        );
        getChildObject().add(new Sphere(ColorPalette.CLOUDS.getRGBA())
                .inlineTranslateObject(-1.2f,-0.03f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.3f)
                .inlineRotateObject((float)Math.toRadians(-35),0f,0f,1f)
        );
    }

    private void createWater(){
    // create deep water using the DEEP in enums
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA())
                .inlineTranslateObject(1.1f,-0.35f,0.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA())
                .inlineTranslateObject(0.1f,-1.35f,0.25f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA())
                .inlineTranslateObject(0.6f,-0.75f,0.15f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_DEEP_SEA.getRGBA())
                .inlineTranslateObject(-0.6f,-0.75f,0.15f)
                .inlineScaleObject(0.95f, 0.95f, 1f)
                .inlineScaleObjectXYZ(0.3f)
        );
    }

    private void createLand(){
        // create land
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(-0.7f,0.05f,0.25f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.7f,0.05f,0.25f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.1f,0.05f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.05f,0.15f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.15f,0.25f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );

        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.5f,0.5f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.5f,0.5f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );

        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(-0.5f,0.5f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.5f,0.5f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );


        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.5f,-0.5f,0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );
        getChildObject().add(new Sphere(ColorPalette.EARTH_LAND.getRGBA())
                .inlineTranslateObject(0.5f,0.5f,-0.35f)
                .inlineScaleObject(0.65f, 0.65f, 1f)
                .inlineScaleObjectXYZ(0.6f)
        );

    }


}
