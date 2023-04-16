package Engine;

import static org.lwjgl.opengl.GL11C.*;

public class Line extends Object{
    public Line(float red, float green, float blue, float alpha) {
        super(red, green, blue, alpha);
    }

    @Override
    public void draw(Camera camera, Projection projection) {
        drawSetup(camera, projection);

        glLineWidth(1);
        glPointSize(0);

        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}
