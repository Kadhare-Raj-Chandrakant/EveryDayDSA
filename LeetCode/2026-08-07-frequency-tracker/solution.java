class FrequencyTracker {
    // Time complexity: O(1) for all operations
    // Space complexity: O(n) where n is the number of unique elements
    private int[] freqMap, freqCount;

    public FrequencyTracker() {
        freqMap = new int[100001]; // to store frequency of each number
        freqCount = new int[100001]; // to store count of each frequency
    }

    public void add(int number) {
        if (freqMap[number] > 0) {
            freqCount[freqMap[number]]--; // decrease count of previous frequency
        }
        freqMap[number]++; // increase frequency of number
        freqCount[freqMap[number]]++; // increase count of new frequency
    }

    public void deleteOne(int number) {
        if (freqMap[number] > 0) {
            freqCount[freqMap[number]]--; // decrease count of previous frequency
            freqMap[number]--; // decrease frequency of number
            if (freqMap[number] > 0) {
                freqCount[freqMap[number]]++; // increase count of new frequency
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqCount[frequency] > 0; // return true if frequency exists
    }
}