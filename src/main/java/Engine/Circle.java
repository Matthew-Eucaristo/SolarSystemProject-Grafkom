package Engine;

import org.joml.Vector3f;

public class Circle extends Object {

    // init 
    float titikPusatX, titikPusatY, radiusX, radiusY, rotation;
    int jumlahPoint;


    public Circle(float titikPusatX, float titikPusatY, float radiusX, float radiusY, float rotation,
    float red, float green, float blue, float alpha, int jumlahPoint) {
        super(red, green, blue, alpha);

        // init titk pusat n radius
        this.titikPusatX = titikPusatX;
        this.titikPusatY = titikPusatY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.rotation = rotation;

        // init jumlah point
        this.jumlahPoint = jumlahPoint;


        // generate circle
        generateCircle();

        // setupvaovbo
        setupVAOVBO();
    }

    private void generateCircle(){
        // jumlah titik yang ditampilkan, increment degree
        float incDeg = (360.0f/this.jumlahPoint);

        // I used 100 x 100 canvas too here
        for (float deg = rotation; deg < 360 + rotation; deg += incDeg){
            vertices.add(
                    new Vector3f(
                            (float) ((titikPusatX + (radiusX * Math.cos(Math.toRadians(deg)))) / 100),
                            (float) ((titikPusatY + (radiusY * Math.sin(Math.toRadians(deg)))) / 100),
                            0.0f)
            );
        }

        // untuk urutan, intinya dari 0 sampe titik.size()
//        List<Integer> urutan = new ArrayList<>();
//        for (int i = 1; i < jumlahPoint - 1 ; i++) {
//            urutan.add(0); // center
//            urutan.add(i);
//            urutan.add(i == jumlahPoint ? 1 : i + 1); // go to the center again
//        }
        // ini untuk algoritma buat urutan titik lingkaran kalau pake segitiga
    }


    public float getTitikPusatX() {
        return titikPusatX;
    }

    public float getTitikPusatY() {
        return titikPusatY;
    }

    public void setTitikPusat(float titikPusatX, float titikPusatY) {
        this.titikPusatX = titikPusatX;
        this.titikPusatY = titikPusatY;
    }

}
