class Solution {
    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 100) return 0;
        String s = String.valueOf(n);
        // Memoization: [idx][tight][leading][last][secondLast]
        // Using a custom Result object to store both values
        Result[][][][][] memo = new Result[s.length()][2][2][11][11];
        return dp(0, true, true, 10, 10, s, memo).waviness;
    }

    private Result dp(int idx, boolean tight, boolean leading, int last, int secondLast, String s, Result[][][][][] memo) {
        if (idx == s.length()) {
            return new Result(0, 1);
        }
        
        int t = tight ? 1 : 0;
        int l = leading ? 1 : 0;
        if (memo[idx][t][l][last][secondLast] != null) return memo[idx][t][l][last][secondLast];

        long totalWaviness = 0;
        long totalCount = 0;
        int limit = tight ? s.charAt(idx) - '0' : 9;

        for (int digit = 0; digit <= limit; digit++) {
            boolean nextTight = tight && (digit == limit);
            boolean nextLeading = leading && (digit == 0);
            
            int nextLast = nextLeading ? 10 : digit;
            int nextSecondLast = nextLeading ? 10 : last;

            Result res = dp(idx + 1, nextTight, nextLeading, nextLast, nextSecondLast, s, memo);
            
            totalCount += res.count;
            totalWaviness += res.waviness;

            // Check for peak or valley
            if (!leading && last != 10 && secondLast != 10) {
                if ((secondLast < last && last > digit) || (secondLast > last && last < digit)) {
                    totalWaviness += res.count;
                }
            }
        }

        return memo[idx][t][l][last][secondLast] = new Result(totalWaviness, totalCount);
    }

    private static class Result {
        long waviness, count;
        Result(long w, long c) { waviness = w; count = c; }
    }
}