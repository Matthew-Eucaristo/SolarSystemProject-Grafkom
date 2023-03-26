package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class RectangleOld extends Object {
    int ibo;
    List<Integer> index;


    public RectangleOld(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                        List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);
    }


    public static RectangleOld generateRectangle(List<Vector3f> titik,
                                                 float red, float green, float blue, float alpha){
        // urutan bawah kiri bawah kanan atas kanan, atas kiri
        return new RectangleOld(
                Arrays.asList(
                        // shaderfile lokasi bisa menyesualkan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        titik
                ),
                new Vector4f(red/255f, green/255f, blue/255f, alpha/255f),
                Arrays.asList(0,1,2,0,3,2)
        );
    }

    public void draw(){
        drawSetup();

        // Bind IBO and draw
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
    }
}
