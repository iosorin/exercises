class IsogramChecker {
    boolean isIsogram(String phrase) {
        if (phrase.length() == 0) return true;

        String sorted = phrase.toLowerCase()
                .chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return !sorted.matches(".*(\\w)\\1+.*");
    }
}
