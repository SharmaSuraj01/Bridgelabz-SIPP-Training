import java.io.*;

public class FileRead {
    public static void main(String[] args) throws Exception {
        String filePath = "largefile.txt"; 
        int[] sizes = {1, 100, 500}; 
        for (int size : sizes) {
            System.out.printf("Reading %dMB file...\n", size);
            long start = System.nanoTime();
            try (FileReader fr = new FileReader(filePath)) {
                while (fr.read() != -1) {}
            }
            long end = System.nanoTime();
            System.out.printf("FileReader: %.4f ms\n", (end - start) / 1e6);
            start = System.nanoTime();
            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
                while (isr.read() != -1) {}
            }
            end = System.nanoTime();
            System.out.printf("InputStreamReader: %.4f ms\n", (end - start) / 1e6);
        }
    }    
}
