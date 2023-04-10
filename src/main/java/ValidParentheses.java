import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        HashMap<Character, Character> pair = new HashMap<>();
        pair.put('(', ')'); pair.put('[', ']'); pair.put('{', '}');
        Stack<Character> crt = new Stack<>();

        for (Character c : s.toCharArray()) {

            if (pair.containsKey(c)) {
                crt.push(pair.get(c));
            } else {
                if (crt.isEmpty()) {
                    return false;
                } else if (crt.peek() == c) {
                    crt.pop();
                } else {
                    return false;
                }
            }
        }

        return crt.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([}}])"));
    }

}
