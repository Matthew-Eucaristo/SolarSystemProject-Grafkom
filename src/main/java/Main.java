import Engine.*;
import Engine.Object;
import Engine.planet.Earth;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    // init window
    private Window window = new Window(800,800, "Solar System");

    // init objects
    private ArrayList<Object> objects = new ArrayList<Object>();

    // init mouseinput
    private MouseInput mouseInput;

    Projection projection = new Projection(window.getWidth(),window.getHeight());

    Camera camera = new Camera();

    public void init(){
        window.init();
        GL.createCapabilities(); // ini harus di atas
        mouseInput = window.getMouseInput();
        camera.setPosition(0,0,2.5f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(0.0f));

        // implement semua object disini
        objects.add(new Earth(96,150,180,255));



    }

    public void input(){
        // ini yang handle input dari mouse
        if(window.isKeyPressed(GLFW_KEY_F)){
            objects.get(0).rotateObject((float)Math.toRadians(1),1f,1f,0f);
        }

        // ini buat yang WASD
        float cameraSpeed = 0.1f;
        float rotateSpeedInDegrees = 2f;
        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(cameraSpeed);
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
            camera.moveUp(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(cameraSpeed);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.addRotation((float) Math.toRadians(-1 *rotateSpeedInDegrees), 0);
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.addRotation((float) Math.toRadians(rotateSpeedInDegrees), 0);
        }


    }

    public void loop(){
        while (window.isOpen()){
            window.update(); // ini update isi window
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // background asal hitam
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
