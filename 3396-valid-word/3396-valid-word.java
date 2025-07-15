class Solution {
    public boolean isValid(String word) {
        int n = word.length();
        if(n < 3) return false;
        int vc = 0, cc = 0;
        word = word.toLowerCase();
        for(char ch : word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) return false;
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vc++;
            } else if(Character.isLetter(ch)) {
                cc++;
            }
        }
        if(vc > 0 && cc > 0) return true;
        return false;
    }
}