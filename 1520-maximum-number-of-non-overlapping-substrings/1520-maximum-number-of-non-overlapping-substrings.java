import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (l[ch] == -1) {
                l[ch] = i;
            }
            r[ch] = i;
        }

        List<String> result = new ArrayList<>();
        int lastRight = -1;

        for (int i = 0; i < n; i++) {
            if (i == l[s.charAt(i) - 'a']) {
                int right = getValidRight(s, i, l, r);
                if (right != -1) {
                    if (i > lastRight) {
                        result.add("");
                    }
                    lastRight = right;
                    result.set(result.size() - 1, s.substring(i, right + 1));
                }
            }
        }

        return result;
    }

    private int getValidRight(String s, int left, int[] l, int[] r) {
        int right = r[s.charAt(left) - 'a'];
        for (int i = left; i <= right; i++) {
            int ch = s.charAt(i) - 'a';
            if (l[ch] < left) {
                return -1;
            }
            right = Math.max(right, r[ch]);
        }
        return right;
    }
}