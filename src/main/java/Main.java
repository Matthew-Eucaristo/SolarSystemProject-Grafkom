import Engine.*;
import Engine.Object;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;

import org.lwjgl.opengl.GL;
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
        camera.setPosition(0,0,1.5f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(10.0f));

        // objects add di sini
//        objects.add(new Sphere(255,255,255,255));
        objects.add(new Rectangle(1,1,30,30,0,255,1,1,255,72));


    }

    public void input(){
        // ini yang handle input dari mouse
        if(window.isKeyPressed(GLFW_KEY_F)){
            objects.get(0).rotateObject((float)Math.toRadians(1),1f,1f,0f);
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
