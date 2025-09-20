class CircularBuffer<T> {
    private T[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    
    public void add(T item) {
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }
    
    public T remove() {
        if (size == 0) return null;
        
        T item = buffer[head];
        buffer[head] = null;
        head = (head + 1) % capacity;
        size--;
        
        return item;
    }
    
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class Circular {
    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);
        
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.display();
        
        buffer.add(4); 
        buffer.display();
    }
}