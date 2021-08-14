class Proverb {
    private final static String TAIL_FORMAT = "And all for the want of a %s.";
    private final static String BODY_FORMAT = "For want of a %s the %s was lost.\n";

    String output = "";

    Proverb(String[] words) {
        if (words.length > 0) {
            for (int i = 0; i < words.length - 1; i++) {
                output += String.format(BODY_FORMAT, words[i], words[i + 1]);
            }

            output += String.format(TAIL_FORMAT, words[0]);
        }
    }

    String recite() {
        return output;
    }

}
