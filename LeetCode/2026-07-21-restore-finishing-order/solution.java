class Solution {
    // Time complexity: O(n + m), where n is the length of order and m is the length of friends
    // Space complexity: O(m), where m is the length of friends
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> friendSet = new HashSet<>();
        for (int friend : friends) {
            friendSet.add(friend);
        }
        
        List<Integer> friendOrder = new ArrayList<>();
        for (int participant : order) {
            if (friendSet.contains(participant)) {
                friendOrder.add(participant);
            }
        }
        
        int[] result = new int[friendOrder.size()];
        for (int i = 0; i < friendOrder.size(); i++) {
            result[i] = friendOrder.get(i);
        }
        
        return result;
    }
}