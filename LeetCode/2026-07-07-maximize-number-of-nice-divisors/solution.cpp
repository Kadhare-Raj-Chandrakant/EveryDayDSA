class Solution {
public:
    // Time complexity: O(primeFactors)
    // Space complexity: O(1)
    int maxNiceDivisors(int primeFactors) {
        const int MOD = 1e9 + 7;
        if (primeFactors % 3 == 0) {
            return pow(3, primeFactors / 3, MOD);
        } else if (primeFactors % 3 == 1) {
            return (pow(3, primeFactors / 3 - 1, MOD) * 4) % MOD;
        } else {
            return (pow(3, primeFactors / 3, MOD) * 2) % MOD;
        }
    }

    int pow(int a, int b, int MOD) {
        int res = 1;
        while (b > 0) {
            if (b & 1) {
                res = (res * (long long)a) % MOD;
            }
            a = (a * (long long)a) % MOD;
            b >>= 1;
        }
        return res;
    }
};