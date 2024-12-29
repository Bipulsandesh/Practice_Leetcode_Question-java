class Solution {
    public String countAndSay(int n) {
       String str = "1"; 
        for (int j = 1; j < n; j++) {  
            int i = 0;
            int count = 1; 
            StringBuilder temp = new StringBuilder();
            while (i < str.length() - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    count++;  
                } else {
                    temp.append(count).append(str.charAt(i));  
                    count = 1; 
                }
                i++;
            }
            temp.append(count).append(str.charAt(i)); 
            str = temp.toString();
        }
        return str;
    }
}