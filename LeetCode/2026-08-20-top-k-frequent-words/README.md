# Top K Frequent Words

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/top-k-frequent-words/)
- **Date**: 2026-08-20
- **Language**: java


**The Problem**

Given an array of strings `words` and an integer `k`, find the top `k` most frequent words.

**Initial Thoughts**

At first, I thought of implementing a brute-force approach by iterating through the words and counting their frequencies. However, this solution has a time complexity of O(n^2), which is not efficient for large inputs. I then thought of using a hash map to count the frequency of each word. This approach has a time complexity of O(n), but it still requires extra space proportional to the total number of words. To optimize this, I decided to use a priority queue to sort the words based on their frequencies.

**The Core Trick**

The core trick here is to use a priority queue to sort the words based on their frequencies. This allows us to efficiently extract the top `k` words without having to iterate through all the words again.

**Complexity**

The time complexity of this solution is O(n log k), as we are sorting `n` words in the priority queue and then extracting `k` elements from it. The space complexity is O(n) due to the hash map used to count the frequencies of words. This is acceptable for most use cases, as it is a constant factor larger than the input size.

**Key Takeaway**

This problem serves as a reminder that even seemingly straightforward problems can have surprising optimizations. By leveraging the power of data structures like priority queues, we can achieve efficient solutions to these problems.