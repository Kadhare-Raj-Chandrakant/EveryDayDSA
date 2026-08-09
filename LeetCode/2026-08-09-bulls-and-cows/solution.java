class Solution {
    // Time complexity: O(n), where n is the length of the secret string
    // Space complexity: O(1), as we are using a constant amount of space
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                countSecret[secret.charAt(i) - '0']++;
                countGuess[guess.charAt(i) - '0']++;
            }
        }

        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(countSecret[i], countGuess[i]);
        }

        return bulls + "A" + cows + "B";
    }
}