class Solution {
    public int maxDistance(String st, int k) {
        int maxDist = 0;
        int north = 0, south = 0, east = 0, west = 0;
        
        for (int i = 0; i < st.length(); i++) {
            char dir = st.charAt(i);
            switch (dir) {
                case 'N': north++; break;
                case 'S': south++; break;
                case 'E': east++; break;
                case 'W': west++; break;
            }
            
            int xDist = Math.abs(north - south);
            int yDist = Math.abs(east - west);
            int currentDist = xDist + yDist;
            
            // Calculate maximum possible improvement
            int remainingMoves = i + 1 - currentDist;
            int possibleImprovement = Math.min(2 * k, remainingMoves);
            
            maxDist = Math.max(maxDist, currentDist + possibleImprovement);
        }
        
        return maxDist;
    }
}