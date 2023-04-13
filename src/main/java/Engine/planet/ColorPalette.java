package Engine.planet;

public enum ColorPalette {
    // color palette for space in the solar system
    SPACE(0,0,0,0),
    EARTH_DEEP_SEA(43,52,103,255),
    EARTH_LAND(79,107,77,255),
    EARTH_DARKER_LAND(45,77,52,255),
    EARTH_LIGHTER_LAND(166,147,131,255),
    CLOUDS(159,169,188,255),
    SUN_COLOR(255,255,0,255),
    STAR_COLOR(255,255,255,255),
    MOON_COLOR(255,255,255,255),
    SATURN_COLOR(255,255,255,255),
    EARTH_MUD(62,39,31,255),
    EARTH_SEA(96,150,180,255),
    EARTH_WIND(223,197,199,250),
    ATOM_COLOR(148,0,211,255);


    // function to get the color
    private final float r, g, b, a;
    ColorPalette(float r, float g, float b, float a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
    public float getR() {
        return r;
    }
    public float getG() {
        return g;
    }
    public float getB() {
        return b;
    }
    public float getA() {
        return a;
    }
    public float[] getRGBA(){
        return new float[]{r,g,b,a};
    }

}
