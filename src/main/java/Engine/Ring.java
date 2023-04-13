package Engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;

public class Ring extends Circle {
    public Ring(float[] rgba) {
        this(rgba[0], rgba[1], rgba[2], rgba[3]);
    }

    public Ring(float red, float green, float blue, float alpha) {
        super(0f, 0f, 0.5f, 0.5f, 0, red, green, blue, alpha, 100);

        createRing();

        setupVAOVBO();
    }

    @Override
    public void draw(Camera camera, Projection projection){
        drawSetup(camera,projection);

        // Draw the vertices
        // opsional
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // bersar kecil vertex

        // wajib
        // GL_LINE
        // GL_LINE_STRIP
        // GL_LINE_LOOP
        // GL_TRIANGLES
        // GL_TRIANGLE_FAN
        // GL_POINT
        glDrawArrays(GL_LINE_STRIP,
                0, // mau gambar dari index berapa (kalau semua dari 0)
                vertices.size());

        for(Object child: childObject){
            child.draw(camera,projection);
        }
    }

    public void createRing() {

    }
}
