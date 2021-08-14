class RotationalCipher {
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        String rotated = "";

        for (int i = 0; i < data.length(); i++) {
            String ch = String.valueOf(data.charAt(i));

            boolean uppercase = false;

            if (ch.matches("[^a-zA-Z]")) {
                rotated += ch;
                continue;
            }

            if (ch.matches("[A-Z]")) uppercase = true;

            int originIndex = alphabet.indexOf(ch.toLowerCase());

            String letter = String.valueOf(getByOriginIndex(originIndex));

            rotated += uppercase ? letter.toUpperCase() : letter;

        }

        return rotated;
    }

    private char getByOriginIndex(int originIndex) {
        int newIndex = originIndex + shiftKey;

        if (newIndex > alphabet.length() - 1) newIndex = newIndex - alphabet.length();

        return alphabet.charAt(newIndex);
    }

}
