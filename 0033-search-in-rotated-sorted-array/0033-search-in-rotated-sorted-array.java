class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If target is found, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Narrow search to left half
                } else {
                    low = mid + 1;  // Look in the right half
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Check if target lies within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Narrow search to right half
                } else {
                    high = mid - 1; // Look in the left half
                }
            }
        }

        // Target was not found in the array
        return -1;
    }
}