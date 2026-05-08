import java.util.*;

class Solution {
    private static final int MAX_VAL = 1000001;
    private static boolean[] isPrime = new boolean[MAX_VAL];
    private static List<Integer>[] primeToIndices = new ArrayList[MAX_VAL];

    static {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p < MAX_VAL; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < MAX_VAL; i += p)
                    isPrime[i] = false;
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> multiples = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            // Pre-calculate which indices are divisible by which primes
            // only for primes that actually appear in the array
            for (int p = 2; p * p <= val; p++) {
                if (val % p == 0) {
                    multiples.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    while (val % p == 0) val /= p;
                }
            }
            if (val > 1) {
                multiples.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Set<Integer> usedPrimes = new HashSet<>();

        queue.offer(0);
        dist[0] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == n - 1) return dist[curr];

            // 1. Adjacent Steps
            int[] neighbors = {curr - 1, curr + 1};
            for (int next : neighbors) {
                if (next >= 0 && next < n && dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }

            // 2. Prime Teleportation (ONLY if nums[curr] is prime)
            int p = nums[curr];
            if (p < MAX_VAL && isPrime[p] && !usedPrimes.contains(p)) {
                if (multiples.containsKey(p)) {
                    for (int nextIdx : multiples.get(p)) {
                        if (dist[nextIdx] == -1) {
                            dist[nextIdx] = dist[curr] + 1;
                            queue.offer(nextIdx);
                        }
                    }
                }
                usedPrimes.add(p);
            }
        }

        return -1;
    }
}