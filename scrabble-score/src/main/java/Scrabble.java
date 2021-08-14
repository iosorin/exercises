import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Scrabble {
    String word;

    int score = 0;

    static HashMap<String, Integer> values = new HashMap<String, Integer>(
            Map.of(
                    "AEIOULNRST",1,
                    "DG", 2,
                    "BCMP", 3,
                    "FHVWY", 4,
                    "K", 5,
                    "JX", 8,
                    "QZ", 10
            )
    );


    Scrabble(String word) {
        this.word = word.toUpperCase();

        this.compute();
    }

    private void compute() {
        HashMap<Character, Integer> acc = new HashMap<Character, Integer>();

        for (char ch: word.toCharArray()) {
            acc.put(ch, Optional.ofNullable(acc.get(ch)).orElse(0) + 1);
        }

        int bla = word.chars().reduce(0, (total, next) -> {
            total += next;
            System.out.println(next);
            values.get(b -> b== 'a')
            return  total;
        });

//        acc.forEach((ch, count) -> score += getCharPoint(ch) * count);
    }

    int getScore() {
        return score;
    }

 }
