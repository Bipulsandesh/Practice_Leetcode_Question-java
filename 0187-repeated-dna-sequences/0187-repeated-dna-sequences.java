class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> seen = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (seen.containsKey(substring)) {
                if (seen.get(substring) == 1) {
                    result.add(substring);
                }
                seen.put(substring, seen.get(substring) + 1);
            } else {
                seen.put(substring, 1);
            }
        }
        return result;
    }
}