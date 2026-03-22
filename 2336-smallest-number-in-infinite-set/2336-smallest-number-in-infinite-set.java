import java.util.*;
class SmallestInfiniteSet {
    private int current;                  
    private PriorityQueue<Integer> pq;    
    private HashSet<Integer> set;         
    public SmallestInfiniteSet() {
        current = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();
    }
    public int popSmallest() {
        if (!pq.isEmpty()) {
            int val = pq.poll();
            set.remove(val);
            return val;
        }
        return current++;
    }
    public void addBack(int num) {
        if (num < current && !set.contains(num)) {
            pq.add(num);
            set.add(num);
        }
    }
}