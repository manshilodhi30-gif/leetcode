class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int finishLand = landStartTime[i] + landDuration[i];
                int startWater = Math.max(finishLand, waterStartTime[j]);
                int finishWater = startWater + waterDuration[j];
                minFinishTime = Math.min(minFinishTime, finishWater);

                int finishWaterFirst = waterStartTime[j] + waterDuration[j];
                int startLand = Math.max(finishWaterFirst, landStartTime[i]);
                int finishLandSecond = startLand + landDuration[i];
                minFinishTime = Math.min(minFinishTime, finishLandSecond);
            }
        }

        return minFinishTime;
    }
}