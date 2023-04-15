package Engine.planet;

import Engine.Circle;
import Engine.Sphere;

public class SpaceShip extends Sphere {
    public SpaceShip(float[] rgba, String type) {
        super(rgba, type);
        createBodyPart();
    }
    private void createBodyPart(){
        //ini moncongnya
        getChildObject().add(new Sphere(ColorPalette.SPACESHIP_HEAD.getRGBA(),"ellipticparaboloid")
                .inlineScaleObject(0.16f, 0.16f, 0.03f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f,1.1f,0.0f));
        getChildObject().add(new Sphere(ColorPalette.SPACESHIP_HEAD.getRGBA(),"tube")
                .inlineScaleObject(1f, 0.7f, 1f)
                .inlineRotateObject((float)Math.toRadians(90),0f,1f,0f)
                .inlineTranslateObject(0f,-0.85f,0f));
        getChildObject().add(new Sphere(ColorPalette.SPACESHIP_EXHAUST.getRGBA(),"ellipticcone")
                .inlineScaleObject(0.10f, 0.1f, 0.10f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0f,-1f,0f));
        getChildObject().add(new Sphere(ColorPalette.SPACESHIP_BODY.getRGBA(),"ellipticparaboloid")
                .inlineScaleObject(0.3f, 0.06f, 0.03f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f,-0.6f,0.0f));
        getChildObject().add(new Sphere(ColorPalette.SPACESHIP_HEAD.getRGBA(),"ball")
                .inlineScaleObject(0.4f,0.4f,0.3f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f,0.2f,0.45f));
        getChildObject().add(new Sphere(ColorPalette.SPACESHIP_GLASS.getRGBA(),"ball")
                .inlineScaleObject(0.35f,0.35f,0.25f)
                .inlineRotateObject((float)Math.toRadians(90),1f,0f,0f)
                .inlineTranslateObject(0.0f,0.2f,0.51f));
//        getChildObject().add(new Circle(0,0,750 ,500,0,255,255,240,255,360,"halfcircle")
//                .inlineScaleObject(0.12f, 0.1f, 0.12f)
//                .inlineRotateObject((float)Math.toRadians(0),1f,0f,0f)
//                .inlineTranslateObject(0f,-1.2f,0f));
    }
}
