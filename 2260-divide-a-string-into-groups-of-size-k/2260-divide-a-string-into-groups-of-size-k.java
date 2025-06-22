class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i += k) {
            int end = Math.min(i + k, s.length());
            StringBuilder group = new StringBuilder(s.substring(i, end));

            // Fill with 'fill' character if needed
            while (group.length() < k) {
                group.append(fill);
            }

            res.add(group.toString());
        }
        return res.toArray(new String[0]);
    }
}