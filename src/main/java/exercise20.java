import java.util.HashMap;
import java.util.Scanner;

public class exercise20 {

    public static boolean findNext(String s, int i, Character p, HashMap<Character, Character> map) {
        boolean found = false;
        while (i < s.length()) {
            if (s.charAt(i) == map.get(p)) {
                return true;
            } else if (map.containsKey(s.charAt(i))) {
                return findNext(s, i, s.charAt(i), map);
            }

            i++;
        }

        return false;
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')'); map.put('[', ']'); map.put('{', '}');
//        [ ( ( ) ( ) ) ]

        for(int i = 0; i < s.length() - 1; i++) {
            boolean hasMatch = findNext(s, i, s.charAt(i), map);

            if (!hasMatch) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String p = scanner.nextLine();
            System.out.println(isValid(p));
        }
    }
}
