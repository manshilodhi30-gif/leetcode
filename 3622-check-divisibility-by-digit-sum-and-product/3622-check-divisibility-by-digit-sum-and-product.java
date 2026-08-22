class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum=0;
        int digitP=1;
        int temp=n;
        while(n!=0){
            int d=n%10;
            digitSum+=d;
            digitP*=d;
            n=n/10;

        }
        int total=digitSum+digitP;
        if(total==0){
            return false;
        }
        return temp%total==0;
    }
}