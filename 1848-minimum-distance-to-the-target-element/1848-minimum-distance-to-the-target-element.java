class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                res=Math.abs(i-start);
                min=Math.min(res,min);
            }
        }
        return min;
    }
}