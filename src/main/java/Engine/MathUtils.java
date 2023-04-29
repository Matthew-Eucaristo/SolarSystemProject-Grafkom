package Engine;

public class MathUtils {
    public static float lerp(float a, float b, float f)
    {
        return a + f * (b - a);
    }
}
