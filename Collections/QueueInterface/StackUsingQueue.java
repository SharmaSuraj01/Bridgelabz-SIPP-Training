import java.util.*;

class StackUsingQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;
    
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(T item) {
        queue1.add(item);
    }
    
    public T pop() {
        if (queue1.isEmpty()) return null;
        
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        T result = queue1.remove();
        
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return result;
    }
    
    public T top() {
        if (queue1.isEmpty()) return null;
        
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        T result = queue1.peek();
        queue2.add(queue1.remove());
        
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return result;
    }
    
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}