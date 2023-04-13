package Engine.planet;

import Engine.Circle;
import Engine.Curve;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;

public class Atom extends Sphere {


    public Atom(float[] rgba,float atomRingScale) {
        super(rgba);
        boolean sw = false;

        createCircle(countAtomScale(atomRingScale,sw));

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
    private void createCircle(float atomRingScale){
        getChildObject().add(new Circle(0,0,100 - atomRingScale,100 - atomRingScale,0,72,0,130,255,360,2));
        getChildObject().add(new Circle(0,0,100 - atomRingScale,100 - atomRingScale,0,72,0,130,255,360,1));
    }
    private float countAtomScale(float atomRingScale, boolean sw){
        if (atomRingScale > 15){
            sw = false;
        }
        else if(atomRingScale < -15){
            sw = true;
        }
        if(sw == true){
            atomRingScale++;
        }
        else {
            atomRingScale--;
        }
        return atomRingScale;
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

}
