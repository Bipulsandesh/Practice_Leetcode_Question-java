class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int current, int max, List<Integer> result) {
        if (current > max) return;
        result.add(current);
        for (int i = 0; i < 10; i++) {
            int next = current * 10 + i;
            if (next > max) return;
            dfs(next, max, result);
        }
    }
}