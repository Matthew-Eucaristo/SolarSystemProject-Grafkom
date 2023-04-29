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
    DUCK_SPAWNER_COLOR(18,26,30,255),
    DUCK_SPAWNER_COLOR2(38,46,50,255),
    DUCK_SPAWNER_COLOR3(8,16,20,255),
    DUCK_SPAWNER_COLOR4(75,81,88,255),
    STAR_COLOR_BRIGHT(213,193,89,255),
    MOON_COLOR(0,12,67,255),
    FIRE_COLOR(255,0,0,255),
    MOON_SURFACE(20,162,188,255),
    DUCK_COLOR(232,197,64,255),
    DUCK_BEAK_COLOR(239,176,149,255),
    DUCK_EYE_COLOR(182,151,45,255),
    DUCK_EYE_2_COLOR(1,1,1,255),
    DUCK_POOP_COLOR(156,114,38,255),
    DUCK_FEET_COLOR(156,114,38,255),
    DUCK_NECK_COLOR(172,151,65,255),
    DUCK_HEAD_COLOR(255,239,71,255),
    DUCK_TAIL_COLOR(198,216,200,255),
    SATURN_COLOR_1(242, 226, 155,0),
    SATURN_COLOR_2(247, 234, 178, 0),
    SATURN_RING_WHITE(247,244,220,0),
    SATURN_RING_LIGHT_BROWN(245,237,188,0),
    SATURN_RING_BROWN(181, 158, 124, 0),
    SATURN_RING_DARK_BROWN(135, 121, 101, 0),
    SATURN_RING_GREY(130, 125, 118, 0),
    SATURN_RING_DARK_GREY(79, 75, 70, 0),
    HOURGLASS(73, 249, 252, 0),
    MOON_ROPE(255,255,255,255),
    QUASO_COLOR(217,124,46,255),
    QUASO_STRIPES_COLOR(123,52,17,255),
    EARTH_MUD(62,39,31,255),
    EARTH_SEA(96,150,180,255),
    EARTH_WIND(223,197,199,250),
    ATOM_COLOR(148,0,211,255),
    SUN_SPOTS(0,0,0,0.9f),
    SOLAR_RAY(241,90,34,255),
    SOLAR_FLARE(211,84,0,1),
    LASER_COLOR(255,0,0,1),
    SPACESHIP_BODY(255,255,240,255),
    SPACESHIP_HEAD(255, 76, 48,255),
    SPACESHIP_EXHAUST(4, 59, 92,255),
    SPACESHIP_GLASS(199, 227, 225,255),
    SPACESHIP_FLAME(252,138,23,255),
    SATELITE_MAIN_COLOR(177,177,177,255),
    SATELITE_BODY(205,211,207,255),
    SATELITE_SOLAR_PANEL(40,40,40,255),
    SATELITE_PARABOLA(178,180,179,255),
    SATELITE_SECONDARY_COLOR(128,129,104,255),
    SATELITE_ALTERNATE_COLOR(217,177,133,255),
    ASTRONAUT_HEAD(220,222,221,255),
    ASTRONAUT_ARMS(96,90,77,255),
    ASTRONAUT_JOINTS(80,86,83,255),
    ASTRONAUT_LEGS(215,212,213,255),
    ASTRONAUT_BAG(220,201,201,255),
    ASTRONAUT_BELT(223,224,206,255),
    ASTRONAUT_BOX(230,230,210,255),
    ASTRONAUT_ORB(34,163,228,255),
    ASTRONAUT_ANTENNA(173,176,181,255),
    ASTRONAUT_BOOTS(109,106,95,255),
    ASTRONAUT_ANTENNA2(45,49,50,255),

    ASTRONAUT_THUMB(230,230,220,255),

    ASTRONAUT_SUIT(239,235,225,255);




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
