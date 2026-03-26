import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean oddFound = false;
        for (int count : freq.values()) {
            length += (count / 2) * 2; 
            if (count % 2 == 1) oddFound = true;
        }
        if (oddFound) length += 1;
        return length;
    }
}
