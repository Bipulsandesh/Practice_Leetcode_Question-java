class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map value to index in nums2
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        // Map nums1 values to their indices in nums2
        int[] nums1_mapped = new int[n];
        for (int i = 0; i < n; i++) {
            nums1_mapped[i] = posInNums2[nums1[i]];
        }

        // Count elements to the left that are smaller using Fenwick Tree
        FenwickTree bit = new FenwickTree(n);
        int[] leftLess = new int[n];
        for (int i = 0; i < n; i++) {
            leftLess[i] = bit.query(nums1_mapped[i]);
            bit.update(nums1_mapped[i], 1);
        }

        // Reset for right pass
        bit = new FenwickTree(n);
        int[] rightGreater = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = bit.query(n - 1) - bit.query(nums1_mapped[i]);
            bit.update(nums1_mapped[i], 1);
        }

        // Calculate total good triplets
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (long) leftLess[i] * rightGreater[i];
        }

        return result;
    }

    // Fenwick Tree / BIT implementation
    class FenwickTree {
        private int[] tree;
        private int size;

        public FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 1];
        }

        public void update(int index, int value) {
            index++;  // 1-based indexing
            while (index <= size) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            index++;  // 1-based indexing
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}