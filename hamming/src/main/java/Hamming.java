public class Hamming {
    int distance;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            if (leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }

            if (rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }

            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        this.distance = computeHammingDistance(leftStrand, rightStrand);
    }

    private int computeHammingDistance(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty()) return 0;

        final int[] result = {0};

        for (int index = 0; index < leftStrand.length(); index++) {
            if(rightStrand.charAt(index) != leftStrand.charAt(index)) {
                result[0]++;
            }
        }

        return result[0];
    }

    public int getHammingDistance() {
        return distance;
    }
}
