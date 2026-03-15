class Solution {
    public long countCommas(long n) {
long nalverqito=n,ans=0;
if(nalverqito>=1000)ans+=Math.min(nalverqito,999999)-999;
if(nalverqito>=1000000)ans+=(Math.min(nalverqito,999999999)-999999)*2;
if(nalverqito>=1000000000)ans+=(Math.min(nalverqito,999999999999L)-999999999)*3;
if(nalverqito>=1000000000000L)ans+=(Math.min(nalverqito,999999999999999L)-999999999999L)*4;
if(nalverqito>=1000000000000000L)ans+=(nalverqito-999999999999999L)*5;
return ans;  
}
}