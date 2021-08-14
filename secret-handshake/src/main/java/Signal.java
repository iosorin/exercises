import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;

enum Signal {
    WINK(1),
    DOUBLE_BLINK(10),
    CLOSE_YOUR_EYES(100),
    JUMP(1000);

    int binaryInt;

    Signal(int binaryInt) {
        this.binaryInt = binaryInt;
    }

    static Optional<Signal> find(int binaryInt) {
        return Arrays.stream(Signal.values()).filter(signal -> signal.binaryInt == binaryInt).findFirst();
    }

    static List<Signal> list(int binaryInt) {
        List<Signal> list = new ArrayList<Signal>();

        String binaryString = String.valueOf(binaryInt);

        for (int i = 0; i < binaryString.length(); i++) {
            int dig = Character.getNumericValue(binaryString.charAt(binaryString.length() - i - 1));

            if (i > 0) for (int k = 0; k < i; k++) dig *= 10;

            Optional<Signal> match = Signal.find(dig);

            if (match.isPresent()) list.add(match.get());
        }

        return list;
    }

}


