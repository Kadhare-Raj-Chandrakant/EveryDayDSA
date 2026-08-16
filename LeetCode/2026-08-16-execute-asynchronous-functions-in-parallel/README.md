# Execute Asynchronous Functions in Parallel

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/execute-asynchronous-functions-in-parallel/)
- **Date**: 2026-08-16
- **Language**: java


The problem I solved today was executing asynchronous functions in parallel. Specifically, I was tasked with creating a function that would asynchronously execute a list of functions and return their results when they were all resolved. The source for this problem can be found [here](https://leetcode.com/problems/execute-asynchronous-functions-in-parallel/).

Initial Thoughts:

I initially thought of using a thread pool to execute the functions concurrently. However, I didn't know how to ensure that the results were returned in order, especially since some of the functions might take different amounts of time to execute. I also didn't know how to handle errors that might occur during execution.

The Core Trick:

To solve this problem, I decided to use a promise/callback-based approach. I created a `Promise` class that represented a future value, which could be either resolved or rejected. I then created a `promiseAll` function that would asynchronously execute a list of functions and return a promise that resolves when all functions have completed.

To ensure that the results were returned in order, I added a counter to keep track of which function had been resolved. If all functions had been resolved, I resolved the promise with the results. For any error that occurred during execution, I rejected the promise.

Complexity:

The time complexity of this solution is O(n), where n is the number of functions. This is because for each function, we have to execute its code and update the counter. The space complexity is O(n) for the results and resolved arrays.

Key Takeaway:

One key takeaway from this problem is the importance of using a consistent and structured approach to handling asynchronous functions. In this case, I used a promise/callback-based approach, which is a common pattern in JavaScript and other languages. It is also important to think about when and how errors might occur, and how to handle them gracefully. Overall, this problem was a good exercise in learning how to structure and implement asynchronous code.