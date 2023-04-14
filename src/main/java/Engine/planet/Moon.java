package Engine.planet;

import Engine.Sphere;

public class Moon extends Sphere {
    public Moon(float[] rgba) {
        super(rgba);
    }

    public void orbitEarth(Earth earth) {
        // Calculate the translation vector from the center of the earth to the center of the moon
        float offsetX = earth.getCenterPoint().x;
        float offsetY = earth.getCenterPoint().y;
        float offsetZ = earth.getCenterPoint().z;

        // Translate the mon to the center of the earth
        translateObject(-offsetX, -offsetY, -offsetZ);

        // Rotate the moon around the desired Axis
        float rotationAmount = (float) Math.toRadians(1);
        rotateObject(rotationAmount, 0f, 0f, 1f);

        // Translate the moon back to its original position
        translateObject(offsetX, offsetY, offsetZ);
    }


}
