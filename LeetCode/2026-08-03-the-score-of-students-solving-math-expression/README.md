# The Score of Students Solving Math Expression

- **Difficulty**: Hard
- **Source**: [Alt-Leetcode](https://leetcode.com/problems/the-score-of-students-solving-math-expression/)
- **Date**: 2026-08-03
- **Language**: java


The problem I solved today was the "The Score of Students Solving Math Expression" on LeetCode. This problem was quite challenging because it required finding the score of students for each answer, which involved evaluating the math expression according to the given operator and number.

Initial Thoughts: I knew I needed to use a dynamic programming approach to solve this problem. I also thought about using a two-dimensional DP array to keep track of the scores for each possible math expression. I decided to start by initializing the DP array with the scores for the first two numbers, and then iterate through the array to update the scores based on the operator and the next number.

The Core Trick: The key to solving this problem was recognizing that the math expression could have any number of operators, and that there was no limit on the size of the numbers. This meant that I needed to be able to handle any combination of operators and numbers, and that I couldn't rely on any specific pattern or structure in the math expression.

Complexity: I analyzed the time and space complexity of my solution to ensure that it was efficient enough to handle the large number of test cases. I calculated that the time complexity would be O(n * 2^m * m), where n is the number of answers and m is the number of operators. I also estimated that the space complexity would be O(2^m * m).

Key Takeaway: This problem taught me that even seemingly complex problems can often be solved using a clever and flexible approach. By recognizing that the math expression could have any combination of operators and numbers, I was able to create a dynamic programming solution that was able to handle all possible cases. I also learned the importance of carefully analyzing the time and space complexity of a solution to ensure that it is efficient enough to handle large inputs.