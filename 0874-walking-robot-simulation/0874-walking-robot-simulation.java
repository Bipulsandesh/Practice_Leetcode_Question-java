class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0, x = 0, y = 0, res = 0;

        for (int c : commands) {
            if (c == -2) d = (d + 3) % 4;
            else if (c == -1) d = (d + 1) % 4;
            else {
                for (int i = 0; i < c; i++) {
                    int ox = x + dirs[d][0];
                    int oy = y + dirs[d][1];
                    if (set.contains(ox + "," + oy)) 
                        break;
                    x = ox;
                    y = oy;
                    res = Math.max(res, x*x + y*y);
                }
            }
        }

        return res;
    }
}