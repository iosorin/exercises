import java.util.Arrays;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    int[] inputNumbers;
    String inputNumber;

    void isCorrectInputNumber(String inputNumber) {
        if (inputNumber.matches(".*\\D.*")) throw new IllegalArgumentException("String to search may only contain digits.");
    }

    void isCorrectSeriesLength(int seriesLength) {
        if (seriesLength < 0) throw new IllegalArgumentException("Series length must be non-negative.");
        if (seriesLength > inputNumber.length()) throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
    }

    LargestSeriesProductCalculator(String inputNumber) {
        isCorrectInputNumber(inputNumber);

        this.inputNumber = inputNumber;

        inputNumbers = Arrays.stream(inputNumber.split("")).mapToInt(i -> i == "" ? 0 : Integer.parseInt(i)).toArray();
    }

    long calculateLargestProductForSeriesLength(int seriesLength) {
        isCorrectSeriesLength(seriesLength);

        if (seriesLength == 0) return 1;

        long largestProduct = calculateLargestProductForSeriesLength(seriesLength, this.inputNumbers);

        if (inputNumbers.length % seriesLength != 0) {
            long reversedNumbersLargestProduct = calculateLargestProductForSeriesLength(
                    seriesLength,
                    IntStream.rangeClosed(1, this.inputNumbers.length).map(i -> this.inputNumbers[this.inputNumbers.length - i]).toArray()
            );

            if (reversedNumbersLargestProduct > largestProduct) return reversedNumbersLargestProduct;
        }

        return largestProduct;
    }

    private long calculateLargestProductForSeriesLength(int seriesLength, int[] numbers) {
        int largestProduct = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (i + seriesLength > numbers.length) continue;

            int chunkProduct = 1;

            for (int j = i; j < i + seriesLength; j++) chunkProduct *= numbers[j];

            if (chunkProduct > largestProduct) largestProduct = chunkProduct;
        }

        return largestProduct;
    }

}
