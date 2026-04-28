class Solution {
    public int minOperations(int[][] grid, int x) {
        /**
        List<Integer> count = new ArrayList<>();
        for (int[] row : grid){
            for (int num : row){
                count.add(num);
            }
        }
        Collections.sort(count);
        for (int c : count){
            if (Math.abs(c - count.get(0)) % x != 0){
                return -1;
            }
        }
        int cost = count.get(count.size() / 2);
        int op = 0;
        for (int c : count){
            op += Math.abs(c - cost) / x;
        }
        return op;
        */
        List<Integer> res = new ArrayList<>();
        for (int[] row : grid) {
            for (int v : row) 
                res.add(v);
        }

        int mod = res.get(0) % x;
        for (int v : res) {
            if (v % x != mod) 
                return -1;
        }

        Collections.sort(res);
        int m = res.get(res.size() / 2);
        int cnt = 0;
        for (int v : res) {
            cnt += Math.abs(v - m) / x;
        }
        return cnt;
    }
}
