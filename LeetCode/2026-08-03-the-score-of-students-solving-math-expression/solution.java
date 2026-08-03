class Solution {
    // Time complexity: O(n * 2^m * m) where n is the number of answers and m is the number of operators
    // Space complexity: O(2^m * m)
    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length();
        int m = (n + 1) / 2;
        int[][] dp = new int[m][1001];
        dp[0][s.charAt(0) - '0'] = 1;
        for (int i = 1; i < m; i++) {
            char op = s.charAt(2 * i - 1);
            int num = s.charAt(2 * i) - '0';
            if (op == '+') {
                for (int j = 0; j <= 1000; j++) {
                    if (dp[i - 1][j] == 1) {
                        for (int k = 0; k <= 10; k++) {
                            dp[i][j + k] = 1;
                        }
                    }
                }
            } else {
                for (int j = 0; j <= 1000; j++) {
                    if (dp[i - 1][j] == 1) {
                        for (int k = 0; k <= 10; k++) {
                            dp[i][j * k] = 1;
                        }
                    }
                }
            }
        }
        int correct = 0;
        for (int i = 0; i < m - 1; i++) {
            char op = s.charAt(2 * i + 1);
            int num = s.charAt(2 * i + 2) - '0';
            if (op == '+') {
                correct += num;
            } else {
                correct *= num;
            }
        }
        int res = 0;
        for (int ans : answers) {
            if (ans == correct) {
                res += 5;
            } else {
                int temp = 0;
                for (int i = 0; i < m - 1; i++) {
                    char op = s.charAt(2 * i + 1);
                    int num = s.charAt(2 * i + 2) - '0';
                    if (op == '+') {
                        temp += num;
                    } else {
                        temp *= num;
                    }
                    if (dp[i + 1][temp] == 1 && temp == ans) {
                        res += 2;
                        break;
                    }
                }
            }
        }
        return res;
    }
}