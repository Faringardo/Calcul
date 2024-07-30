import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public enum Roma {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int value;

    Roma(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<Roma> getReverseSortedValues(){
        return Arrays.stream(Roma.values()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static int romanToArabic(String input) {
        String numbers = input.toUpperCase();
        int result = 0;

        List<Roma> romanNumerals = Roma.getReverseSortedValues();

        int i = 0;

        while ((numbers.length() > 0) && (i < romanNumerals.size())) {
            Roma symbol = romanNumerals.get(i);
            if (numbers.startsWith(symbol.name())) {
                result += symbol.getValue();
                numbers = numbers.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (numbers.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }
        return result;
    }

    public static String arabicToRoman(int numbers) {
        if ((numbers <= 0) || (numbers >=4000)){
            throw new IllegalArgumentException(numbers + " is not in range [0,4000]");
        }

        List<Roma> romanNumerals = Roma.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((numbers > 0) && (i < romanNumerals.size())) {
            Roma currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= numbers) {
                sb.append(currentSymbol.name());
                numbers -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
