class Solution {
    
    public int maxLevelSum(TreeNode root) {
        List<Integer> nodesSumList = new ArrayList<>();
        getMaxLevelSum(root, 0, nodesSumList);
        int maxSum = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;
        for(int i=0; i<nodesSumList.size(); i++) {
            if(maxSum < nodesSumList.get(i)) {
                maxSum = nodesSumList.get(i);
                minLevel = i;
            }
            else if(maxSum == nodesSumList.get(i) && minLevel > i) {
                minLevel = i;
            }
        }

        return minLevel+1;
    }

    public void getMaxLevelSum(TreeNode root, int currLevel, List<Integer> nodesSumList) {
        if(root == null) {
            return;
        }
        if(nodesSumList.size() == currLevel) {
            nodesSumList.add(root.val);
        } else {
            nodesSumList.set(currLevel, nodesSumList.get(currLevel) + root.val);
        }
        getMaxLevelSum(root.left, currLevel+1, nodesSumList);
        getMaxLevelSum(root.right, currLevel+1, nodesSumList);
    }
}