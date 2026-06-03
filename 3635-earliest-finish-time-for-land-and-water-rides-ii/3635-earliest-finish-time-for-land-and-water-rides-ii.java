class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(calculate(landStartTime, landDuration, waterStartTime, waterDuration),
                        calculate(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    private int calculate(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        int minEnd1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minEnd1 = Math.min(minEnd1, start1[i] + dur1[i]);
        }

        int minTotalFinish = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            int finishTime = Math.max(minEnd1, start2[i]) + dur2[i];
            minTotalFinish = Math.min(minTotalFinish, finishTime);
        }

        return minTotalFinish;
    }
}