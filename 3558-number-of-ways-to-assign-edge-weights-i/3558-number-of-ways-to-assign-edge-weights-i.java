class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        java.util.List<Integer>[] adj = new java.util.List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new java.util.ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] depth = new int[n + 1];
        int maxDepth = 0;
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.add(1);
        depth[1] = 0;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            maxDepth = Math.max(maxDepth, depth[u]);
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[u] + 1;
                    q.add(v);
                }
            }
        }
        long mod = 1_000_000_007;
        long res = 1;
        for (int i = 0; i < maxDepth - 1; i++) {
            res = (res * 2) % mod;
        }
        return (int) res;
    }
}