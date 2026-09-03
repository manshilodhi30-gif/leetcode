class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        for(int i=0; i<nums1.length; i++){
            if(nums1[i]<min)min=nums1[i];
        }
        if(min%2==1) return true;
        for(int i: nums1){
            if(i%2==1) return false;// if min is even and element is odd then it will be odd result
        }
        return true;
    }
}