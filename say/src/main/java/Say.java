import java.util.Arrays;
import java.util.HashMap;

public class Say {
    static int MIN = 0;
    static long MAX = 999_999_999_999L;

    public static void isNotLess(int input) {
        if (input < Say.MIN) throw new IllegalArgumentException(input + " less than " + Say.MIN);
    }

    public static void isNotGreater(long input) {
        if (input > Say.MAX) throw new IllegalArgumentException(input + " greater than " + Say.MAX);
    }

    static Dictionary dictionary = new Dictionary();

    String say(int input) {
        isNotLess(input);
        isNotGreater(input);

        String dictionaryWord = dictionary.get(input);

        if (!dictionaryWord.isEmpty()) return dictionaryWord;

        return convert(String.valueOf(input));
    }

    String say(long input) {
        isNotGreater(input);

        return convert(String.valueOf(input));
    }

    private String convert(String input) {
        String words = "";

        String[] chunks = splitIntoChunks(input);

        for (int i = 0; i < chunks.length; i++) {
            String chunk = chunks[i];
            String power = i == chunks.length - 1 ? "" : dictionary.getPower(chunks.length - i);
            String delimiter = i == 0 ? "" : " ";

            if (Integer.parseInt(chunk) == 0) continue;

            words += delimiter + convertChunk(chunk) + power;
        }

        return words;
    }

    private String convertChunk(String chunk) {
        if (chunk.length() > 3) throw new IllegalArgumentException("string length greater than 3");

        Integer[] digits = Arrays.stream(chunk.split("")).map(Integer::valueOf).toArray(Integer[]::new);

        String hundreds = "", hundredsPower = "", tens = "", delimiter = "";

        hundreds = digits.length == 3 ? digits[0] == 0 ? "" : dictionary.get(digits[0]) : "";

        if (!hundreds.isEmpty()) hundredsPower = dictionary.getPower(1);

        if (digits[digits.length - 2] * 10 + digits[digits.length - 1] != 0) {
            tens = dictionary.get(digits[digits.length - 2] * 10 + digits[digits.length - 1]);

            if (tens.isEmpty()) tens = dictionary.get(digits[digits.length - 2] * 10) + "-" + dictionary.get(digits[digits.length - 1]);
        }

        if (!hundredsPower.isEmpty() && !tens.isEmpty()) delimiter = " ";

        return hundreds + hundredsPower + delimiter + tens;
    }

    private String[] splitIntoChunks(String string) {
        int mod = string.length() % 3;

        String stringWithLeadingZeros = mod == 0 ? string : (String.format("%0" + (3 - mod) + "d", 0) + string);

        String[] groups = stringWithLeadingZeros
                .replaceAll("\\w{3}", "$0:")
                .split(":");

        return groups;
    }
}

class Dictionary {
    private HashMap<Integer, String> helper = new HashMap<Integer, String>();
    private HashMap<Integer, String> dictionary = new HashMap<Integer, String>();

    private HashMap<Integer, String> powers = new HashMap<Integer, String>();

    Dictionary() {
        this.init();
    }

    void init() {
        this.generatePowers();
        this.generateNumbers();
    }

    void generatePowers() {
        powers.put(1, "hundred");
        powers.put(2, "thousand");
        powers.put(3, "million");
        powers.put(4, "billion");
    }

    void generateNumbers() {
        helper.put(3, "three, thir, thir");
        helper.put(4, "four, four, for");
        helper.put(5, "five, fif, fif");
        helper.put(6, "six, six, six");
        helper.put(7, "seven, seven, seven");
        helper.put(8, "eight, eigh, eigh");
        helper.put(9, "nine, nine, nine");

        dictionary.put(0, "zero");
        dictionary.put(1, "one");
        dictionary.put(2, "two");
        dictionary.put(10, "ten");
        dictionary.put(11, "eleven");
        dictionary.put(12, "twelve");
        dictionary.put(20, "twenty");

        for (int key : helper.keySet()) {
            String[] values = helper.get(key).split(", ");

            if (values.length != 3) continue;

            dictionary.put(key, values[0]);
            dictionary.put(key + 10, values[1] + "teen");
            dictionary.put(key * 10, values[2] + "ty");
        }
    }

    String get(int key) {
        String number = dictionary.get(key);

        if (number == null) return "";

        return number;
    }

    String getPower(int key) {
        String power = powers.get(key);

        if (power == null) return "";

        return " " + power;
    }
}