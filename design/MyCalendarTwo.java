package dailyproblems.design;

import java.util.Map;
import java.util.TreeMap;

class MyCalendarTwo {

    private TreeMap<Integer, Integer> bookingCount;
    private final int maxOverlappedBooking;

    public MyCalendarTwo() {
        bookingCount = new TreeMap<>();
        maxOverlappedBooking = 2;
    }

    public boolean book(int start, int end) {
        // Increase the booking count at 'start' and decrease at 'end'.
        bookingCount.put(start, bookingCount.getOrDefault(start, 0) + 1);
        bookingCount.put(end, bookingCount.getOrDefault(end, 0) - 1);

        int overlappedBooking = 0;
        // [10-20, 10-40, 50-60, 5-15]
        // [5-1, 10- 1, 15 -1, 20- -1, 40 -1, 50 1, 60 -1]
        // Calculate the prefix sum of bookings.
        for (var entry : bookingCount.values()) {
            //System.out.println(overlappedBooking+"start");
            System.out.println(entry);
            //overlappedBooking += entry.getValue();
            //System.out.println(overlappedBooking+"after");

            // If the number of overlaps exceeds the allowed limit, rollback and
            // return false.
            if (overlappedBooking > maxOverlappedBooking) {
                // Rollback changes.
                bookingCount.put(start, bookingCount.get(start) - 1);
                bookingCount.put(end, bookingCount.get(end) + 1);

                // Clean up if the count becomes zero to maintain the map clean.
                if (bookingCount.get(start) == 0) {
                    bookingCount.remove(start);
                }

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo=new MyCalendarTwo();
        int arr[][]={{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
}