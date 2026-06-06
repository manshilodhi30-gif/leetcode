class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        int currentLeft = 0;
        for (int i = 0; i < n; i++) {
            leftSum[i] = currentLeft;
            currentLeft += nums[i];
        }
        
        int currentRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = currentRight;
            currentRight += nums[i];
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        
        return answer;
    }
}