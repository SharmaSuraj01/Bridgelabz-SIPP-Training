package BestPractices.StringBuffer;
public class ComparePerformance {
    
    public static void main(String[] args) {
        int iterations = 100000;
        String text = "hello";
        
        long startTimeBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1000000;
        long startTimeBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1000000; // Convert to milliseconds
        
        System.out.println("StringBuilder time: " + durationBuilder + " ms");
        System.out.println("StringBuffer time: " + durationBuffer + " ms");
        System.out.println("StringBuffer is " + (durationBuffer > durationBuilder ? 
                          "slower by " + (durationBuffer - durationBuilder) : 
                          "faster by " + (durationBuilder - durationBuffer)) + " ms");
    }
}