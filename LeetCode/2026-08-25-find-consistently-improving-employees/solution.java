import java.util.*;

class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for storing the result
    public List<List<Object>> consistentlyImprovingEmployees(List<List<Integer>> employees, List<List<Object>> performanceReviews) {
        // Create a map to store the reviews for each employee
        Map<Integer, List<List<Object>>> reviewsMap = new HashMap<>();
        for (List<Object> review : performanceReviews) {
            int employeeId = (int) review.get(1);
            reviewsMap.computeIfAbsent(employeeId, k -> new ArrayList<>()).add(review);
        }

        // Sort the reviews for each employee by date
        for (List<List<Object>> reviews : reviewsMap.values()) {
            reviews.sort((a, b) -> ((Date) a.get(2)).compareTo((Date) b.get(2)));
        }

        // Find employees with consistently improving performance
        List<List<Object>> result = new ArrayList<>();
        for (List<Integer> employee : employees) {
            int employeeId = employee.get(0);
            List<List<Object>> reviews = reviewsMap.get(employeeId);
            if (reviews.size() >= 3) {
                List<Integer> ratings = new ArrayList<>();
                for (int i = reviews.size() - 3; i < reviews.size(); i++) {
                    ratings.add((int) reviews.get(i).get(3));
                }
                if (isStrictlyIncreasing(ratings)) {
                    int improvementScore = ratings.get(2) - ratings.get(0);
                    result.add(Arrays.asList(employeeId, employee.get(1), improvementScore));
                }
            }
        }

        // Sort the result by improvement score in descending order, then by name in ascending order
        result.sort((a, b) -> {
            int scoreCompare = (int) b.get(2) - (int) a.get(2);
            if (scoreCompare == 0) {
                return ((String) a.get(1)).compareTo((String) b.get(1));
            }
            return scoreCompare;
        });

        return result;
    }

    private boolean isStrictlyIncreasing(List<Integer> ratings) {
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i) <= ratings.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}