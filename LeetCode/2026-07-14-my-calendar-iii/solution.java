// Time complexity: O(n log n) due to sorting
// Space complexity: O(n) for storing events
class MyCalendarThree {
    private int maxBookings;
    private int[] events;

    public MyCalendarThree() {
        maxBookings = 0;
        events = new int[800]; // At most 400 calls will be made to book
    }

    public int book(int startTime, int endTime) {
        addEvent(startTime, 1);
        addEvent(endTime, -1);
        return maxBookings;
    }

    private void addEvent(int time, int delta) {
        int index = binarySearch(time);
        events[index] += delta;
        updateMaxBookings(index);
    }

    private int binarySearch(int time) {
        int left = 0, right = events.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid] == 0 || events[mid - 1] != 0) {
                if (time < mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                int i = mid;
                while (i >= 0 && events[i] == 0) {
                    i--;
                }
                return i + 1;
            }
        }
        return left;
    }

    private void updateMaxBookings(int index) {
        int bookings = 0;
        for (int i = 0; i < events.length; i++) {
            bookings += events[i];
            maxBookings = Math.max(maxBookings, bookings);
        }
    }
}