public class StringConcat {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int n : sizes) {
            // String
            long start = System.nanoTime();
            String s = "";
            for (int i = 0; i < n; i++) s += "a";
            System.out.print(s.hashCode());
            long end = System.nanoTime();
            System.out.printf("String (N=%d): %.4f ms\n", n, (end - start) / 1e6);

            // StringBuilder
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append('a');
            if (sb.length() == -1) System.out.print("");
            end = System.nanoTime();
            System.out.printf("StringBuilder (N=%d): %.4f ms\n", n, (end - start) / 1e6);

            // StringBuffer
            start = System.nanoTime();
            StringBuffer sbuf = new StringBuffer();
            for (int i = 0; i < n; i++) sbuf.append('a');
            System.out.print(sbuf.hashCode()); 
            end = System.nanoTime();
            System.out.printf("StringBuffer (N=%d): %.4f ms\n", n, (end - start) / 1e6);
        }
    }
}