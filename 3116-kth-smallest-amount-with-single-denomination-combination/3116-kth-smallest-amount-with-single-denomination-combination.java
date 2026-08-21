class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1;
        long right = (long) coins[0] * k;
        for (int coin : coins) {
            right = Math.min(right, (long) coin * k);
        }
        
        long ans = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (count(coins, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private long count(int[] coins, long target) {
        long total = 0;
        int n = coins.length;
        int numSubsets = 1 << n;

        for (int mask = 1; mask < numSubsets; mask++) {
            long currentLcm = 1;
            int bitCount = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bitCount++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    if (currentLcm > target) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) continue;

            if (bitCount % 2 == 1) {
                total += target / currentLcm;
            } else {
                total -= target / currentLcm;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }
}