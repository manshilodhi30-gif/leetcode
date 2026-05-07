class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        int lastCut = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || prefixMax[i] <= suffixMin[i + 1]) {
                int currentSegmentMax = prefixMax[i];
                for (int j = lastCut; j <= i; j++) {
                    ans[j] = currentSegmentMax;
                }
                lastCut = i + 1;
            }
        }
        return ans;
    }
}