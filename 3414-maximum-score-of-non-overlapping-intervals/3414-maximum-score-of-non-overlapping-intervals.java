import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] p = new Integer[n];
        for (int i = 0; i < n; i++) p[i] = i;

        Arrays.sort(p, (a, b) -> {
            if (!intervals.get(a).get(0).equals(intervals.get(b).get(0))) {
                return Integer.compare(intervals.get(a).get(0), intervals.get(b).get(0));
            }
            if (!intervals.get(a).get(1).equals(intervals.get(b).get(1))) {
                return Integer.compare(intervals.get(a).get(1), intervals.get(b).get(1));
            }
            return Integer.compare(a, b);
        });

        int[] nxt = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n, ans = n;
            int curEnd = intervals.get(p[i]).get(1);
            while (low < high) {
                int mid = (low + high) / 2;
                if (intervals.get(p[mid]).get(0) > curEnd) {
                    ans = mid;
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            nxt[i] = ans;
        }

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] path = new List[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                path[i][k] = new ArrayList<>();
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                long takeW = intervals.get(p[i]).get(2) + dp[nxt[i]][k - 1];
                List<Integer> takeList = new ArrayList<>();
                takeList.add(p[i]);
                takeList.addAll(path[nxt[i]][k - 1]);
                Collections.sort(takeList);

                long skipW = dp[i + 1][k];
                List<Integer> skipList = path[i + 1][k];

                if (takeW > skipW) {
                    dp[i][k] = takeW;
                    path[i][k] = takeList;
                } else if (takeW < skipW) {
                    dp[i][k] = skipW;
                    path[i][k] = skipList;
                } else {
                    dp[i][k] = takeW;
                    if (isSmaller(takeList, skipList)) {
                        path[i][k] = takeList;
                    } else {
                        path[i][k] = skipList;
                    }
                }
            }
        }

        List<Integer> best = path[0][4];
        long maxVal = dp[0][4];

        for (int k = 1; k < 4; k++) {
            if (dp[0][k] > maxVal) {
                maxVal = dp[0][k];
                best = path[0][k];
            } else if (dp[0][k] == maxVal && isSmaller(path[0][k], best)) {
                best = path[0][k];
            }
        }

        int[] ans = new int[best.size()];
        for (int i = 0; i < best.size(); i++) {
            ans[i] = best.get(i);
        }
        return ans;
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {
        if (a.isEmpty()) return false;
        if (b.isEmpty()) return true;
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}