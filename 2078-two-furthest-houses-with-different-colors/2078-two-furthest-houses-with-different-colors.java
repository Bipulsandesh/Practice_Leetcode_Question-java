class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        //compare with first house
        for(int i = n - 1; i >= 0; i--) {
            if(colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i);
                break;
            }
        }
        
        //compare with last house
        for(int i = 0; i < n; i++) {
            if(colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, n - 1 - i);
                break;
            }
        }

        return maxDist;
    }
}