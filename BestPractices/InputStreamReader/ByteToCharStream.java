package BestPractices.InputStreamReader;
import java.io.*;

public class ByteToCharStream {
    public static void readBinaryFile(String filePath, String charset) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, charset);
             BufferedReader reader = new BufferedReader(isr)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filePath = "sample.bin";
        String charset = "UTF-8";
       
        System.out.println("Reading binary file with charset: " + charset);
        readBinaryFile(filePath, charset);
    }
}