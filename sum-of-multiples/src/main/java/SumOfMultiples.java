import java.util.HashSet;

class SumOfMultiples {
    int sum = 0;

    SumOfMultiples(int number, int[] set) {
        HashSet<Integer> factors = new HashSet<Integer>();

        for (int i = 0; i < set.length; i++) {
            int n = set[i];

            if (n == 0) continue;

            while (n < number) {
                if (!factors.contains(n)) {
                    sum += n;
                    factors.add(n);
                }

                n += set[i];
            }
        }


    }

    int getSum() {
        return sum;
    }

}
