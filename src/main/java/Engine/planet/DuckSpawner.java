package Engine.planet;

import Engine.Curve;
import Engine.Object;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DuckSpawner extends Sphere {
    // spawn duck in periodic time
    private float spawnTime = 500f;
    private float spawnTimer = 0f;
    public DuckSpawner(float[] rgba) {
        super(0.3f,0.3f,0.3f,rgba, "ellipsoid");

        // init decoration as a first child
        initDecoration();
    }

    private void initDecoration() {
        // this is a child containg all of the decoration
        getChildObject().add(new Object(0f,0f,0f,0f));

        // create duck spawner decoration, Minecraft-like but customized
        create6BoxDecoration();
        createSkeletonDecoration();
        create6SmallerBoxDecoration();

    }

    private void create6SmallerBoxDecoration() {
        // similar to the 6 box decoration, but smaller and translate slightly out from the center box
        // front back
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR4.getRGBA(), "box")
                        .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(0.0f, 0.0f, 1.25f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR4.getRGBA(), "box")
                        .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(0.0f, 0.0f, -1.25f)
        );
        // left right
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR4.getRGBA(), "box")
                        .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(1.25f, 0.0f, 0.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR4.getRGBA(), "box")
                        .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(-1.25f, 0.0f, 0.0f)
        );
        // top bot
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR4.getRGBA(), "box")
                        .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(0.0f, 1.25f, 0.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR4.getRGBA(), "box")
                        .inlineScaleObjectXYZ(0.9f)
                .inlineTranslateObject(0.0f, -1.25f, 0.0f)
        );

    }


    private void createSkeletonDecoration() {
        // create tube for connecting all the 6 boxes to the middle
        // front back
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR3.getRGBA(), "tube")
                .inlineScaleObject(0.2f, 0.9f, 0.2f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f, 0.0f, 0.5f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR3.getRGBA(), "tube")
                .inlineScaleObject(0.2f, 0.9f, 0.2f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f, 0.0f, -0.5f)
        );
        // left right
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR3.getRGBA(), "tube")
                .inlineScaleObject(0.2f, 0.9f, 0.2f)
                .inlineRotateObject((float)Math.toRadians(90),0f,0f,1f)
                .inlineTranslateObject(0.5f, 0.0f, 0.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR3.getRGBA(), "tube")
                .inlineScaleObject(0.2f, 0.9f, 0.2f)
                .inlineRotateObject((float)Math.toRadians(90),0f,0f,1f)
                .inlineTranslateObject(-0.5f, 0.0f, 0.0f)
        );
        // top bot
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR3.getRGBA(), "tube")
                .inlineScaleObject(0.2f, 0.9f, 0.2f)
                .inlineTranslateObject(0.0f, 0.5f, 0.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR3.getRGBA(), "tube")
                .inlineScaleObject(0.2f, 0.9f, 0.2f)
                .inlineTranslateObject(0.0f, -0.5f, 0.0f)
        );

    }

    private void create6BoxDecoration() {
        // create 6 boxed on left right top bot front back
        // front back
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR2.getRGBA(), "box")
                .inlineScaleObjectXYZ(1.5f)
                .inlineTranslateObject(0.0f, 0.0f, 1.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR2.getRGBA(), "box")
                .inlineScaleObjectXYZ(1.5f)
                .inlineTranslateObject(0.0f, 0.0f, -1.0f)
        );
        // left right
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR2.getRGBA(), "box")
                .inlineScaleObjectXYZ(1.5f)
                .inlineTranslateObject(1.0f, 0.0f, 0.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR2.getRGBA(), "box")
                .inlineScaleObjectXYZ(1.5f)
                .inlineTranslateObject(-1.0f, 0.0f, 0.0f)
        );
        // top bot
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR2.getRGBA(), "box")
                .inlineScaleObjectXYZ(1.5f)
                .inlineTranslateObject(0.0f, 1.0f, 0.0f)
        );
        getChildObject().get(0).getChildObject().add(new Sphere(ColorPalette.DUCK_SPAWNER_COLOR2.getRGBA(), "box")
                .inlineScaleObjectXYZ(1.5f)
                .inlineTranslateObject(0.0f, -1.0f, 0.0f)
        );

    }

    public void runSpawnTimer() {
        // spawn duck in periodic time
        if (spawnTimer >= spawnTime) {
            // spawn duck
            spawnDuck();

            // reset spawn timer
            spawnTimer = 0f;
        }
        spawnTimer += 1;
    }

    private void spawnDuck() {
        if (getChildObject().size() > 5){
            getChildObject().remove(1);
        }
        getChildObject().add(1,new Duck()
                .inlineScaleObjectXYZ(0.1f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineTranslateObject(getCenterPoint().x, getCenterPoint().y, getCenterPoint().z)
        );
    }

}
