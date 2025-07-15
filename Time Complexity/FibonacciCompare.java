public class FibonacciCompare {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int[] ns = {10, 30, 50};
        for (int n : ns) {
            long start, end;
            if (n <= 30) {
                start = System.nanoTime();
                fibonacciRecursive(n);
                end = System.nanoTime();
                System.out.printf("Recursive (N=%d): %.4f ms\n", n, (end - start) / 1e6);
            } else {
                System.out.printf("Recursive (N=%d): Unfeasible\n", n);
            }
            start = System.nanoTime();
            fibonacciIterative(n);
            end = System.nanoTime();
            System.out.printf("Iterative (N=%d): %.4f ms\n", n, (end - start) / 1e6);
        }
    }
}
