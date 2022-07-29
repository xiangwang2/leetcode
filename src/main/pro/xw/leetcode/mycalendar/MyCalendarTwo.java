package src.main.pro.xw.leetcode.mycalendar;

import javafx.util.Pair;

import java.util.*;

public class MyCalendarTwo {

    private List<Pair<Integer, Integer>> times;


    public static void main(String[] args) {
        MyCalendarTwo  myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(50, 60));
        System.out.println(myCalendar.book(10, 40));
        System.out.println(myCalendar.book(5, 15));
        System.out.println(myCalendar.book(5, 10));
        System.out.println(myCalendar.book(25, 55));
    }

    public MyCalendarTwo() {
        this.times = new LinkedList<>();
    }

    public boolean book(int start, int end) {
        int repead = 0;
        Pair<Integer, Integer> cur = new Pair<>(start, end);
        for (Pair<Integer, Integer> time : times) {
            if (isRepted(time, cur)) {
                repead++;
            }
            if (repead >= 2) {
                return false;
            }
        }
        times.add(cur);
        return true;
    }

    private boolean isRepted(Pair<Integer,Integer> a, Pair<Integer, Integer> b) {
        int aStart = a.getKey();
        int aEnd = a.getValue();
        int bStart = b.getKey();
        int bEnd = b.getValue();

        if (aStart >bStart && aStart< bEnd) {
            return true;
        }

        if (bStart > aStart && bStart < aEnd) {
            return true;
        }

        if (aStart > bStart && aEnd < bEnd) {
            return true;
        }

        if (aStart < bStart && aEnd > bEnd) {
            return true;
        }
        return false;
    }
}
