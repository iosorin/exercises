import java.util.stream.IntStream;

class NaturalNumber {
     Classification classification;

     NaturalNumber(int number) {
         if (number <= 0) throw new IllegalArgumentException("You must supply a natural number (positive integer)");

         this.classification = valueOf(number);
     }

     Classification valueOf(int input) {
         if (input == 1) return Classification.DEFICIENT;

         int sumOfFactors = IntStream.range(2, (input / 2) + 1)
                 .reduce(1, (acc, next) -> acc += input % next == 0 ? next : 0);

         if (sumOfFactors > input) return Classification.ABUNDANT;
         if (sumOfFactors < input) return Classification.DEFICIENT;

         return Classification.PERFECT;
     }

     Classification getClassification() {
         return this.classification;
     }
}
