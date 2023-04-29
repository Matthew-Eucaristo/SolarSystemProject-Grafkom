package Engine.planet;

import Engine.Sphere;

public class Star extends Sphere {
    public Star(float[] rgba) {
        super(rgba, "box");
//        Cancer
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(20f, 3f, 0.5f) //kanan
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(0f, -15f, 0.5f) //bawah main star
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-10f, 3f, 0.5f) //kiri pertama
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-20f, 6f, 0.5f) //kiri kedua
        );

        //Virgo
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(0f, 100f, 0.5f) //Core
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(0f, 110f, 0.5f) //Up +1
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-2f, 120f, 0.5f) //Up +2
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-12f, 125f, 0.5f) //Up +2
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-20f, 115f, 0.5f) //Up left
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-15f, 95f, 0.5f) //Down left +1
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-25f, 95f, 0.5f) //Down left +2
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(12f, 90f, 0.5f) //Down right +1
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(25f, 85f, 0.5f) //Down right +2
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-5f, 80f, 0.5f) //Core down +1
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-15f, 75f, 0.5f) //Core down right +1
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-20f, 60f, 0.5f) //Core down right +2
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(5f, 68f, 0.5f) //Core down +1
        );
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(3f, 60f, 0.5f) //Core down right +2
        );

        // this is for decoration only
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-3f, 60f, 0.5f));
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-3f, 60f, -0.5f));
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(-3f, -60f, -0.5f));
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(3f, -60f, 0.5f));
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(3f, -10f, 0.5f));
        getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject(3f, 10f, -0.5f));

//         create more random star on the screen, little far from the planets (sun, earth, etc.)
        for (int i = 0; i < 100; i++) {
            getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject((float) (Math.random() * 1000 - 500), (float) (Math.random() * 1000 - 500), (float) (Math.random() * 1000 - 500)));
        }

        // generate more random star for making the background richer with stars
        for (int i = 0; i < 1000; i++) {
            getChildObject().add(new Sphere(ColorPalette.STAR_COLOR.getRGBA(),"Tube").inlineTranslateObject((float) (Math.random() * 10000 - 5000), (float) (Math.random() * 10000 - 5000), (float) (Math.random() * 10000 - 5000)));
        }

        // generate more random star in background but with bright color
        for (int i = 0; i < 100; i++) {
            getChildObject().add(new Sphere(ColorPalette.STAR_COLOR_BRIGHT.getRGBA(),"Tube").inlineTranslateObject((float) (Math.random() * 10000 - 5000), (float) (Math.random() * 10000 - 5000), (float) (Math.random() * 10000 - 5000)));
        }
    }
}
