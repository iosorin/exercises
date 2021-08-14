class IsbnVerifier {
    private final int SIZE = 10;

    boolean isValid(String stringToVerify) {
        if (stringToVerify.length() < SIZE) return false;

        String[] numbers = stringToVerify.replaceAll("\\D", "").split("");

        if (numbers.length < SIZE - 1 || numbers.length > SIZE) return false;

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) sum += Integer.parseInt(numbers[i]) * (10 - i);

        if (stringToVerify.contains("X")) sum += 10;

        return sum % 11 == 0;
    }

}
