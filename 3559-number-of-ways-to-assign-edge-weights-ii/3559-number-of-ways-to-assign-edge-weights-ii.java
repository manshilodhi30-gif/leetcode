import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // Precompute depths and binary lifting table for LCA
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;
        int[][] up = new int[n + 1][maxLog];
        int[] depth = new int[n + 1];
        dfs(1, 1, 0, adj, up, depth, maxLog);

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) {
                results[i] = 0;
                continue;
            }

            int lca = getLCA(u, v, depth, up, maxLog);
            int dist = depth[u] + depth[v] - 2 * depth[lca];
            
            // The problem is equivalent to choosing weights 1 or 2 
            // such that the sum is odd.
            // For a path of length k, the number of ways to have an odd sum
            // is 2^(k-1) ways.
            results[i] = power(2, dist - 1);
        }
        return results;
    }

    private void dfs(int u, int p, int d, List<Integer>[] adj, int[][] up, int[] depth, int maxLog) {
        depth[u] = d;
        up[u][0] = p;
        for (int i = 1; i < maxLog; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }
        for (int v : adj[u]) {
            if (v != p) dfs(v, u, d + 1, adj, up, depth, maxLog);
        }
    }

    private int getLCA(int u, int v, int[] depth, int[][] up, int maxLog) {
        if (depth[u] < depth[v]) { int temp = u; u = v; v = temp; }
        for (int i = maxLog - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) u = up[u][i];
        }
        if (u == v) return u;
        for (int i = maxLog - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    private int power(long base, int exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return (int) res;
    }
}