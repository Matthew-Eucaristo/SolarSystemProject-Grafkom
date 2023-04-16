package Engine;

import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11C.*;

public class Sphere extends Circle{
    float radiusZ;
    float titikPusatZ;
    int stackCount, sectorCount;

    // NOTE:
    // in here I guess the titiPusatX, titikPusatY, and titikPusatZ is just a relative titikPusat to work with, when the object is translated, rotated, etc. the titikPusat is not affected


    public Sphere(float titikPusatX, float titikPusatY, float titikPusatZ,
                  float radiusX, float radiusY, float radiusZ, int stackCount, int sectorCount,
                  float red, float green, float blue, float alpha, String type) {
        super(titikPusatX, titikPusatY, radiusX, radiusY, 0, red, green, blue, alpha, 0);

        // init dari parameter
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        this.titikPusatZ = titikPusatZ;

        // panggil function pilihan
        switch (type.toLowerCase()) {
            case "box" -> createBox();
            case "hyperboloid1side" -> createHyperboloid1Side();
            case "hyperboloid2side" -> createHyperboloid2Side();
            case "ellipticcone" -> createEllipticCone();
            case "ellipticparaboloid" -> createEllipticParaboloid();
            case "hyperboloidparaboloid" -> createHyperboloidParaboloid();
            case "tube" -> createTube();
            default -> createEllipsoid();
        }

        // set centerpoint
        this.centerPoint = new Vector3f(titikPusatX, titikPusatY, titikPusatZ);

        setupVAOVBO();
    }
    public Sphere(float[] rgba, String type){
        this(rgba[0], rgba[1], rgba[2], rgba[3], type);
    }
    public Sphere(float radiusX, float radiusY, float radiusZ,
                  float[] rgba, String type) {
        this(0f, 0f, 0f,
                radiusX, radiusY, radiusZ,
                100, 100,
                rgba[0], rgba[1], rgba[2], rgba[3], type);
    }

    public Sphere(float red, float green, float blue, float alpha, String type) {
        this(0f, 0f, 0f,
                0.5f, 0.5f, 0.5f,
                100, 100,
                red, green, blue, alpha,
                type);
    }

    public void createEllipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/stackCount){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/sectorCount){
                float x = radiusX * (float)(Math.cos(v) * Math.cos(u)) + titikPusatX;
                float y = radiusY * (float)(Math.cos(v) * Math.sin(u)) + titikPusatY;
                float z = radiusZ* (float)(Math.sin(v)) + titikPusatZ;
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }
    public void createHyperboloid1Side(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI / 2; v<= Math.PI/2; v+=Math.PI/stackCount){
            for(double u = -Math.PI / 2; u<= Math.PI/2; u+=Math.PI/sectorCount){
                float x = radiusX * (float)((1.0f/Math.cos(v)) * Math.cos(u)) + titikPusatX;
                float y = radiusY * (float)((1.0f/Math.cos(v)) * Math.sin(u)) + titikPusatY;
                float z = radiusZ * (float)(Math.tan(v)) + titikPusatZ;
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }
    public void createHyperboloid2Side(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/stackCount){
            for(double u = Math.PI/2; u<= 3*Math.PI/2; u+=Math.PI/sectorCount){
                float x = radiusX * (float)(Math.tan(v) * Math.cos(u)) + titikPusatX;
                float y = radiusY * (float)(Math.tan(v) * Math.sin(u)) + titikPusatY;
                float z = radiusZ * (float)(1/Math.cos(v)) + titikPusatZ;
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }
    public void createEllipticCone(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 2*Math.PI; v+=Math.PI/stackCount){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/sectorCount){
                float x = radiusX * (float)(v * Math.cos(u)) + titikPusatX;
                float y = radiusY * (float)(v * Math.sin(u)) + titikPusatY;
                float z = radiusZ * (float)(v) + titikPusatZ;
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }
    public void createEllipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 2*Math.PI; v+=Math.PI/stackCount){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/sectorCount){
                float x = radiusX * (float)(v * Math.cos(u)) + titikPusatX;
                float y = radiusY * (float)(v * Math.sin(u)) +titikPusatY;
                float z = radiusZ * (float)(v*v) + titikPusatZ;
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }
    public void createHyperboloidParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 2*Math.PI; v+=Math.PI/stackCount){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/sectorCount){
                float x = radiusX * (float)(v * Math.tan(u)) + titikPusatX;
                float y = radiusY * (float)(v * 1/Math.cos(u)) + titikPusatY;
                float z = radiusZ * (float)(v*v) + titikPusatZ;
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;
    }
    public void createTube(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(float v = -radiusY; v<= radiusY; v+=0.01){
            for(float i = 0;i<360;i+=1){
                double rad = Math.toRadians(i);
                float x = radiusX * (float)(Math.cos(rad));
                float y = radiusY * (float)(Math.sin(rad));
                temp.add(new Vector3f(x, v,y));
            }
        }

        vertices = temp;
    }

    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1 kiri atas belakang
        temp.x = titikPusatX - radiusX / 2.0f;
        temp.y = titikPusatY + radiusY / 2.0f;
        temp.z = titikPusatZ - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2 kanan atas belakang
        temp.x = titikPusatX + radiusX / 2.0f;
        temp.y = titikPusatY + radiusY / 2.0f;
        temp.z = titikPusatZ - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3 kanan bawah belakang
        temp.x = titikPusatX + radiusX / 2.0f;
        temp.y = titikPusatY - radiusY / 2.0f;
        temp.z = titikPusatZ - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4 kiri bawah belakang
        temp.x = titikPusatX - radiusX / 2.0f;
        temp.y = titikPusatY - radiusY / 2.0f;
        temp.z = titikPusatZ - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5 kiri atas depan
        temp.x = titikPusatX - radiusX / 2.0f;
        temp.y = titikPusatY + radiusY / 2.0f;
        temp.z = titikPusatZ + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6 kanan atas depan
        temp.x = titikPusatX + radiusX / 2.0f;
        temp.y = titikPusatY + radiusY / 2.0f;
        temp.z = titikPusatZ + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7 kanan bawah depan
        temp.x = titikPusatX + radiusX / 2.0f;
        temp.y = titikPusatY - radiusY / 2.0f;
        temp.z = titikPusatZ + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8 kiri bawah depan
        temp.x = titikPusatX - radiusX / 2.0f;
        temp.y = titikPusatY - radiusY / 2.0f;
        temp.z = titikPusatZ + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }

    public void selfRotate(float degree, float xAxes, float yAxes, float zAxes){
        float x = getCenterPoint().x;
        float y = getCenterPoint().y;
        float z = getCenterPoint().z;

        translateObject(-x, -y, -z);
        rotateObject(degree, xAxes, yAxes, zAxes);
        translateObject(x, y, z);
    }


    public void drawIndices(Camera camera, Projection projection){
        drawSetup(camera, projection);
        glLineWidth(1); //ketebalan garis
        glPointSize(1); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }

    public float getTitikPusatZ() {
        return titikPusatZ;
    }

    public void setTitikPusat(float titikPusatX, float titikPusatY, float titikPusatZ) {
        this.titikPusatX = titikPusatX;
        this.titikPusatY = titikPusatY;
        this.titikPusatZ = titikPusatZ;
    }


}
