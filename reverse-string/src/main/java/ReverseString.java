import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ReverseString {
    String reverse(String input){
        List<String> letters = Arrays.asList(input.split(""));
        Collections.reverse(letters);

        return String.join("", letters);
    }
}