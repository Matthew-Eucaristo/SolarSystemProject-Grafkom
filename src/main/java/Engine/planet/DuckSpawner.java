package Engine.planet;

import Engine.Object;
import Engine.Sphere;

import java.util.List;

public class DuckSpawner extends Sphere {
    // spawn duck in periodic time
    private float spawnTime = 500f;
    private float spawnTimer = 0f;
    public DuckSpawner(float[] rgba) {
        super(rgba, "ellipsoid");
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
            getChildObject().remove(0);
        }
        getChildObject().add(new Duck()
                .inlineScaleObjectXYZ(0.1f)
                .inlineRotateObject((float)Math.toRadians(180),0f,1f,0f)
                .inlineTranslateObject(getCenterPoint().x, getCenterPoint().y, getCenterPoint().z)
        );
    }

}
