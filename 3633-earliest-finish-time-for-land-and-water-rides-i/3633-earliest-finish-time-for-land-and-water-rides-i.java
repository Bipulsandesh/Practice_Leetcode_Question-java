class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                // Land -> Water
                int finishLand = landStartTime[i] + landDuration[i];
                int finishLW = Math.max(finishLand, waterStartTime[j]) + waterDuration[j];

                // Water -> Land
                int finishWater = waterStartTime[j] + waterDuration[j];
                int finishWL = Math.max(finishWater, landStartTime[i]) + landDuration[i];

                ans = Math.min(ans, Math.min(finishLW, finishWL));
            }
        }

        return ans;
    }
}