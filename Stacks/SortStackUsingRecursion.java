package Stacks;
import java.util.Stack;

public class SortStackUsingRecursion {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1) {
            return;
        }
        int temp = stack.pop();
        sortStack(stack);
        insertSorted(stack, temp);
    }
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}