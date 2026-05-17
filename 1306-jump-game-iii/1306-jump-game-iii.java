class Solution {
    public boolean canReach(int[] arr, int start) {
        // Base case: check array boundaries and if the index is already visited
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        
        // If we find a 0, we've successfully reached the target
        if (arr[start] == 0) {
            return true;
        }
        
        // Cache the jump value and mark the current index as visited
        int jump = arr[start];
        arr[start] = -arr[start]; 
        
        // Recursively try jumping forward and backward
        // If the original jump value was 0, it would have been caught above,
        // so marking it negative safely handles non-zero values.
        return canReach(arr, start + jump) || canReach(arr, start - jump);
    }
}