class ResistorColorDuo {
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

        static int value(String[] colors, int size) {
            StringBuilder out = new StringBuilder();

            for(int i = 0; i < size; i++) {
                out.append(Color.index(colors[i]));
            }

            return Integer.parseInt(out.toString());
        }
    }

    int value(String[] colors) {
        return Color.value(colors,2);
    }
}
