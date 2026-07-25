// Time complexity: O(log n) for change and find operations
// Space complexity: O(n) for storing the hash maps and ordered sets
class NumberContainers {
    private Map<Integer, TreeSet<Integer>> numToIndices;
    private Map<Integer, Integer> indexToNum;

    public NumberContainers() {
        numToIndices = new HashMap<>();
        indexToNum = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNum.containsKey(index)) {
            int oldNumber = indexToNum.get(index);
            numToIndices.get(oldNumber).remove(index);
            if (numToIndices.get(oldNumber).isEmpty()) {
                numToIndices.remove(oldNumber);
            }
        }
        indexToNum.put(index, number);
        numToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        return numToIndices.containsKey(number) ? numToIndices.get(number).first() : -1;
    }
}