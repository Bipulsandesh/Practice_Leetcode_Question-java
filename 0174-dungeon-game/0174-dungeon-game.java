class Solution {
    private int memoizationUtil(int[][] dungeon, int row, int col, int[][] dp) {
		if (row >= dungeon.length || col >= dungeon[0].length) {
			return Integer.MAX_VALUE;
		}
		if (dp[row][col] != -1) {
			return dp[row][col];
		}
		int down = memoizationUtil(dungeon, row + 1, col, dp);
		int right = memoizationUtil(dungeon, row, col + 1, dp);
		if (dungeon[row][col] < 0) {
			dp[row][col] = Math.min(down, right) + Math.abs(dungeon[row][col]);
		} else {
			int health = Math.min(down, right) - dungeon[row][col];
			if (health <= 0) {
				health = 1;
			}
			dp[row][col] = health;
		}
		return dp[row][col];
	}

	private int memoization(int[][] dungeon) {
		int[][] dp = new int[dungeon.length][dungeon[0].length];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int princess = dungeon[dungeon.length - 1][dungeon[0].length - 1];
		dp[dungeon.length - 1][dungeon[0].length - 1] = princess < 0 ? -1 * princess + 1 : 1;
		return memoizationUtil(dungeon, 0, 0, dp);
	}

	private int tabulation(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];//Add extra row and column at bottom and right side to handle edge case
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		int princess = dungeon[dungeon.length - 1][dungeon[0].length - 1];
		dp[m - 1][n - 1] = princess < 0 ? -1 * princess + 1 : 1;
		for (int row = m - 1; row >= 0; row--) {
			for (int col = n - 1; col >= 0; col--) {
				if (row == m - 1 && col == n - 1) {
					continue;
				}
				int health = Math.min(dp[row + 1][col], dp[row][col + 1]) - dungeon[row][col];//No need to write extra code to check row + 1 < m and col + 1 < n 
				if (dungeon[row][col] >= dp[row + 1][col] || dungeon[row][col] >= dp[row][col + 1]) {
					health = 1;
				}
				dp[row][col] = health;
			}
		}
		return dp[0][0];
	}

	public int calculateMinimumHP(int[][] dungeon) {
//		return memoization(dungeon);
		return tabulation(dungeon);
	}
}