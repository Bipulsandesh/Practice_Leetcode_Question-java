class Solution {

    static HashMap<Integer, Integer> memory = new HashMap<>();
    static int max = 0;
    ArrayList<ArrayList<String>> perms;

    public void partitions(ArrayList<String> arr, String s) {
        if (s.length() == 0) {
            perms.add(arr);
        }
        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> temp = new ArrayList<>(arr);
            temp.add(s.substring(0, i + 1));
            partitions(temp, s.substring(i + 1));
        }
    }

    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if(i <= max) {
                result += memory.getOrDefault(i, 0);
                continue;
            }
            perms = new ArrayList<>();
            partitions(new ArrayList<>(), (i * i) + "");
            for (int j = 0; j < perms.size(); j++) {
                int curr = 0;
                for (int k = 0; k < perms.get(j).size(); k++) {
                    curr += Integer.parseInt(perms.get(j).get(k));
                }
                if(curr == i) {
                    result += i * i;
                    memory.put(i, i * i);
                    break;
                }
            }
        }
        max = Math.max(max, n);
        return result;
    }
}
