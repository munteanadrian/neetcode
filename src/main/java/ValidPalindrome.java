public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        boolean pal = true;

        s = s.replaceAll("[_\\W]+", "").toLowerCase();
        if (s.length() > 1) {
            for (int i = 0; i < s.length()/2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    pal = false;
                    break;
                }
            }
        }

        return pal;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
