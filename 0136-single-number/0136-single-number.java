import java.util.HashMap;
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> my=new HashMap<>();
        for(int i:nums){
            my.put(i,my.getOrDefault(i,0)+1);
        }
        for(var pair:my.entrySet()){
            if(pair.getValue()==1){
                return pair.getKey();
            }
        }
        return -1;
    }
}