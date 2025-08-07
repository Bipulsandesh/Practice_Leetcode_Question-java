class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int res = 0;
        for (int i = 0; i < fruits.length; i++){
            for (int j = 0; j < fruits.length; j++){
                if (i == j){
                    res += fruits[i][j]; 
                }
            }
        } 
        int[][] dp = new int[fruits.length][fruits.length]; 
        dp[0][fruits.length - 1] = fruits[0][fruits.length - 1];
        dp[fruits.length - 1][0] = fruits[fruits.length - 1][0];  
        int[][] iprev = {{-1, -1,}, {-1, 0}, {-1, 1}};
        int[][] jprev = {{-1, -1}, {0, -1}, {1, -1}};  
        for (int i = 1; i < fruits.length; i++){
            for (int j = 1; j < fruits.length; j++){
                if (i == j){
                    continue; 
                }
                if (j > i){
                    if (i < (fruits.length - 1 - j)){
                        continue; 
                    }
                    for (int[] dir : iprev){
                        if (i + dir[0] < 0 || i + dir[0] >= fruits.length || j + dir[1] < 0 || j + dir[1] >= fruits.length){
                            continue; 
                        }
                        dp[i][j] = Math.max(dp[i][j], fruits[i][j] + dp[i + dir[0]][j + dir[1]]); 
                    }
                }
            }
        }
        for (int j = 0; j < fruits.length; j++){
            for (int i = 0; i < fruits.length; i++){
                if (i > j){
                    if (j < (fruits.length - 1 - i)){
                        continue; 
                    }
                    for (int[] dir : jprev){
                        if (i + dir[0] < 0 || i + dir[0] >= fruits.length || j + dir[1] < 0 || j + dir[1] >= fruits.length){
                            continue; 
                        }
                        dp[i][j] = Math.max(dp[i][j], fruits[i][j] + dp[i + dir[0]][j + dir[1]]); 
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp)); 
        res += dp[fruits.length - 2][fruits.length - 1]; 
        res += dp[fruits.length - 1][fruits.length - 2]; 
        return res;  
    }
}