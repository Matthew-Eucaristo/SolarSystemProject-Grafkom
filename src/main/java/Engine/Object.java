package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL30.*;

public class Object extends ShaderProgram {
    // ini sering dipake
    List<Vector3f> vertices;
    int vao;
    int vbo;
    UniformsMap uniformsMap;
    Vector4f color;
    Matrix4f model;



    List<Object> childObject; // untuk hierarki?
    List<Float> centerPoint;




    // constructor
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;

        // panggil setup
        setupVAOVBO();

        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        this.color = color;
        this.model = new Matrix4f().identity();

        // init child
        childObject = new ArrayList<>();
    }


        // contructor yang lebih simpel buat di inherit
    public Object(float red, float green, float blue, float alpha){
        this(
                Arrays.asList(
                // shaderfile lokasi bisa menyesualkan objectnya
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(red / 255f, green / 255f, blue/ 255f, alpha/ 255f)
                );
    }


    public void setupVAOVBO() {
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        // set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }


    public void drawSetup(){
        bind();

        // set uniforms map
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);

        // Bind VBO
        glEnableVertexAttribArray(0); // ini biar masuk ke shader dan masuk e ke 0 dulu urut
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,
                GL_FLOAT,
                false,
                0,
                0
                );


    }


    public void draw(){
        drawSetup();

        // Draw the vertices
        // opsional
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // bersar kecil vertex

        // wajib
        // GL_LINE
        // GL_LINE_STIP
        // GL_LINE_LOOP
        // GL_TRIANGLES
        // GL_TRIANGLE_FAN
        // GL_POINT
        glDrawArrays(GL_POLYGON,
                0, // mau gambar dari index berapa (kalau semua dari 0)
                vertices.size());

        for(Object child: childObject){
            child.draw();
        }

    }

    public void drawLine(){
        drawSetup();

        glLineWidth(1);
        glPointSize(0);

        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVertices){
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public void setVertices(List<Vector3f> newVertices){
        vertices = newVertices;
        setupVAOVBO();
    }
    public void setVerticesByIndex(Vector3f newSingleVertices, int index){
        vertices.get(index).set(newSingleVertices);
        setupVAOVBO();
    }
    public void setVerticesByReference(Vector3f targetVertices, Vector3f newSingleVertices){
        int targetIndex = -1;
        // find the corresponding index
        for (int i = 0; i < vertices.size(); i++) {
            if(vertices.get(0) == targetVertices) targetIndex = i;
        }

        vertices.set(targetIndex, newSingleVertices);

        setupVAOVBO();
    }

    public List<Vector3f> getVertices() {
        return vertices;
    }



        // transformasi
    // translate
    public void translateObject(float offsetX, float offsetY, float offsetZ){
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child:childObject){
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }
    // rotate
    public void rotateObject(float degree, float x, float y, float z){
        model = new Matrix4f().rotate(degree, x, y, z).mul(new Matrix4f(model));
        for (Object child:childObject){
            child.rotateObject(degree, x, y, z);
        }
    }
    // scale
    public void scaleObject(float scaleX, float scaleY, float scaleZ){
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
        for (Object child:childObject){
            child.scaleObject(scaleX, scaleY, scaleZ);
        }
    }
    public void scaleObjectXYZ(float scale){
        this.scaleObject(scale, scale, scale);
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }

    public List<Float> getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(List<Float> centerPoint) {
        this.centerPoint = centerPoint;
    }
}
