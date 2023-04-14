package Engine.planet;

import Engine.Curve;
import Engine.Sphere;
import org.joml.Vector3f;

import java.util.List;
import java.util.Random;

public class Sun extends Sphere {
    public Sun(float[] rgba) {
        super(rgba);
//        surfaceDetail();
    }
    public void surfaceDetail(){
        generateFlare();
        generateFlare();
        generateFlare();
        generateFlare();
        generateFlare();
        generateFlare();
        createBlackSpots();

    }
    private void createBlackSpots(){
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//1
                .inlineTranslateObject(0.5f,0.15f,0.2f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                //Y buat stretch vertikal, X buat stretch horizontal, Z buat letak
                // (-) akan stretch ke kiri
                .inlineScaleObjectXYZ(0.5f) //scaling size
        );
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//2
                .inlineTranslateObject(0.2f,0.15f,0.2f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.5f)
        );

        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//3
                .inlineTranslateObject(-0.5f,0.15f,0.25f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.5f)
        );
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//4
                .inlineTranslateObject(-0.5f,0.15f,0.25f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.5f)
                .inlineRotateObject((float)Math.toRadians(-35),0f,0f,1f)
        );
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//5
                .inlineTranslateObject(-0.5f,0.15f,0.25f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.5f)
                .inlineRotateObject((float)Math.toRadians(255),0f,0f,1f)
        );
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//6
                .inlineTranslateObject(-0.5f,0.15f,0.25f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.5f)
                .inlineRotateObject((float)Math.toRadians(-255),0f,0f,-1f)
        );
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//7
                .inlineTranslateObject(-0.5f,-0.3f,-0.25f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.5f)

        );
        getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA())//7
                .inlineTranslateObject(-0.5f,-0.8f,-0.25f)
                .inlineScaleObject(-1.0f, 0.5f, -0.9f)
                .inlineScaleObjectXYZ(0.4f)

        );
    }

    public void generateFlare(){
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
        point4.x = point4.x * 1.4f;
        point4.y = point4.y * 1.4f;
        point4.z = point4.z * 1.4f;

        // for the fifth point
        Vector3f point5 = getVertices().get(choices[4]);

        // create curve
        getChildObject().add(new Curve(List.of(new Vector3f[]{point1, point2, point3, point4, point5}),
                ColorPalette.SOLAR_FLARE.getRGBA()
        ));
    }
}
