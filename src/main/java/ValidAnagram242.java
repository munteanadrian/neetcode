import java.util.HashMap;

public class ValidAnagram242 {

    public static boolean isAnagramWithHashTable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> occ = new HashMap<>();
        for (char c : s.toCharArray()) {
            occ.put(c, occ.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            occ.put(c, occ.getOrDefault(c, 0) - 1);
        }

        for (char c : occ.keySet()) {
            if (occ.get(c) != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagramEfficient(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] characters = new int[26];
        for (char c : s.toCharArray()) {
            characters[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (characters[c - 'a'] == 0) {
                return false;
            }

            characters[c - 'a']--;
        }

        return true;
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
        }

        for (int j = 0; j < t.length(); j++) {
            tMap.merge(t.charAt(j), 1, Integer::sum);
        }

        return sMap.equals(tMap);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "ab"));
    }
}
