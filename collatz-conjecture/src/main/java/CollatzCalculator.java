class CollatzCalculator {
    public final int POINT = 1;

    int computeStepCount(int start) {
        if (start <= 0) throw new IllegalArgumentException("Only natural numbers are allowed");

        if (start == POINT) return 0;

        int step = 0;

        while (start != POINT) {
            if (start % 2 == 0) start /= 2;
            else start = start * 3 + 1;

            step += 1;
        }

        return step;
    }

}
