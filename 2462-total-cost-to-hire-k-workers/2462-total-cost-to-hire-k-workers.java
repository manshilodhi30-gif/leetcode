import java.util.*;

class Solution {
    public long totalCost(int[] c, int k, int m) {
        
        PriorityQueue<Integer> l = new PriorityQueue<>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        
        int i = 0, j = c.length - 1;
        
        for (int x = 0; x < m && i <= j; x++) {
            l.add(c[i++]);
        }
        
        for (int x = 0; x < m && i <= j; x++) {
            r.add(c[j--]);
        }
        
        long ans = 0;
        
        for (int x = 0; x < k; x++) {
            int a = l.isEmpty() ? Integer.MAX_VALUE : l.peek();
            int b = r.isEmpty() ? Integer.MAX_VALUE : r.peek();
            
            if (a <= b) {
                ans += l.poll();
                if (i <= j) l.add(c[i++]);
            } else {
                ans += r.poll();
                if (i <= j) r.add(c[j--]);
            }
        }
        
        return ans;
    }
}