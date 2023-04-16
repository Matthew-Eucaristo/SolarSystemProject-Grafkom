import Engine.*;
import Engine.Object;
import Engine.Window;
import Engine.planet.*;
import Engine.planet.Star;
import org.lwjgl.opengl.GL;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    // init window
    private Window window = new Window(1920, 1080, "Solar System");

    // init objects
    private ArrayList<Object> objects = new ArrayList<Object>();

    // init mouseinput
    private MouseInput mouseInput;

    private float atomRingScale = 1f;

    private float atomBallRotationX = 0f;

    private float atomBallRotationY = 0f;

    private float atomBallRotationZ = 0f;

    private boolean swATM = false;

    Projection projection = new Projection(window.getWidth(), window.getHeight());

    Camera camera = new Camera();

    // for sound
    public static Clip mainMusicClip, atomOrbitMusic, duckSound;


    public void init() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        window.init();
        GL.createCapabilities(); // ini harus di atas
        mouseInput = window.getMouseInput();
        camera.setPosition(0, 0, 2.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));

        // urusan sound
        initMainMusic();

        // implement semua object disini
        objects.add(new Sun(ColorPalette.SUN_COLOR.getRGBA()).inlineScaleObjectXYZ(0.8f)); // pusat (parent utama)

        objects.get(0).getChildObject().add(new Earth(ColorPalette.EARTH_SEA.getRGBA()).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(-2f, 0f, 0f)); // ini buat bumi

        objects.get(0).getChildObject().get(0).getChildObject().add(new Moon(ColorPalette.MOON_COLOR.getRGBA()).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(-1f, 0f, 0f)); // ini buat bulan

        objects.get(0).getChildObject().add(new Saturn(ColorPalette.SATURN_COLOR_1.getRGBA())
                .inlineScaleObjectXYZ(0.4f)
                .inlineTranslateObject(2f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(90), 1, 0, 0)); // ini buat saturnus

        objects.add(new Star(ColorPalette.STAR_COLOR.getRGBA()).inlineScaleObjectXYZ(0.2f)
                .inlineTranslateObject(1.5f, 1f, 0.5f)); // ini buat bintang

        objects.get(0).getChildObject().add(new Atom(ColorPalette.ATOM_COLOR.getRGBA(), atomRingScale, atomBallRotationX, atomBallRotationY).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(1f, 0.5f, 0.5f)); // ini buat atom

        objects.add(new Duck()
                .inlineScaleObjectXYZ(0.1f)
                .inlineTranslateObject(-1f,1f,1f)); // ini untuk bebek

        objects.add(new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
                .inlineScaleObject(0.1f,0.2f,0.1f)
                .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
                .inlineTranslateObject(0.5f,1f,1f)); // ini buat spaceship







        objects.add(new Quaso(ColorPalette.QUASO_COLOR.getRGBA())
                .inlineScaleObjectXYZ(0.1f)
                        .inlineScaleObject(1f,3f,1f)
                .inlineRotateObject((float) Math.toRadians(90),1f,0f,0f)
                        .inlineRotateObject((float) Math.toRadians(90),0f,1f,0f)
                .inlineTranslateObject(0.9f, -1.9f, 0.7f)); // ini buat quaso











        objects.get(0).getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA(),"ellipsoid")
                .inlineScaleObjectXYZ(0)
        );
        Sun sun = (Sun) objects.get(0);
        sun.surfaceDetail();
    }

    private void initAtomOrbit() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (atomOrbitMusic != null && atomOrbitMusic.isRunning()) return;

        if (atomOrbitMusic != null && atomOrbitMusic.isOpen()) {
            atomOrbitMusic.close();
        }

        AudioInputStream  audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/hola.wav").getAbsoluteFile());
        atomOrbitMusic = AudioSystem.getClip();

        atomOrbitMusic.open(audioInputStream);
        FloatControl gainControl = (FloatControl) atomOrbitMusic.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(0.5f);

        System.out.println(atomOrbitMusic.getFrameLength() + "|" + atomOrbitMusic.getFramePosition());
        atomOrbitMusic.start();

    }
    private static void initMainMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (mainMusicClip != null && mainMusicClip.isOpen()) {
            mainMusicClip.close();
        }

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/music.wav").getAbsoluteFile());
        mainMusicClip = AudioSystem.getClip();

        mainMusicClip.open(audioInputStream);
        FloatControl gainControl = (FloatControl) mainMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(0.5f);

        System.out.println(mainMusicClip.getFrameLength() + "|" + mainMusicClip.getFramePosition());
        mainMusicClip.start();
    }

    public void input() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        // ini buat input handle dari mouse
        // ini nanti rencana untuk play animation dari class" untuk run method animation nya


        // ini yang handle input dari keyboard
        if (window.isKeyPressed(GLFW_KEY_Y)){
            Quaso quaso = (Quaso) objects.get(4);
            quaso.eatQuaso();
        }

        // ini buat rotate all objects
        if (window.isKeyPressed(GLFW_KEY_F)) {
            // revolusi matahari
            objects.get(0).rotateObject((float) Math.toRadians(1), 0, 1, 0);


            // rotate earth untuk rotate semua child earth (bulan)
            Earth earth = (Earth) objects.get(0).getChildObject().get(0);
            earth.selfRotate((float)Math.toRadians(0.25),1f,1f,1f);

            // rotate Quaso
            Quaso quaso = (Quaso) objects.get(4);
            quaso.rotateObject((float)Math.toRadians(0.25),-1f,1f,1f);
            quaso.selfRotate((float)Math.toRadians(.85),1f,1f,1f);

            // rotate Saturn
            Saturn saturn = (Saturn) objects.get(0).getChildObject().get(1);
            saturn.selfRotate((float) Math.toRadians(1), 0, 1, 0);

        }


        // function atom
        if (window.isKeyPressed(GLFW_KEY_T)) {
            if (atomRingScale > 15) {
                swATM = false;
            } else if (atomRingScale < -15) {
                swATM = true;
            }
            if (swATM == true) {
                atomRingScale++;
            } else {
                atomRingScale--;
            }
            if (atomBallRotationX > 360) {
                atomBallRotationX = 0;
            }
            atomBallRotationX = (float) (100 * Math.cos(Math.toRadians(atomBallRotationX)) / 100);
//            System.out.println(atomBallRotationX);
            if (atomBallRotationY > 360) {
                atomBallRotationY = 0;
            }
            atomBallRotationY = (float) (100 * Math.sin(Math.toRadians(atomBallRotationY)) / 100);
//            objects.get(0).getChildObject().get(2).setCenterPoint(xyzAtom);
//            xyzAtom = objects.get(0).getChildObject().get(2).getCenterPoint();
//            sou
            float atomX = objects.get(0).getChildObject().get(2).getCenterPoint().get(0);
            float atomY = objects.get(0).getChildObject().get(2).getCenterPoint().get(1);
            float atomZ = objects.get(0).getChildObject().get(2).getCenterPoint().get(2);
            objects.get(0).getChildObject().remove(2);
            objects.get(0).getChildObject().add(2,new Atom(ColorPalette.ATOM_COLOR.getRGBA(), atomRingScale, atomBallRotationX, atomBallRotationY).inlineScaleObjectXYZ(0.3f)
                    .inlineTranslateObject(atomX, atomY, atomZ));

       }
        if (window.isKeyPressed(GLFW_KEY_C)) {
            // rotasi atom kecil


            // update the atom center point
            objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(-objects.get(0).getChildObject().get(2).getCenterPoint().get(0),-objects.get(0).getChildObject().get(2).getCenterPoint().get(1),-objects.get(0).getChildObject().get(2).getCenterPoint().get(2));
            objects.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float) Math.toRadians(1),0,0,1);
            objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(objects.get(0).getChildObject().get(2).getCenterPoint().get(0),objects.get(0).getChildObject().get(2).getCenterPoint().get(1),objects.get(0).getChildObject().get(2).getCenterPoint().get(2));

            objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(-objects.get(0).getChildObject().get(2).getCenterPoint().get(0),-objects.get(0).getChildObject().get(2).getCenterPoint().get(1),-objects.get(0).getChildObject().get(2).getCenterPoint().get(2));
            objects.get(0).getChildObject().get(2).getChildObject().get(3).rotateObject((float) Math.toRadians(1),1,0,0);
            objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(objects.get(0).getChildObject().get(2).getCenterPoint().get(0),objects.get(0).getChildObject().get(2).getCenterPoint().get(1),objects.get(0).getChildObject().get(2).getCenterPoint().get(2));

            // init sound
            initAtomOrbit();
        }
        if (window.isKeyReleased(GLFW_KEY_C)) {
            if (atomOrbitMusic != null && atomOrbitMusic.isOpen()) {
                atomOrbitMusic.stop();
            }
        }


        if (window.isKeyPressed(GLFW_KEY_O)) {
            objects.get(0).getChildObject().get(2).translateObject(-objects.get(0).getChildObject().get(2).getCenterPoint().get(0),-objects.get(0).getChildObject().get(2).getCenterPoint().get(1),-objects.get(0).getChildObject().get(2).getCenterPoint().get(2));
            objects.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(1),0,0,1);
            objects.get(0).getChildObject().get(2).translateObject(objects.get(0).getChildObject().get(2).getCenterPoint().get(0),objects.get(0).getChildObject().get(2).getCenterPoint().get(1),objects.get(0).getChildObject().get(2).getCenterPoint().get(2));
        }

        if (window.isKeyPressed(GLFW_KEY_P)) {
            float spaceshipX = objects.get(3).getCenterPoint().get(0);
            float spaceshipY = objects.get(3).getCenterPoint().get(1);
            float spaceshipZ = objects.get(3).getCenterPoint().get(2);
            objects.remove(3);
            objects.add(3,new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
                    .inlineScaleObject(0.1f,0.2f,0.1f)
                    .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
                    .inlineTranslateObject(spaceshipX - 0.02f,spaceshipY,spaceshipZ));
            }

        if (window.isKeyPressed(GLFW_KEY_R)) {
            Saturn saturn = (Saturn) objects.get(0).getChildObject().get(1);
            saturn.rotateRings();
        }

        // ini buat bebek ku jalan
        if (window.isKeyPressed(GLFW_KEY_I)){
            objects.get(2).translateObject(0,0.01f,0);
            initDuckAniSound();
        }
        if (window.isKeyPressed(GLFW_KEY_K)){
            objects.get(2).translateObject(0,-0.01f,0);
            initDuckAniSound();
        }
        if (window.isKeyPressed(GLFW_KEY_J)){
            objects.get(2).translateObject(-0.01f,0,0);
            initDuckAniSound();
        }
        if (window.isKeyPressed(GLFW_KEY_L)){
            objects.get(2).translateObject(0.01f,0,0);
            initDuckAniSound();
        }

        // ini buat yang WASD
        float cameraSpeed = 0.01f;
        float rotateSpeedInDegrees = 1f;
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveUp(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveDown(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(cameraSpeed);
        }

        // ini buat Q dan E buat rotate
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            camera.addRotation(0, (float) Math.toRadians(-1 * rotateSpeedInDegrees));
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            camera.addRotation(0, (float) Math.toRadians(rotateSpeedInDegrees));
        }

        // ini buat zoom in dan out, also arrow left and right
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveForward(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveBackwards(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.addRotation((float) Math.toRadians(-1 * rotateSpeedInDegrees), 0);
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.addRotation((float) Math.toRadians(rotateSpeedInDegrees), 0);
        }

        // ini pake scroll wheel for move forward and backwards
        if (mouseInput.getScroll().y > 0) {
            camera.moveForward(cameraSpeed * 2);
        } else if (mouseInput.getScroll().y < 0) {
            camera.moveBackwards(cameraSpeed * 2);
        }
        mouseInput.resetScroll();

        // rotate the camera using page up and down, rotate the Z axis
        if (window.isKeyPressed(GLFW_KEY_PAGE_UP)) {
            camera.addRotation(0, 0, (float) Math.toRadians(-1 * rotateSpeedInDegrees));
        }
        if (window.isKeyPressed(GLFW_KEY_PAGE_DOWN)) {
            camera.addRotation(0, 0, (float) Math.toRadians(rotateSpeedInDegrees));
        }

    }

    private void initDuckAniSound() {

        if (duckSound != null && duckSound.isRunning()) {
            return;
        }

        if (duckSound != null && duckSound.isOpen()) {
            duckSound.close();
        }


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/Quack_Sound_Effect.wav").getAbsoluteFile());
            duckSound = AudioSystem.getClip();
            duckSound.open(audioInputStream);

            FloatControl gainControl = (FloatControl) duckSound.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0.5f);

            System.out.println(duckSound.getFrameLength() + "|" + duckSound.getFramePosition());
            duckSound.loop(0);

            duckSound.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


    }


    public void loop() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        while (window.isOpen()) {
            window.update(); // ini update isi window
            glClearColor(ColorPalette.SPACE.getR(),
                    ColorPalette.SPACE.getB(),
                    ColorPalette.SPACE.getA(),
                    ColorPalette.SPACE.getA()
            ); // background asal hitam

            GL.createCapabilities(); // ini harus di atas
            input(); // terima input dari mouse

            // draw objects
            for (Object object : objects) {
                object.draw(camera, projection);
            }

            // update all the center point to the correct one
            for (Object object : objects) {
                object.updateCenterPoint();
            }


            // restore state
            glDisableVertexAttribArray(0);

            // poll for window events
            // the key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        init();
        loop();

        // terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        new Main().run();
    }

}
