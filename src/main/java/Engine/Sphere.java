package Engine;

import org.joml.Vector3f;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11C.*;

public class Sphere extends Circle{
    float radiusZ;
    float titikPusatZ;
    int stackCount, sectorCount;


    public Sphere(float titikPusatX, float titikPusatY, float titikPusatZ,
                  float radiusX, float radiusY, float radiusZ, int stackCount, int sectorCount,
                  float red, float green, float blue, float alpha) {
        super(titikPusatX, titikPusatY, radiusX, radiusY, 0, red, green, blue, alpha, 0);

        // init dari parameter
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        this.titikPusatZ = titikPusatZ;

        // panggil function pilihan
//        createBox();
        createEllipsoid();
//        createHyperboloid1Side();
//        createHyperboloid2Side();
//        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperboloidParaboloid();


        setupVAOVBO();
    }
    public Sphere(float red, float green, float blue, float alpha) {
        super(0f, 0f, 0.5f, 0.5f, 0, red, green, blue, alpha, 0);

        // init dari parameter
        this.radiusZ = 0.5f;
        this.stackCount = 100;
        this.sectorCount = 100;
        this.titikPusatZ = 0f;

        // panggil function pilihan
//        createBox();
        createEllipsoid();
//        createHyperboloid1Side();
//        createHyperboloid2Side();
//        createEllipticCone();
//        createEllipticParaboloid();
//        createHyperboloidParaboloid();


        setupVAOVBO();
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

    public void drawIndices(){
        drawSetup();
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
