class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        int[] prevCount = null;

        for (String word : words) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            if (prevCount == null || !Arrays.equals(count, prevCount)) {
                result.add(word);
                prevCount = count;
            }
        }

        return result;
    }
}