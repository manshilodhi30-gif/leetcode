class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> l = new PriorityQueue<>();
        PriorityQueue<Integer> r = new PriorityQueue<>();
        int i = 0, j = n - 1;
        long ans = 0;
        for (int x = 0; x < candidates && i <= j; x++) {
            l.add(costs[i++]);
        }
        for (int x = 0; x < candidates && i <= j; x++) {
            r.add(costs[j--]);
        }
        while (k-- > 0) {
            if (r.isEmpty() || (!l.isEmpty() && l.peek() <= r.peek())) {
                ans += l.poll();
                if (i <= j) l.add(costs[i++]);
            } else {
                ans += r.poll();
                if (i <= j) r.add(costs[j--]);
            }
        }
        return ans;
    }
}