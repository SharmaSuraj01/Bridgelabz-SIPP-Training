package Stacks;
import java.util.*;

public class StockSpanProblem {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();
        spans[0] = 1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return spans;
    }
    
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        
        System.out.println("Stock Prices: " + Arrays.toString(prices));
        System.out.println("Stock Spans: " + Arrays.toString(spans));
    }
}