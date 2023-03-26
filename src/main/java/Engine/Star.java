package Engine;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Star extends Circle {
    int ibo;
    List<Integer> index;
    boolean ganjil;
    public Star(float titikPusatX, float titikPusatY, float radiusX, float radiusY, float rotation, float red, float green, float blue, float alpha, int jumlahPoint) {
        super(titikPusatX, titikPusatY, radiusX, radiusY, rotation, red, green, blue, alpha, jumlahPoint);


        // set ganjil/genap
        ganjil = jumlahPoint % 2 == 1;

        // set index
        index = new ArrayList<>();
        if (ganjil){
            // kasi start point di 0
            index.add(0);

            for (int i = 0; i < jumlahPoint / 2; i++) {
                index.add(jumlahPoint / 2 - i);
                index.add(jumlahPoint - i - 1);
            }

            // kasi 0 lagi di akhir biar kembali ke awal
            index.add(0);
    
        } else {
            System.out.println("error anjer");
        }


        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);

    }

    @Override
    public void draw() {
        drawSetup();

        // Bind IBO and draw
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_LINE_LOOP, index.size(), GL_UNSIGNED_INT, 0);
    }
}
