package Engine.planet;

import Engine.Curve;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class Sun extends Sphere {
    public Sun(float[] rgba) {
        super(rgba);

        // start the solar rays
        initSolarRays();
    }

    private void initSolarRays(){
        // create Solar Rays
        // create Random variables for the multiplier

        Random random = new Random();
        float multiplier = random.nextFloat() * 1.5f + 1.5f;
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
        createSolarRays(multiplier);
    }


    private void createSolarRays(float multiplier){
        // create Solar Rays
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
        point2.x = point2.x * multiplier;
        point2.y = point2.y * multiplier;
        point2.z = point2.z * multiplier;

        // for the third point
        Vector3f point3 = getVertices().get(choices[2]);
        point3.x = point3.x * multiplier;
        point3.y = point3.y * multiplier;
        point3.z = point3.z * multiplier;

        // for the fourth point
        Vector3f point4 = getVertices().get(choices[3]);
        point4.x = point4.x * multiplier;
        point4.y = point4.y * multiplier;
        point4.z = point4.z * multiplier;

        // for the fifth point
        Vector3f point5 = getVertices().get(choices[4]);

        // create curve
        getChildObject().add(new Curve(List.of(new Vector3f[]{point1, point2, point3, point4, point5}),
                ColorPalette.SUN_RAYS.getRGBA()
        ));
    }
}
