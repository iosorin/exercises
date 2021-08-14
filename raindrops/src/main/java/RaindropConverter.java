import java.util.LinkedHashMap;

class RaindropConverter {
    static LinkedHashMap<String,Integer> factors = new LinkedHashMap<>();

    static {
        factors.put("Pling", 3);
        factors.put("Plang", 5);
        factors.put("Plong", 7);
    }

    String convert(int number) {
        String output = factors.keySet().stream()
                .reduce("", (acc, next) -> acc += number % factors.get(next) == 0 ? next : "");

        return output.isEmpty() ? String.valueOf(number) : output;
    }

}
