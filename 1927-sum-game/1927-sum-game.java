class Solution {
    public boolean sumGame(String num) {
        int n=num.length(),half=n/2;
        int leftSum =0,rightSum=0,leftQ=0,rightQ=0;
        for (int i=0;i<half;i++) {
            if (num.charAt(i)=='?')leftQ++;
            else leftSum+=num.charAt(i)-'0';
        }
        for (int i=half;i<n;i++) {
            if (num.charAt(i)=='?')rightQ++;
            else rightSum+=num.charAt(i)-'0';
        }
        return (leftSum-rightSum)*2+(leftQ-rightQ)*9!= 0;
    }
}
