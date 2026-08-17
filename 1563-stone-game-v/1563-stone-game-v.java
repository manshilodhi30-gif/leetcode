public class Solution {
    private int[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stoneValue, int i, int j) {
        if (i == j) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxScore = 0;

        for (int k = i; k < j; k++) {
            int leftSum = getSum(i, k);
            int rightSum = getSum(k + 1, j);

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, i, k));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, k + 1, j));
            } else {
                int takeLeft = leftSum + solve(stoneValue, i, k);
                int takeRight = rightSum + solve(stoneValue, k + 1, j);
                maxScore = Math.max(maxScore, Math.max(takeLeft, takeRight));
            }
        }

        memo[i][j] = maxScore;
        return maxScore;
    }

    private int getSum(int l, int r) {
        return prefixSum[r + 1] - prefixSum[l];
    }
}