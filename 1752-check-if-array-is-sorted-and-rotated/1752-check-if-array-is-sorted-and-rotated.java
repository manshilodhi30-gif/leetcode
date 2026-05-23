class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the next element
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            
            // If there's more than one drop, it can't be a sorted and rotated array
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}