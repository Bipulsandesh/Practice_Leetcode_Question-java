import java.util.*;

class Solution {
    private static final class Node {
        final int freq, val;
        Node(int freq, int val){ this.freq = freq; this.val = val; }
        @Override public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node)o; return freq == n.freq && val == n.val;
        }
        @Override public int hashCode(){ return Objects.hash(freq, val); }
    }

    private static final Comparator<Node> COMP = (a, b) -> {
        if (a.freq != b.freq) return Integer.compare(b.freq, a.freq);
        return Integer.compare(b.val, a.val);
    };

    private Map<Integer,Integer> freqMap;
    private TreeSet<Node> topSet, restSet;
    private long topSum;

    private void removeNode(int val, int freq){
        Node key = new Node(freq, val);
        if (topSet.remove(key)) {
            topSum -= 1L * freq * val;
        } else {
            restSet.remove(key);
        }
    }

    private void addToTop(int val, int freq){
        topSet.add(new Node(freq, val));
        topSum += 1L * freq * val;
    }

    private void addValue(int val, int limit){
        int freq = freqMap.getOrDefault(val, 0);
        if (freq > 0) removeNode(val, freq);
        freq += 1;
        freqMap.put(val, freq);
        addToTop(val, freq);
        if (topSet.size() > limit){
            Node lowest = topSet.last();
            topSet.remove(lowest);
            topSum -= 1L * lowest.freq * lowest.val;
            restSet.add(lowest);
        }
    }

    private void removeValue(int val, int limit){
        Integer f = freqMap.get(val);
        if (f == null || f == 0) return;
        int freq = f;
        removeNode(val, freq);
        freq -= 1;
        if (freq == 0) freqMap.remove(val);
        else {
            freqMap.put(val, freq);
            restSet.add(new Node(freq, val));
        }
        if (topSet.size() < limit && !restSet.isEmpty()){
            Node best = restSet.first();
            restSet.remove(best);
            topSet.add(best);
            topSum += 1L * best.freq * best.val;
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        freqMap = new HashMap<>(Math.max(16, n * 2));
        topSet = new TreeSet<>(COMP);
        restSet = new TreeSet<>(COMP);
        topSum = 0;

        for (int i = 0; i < k; ++i) addValue(nums[i], x);
        ans[0] = topSum;
        for (int i = k; i < n; ++i){
            removeValue(nums[i - k], x);
            addValue(nums[i], x);
            ans[i - k + 1] = topSum;
        }
        return ans;
    }
}