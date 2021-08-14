import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {
    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.range(1, input + 1).reduce(0, Integer::sum), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.range(1, input + 1).reduce(0, (total, next) -> total + (int) Math.pow(next, 2));
    }

    int computeDifferenceOfSquares(int input) {
        return Math.abs(computeSumOfSquaresTo(input) - computeSquareOfSumTo(input));
    }
}
