import java.util.Arrays;
import java.util.stream.Stream;

class ResistorColor {
    int colorCode(String color) {
        return Color.index(color);
    }

    String[] colors() {
        return Color.colors();
    }

    private enum Color {
        black,
        brown,
        red,
        orange,
        yellow,
        green,
        blue,
        violet,
        grey,
        white;

        static int index(String color) {
            return Color.valueOf(color).ordinal();
        }

        static String[] colors() {
            return Stream.of(Color.values()).map(Color::name).toArray(String[]::new);
        }
    }
}
