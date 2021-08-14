class Acronym {
    String value;

    Acronym(String phrase) {
        value = phrase.toUpperCase()
                .replaceAll("[^A-Z-\\s]", "")
                .replaceAll("\\B.|\\W", "");
    }

    String get() {
        return value;
    }

}
