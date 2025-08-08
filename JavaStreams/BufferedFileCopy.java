import java.io.*;

public class BufferedFileCopy {
    
    public static void copyWithBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            
            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        long endTime = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
    
    public static void copyWithNormalStreams(String source, String dest) {
        long startTime = System.nanoTime();
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        long endTime = System.nanoTime();
        System.out.println("Normal copy time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
    
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String bufferedDest = "buffered_copy.txt";
        String normalDest = "normal_copy.txt";
        
        System.out.println("Comparing file copy performance:");
        copyWithBufferedStreams(sourceFile, bufferedDest);
        copyWithNormalStreams(sourceFile, normalDest);
    }
}