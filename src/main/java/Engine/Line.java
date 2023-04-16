package Engine;

import org.joml.Vector3f;

import java.util.Collections;
import java.util.List;

import static org.lwjgl.opengl.GL11C.*;

public class Line extends Object{
    public Line(float red, float green, float blue, float alpha) {
        super(red, green, blue, alpha);
    }

    public Line(float[] rgba) {
        this(rgba[0], rgba[1], rgba[2], rgba[3]);
    }

    public Line(float[] rgba, List<Vector3f> vertices) {
        this(rgba);
        this.vertices = Collections.singletonList((Vector3f) vertices);
        setupVAOVBO();
    }

    @Override
    public void draw(Camera camera, Projection projection) {
        drawSetup(camera, projection);

        glLineWidth(1);
        glPointSize(0);

        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}
