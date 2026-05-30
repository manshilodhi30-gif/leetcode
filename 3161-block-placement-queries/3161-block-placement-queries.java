import java.util.*;

class Solution {
    private int[] tree;
    private final int MAX = 50000;

    public List<Boolean> getResults(int[][] queries) {
        tree = new int[4 * (MAX + 1)];
        // The TreeSet maintains all obstacle positions
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        
        List<Boolean> results = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                Integer prev = set.lower(x);
                // Update: The gap at position 'x' is now (x - prev)
                update(1, 0, MAX, x, x - (prev == null ? 0 : prev));
                
                // Update: The gap at the 'next' obstacle needs to be recalculated
                Integer next = set.higher(x);
                if (next != null) {
                    update(1, 0, MAX, next, next - x);
                }
                set.add(x);
            } else {
                int x = q[1], sz = q[2];
                // Query: Max gap in [0, x]
                // 1. Check max gap recorded in obstacles before x
                // 2. Check the space between the last obstacle and x
                int last = set.floor(x);
                int maxGapBefore = query(1, 0, MAX, 0, last);
                
                if (Math.max(maxGapBefore, x - last) >= sz) {
                    results.add(true);
                } else {
                    results.add(false);
                }
            }
        }
        return results;
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, val);
        else update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return Math.max(query(2 * node, start, mid, l, r), 
                        query(2 * node + 1, mid + 1, end, l, r));
    }
}