class LuhnValidator {
    private final int LIMIT_TO_DOUBLE = 9;

    boolean isValid(String candidate) {
        String string = candidate.replaceAll("\\s", "");

        if (string.length() <= 1 || string.matches(".*[^0-9].*")) return false;

        int sum = getSum(string.split(""));

        return sum % 10 == 0;
    }


    int getSum(String[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int n = Integer.parseInt(numbers[numbers.length - i - 1]);

            if (i % 2 == 0) sum += n;

            else sum += n * 2 - (n * 2 < LIMIT_TO_DOUBLE ? 0 : LIMIT_TO_DOUBLE);
        }

        return sum;
    }
}
