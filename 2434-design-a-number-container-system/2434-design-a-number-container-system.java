import java.util.*;

class NumberContainers {
    private Map<Integer, TreeSet<Integer>> numberToIndices;
    private Map<Integer, Integer> indexToNumber;

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            numberToIndices.get(oldNumber).remove(index);
            if (numberToIndices.get(oldNumber).isEmpty()) {
                numberToIndices.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);
        if (!numberToIndices.containsKey(number)) {
            numberToIndices.put(number, new TreeSet<>());
        }
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }
        return numberToIndices.get(number).first();
    }
}

