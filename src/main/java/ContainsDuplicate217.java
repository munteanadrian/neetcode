package untitled.src.main.java;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> occurences = new HashSet<>();

        for (int num : nums) {
            if (!occurences.add(num)) {
                return true;
            }
        }

        return false;
    }
}
