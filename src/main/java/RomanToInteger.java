/**
 * can be improved with case switch + comparing current number to previous
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {
    public static int toLatin(String[] roman) {
        HashMap<String, Integer> e = new HashMap<>();
        e.put("I", 1); e.put("V", 5); e.put("X", 10); e.put("L", 50); e.put("C", 100); e.put("D", 500); e.put("M", 1000);
        e.put("IV", 4); e.put("IX", 9); e.put("XL", 40); e.put("XC", 90); e.put("CD", 400); e.put("CM", 900);
        ArrayList<String> illegal = new ArrayList<>(Arrays.asList("VIV", "DCD"));

        int n = 0;

        for (int i = 0; i < roman.length; i++) {
            boolean structExists = false;

            if (i < roman.length - 1) {
                String struct = roman[i].concat(roman[i + 1]);

                if (i > 0) {
                    struct = roman[i-1].concat(struct);

                    if (!illegal.contains(struct) && e.containsKey(struct.substring(1))) {
                        structExists = true;
                        n += e.get(struct.substring(1));
                        i++;
                    }
                } else {
                    if (e.containsKey(struct)) {
                        structExists = true;
                        n += e.get(struct);
                        i++;
                    }
                }
            }

            if (!structExists) {
                n += e.get(roman[i]);
            }
        }

        return n;
    }

    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] roman = scanner.nextLine().split("");
            System.out.println(toLatin(roman));
        }

    }
}
