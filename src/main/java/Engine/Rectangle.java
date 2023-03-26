package Engine;

import org.joml.Vector2f;

public class Rectangle extends Circle{

    Vector2f radius = new Vector2f();
    Vector2f koordinatPusatKotak = new Vector2f();
    public Rectangle(float titikPusatX, float titikPusatY, float radiusX, float radiusY, float rotation, float red, float green, float blue, float alpha, int jumlahPoint) {
        super(titikPusatX, titikPusatY, radiusX, radiusY, rotation, red, green, blue, alpha, jumlahPoint);

        // init coordinat
        koordinatPusatKotak.x = titikPusatX;
        koordinatPusatKotak.y = titikPusatY;

        // init radius
        radius.x = radiusX;
        radius.y = radiusY;
    }

    public Rectangle isCollided(float posX, float posY){
        if( posX < getKoordinatPusatKotak().x + getRadius().x &&
                posX > getKoordinatPusatKotak().x - getRadius().x &&
                posY > getKoordinatPusatKotak().y - getRadius().y &&
                posY < getKoordinatPusatKotak().y + getRadius().y) return this;
        return null;

    }

    public Vector2f getRadius() {
        return radius;
    }

    public Vector2f getKoordinatPusatKotak() {
        return koordinatPusatKotak;
    }
}
