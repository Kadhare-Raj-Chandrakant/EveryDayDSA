# Total Score of Dungeon Runs

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/total-score-of-dungeon-runs/)
- **Date**: 2026-07-02
- **Language**: java


The problem I solved today was "Total Score of Dungeon Runs," a medium-difficulty question on LeetCode. The task was to calculate the total score for a player who has to complete a dungeon with a given level of health (hp) and damage dealt by enemies (damage) every turn. The score is determined by the number of turns taken to complete the dungeon and the cumulative damage dealt. The player's score increases by the number of turns and the cumulative damage, while the requirement score is subtracted for every turn it takes longer than the requirement. The score is calculated by subtracting the number of turns it took to complete the dungeon compared to the requirement.

Initial Thoughts:
I started by trying a brute-force approach, iterating through all possible combinations of turns and cumulative damage for a given hp and damage array. This approach was inefficient as it required O(n^2) time and space complexity, where n is the length of the damage array.

The Core Trick:
The core trick was to use binary search to find the number of turns it takes to complete the dungeon with a cumulative damage equal to the requirement. This approach reduced the time complexity to O(n log n).

Complexity:
The time complexity of the solution is O(n log n) due to the binary search algorithm. The space complexity is O(n) for the pref array, which is used to store the cumulative damage.

Key Takeaway:
The takeaway from this problem is the importance of using efficient algorithms and data structures to solve problems efficiently. By using binary search, I was able to significantly reduce the time complexity of the solution.

In conclusion, using binary search to find the number of turns it takes to complete the dungeon with a cumulative damage equal to the requirement was the key to solving this problem efficiently.