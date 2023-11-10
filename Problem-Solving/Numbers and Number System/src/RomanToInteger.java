import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static int romanToInt(String num) {
        // Create a HashMap to store the Roman numerals with their corresponding integer
        // values
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;

        for (int i = 0; i < num.length(); i++) {
            int currValue = romanValues.get(num.charAt(i));

            if (i < num.length() - 1 && currValue < romanValues.get(num.charAt(i + 1))) {
                result -= currValue;
            } else {
                result += currValue;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("MI"));
        System.out.println(romanToInt("XV"));

    }
}
