class Solution {
    public String longestPalindrome(String s) {
         if (s == null || s.length() == 0) {
            return "";
        }
        HashMap<String, Boolean> map = new HashMap<>();
        String l = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String c = s.substring(i, j + 1);
                if (isPalindrome(c, map)) {
                    if (c.length() > l.length()) {
                        l = c;
                    }
                }
            }
        }
        return l;
    }
    public boolean isPalindrome(String str, HashMap<String, Boolean> map) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                map.put(str, false);
                return false;
            }
            left++;
            right--;
        }
        map.put(str, true);
        return true;
    }
}