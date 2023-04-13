import Engine.*;
import Engine.Object;
import Engine.Curve;
import Engine.Window;
import Engine.planet.*;
import Engine.planet.Star;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.windows.DISPLAY_DEVICE;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    // init window
    private Window window = new Window(1920,1080, "Solar System");

    // init objects
    private ArrayList<Object> objects = new ArrayList<Object>();

    // init mouseinput
    private MouseInput mouseInput;

    private float atomRingScale = 1f;

    private float atomBallRotation = 0f;

    private boolean swATM = false;

    List<Float> xyzAtom;

    Projection projection = new Projection(window.getWidth(),window.getHeight());

    Camera camera = new Camera();

    public void init(){
        window.init();
        GL.createCapabilities(); // ini harus di atas
        mouseInput = window.getMouseInput();
        camera.setPosition(0,0,2.5f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(0.0f));

        // implement semua object disini
        objects.add(new Sun(ColorPalette.SUN_COLOR.getRGBA()).inlineScaleObjectXYZ(0.8f)); // pusat (parent utama)

        objects.get(0).getChildObject().add(new Earth(ColorPalette.EARTH_SEA.getRGBA()).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(-2f,0f,0f)); // ini buat bumi

        objects.get(0).getChildObject().get(0).getChildObject().add(new Moon(ColorPalette.MOON_COLOR.getRGBA()).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(-1f,0f,0f)); // ini buat bulan

        objects.get(0).getChildObject().add(new Saturn(ColorPalette.SATURN_COLOR_1.getRGBA()).inlineScaleObjectXYZ(0.6f)
                .inlineTranslateObject(1.5f,0f,0f)); // ini buat saturnus

        objects.add(new Star(ColorPalette.STAR_COLOR.getRGBA()).inlineScaleObjectXYZ(0.2f)
                .inlineTranslateObject(1.5f,1f,0.5f)); // ini buat bintang

        objects.get(0).getChildObject().add(new Atom(ColorPalette.ATOM_COLOR.getRGBA(),atomRingScale,atomBallRotation).inlineScaleObjectXYZ(0.3f)
                .inlineTranslateObject(1f,0.5f,0.5f)); // ini buat atom
        
    }

    public void input(){
        // ini buat input handle dari mouse
        // ini nanti rencana untuk play animation dari class" utnuk run method animation nya


        // ini yang handle input dari keyboard
        if(window.isKeyPressed(GLFW_KEY_F)){
            objects.get(0).rotateObject((float)Math.toRadians(1),0f,1f,0f);
        }
        if(window.isKeyPressed(GLFW_KEY_M)){
            objects.get(0).getChildObject().get(0).getChildObject().get(12).rotateObject((float)Math.toRadians(1),0f,1f,1f);
        }
        if(window.isKeyPressed(GLFW_KEY_T)){
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
            if (atomBallRotation > 360){
                atomBallRotation = 0;
            }
            atomBallRotation = (float) (100 * Math.cos(Math.toRadians(atomBallRotation))/ 100);
            if (atomBallRotation > 360){
                atomBallRotation = 0;
            }
            atomBallRotation = (float) (100 * Math.sin(Math.toRadians(atomBallRotation))/ 100);
//            xyzAtom.add(1f);
//            xyzAtom.add(0f);
//            xyzAtom.add(0f);
//            objects.get(0).getChildObject().get(2).setCenterPoint(xyzAtom);
//            xyzAtom = objects.get(0).getChildObject().get(2).getCenterPoint();
//            System.out.println(xyzAtom.get(0));
            objects.get(0).getChildObject().remove(2);
            objects.get(0).getChildObject().add(new Atom(ColorPalette.ATOM_COLOR.getRGBA(),atomRingScale,atomBallRotation).inlineScaleObjectXYZ(0.3f)
                    .inlineTranslateObject(1f,0.5f,0.5f));
//            System.out.println(atomRingScale);
//            objects.get(0).getChildObject().get(2).getChildObject().get(0).scaleObjectXYZ(1.5f);
        }
        if (window.isKeyPressed(GLFW_KEY_C)){

        }


        // ini buat yang WASD
        float cameraSpeed = 0.1f;
        float rotateSpeedInDegrees = 2f;
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
            camera.addRotation(0, (float) Math.toRadians(-1 *rotateSpeedInDegrees));
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
            camera.addRotation((float) Math.toRadians(-1 *rotateSpeedInDegrees), 0);
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


    }

    public void loop(){
        while (window.isOpen()){
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
                object.draw(camera,projection);
            }

            // restore state
            glDisableVertexAttribArray(0);

            // poll for window events
            // the key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run(){
        init();
        loop();

        // terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }

}
