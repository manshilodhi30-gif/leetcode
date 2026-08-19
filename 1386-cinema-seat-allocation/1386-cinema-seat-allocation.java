import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] res : reservedSeats) {
            int r = res[0];
            int s = res[1];
            if (s >= 2 && s <= 9) {
                map.put(r, map.getOrDefault(r, 0) | (1 << s));
            }
        }
        int ans = (n - map.size()) * 2;
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int mid = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        for (int m : map.values()) {
            boolean l = (m & left) == 0;
            boolean r = (m & right) == 0;
            boolean c = (m & mid) == 0;
            if (l && r) {
                ans += 2;
            } else if (l || r || c) {
                ans += 1;
            }
        }
        return ans;
    }
}