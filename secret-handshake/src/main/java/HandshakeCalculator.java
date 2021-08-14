import java.util.*;

class HandshakeCalculator {
    static int BinaryValueToReverseInput = 10000;

    List<Signal> calculateHandshake(int number) {
        boolean reversed = false;

        int binaryInt = Integer.parseInt(Integer.toBinaryString(number));

        if (binaryInt == 0) return Collections.emptyList();

        if (binaryInt >= BinaryValueToReverseInput) {
            binaryInt -= BinaryValueToReverseInput * Math.round(binaryInt / BinaryValueToReverseInput);
            reversed = true;
        }

        List<Signal> list = Signal.list(binaryInt);

        if (reversed) Collections.reverse(list);

        return list;
    }

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
}
