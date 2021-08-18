import java.util.HashMap;
import java.util.Map;

class PrimeCalculator {
    private Map<Integer, Integer> primes = new HashMap<Integer, Integer>();

    PrimeCalculator() {
        boolean[] notPrimes = new boolean[1000000];

        for(int i = 2; i * i < notPrimes.length; i++) {
            if(!notPrimes[i]) {
                for (int j = i * i; j < notPrimes.length; j += i) {
                    notPrimes[j] = true;
                }
            }
        }

        int counter = 1;

        for(int i = 2; i < notPrimes.length; i++) {
            if(!notPrimes[i]) {
                primes.put(counter, i);
                counter++;
            }
        }
    }

    int nth(int nth) {
        if(nth < 1) throw new IllegalArgumentException();

        return primes.get(nth);
    }
}