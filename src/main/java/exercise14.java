import java.util.Arrays;

/**
 * 14. Longest common prefix
 */

public class exercise14 {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = Arrays.stream(strs).sorted((s1, s2) -> s1.length() < s2.length() ? -1 : 1).findFirst().get();
        boolean found = false;

        while (!found && prefix.length() > 0) {

            found = true;
            for (String word : strs) {
                if (!word.substring(0, prefix.length()).equals(prefix)) {
                    found = false;
                    break;
                }
            }

            if (!found) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] list = new String[]{"flower", "flow", "floght"};

        System.out.println(longestCommonPrefix(list));
    }
}
