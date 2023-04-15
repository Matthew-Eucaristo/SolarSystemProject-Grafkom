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
    SUN_RAYS(241,90,34,255),
    STAR_COLOR(255,255,255,255),
    MOON_COLOR(244,241,201,255),
    SATURN_COLOR_1(242, 226, 155,0),
    DUCK_COLOR(232,197,64,255),
    DUCK_BEAK_COLOR(239,176,149,255),
    DUCK_EYE_COLOR(182,151,45,255),
    DUCK_EYE_2_COLOR(1,1,1,255),
    DUCK_POOP_COLOR(156,114,38,255),
    DUCK_FEET_COLOR(156,114,38,255),
    DUCK_NECK_COLOR(172,151,65,255),
    DUCK_HEAD_COLOR(255,239,71,255),
    DUCK_TAIL_COLOR(198,216,200,255),
    SATURN_COLOR_2(247, 234, 178, 0),
    SATURN_RING_WHITE(247,244,220,0),
    SATURN_RING_LIGHT_BROWN(245,237,188,0),
    /*
    SATURN_RING_BROWN(),
    SATURN_RING_DARK_BROWN(),
    SATURN_RING_GREY(),
    SATURN_RING_DARK_GREY(),
     */
    EARTH_MUD(62,39,31,255),
    EARTH_SEA(96,150,180,255),
    EARTH_WIND(223,197,199,250),
    ATOM_COLOR(148,0,211,255),
    SUN_SPOTS(0,0,0,0.9f),
    SOLAR_RAY(241,90,34,255),
    SOLAR_FLARE(211,84,0,1),
    SPACESHIP_BODY(255,255,240,255),
    SPACESHIP_HEAD(255, 76, 48,255),
    SPACESHIP_EXHAUST(4, 59, 92,255),
    SPACESHIP_GLASS(199, 227, 225,255);



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
