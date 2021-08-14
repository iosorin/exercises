public class PangramChecker {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String patternForCleaning = "\\W|_|\\d|\\s+";

    public boolean isPangram(String input) {
        if (input.length() < alphabet.length()) return false;

        String stringToCompare = getCleanAlphabeticallyString(input);

        return alphabet.equals(stringToCompare);
    }

    String getCleanAlphabeticallyString (String input) {
        return input
                .toLowerCase()
                .replaceAll(patternForCleaning, "")
                .chars()
                .sorted()
                .distinct()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
