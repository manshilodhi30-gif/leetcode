class Solution {
    public int longestSubsequence(int[] nums) {
        int total=0;
        boolean flag=false;
        for(int num: nums){
            total=total^num;
            // check is all elements zero?
            if(num !=0){
                flag=true;// if all is zero then this condition never become true;
            }
        }
        if(total != 0){
            return nums.length;
        }
        if(flag){
            return nums.length-1;
        }
        return 0;
    }
}