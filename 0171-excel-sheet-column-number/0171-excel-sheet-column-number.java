class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle.length() == 1) {
            return columnTitle.charAt(0) - 'A' + 1;
        }
        if (columnTitle.length() == 2) {
            return ((columnTitle.charAt(0) - 'A' + 1) * 26 + (columnTitle.charAt(1) - 'A' + 1));
        }
        if (columnTitle.length() == 3) {
            return ((columnTitle.charAt(0) - 'A' + 1) * 26 * 26 
                  + (columnTitle.charAt(1) - 'A' + 1) * 26 
                  + (columnTitle.charAt(2) - 'A' + 1));
        }
        if (columnTitle.length() == 4) {
            return ((columnTitle.charAt(0) - 'A' + 1) * 26 * 26 * 26 
                  + (columnTitle.charAt(1) - 'A' + 1) * 26 * 26 
                  + (columnTitle.charAt(2) - 'A' + 1) * 26 
                  + (columnTitle.charAt(3) - 'A' + 1));
        }
        if (columnTitle.length() == 5) {
            return ((columnTitle.charAt(0) - 'A' + 1) * 26 * 26 * 26 * 26 
                  + (columnTitle.charAt(1) - 'A' + 1) * 26 * 26 * 26 
                  + (columnTitle.charAt(2) - 'A' + 1) * 26 * 26 
                  + (columnTitle.charAt(3) - 'A' + 1) * 26 
                  + (columnTitle.charAt(4) - 'A' + 1));
        }
        if (columnTitle.length() == 6) {
            return ((columnTitle.charAt(0) - 'A' + 1) * 26 * 26 * 26 * 26 * 26 
                  + (columnTitle.charAt(1) - 'A' + 1) * 26 * 26 * 26 * 26 
                  + (columnTitle.charAt(2) - 'A' + 1) * 26 * 26 * 26 
                  + (columnTitle.charAt(3) - 'A' + 1) * 26 * 26 
                  + (columnTitle.charAt(4) - 'A' + 1) * 26 
                  + (columnTitle.charAt(5) - 'A' + 1));
        }
        if (columnTitle.length() == 7) {
            return ((columnTitle.charAt(0) - 'A' + 1) * 26 * 26 * 26 * 26 * 26 * 26 
                  + (columnTitle.charAt(1) - 'A' + 1) * 26 * 26 * 26 * 26 * 26 
                  + (columnTitle.charAt(2) - 'A' + 1) * 26 * 26 * 26 * 26 
                  + (columnTitle.charAt(3) - 'A' + 1) * 26 * 26 * 26 
                  + (columnTitle.charAt(4) - 'A' + 1) * 26 * 26 
                  + (columnTitle.charAt(5) - 'A' + 1) * 26 
                  + (columnTitle.charAt(6) - 'A' + 1));
        }
        return 0;
    }
}