package Engine;

import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;

public class Curve extends Object {
    List<Vector3f> titikTersedia;
    public Curve(List<Vector3f> titik, float red, float green, float blue, float alpha) {
        super(red, green, blue, alpha);

        // init titik dan vertices
        this.titikTersedia = titik;
        this.vertices = new ArrayList<>();

        generateCurve();
        setupVAOVBO();
    }

    private void generateCurve( ){
        // generate curve using Berzier's Curve
        for (float i = 0; i < 1; i+= 0.01f) {
            float hasilX = 0;
            float hasilY = 0;
            for (int j = 0; j < titikTersedia.size(); j++) {
                double satuMinT =  Math.pow((1 - i),(titikTersedia.size() - j - 1));
                double koefisien = factorial(titikTersedia.size() -1) / (factorial(titikTersedia.size()-1 - j) * factorial(j));
                double t =  Math.pow(i, j);

                double hasil = satuMinT * koefisien * t;

                // ambil vertice
                Vector3f vertice = titikTersedia.get(j);
                hasilX += hasil * vertice.x;
                hasilY += hasil * vertice.y;
            }
            this.vertices.add(new Vector3f(hasilX, hasilY, 0));
        }
    }

    private double factorial(int n){
        // base case
        if (n == 0) return 1;

        // recursive function
        return n * factorial(n - 1);
    }

    @Override
    public void draw(Camera camera, Projection projection) {
        drawSetup(camera,projection);

        glLineWidth(2);
        glPointSize(0);

        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}
