class Solution { 
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) { 
        boolean[] busy = new boolean[baskets.length]; 
        boolean placed = false; 
        int remain = 0;

        for (int i = 0; i < fruits.length; i++) { 
            placed = false; // Reset the "placed" flag to false for each *new* type of fruit. We assume we won't find a basket until we actually do.

            for (int j = 0; j < baskets.length; j++) { 
                // Check if the current basket is NOT busy AND if its capacity is enough for the current fruit.
                if (busy[j] == false && baskets[j] >= fruits[i]) {

                    busy[j] = true; // If both conditions are met, we mark this basket as busy (red light!). We've found a home for this fruit!
                    placed = true;  // Since we found a basket, we set our "placed" flag to true.
                    break;          // We've found the *first* suitable basket, so we don't need to check any more baskets for this fruit. We "break" out of the inner basket-checking loop.

                }
            }

            // After checking all the baskets for the current fruit:
            if (placed == false) { // If our "placed" flag is still false, it means we couldn't find any suitable basket for this fruit.
                remain++; // So, we increment our "unplaced fruits" counter.
            }
        }

        return remain; 
    }
}