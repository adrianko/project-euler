import java.util.Arrays;
import java.util.List;

/**
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19 {

    public static void main(String[] args) {
        int count = 0;
        int dow = 0;
        for (int year = 1900; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= days(month, year); day++) {
                    dow++;

                    if (dow % 7 == 0) {
                        if (year >= 1901 && year <= 2000 && day == 1) {
                            count++;
                        }

                        dow = 0;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static int days(int month, int year) {
        List<Integer> smaller = Arrays.asList(9, 4, 6, 11);
        List<Integer> larger = Arrays.asList(1, 3, 5, 8, 10, 12);

        if (smaller.contains(month)) {
            return 30;
        } else if (larger.contains(month)) {
            return 31;
        } else {
            if (leapYear(year)) {
                return 29;
            }

            return 28;
        }
    }

    public static boolean leapYear(int year) {
        if (year % 100 == 0) {
            return (year % 400 == 0);
        } else if (year % 4 == 0) {
            return true;
        }

        return false;
    }

}
