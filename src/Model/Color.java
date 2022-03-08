package Model;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    YELLOW(1), RED(2), GREEN(3), BLUE(4);
    private int color;
    private static final Map<Integer, Color> MAP = new HashMap<>();

    private Color(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public static Color fromColor(int color) {
        return MAP.get(color);
    }

    static {
        for (Color c : values()) {
            MAP.put(c.getColor(), c);
        }
    }
}
