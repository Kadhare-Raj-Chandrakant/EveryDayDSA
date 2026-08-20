# Image Smoother

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/image-smoother/)
- **Date**: 2026-08-20
- **Language**: java


Today, I tackled the "Image Smoother" problem on LeetCode. The problem asks you to design an image smoother that reduces noise in a given image. I wrote a Java solution with a time complexity of O(m*n), where m is the number of rows and n is the number of columns in the image, and a space complexity of O(m*n) as well. Here's how I approached it:

**The Problem**
Given a 2D integer array `img`, design an algorithm to smooth the image. The image is represented by a 2D grid of integers, where each integer represents the pixel value of the image. Pixels outside the image boundaries should wrap around it.

**Initial Thoughts**
At first, I thought I needed to iterate through all the pixels in the image and calculate the average value of their neighbors. This would take O(m*n) time and space, but it might not be efficient enough for large images. Then, I remembered that the image is wrapped around, so I could limit the range of each pixel's neighbors. This reduced the complexity to O(m*n) time and space.

**The Core Trick**
The key to solving this problem is not just finding the average value of neighbors but also considering the fact that the image is wrapped around. I used a 3x3 sliding window to calculate the average value of the neighbors, which meant I could ensure that the image was wrapped around properly.

**Complexity**
The time complexity of this solution is O(m*n), as we iterate through all the pixels in the image. The space complexity is also O(m*n), as we create a new 2D array to store the smoothed image.

**Key Takeaway**
This problem taught me to think creatively when dealing with images that wrap around. The key tip was to consider the boundaries of the image and implement proper wrapping when considering neighbors.