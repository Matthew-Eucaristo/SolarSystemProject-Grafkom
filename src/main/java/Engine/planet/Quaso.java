package Engine.planet;

import Engine.Sphere;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Quaso extends Sphere {
    private Clip clipEat, clipAte;
    public Quaso(float[] rgba) {
        super(rgba, "tube");
        initQuasoBody();
    }

    private void initQuasoBody() {
        getChildObject().add(new Sphere(ColorPalette.QUASO_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.5f)
                        .inlineScaleObject(0.5f,0.5f,0.1f)
                .inlineRotateObject((float) Math.toRadians(90), 1f, 0f, 0f)
                        .inlineRotateObject((float) Math.toRadians(20), 1f, 0f, 0f)
                .inlineTranslateObject(0.0f, 1.0f, 0.40f)
        );
        getChildObject().add(new Sphere(ColorPalette.QUASO_COLOR.getRGBA(), "ellipticparaboloid")
                .inlineScaleObjectXYZ(0.5f)
                .inlineScaleObject(0.5f,0.5f,0.1f)
                .inlineRotateObject((float) Math.toRadians(90), 1f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(20), 1f, 0f, 0f)
                        .inlineRotateObject((float) Math.toRadians(180), 0f, 0f, 1f)
                .inlineTranslateObject(0.0f, -1.0f, 0.40f)
        );
    }

    public void eatQuaso() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (!getChildObject().isEmpty()) {
            // init sound eat sound
            if (clipEat != null && clipEat.isOpen()) {
                clipEat.close();
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/Quaso.wav"));
            clipEat = AudioSystem.getClip();

            clipEat.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clipEat.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(1.0f);

            System.out.println(clipEat.getFrameLength() + "|" + clipEat.getFramePosition());
            clipEat.start();
            getChildObject().remove(0);
        } else {
            // init Ate sound
            if (clipAte != null && clipAte.isOpen()) {
                clipAte.close();
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/AAAAUUUGHHHH_Meme_Sound_Effect.wav"));
            clipAte = AudioSystem.getClip();

            clipAte.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clipAte.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(1.0f);

            System.out.println(clipAte.getFrameLength() + "|" + clipAte.getFramePosition());
            clipAte.start();

        }

    }

}
