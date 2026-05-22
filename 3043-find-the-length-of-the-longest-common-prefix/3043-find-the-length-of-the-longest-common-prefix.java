import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        
        // Step 1: Insert all possible prefixes of numbers in arr1
        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10; // Chop off the last digit to get the next prefix
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check all possible prefixes of numbers in arr2
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    // String.valueOf(val).length() gives the length of the prefix
                    maxLength = Math.max(maxLength, String.valueOf(val).length());
                    break; // Since we go from largest prefix to smallest, we can stop for this number
                }
                val /= 10;
            }
        }
        
        return maxLength;
    }
}