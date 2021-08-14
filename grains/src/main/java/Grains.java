import java.math.BigInteger;

class Grains {
    final Range range = new Range(1, 64);

    BigInteger grainsOnSquare(final int square) {
        if (!range.contains(square)) throw new IllegalArgumentException(
                String.format("square must be between %d and %d", range.min, range.max)
        );

        return range.get(square);
    }

    BigInteger grainsOnBoard() {
        return range.sum;
    }

    private class Range {

        int min, max;

        BigInteger sum;
        BigInteger[] values;

        BigInteger EXPO_FACTOR = BigInteger.valueOf(2);

        Range(int min, int max) {
            if (min < 1) throw new IllegalArgumentException("range min must be greater then 0");

            this.min = min;
            this.max = max;

            this.fill();
        }

        private void fill() {
            this.values = new BigInteger[this.max];
            this.values[0] = this.sum = BigInteger.valueOf(this.min);

            for (int i = 1; i < this.max ; i++) {
                this.values[i] = this.values[i - 1].multiply(this.EXPO_FACTOR);
                this.sum = this.sum.add(this.values[i]);
            }
        }

        boolean contains(int num) {
            return this.min <= num && this.max >= num;
        }

        BigInteger get(int num) {
            return this.values[num - 1];
        }
    }

}
