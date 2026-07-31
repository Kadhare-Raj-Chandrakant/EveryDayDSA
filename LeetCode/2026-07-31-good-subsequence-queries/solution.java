class Solution {
    // Time complexity: O(n * log^2(max(nums))) + O(q * log(max(nums)))
    // Space complexity: O(n * log(max(nums)))
    public int countGoodSubseq(int[] nums, int p, int[][] queries) {
        int n = nums.length;
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int[] primes = getPrimes(maxNum);
        int[][] primeFactors = getPrimeFactors(nums, primes);
        int[] primeCounts = new int[primes.length];
        int[] primeCountsAtIndices = new int[n];
        int activeCount = 0;
        int goodCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % p == 0) {
                activeCount++;
                for (int primeFactor : primeFactors[i]) {
                    primeCounts[primeFactor]++;
                }
                primeCountsAtIndices[i] = primeFactors[i].length;
            }
        }
        for (int[] query : queries) {
            int index = query[0];
            int value = query[1];
            if (nums[index] % p == 0) {
                for (int primeFactor : primeFactors[index]) {
                    primeCounts[primeFactor]--;
                }
                activeCount--;
            }
            nums[index] = value;
            if (nums[index] % p == 0) {
                primeFactors[index] = getPrimeFactors(nums[index], primes);
                for (int primeFactor : primeFactors[index]) {
                    primeCounts[primeFactor]++;
                }
                activeCount++;
                primeCountsAtIndices[index] = primeFactors[index].length;
            }
            boolean hasGoodSubseq = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] % p == 0 && primeCountsAtIndices[i] < primeCounts.length) {
                    boolean hasUniquePrime = false;
                    for (int j = 0; j < primeFactors[i].length; j++) {
                        if (primeCounts[primeFactors[i][j]] < activeCount) {
                            hasUniquePrime = true;
                            break;
                        }
                    }
                    if (hasUniquePrime) {
                        hasGoodSubseq = true;
                        break;
                    }
                }
            }
            if (hasGoodSubseq) {
                goodCount++;
            }
        }
        return goodCount;
    }

    private int[] getPrimes(int maxNum) {
        boolean[] isPrime = new boolean[maxNum + 1];
        for (int i = 0; i <= maxNum; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= maxNum; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int primeCount = 0;
        for (int i = 0; i <= maxNum; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
        int[] primes = new int[primeCount];
        int index = 0;
        for (int i = 0; i <= maxNum; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }
        return primes;
    }

    private int[] getPrimeFactors(int num, int[] primes) {
        int[] primeFactors = new int[primes.length];
        int index = 0;
        for (int prime : primes) {
            if (num % prime == 0) {
                primeFactors[index++] = prime;
                while (num % prime == 0) {
                    num /= prime;
                }
            }
        }
        int[] result = new int[index];
        System.arraycopy(primeFactors, 0, result, 0, index);
        return result;
    }
}