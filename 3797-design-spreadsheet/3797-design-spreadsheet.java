class Spreadsheet {

    // Our digital notebook's memory. It stores cell names (e.g., "A1") and their values.
    private final Map<String, Integer> map;

    // Constructor: We create a new spreadsheet with a given number of rows.
    // (The 'rows' parameter isn't used, which is a bit quirky! \U0001f914)
    public Spreadsheet(int rows) {
        this.map = new HashMap<>(); // We prepare a fresh, empty memory.
    }
    
    // Write a number into a named cell. Like writing "5" on the page labeled "A1".
    public void setCell(String cell, int value) {
        map.put(cell, value); // Puts the value into our memory under the cell name.
    }
    
    // Erase a cell from the notebook.
    public void resetCell(String cell) {
        map.remove(cell); // Finds the cell name in memory and deletes it.
    }
    
    // The magic method! Give it a string, and it gives you back a number.
    public int getValue(String formula) {
        // Find the position of the '+' sign in the formula string.
        // Example: For "=A1+5", plusIndex will be 3 (the index of '+').
        int plusIndex = formula.indexOf('+');
        
        // Split the formula into two parts around the '+' sign.
        // Part 1: From right after the '=' sign (index 1) to the '+' sign.
        String cell1 = formula.substring(1, plusIndex); // For "=A1+5", this is "A1"
        // Part 2: Everything after the '+' sign.
        String cell2 = formula.substring(plusIndex + 1); // For "=A1+5", this is "5"
        
        // Now, let's figure out what numerical values these two parts represent.
        int val1 = parseValue(cell1); // Decodes "A1" -> looks up its value in memory.
        int val2 = parseValue(cell2); // Decodes "5" -> converts the string to number 5.

        // Finally, add the two values together and return the result!
        return val1 + val2;
    }

    // The decoder ring! This helper method translates a string into a number.
    private int parseValue(String input) {
        // How does it work? It checks the first character of the string.
        // If the first char is a letter (its value is greater than '9'), it's a cell name.
        // If it's a digit, it's a direct number.
        return (input.charAt(0) > '9')
                ? map.getOrDefault(input, 0) // It's a cell name: look it up. If not found, use 0.
                : Integer.parseInt(input);    // It's a direct number: convert the string to an integer.
    }
}