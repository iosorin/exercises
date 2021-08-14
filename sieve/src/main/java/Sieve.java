import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sieve {
    int MIN_PRIME = 2;
    int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        if (maxPrime < MIN_PRIME) return Collections.EMPTY_LIST;

        List<Boolean> ignore = new ArrayList<>();

        for (int i = MIN_PRIME; i <= maxPrime; i++) ignore.add(0, false);

        int step = MIN_PRIME;
        int stepPow = (int) Math.pow(step, 2);
        int nextIndex =  0;

        while (stepPow <= maxPrime) {
            int index = stepPow - MIN_PRIME;

            while (index < maxPrime - 1) {
                ignore.set(index, true);
                index += step;
            }

            nextIndex += 1;

            step = nextIndex + MIN_PRIME;
            stepPow = (int) Math.pow(step, 2);
        }

        return inferPrimes(ignore);
    }

    private List<Integer> inferPrimes(List<Boolean> ignore) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < ignore.size(); i++) if(ignore.get(i) == false) numbers.add(i + MIN_PRIME);

        return numbers;
    }
}