class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        for (int i = 100; i <= 998; i += 2) {
            int d1 = i / 100;
            int d2 = (i / 10) % 10;
            int d3 = i % 10;

            int[] tempFreq = new int[10];
            tempFreq[d1]++;
            tempFreq[d2]++;
            tempFreq[d3]++;

            if (freq[d1] >= tempFreq[d1] &&
                freq[d2] >= tempFreq[d2] &&
                freq[d3] >= tempFreq[d3]) {
                count++;
            }
        }

        return count;
    }
}