import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class DiamondPrinter {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    List<String> printToList(char a) {
        List<String> result = triangle(a);

        result.addAll(reverse(result));

        return result;
    }

    List<String> triangle(char a) {
        List<String> result = new ArrayList<>();

        int index = alphabet.indexOf(a) + 1;
        int size = index * 2 - 1;

        String[] letters = alphabet.substring(0, index).split("");

        for (int i = 0; i < letters.length; i++) {
            String[] string = new String[size];

            for (int j = 0; j < size; j++) {
                string[j] = (j == (size / 2 - i) || j == (size / 2 + i)) ? letters[i] : " ";
            }

            result.add(String.join("", string));
        }

        return result;
    }

    List<String> reverse(List<String> triangle) {
        List<String> reversed = new ArrayList<>(triangle);

        Collections.reverse(reversed);

        reversed.remove(0);

        return reversed;
    }
}
