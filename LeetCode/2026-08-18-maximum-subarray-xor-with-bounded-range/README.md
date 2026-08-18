# Maximum Subarray XOR with Bounded Range

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-subarray-xor-with-bounded-range/)
- **Date**: 2026-08-18
- **Language**: java


Problem: Given an array of integers `nums` and a bound `k`, find the maximum XOR value in the array with the constraint that the XOR value of any two elements in the subarray cannot exceed the bound `k`.

Initial Thoughts: At first, I attempted to solve this problem using a brute-force approach, checking every possible subarray and calculating the XOR value for each one. However, this approach has a time complexity of O(n^3), which is too slow for large inputs. I then thought about using a hash map to keep track of the XOR values seen so far, and checking if any subarray has a sum greater than `k`. This approach also has a time complexity of O(n^2), but it is still slow due to the hash map operations.

The Core Trick: The key insight that allowed me to solve this problem efficiently is that we can maintain a prefix sum array `pref` to keep track of the XOR values of all the elements seen so far. We can then iterate through the array using two pointers `L` and `R`, moving `R` one step at a time and updating the XOR value `res` whenever we find a subarray with a sum of XOR values less than or equal to `k`. This approach has a time complexity of O(n * log(max_val)), where `max_val` is the maximum value in the array.

Complexity: The time complexity of the solution is O(n * log(max_val)), which is more efficient than O(n^3) or O(n^2). The space complexity is also O(n * log(max_val)), which is acceptable given the time complexity.

Key Takeaway: This problem demonstrates the importance of thinking creatively and efficiently when dealing with data structures and algorithms. By analyzing the available time and space constraints and identifying patterns in the input data, we were able to come up with an efficient solution that leverages the properties of the prefix sum array and hash map data structures.