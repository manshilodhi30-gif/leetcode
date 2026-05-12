import java.util.*;
class Solution{
    public int minimumEffort(int[][] tasks){
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int res=0,cur=0;
        for(int[] t:tasks){
            res=Math.max(res,cur+t[1]);
            cur+=t[0];
        }
        return res;
    }
}
