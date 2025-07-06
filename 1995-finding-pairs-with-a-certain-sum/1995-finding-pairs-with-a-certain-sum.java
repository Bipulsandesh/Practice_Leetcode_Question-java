import java.util.*;

class FindSumPairs {
    private int[] arr1, arr2;
    private Map<Integer, Integer> freq;

    public FindSumPairs(int[] nums1, int[] nums2) {
        arr1 = nums1;
        arr2 = nums2;
        freq = new HashMap<>();
        for (int num : arr2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = arr2[index];
        freq.put(oldVal, freq.get(oldVal) - 1);
        arr2[index] += val;
        int newVal = arr2[index];
        freq.put(newVal, freq.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int total = 0;
        for (int num : arr1) {
            int target = tot - num;
            total += freq.getOrDefault(target, 0);
        }
        return total;
    }
}