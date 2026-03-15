class Solution {
    public int countCommas(int n) {
       int res=0;
        if(n>=1000)res+=Math.min(n,999999)-999;
        if(n>=1000000)res+=(Math.min(n,99999999)-999999)*2;
        if(n>=100000000)res+=(Math.min(n,999999999)-99999999)*3;
        return res;

    }
}