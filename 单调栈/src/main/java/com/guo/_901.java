package com.guo;
import java.util.Deque;
import java.util.LinkedList;

public class _901 {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        System.out.println(s.next(100));
        System.out.println(s.next(80));
        System.out.println(s.next(60));
        System.out.println(s.next(70));
        System.out.println(s.next(60));
        System.out.println(s.next(75));
        System.out.println(s.next(85));
    }
}

class StockSpanner {
    Deque<Integer> days;
    Deque<Integer> prices;
    public StockSpanner() {
        days=new LinkedList<>();
        prices=new LinkedList<>();
    }

    public int next(int price) {
        int day=1;
        while (!prices.isEmpty() && prices.peek() <= price)
        {
            day+=days.pop();
            prices.pop();
        }
        prices.push(price);
        days.push(day);
        return day;
    }
}

