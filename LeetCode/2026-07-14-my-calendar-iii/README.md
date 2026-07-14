# My Calendar III

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/my-calendar-iii/)
- **Date**: 2026-07-14
- **Language**: java


Problem: My Calendar III

Difficulty: Hard

This problem asks us to implement a data structure, MyCalendarThree, which allows us to book appointments (start and end times) with a maximum of four hundred calls to book. The solution should handle overlapping appointments.

Initial Thoughts:

My first thought was to sort the appointments by their start times and then iterate through them. This approach would have a time complexity of O(n log n), where n is the number of appointments. However, this method could lead to duplicate entries and overbookings.

The Core Trick:

To avoid duplicate entries and overbookings, I decided to maintain a sorted array of events (appointments) and update the maximum number of bookings as I added new events or decremented the bookings for existing events. This approach ensures that no appointment overlaps with another appointment in the sorted array.

Complexity:

The time complexity of the solution is O(n log n) due to the sorting step. The space complexity is O(n) for storing events in the sorted array.

Key Takeaway:

This problem taught me the importance of handling overlapping appointments carefully, especially when using a data structure that allows for multiple calls to book and handle them efficiently. The solution I provided is a good starting point for those looking to tackle similar problems.