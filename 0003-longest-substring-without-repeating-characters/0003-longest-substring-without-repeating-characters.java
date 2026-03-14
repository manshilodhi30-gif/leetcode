import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int m = 0;
        int l = 0;   // Initialize left pointer
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            }

            map.put(c, r);
            m = Math.max(m, r - l + 1);
        }
        return m;
    }
}
