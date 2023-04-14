package Engine.planet;

import Engine.Circle;
import Engine.Curve;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;

public class Atom extends Sphere {


    public Atom(float[] rgba,float atomRingScale, float atomBallRotationX, float atomBallRotationY) {
        super(rgba);
        boolean swATM = false;
        boolean swBLL = false;

        createCircle(countAtomScale(atomRingScale,swATM));
        createBall(atomRingScale,atomBallRotationX,atomBallRotationY);
        createBall(atomRingScale,atomBallRotationX,atomBallRotationY);
//        getChildObject().get(1).inlineTranslateObject(countBallRotationX(atomBallRotation,100),+ countBallRotationY(atomBallRotation,100),0f);
//        getChildObject().get(2).inlineTranslateObject(countBallRotationX(atomBallRotation,100),+ countBallRotationY(atomBallRotation,100),0f);
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
        getChildObject().add(new Circle(0,0,100 - atomRingScale ,100 - atomRingScale,0,72,0,130,255,360,1));
        getChildObject().add(new Circle(0,0,100 - atomRingScale ,100 - atomRingScale,0,72,0,130,255,360,2));

    }
    private float countAtomScale(float atomRingScale, boolean swATM){
        if (atomRingScale > 15){
            swATM = false;
        }
        else if(atomRingScale < -15){
            swATM = true;
        }
        if(swATM == true){
            atomRingScale++;
        }
        else {
            atomRingScale--;
        }
        return atomRingScale;
    }
    private float countBallRotationX(float atomBallRotationX,float radiusX){
        if (atomBallRotationX > 360){
            atomBallRotationX = 0;
        }
        atomBallRotationX = (float) (radiusX * Math.cos(Math.toRadians(atomBallRotationX))/ 100);
        return atomBallRotationX;
    }
    private float countBallRotationY(float atomBallRotationY,float radiusY){
        if (atomBallRotationY > 360){
            atomBallRotationY = 0;
        }
        atomBallRotationY = (float) (radiusY * Math.sin(Math.toRadians(atomBallRotationY))/ 100);
        return atomBallRotationY;
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
    private void createBall(float atomRingScale,float atomBallRotationX, float atomBallRotationY){
        getChildObject().add(new Sphere(ColorPalette.EARTH_LIGHTER_LAND.getRGBA())
                .inlineScaleObjectXYZ(0.2f)
                .inlineTranslateObject(1f - atomRingScale * 0.01f ,countBallRotationY(atomBallRotationY,100),0f)

        );
        System.out.println(countBallRotationX(atomBallRotationX,100));
                System.out.println(countBallRotationX(atomBallRotationY,100));
        getChildObject().add(new Sphere(ColorPalette.SUN_COLOR.getRGBA())
                .inlineScaleObjectXYZ(0.2f)
                .inlineTranslateObject(0f,1f - atomRingScale * 0.01f,countBallRotationX(atomBallRotationX,100) * 0.01f)

        );

//        System.out.println(countBallRotationX(atomBallRotation,100));
//        System.out.println(atomBallRotation);
    }

}
