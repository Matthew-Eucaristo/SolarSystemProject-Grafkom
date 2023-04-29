import Engine.*;
import Engine.Object;
import Engine.Window;
import Engine.planet.*;
import Engine.planet.Star;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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

    private float flameX = 0,flameY,flameZ;

    private float flameJetPack = 0;

    private boolean flameMovement = true;

    private float spaceshipX,spaceshipY,spaceshipZ;

    private boolean swATM = false;

    Projection projection = new Projection(window.getWidth(), window.getHeight());

    Camera camera = new Camera();
    private boolean isLost = false;

    // for sound
    public static Clip mainMusicClip, atomOrbitMusic, duckSound,spaceshipSound, loseMusic;

    private Random random = new Random();
    private boolean initialized = false;
    private int loseTimer = 0;


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

        objects.get(0).getChildObject().get(0).getChildObject().add(new Satelite(ColorPalette.SATELITE_MAIN_COLOR.getRGBA()).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(-1f, 0f, 0f)); // ini buat satelite

        objects.get(0).getChildObject().add(new Saturn(ColorPalette.SATURN_COLOR_1.getRGBA())
                .inlineScaleObjectXYZ(0.4f)
                .inlineTranslateObject(2f, 0f, 0f)
                .inlineRotateObject((float) Math.toRadians(90), 1, 0, 0)); // ini buat saturnus

        objects.add(new Star(ColorPalette.STAR_COLOR.getRGBA()).inlineScaleObjectXYZ(0.03f)
                .inlineTranslateObject(1.5f, 1f, 0.5f)); // ini buat bintang

        objects.get(0).getChildObject().add(new Atom(ColorPalette.ATOM_COLOR.getRGBA(), atomRingScale, atomBallRotationX, atomBallRotationY).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(1f, 0.5f, 0.5f)); // ini buat atom

        objects.add(new DuckSpawner(ColorPalette.DUCK_SPAWNER_COLOR.getRGBA())
                .inlineScaleObjectXYZ(0.8f)
                .inlineTranslateObject(-10f,1f,1f)); // ini untuk bebek

        objects.add(new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
                        .inlineScaleObjectXYZ(1.2f)
                .inlineScaleObject(0.1f,0.2f,0.1f)
                .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
                .inlineTranslateObject(6.5f,1f,1f)); // ini buat spaceship

        objects.add(new Object(255f,255f,255f,255f)); // place holder


        objects.add(new Laser(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
                .inlineScaleObject(0.02f,0.03f,0.02f)
                .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
                .inlineTranslateObject(6.5f,1f,1f));

        objects.add(new Astronaut(ColorPalette.ASTRONAUT_SUIT.getRGBA(),"ellipsoid")
                        .inlineScaleObjectXYZ(5f)
                        .inlineRotateObject((float) Math.toRadians(45),1f,0f,0f)
                .inlineTranslateObject(0f,6f,-70000f));








        objects.get(0).getChildObject().add(new Sphere(ColorPalette.SUN_SPOTS.getRGBA(),"ellipsoid")
                .inlineScaleObjectXYZ(0)
        );
        Sun sun = (Sun) objects.get(0);
        sun.surfaceDetail();

        // ini hanya ending buat scaling dasar semua planet
        objects.get(0).inlineScaleObjectXYZ(1.5f);
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
        gainControl.setValue(-10.5f);
        mainMusicClip.loop(99);

        mainMusicClip.start();
    }

    public void input() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        // ini buat input handle dari mouse
        // ini nanti rencana untuk play animation dari class" untuk run method animation nya

        // function atom
        if (window.isKeyPressed(GLFW_KEY_T)&& !window.isKeyPressed(GLFW_KEY_F)) {
            if (atomRingScale > 15) {
                swATM = false;
            } else if (atomRingScale < -15) {
                swATM = true;
            }
            if (swATM) {
                atomRingScale++;
            } else {
                atomRingScale--;
            }
            if (atomBallRotationX > 360) {
                atomBallRotationX = 0;
            }
            atomBallRotationX = (float) (100 * Math.cos(Math.toRadians(atomBallRotationX)) / 100);
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

        if (window.isKeyPressed(GLFW_KEY_T) && window.isKeyPressed(GLFW_KEY_F)){
            if (atomRingScale > 15) {
                swATM = false;
            } else if (atomRingScale < -15) {
                swATM = true;
            }
            if (swATM) {
                atomRingScale++;
            } else {
                atomRingScale--;
            }
            if (atomBallRotationX > 360) {
                atomBallRotationX = 0;
            }
            atomBallRotationX = (float) (100 * Math.cos(Math.toRadians(atomBallRotationX)) / 100);
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
            objects.get(0).getChildObject().add(2,new Atom(ColorPalette.ATOM_COLOR.getRGBA(), atomRingScale, atomBallRotationX, atomBallRotationY)
                    .inlineScaleObjectXYZ(0.3f)
                    .inlineTranslateObject(atomX, atomY, atomZ).inlineRotateObject((float) Math.toRadians(1),0,1,0));
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

            Saturn saturn = (Saturn) objects.get(0).getChildObject().get(1);
            saturn.moveTophat();

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



        // update spaceship flame
        if (window.isKeyReleased(GLFW_KEY_P)){
            if(flameX > -0.02){
                objects.get(3).getChildObject().get(6).inlineTranslateObject(-0.001f,0f,0f);
                flameX = flameX - 0.001f;
            }
//            if (spaceshipSound != null && spaceshipSound.isOpen()) {
//                spaceshipSound.stop();
//            }
        }

        if (window.isKeyPressed(GLFW_KEY_9)){
            objects.get(3).translateObject(-objects.get(3).getCenterPoint().get(0),-objects.get(3).getCenterPoint().get(1),-objects.get(3).getCenterPoint().get(2));
            objects.get(3).inlineRotateObject((float) Math.toRadians(1),0,1,0);
            objects.get(3).translateObject(objects.get(3).getCenterPoint().get(0), objects.get(3).getCenterPoint().get(1), objects.get(3).getCenterPoint().get(2));

            objects.get(3).inlineRotateObject((float) Math.toRadians(-1),0,1,0);

        }

        // ini buat nembak nembak spaceshipnya
        if (window.isKeyPressed(GLFW_KEY_Z)){
            objects.get(5).getChildObject().add(new Sphere(ColorPalette.LASER_COLOR.getRGBA(), "tube")
                    .inlineScaleObject(0.02f,0.03f,0.02f)
                    .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
                    .inlineTranslateObject(objects.get(5).getCenterPoint().x,objects.get(5).getCenterPoint().y,objects.get(5).getCenterPoint().z));

            // delete the first laser if max
            if (objects.get(5).getChildObject().size() > 200){
                // delete the first laser
                objects.get(5).getChildObject().remove(0);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_R)) {
            Saturn saturn = (Saturn) objects.get(0).getChildObject().get(1);
            saturn.selfRotate((float) Math.toRadians(1), 0, 1, 0);
            saturn.rotateRings();
            saturn.moveHourglass();
        }

        // ini buat bebek ku jalan
        if (window.isKeyPressed(GLFW_KEY_I)){
            spaceshipX = objects.get(3).getCenterPoint().get(0);
            spaceshipY = objects.get(3).getCenterPoint().get(1);
            spaceshipZ = objects.get(3).getCenterPoint().get(2);

//            objects.remove(3);
//            objects.add(3, new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
//                    .inlineScaleObject(0.1f,0.2f,0.1f)
//                    .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
//                    .inlineTranslateObject(spaceshipX - 0.02f,spaceshipY,spaceshipZ));
            objects.get(3).inlineTranslateObject(0,0.05f,0);
            objects.get(5).inlineTranslateObject(0f,0.05f,0f);
//            flameX = flameX - 0.02f;

            for (Object laser : objects.get(5).getChildObject()) {
                laser.inlineTranslateObject(0f,-0.05f,0f);
            }

            if (flameX == 0){
                flameX = objects.get(3).getChildObject().get(6).getCenterPoint().get(0);
                flameY = objects.get(3).getChildObject().get(6).getCenterPoint().get(1);
                flameZ = objects.get(3).getChildObject().get(6).getCenterPoint().get(2);

            }
            if (flameX < 0.08){
                flameX = flameX + 0.02f;
                objects.get(3).getChildObject().get(6).inlineTranslateObject(
                        0.02f,0,0);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_K)){
            spaceshipX = objects.get(3).getCenterPoint().get(0);
            spaceshipY = objects.get(3).getCenterPoint().get(1);
            spaceshipZ = objects.get(3).getCenterPoint().get(2);

//            objects.remove(3);
//            objects.add(3, new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
//                    .inlineScaleObject(0.1f,0.2f,0.1f)
//                    .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
//                    .inlineTranslateObject(spaceshipX - 0.02f,spaceshipY,spaceshipZ));
            objects.get(3).inlineTranslateObject(0,-0.05f,0);
            objects.get(5).inlineTranslateObject(0,-0.05f,0f);
//            flameX = flameX - 0.02f;

            for (Object laser : objects.get(5).getChildObject()) {
                laser.inlineTranslateObject(0f,0.05f,0f);
            }

            if (flameX == 0){
                flameX = objects.get(3).getChildObject().get(6).getCenterPoint().get(0);
                flameY = objects.get(3).getChildObject().get(6).getCenterPoint().get(1);
                flameZ = objects.get(3).getChildObject().get(6).getCenterPoint().get(2);

            }
            if (flameX < 0.08){
                flameX = flameX + 0.02f;
                objects.get(3).getChildObject().get(6).inlineTranslateObject(
                        0.02f,0,0);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_J)){
            spaceshipX = objects.get(3).getCenterPoint().get(0);
            spaceshipY = objects.get(3).getCenterPoint().get(1);
            spaceshipZ = objects.get(3).getCenterPoint().get(2);
//            objects.remove(3);
//            objects.add(3, new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
//                    .inlineScaleObject(0.1f,0.2f,0.1f)
//                    .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
//                    .inlineTranslateObject(spaceshipX - 0.02f,spaceshipY,spaceshipZ));
            objects.get(3).inlineTranslateObject(-0.05f,0,0);
            objects.get(5).inlineTranslateObject(-0.05f,0f,0f);
//            flameX = flameX - 0.02f;
            for (Object laser : objects.get(5).getChildObject()) {
                laser.inlineTranslateObject(0.05f,0f,0f);
            }

            if (flameX == 0){
                flameX = objects.get(3).getChildObject().get(6).getCenterPoint().get(0);
                flameY = objects.get(3).getChildObject().get(6).getCenterPoint().get(1);
                flameZ = objects.get(3).getChildObject().get(6).getCenterPoint().get(2);

            }
            if (flameX < 0.08){
                flameX = flameX + 0.02f;
                objects.get(3).getChildObject().get(6).inlineTranslateObject(
                        0.02f,0,0);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_L)){
            spaceshipX = objects.get(3).getCenterPoint().get(0);
            spaceshipY = objects.get(3).getCenterPoint().get(1);
            spaceshipZ = objects.get(3).getCenterPoint().get(2);
//            objects.remove(3);
//            objects.add(3, new SpaceShip(ColorPalette.SPACESHIP_BODY.getRGBA(), "tube")
//                    .inlineScaleObject(0.1f,0.2f,0.1f)
//                    .inlineRotateObject((float) Math.toRadians(90),0f,0f,1f)
//                    .inlineTranslateObject(spaceshipX - 0.02f,spaceshipY,spaceshipZ));
            objects.get(3).inlineTranslateObject(0.05f,0,0);
            objects.get(5).inlineTranslateObject(0.05f,0f,0f);
//            flameX = flameX - 0.02f;

            for (Object laser : objects.get(5).getChildObject()) {
                laser.inlineTranslateObject(-0.05f,0f,0f);
            }

            if (flameX == 0){
                flameX = objects.get(3).getChildObject().get(6).getCenterPoint().get(0);
                flameY = objects.get(3).getChildObject().get(6).getCenterPoint().get(1);
                flameZ = objects.get(3).getChildObject().get(6).getCenterPoint().get(2);

            }
            if (flameX < 0.08){
                flameX = flameX + 0.02f;
                objects.get(3).getChildObject().get(6).inlineTranslateObject(
                        0.02f,0,0);
            }
            initSpaceshipAniSound();
        }
        if (window.isKeyReleased(GLFW_KEY_L)){
            if (spaceshipSound != null && spaceshipSound.isOpen()) {
                spaceshipSound.stop();
            }
        }

        //temporary "reset" for saturn
        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            objects.get(0).getChildObject().remove(1);
            objects.get(0).getChildObject().add(1, new Saturn(ColorPalette.SATURN_COLOR_1.getRGBA())
                    .inlineScaleObjectXYZ(0.4f)
                    .inlineTranslateObject(2f, 0f, 0f)
                    .inlineRotateObject((float) Math.toRadians(90), 1, 0, 0));
        }

        // ini buat yang WASD
        float cameraSpeed = 0.1f;
        float rotateSpeedInDegrees = 0.5f;
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

        // ini buat liat atas sama bawah, sama puter z axis
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.addRotation((float) Math.toRadians(rotateSpeedInDegrees), 0);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)){
            camera.addRotation(0, 0, (float) Math.toRadians(rotateSpeedInDegrees));
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.addRotation((float) Math.toRadians(-1 * rotateSpeedInDegrees), 0);
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.addRotation(0, 0, (float) Math.toRadians(-1 * rotateSpeedInDegrees));
        }

        // ini pake scroll wheel for move forward and backwards
        if (mouseInput.getScroll().y > 0) {
            camera.moveForward(cameraSpeed * 2);
        } else if (mouseInput.getScroll().y < 0) {
            camera.moveBackwards(cameraSpeed * 2);
        }
        mouseInput.resetScroll();



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
            gainControl.setValue(-20.5f);

            duckSound.loop(0);

            duckSound.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


    }

    private void initSpaceshipAniSound() {

        if (spaceshipSound != null && spaceshipSound.isRunning()) {
            return;
        }

        if (spaceshipSound != null && spaceshipSound.isOpen()) {
            spaceshipSound.close();
        }


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/Sheesh.wav").getAbsoluteFile());
            spaceshipSound = AudioSystem.getClip();
            spaceshipSound.open(audioInputStream);

            FloatControl gainControl = (FloatControl) spaceshipSound.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-9.5f);


            spaceshipSound.start();
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

            // for Duck Spawn Timer
            DuckSpawner duckSpawner = (DuckSpawner) objects.get(2);
            duckSpawner.runSpawnTimer();
            // for moving the duckspawner
            duckSpawner.executeNewPlaceTimer();
            duckSpawner.executeTravelToNewPlace();

            // for moving the astronaut
            Astronaut astronaut = (Astronaut) objects.get(6);
            astronaut.executeNewPlaceTimer();
            astronaut.executeTravelToNewPlace();

            // for moving the duck
            for (Object child : objects.get(2).getChildObject()) {
                if (!(child instanceof Duck)) {
                    continue;
                }
                Duck duck = (Duck) child;
                duck.inlineTranslateObject(0.01f,0f,0f);
            }
            // for moving the bombs
            for (Object child : objects.get(2).getChildObject()){
                if (!(child instanceof Moon)) {
                    continue;
                }
                Moon moon = (Moon) child;
                moon.inlineTranslateObject(0.01f,0f,0f);
            }

            // update all the center point to the correct one
            for (Object object : objects) {
                object.updateCenterPoint();
            }

            // rotate the duckspawner
            objects.get(2).getChildObject().get(0).selfRotate((float) Math.toRadians(0.1f), 1f, 1f, 1f);

            // for moving lasers
            for (Object laser : objects.get(5).getChildObject()) {
                laser.inlineTranslateObject(-0.08f,0f,0f);
            }

            // for checking the laser collision with the duck
            for (Object laser : objects.get(5).getChildObject()) {
                Iterator<Object> duckIterator = objects.get(2).getChildObject().iterator();
                while (duckIterator.hasNext()) {
                    Object duckObject = duckIterator.next();
                    if (laser.checkCollision(duckObject,0.1f) && duckObject instanceof Duck) {
                        System.out.println("Laser hit the duck");
                        // delete duck
                        duckIterator.remove();
                        initDuckAniSound();
                        break; // exit inner while loop
                    }
                }
            }

            // for checking the bomb (moon) collided with spaceship
            for (Object moon : objects.get(2).getChildObject()) {
                if (!(moon instanceof Moon)) {
                    continue;
                }

                if (moon.checkCollision(objects.get(3), 0.4f)) {

                    // initiate lose method
                    lose();

                    initSpaceshipAniSound();
                    break; // exit inner while loop
                }
            }

            // initialize the screen
            if (!initialized){
                // zoom out the camera with smooth movement
                float acceptedOffset = 0.3f;
                Vector3f cameraTargetPosition = new Vector3f(0,0,12);
                camera.setTargetPosition(cameraTargetPosition);
                camera.updatePosition();

                if (camera.getPosition().z >= (cameraTargetPosition.z -acceptedOffset)){
                    initialized = true;
                    System.out.println("Camera has been initialized");
                }
            }
            // gerak api jetpack
            if(flameJetPack > 1){
                flameMovement = false;
            } else if (flameJetPack < 0.1) {
                flameMovement = true;
            }
            if (flameMovement){
                objects.get(6).getChildObject().get(0).inlineTranslateObject(0f,-0.015f,-0.015f);
                objects.get(6).getChildObject().get(1).inlineTranslateObject(0f,-0.015f,-0.015f);
                flameJetPack = flameJetPack + 0.015f;
            }
            else {
                objects.get(6).getChildObject().get(0).inlineTranslateObject(0f,0.015f,0.015f);
                objects.get(6).getChildObject().get(1).inlineTranslateObject(0f,0.015f,0.015f);
                flameJetPack = flameJetPack - 0.015f;
            }

            // is Lost
            if (isLost){
                // zoom in the camera with smooth movement
                Vector3f cameraTargetPosition = new Vector3f(0,0,1000);
                camera.setTargetPosition(cameraTargetPosition);
                camera.updatePosition();

                // move the astronaut to the center
                objects.get(6).inlineTranslateObject(0f,0f,9.1f);

                loseTimer += 1;
                if (loseTimer > 2650){
                    System.out.println("<---------------------Y-O-U----L-O-S-T--------------------->");
                    System.exit(0);
                }
            }


            // rotasi semua
            // revolusi matahari
            objects.get(0).rotateObject((float) Math.toRadians(0.2), 0, 1, 0);

            // rotate earth untuk rotate semua child earth (bulan)
            Earth earth = (Earth) objects.get(0).getChildObject().get(0);
            earth.selfRotate((float)Math.toRadians(0.15),1f,1f,1f);

            // rotate Saturn
            Saturn saturn = (Saturn) objects.get(0).getChildObject().get(1);
            saturn.selfRotate((float) Math.toRadians(-0.35), 0, 1, 0);
            saturn.moveHourglass();


            // restore state
            glDisableVertexAttribArray(0);

            // poll for window events
            // the key callback above will only be
            // invoked during this call.
            glfwPollEvents();

        }
    }

    private void lose() {
        mainMusicClip.stop();
        initLoseMusic();

        isLost = true;
    }


    private void initLoseMusic() {
        if (loseMusic != null) {
            return;
        }
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/java/assets/sound/lose.wav").getAbsoluteFile());
            loseMusic = AudioSystem.getClip();
            loseMusic.open(audioInputStream);

            FloatControl gainControl = (FloatControl) loseMusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-1.0f);

            System.out.println("Lose music is playing");
            loseMusic.loop(9);

            loseMusic.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
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
