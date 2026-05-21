class Solution {
    class TrieNode
    {
        TrieNode[] child = new TrieNode[10];
    }
    TrieNode root = new TrieNode();
    void insert(int num)
    {
        String s = Integer.toString(num);
        TrieNode curr = root;
        for(char ch : s.toCharArray())
        {
            int idx = ch-'0';
            if(curr.child[idx]==null)
            curr.child[idx] = new TrieNode();

            curr = curr.child[idx];
        }
    }

    int search(int num)
    {
        String s = Integer.toString(num);
        TrieNode curr = root;
        int len = 0;
        for(char ch : s.toCharArray())
        {
            int idx = ch-'0';
            if(curr.child[idx]==null)
            break;
            len++;
            curr = curr.child[idx];
        }
        return len;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int num : arr1)
        insert(num);
        int max = 0;
        for(int num : arr2)
        max = Math.max(max,search(num));
        return max;
    }
}