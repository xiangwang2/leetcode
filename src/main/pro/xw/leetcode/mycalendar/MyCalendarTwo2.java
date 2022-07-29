package src.main.pro.xw.leetcode.mycalendar;

public class MyCalendarTwo2 {

    private int[] times;

    public static void main(String[] args) {
        MyCalendarTwo2  myCalendar = new MyCalendarTwo2();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(50, 60));
        System.out.println(myCalendar.book(10, 40));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(25, 55));
        ThreadLocal<Object> a = new ThreadLocal<>();
    }

    public MyCalendarTwo2() {
        times = new int[100];
    }

    public boolean book(int start, int end) {
        int[] temp = new int[100];
        System.arraycopy(times, 0, temp, 0, times.length);
        for (int i = start; i < end; i++) {
            temp[i] = temp[i]+1;
            if (temp[i] > 2) {
                return false;
            }
        }
        times = temp;
        return true;
    }
}
