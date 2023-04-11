package Engine.planet;

public enum ColorPaletteSpace {
    // color palette for space in the solar system
    SPACE(0,0,0,0),
    EARTH_DEEP_SEA(43,52,103,255),
    EARTH_LAND(0,255,0,255),
    CLOUDS(252,255,231,100),
    EARTH_SEA(96,150,180,255);

    // function to get the color
    private final float r, g, b, a;
    ColorPaletteSpace(float r, float g, float b, float a){
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
