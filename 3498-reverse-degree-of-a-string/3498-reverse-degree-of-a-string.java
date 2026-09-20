class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=1; i<=s.length(); i++){
            sum+=(26-(s.charAt(i-1)-'a'))*i;
        }
        return sum;
    }
}