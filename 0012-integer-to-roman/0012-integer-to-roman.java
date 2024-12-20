class Solution {
    public String intToRoman(int num) {
        String Roman = "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        int i = 1000;
        while (i != 0) {
            int a = (num / i);
            num = num - a * i;
            if (a != 0 && (a == 2 || a == 3 || a == 1)) {
                for (int j = 0; j < a; j++) {
                    Roman += map.get(1 * i);
                }

            } else if (a != 0 && (a == 5 || a == 6 || a == 7 || a == 8)) {
                Roman += map.get(5 * i);
                num = num + ((a - 5) * i);
                i *= 10;

            } else if (a != 0) {
                Roman += map.get(1 * i);
                if (a == 4) {
                    Roman += map.get(5 * i);
                } else {
                    Roman += map.get(10 * i);
                }

            }
            i /= 10;
        }
        return Roman;
    }
}