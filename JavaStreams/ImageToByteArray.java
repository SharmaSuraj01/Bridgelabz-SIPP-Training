import java.io.*;

public class ImageToByteArray {
    
    public static void convertImageToByteArray(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            // Read image into byte array
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array. Size: " + imageBytes.length + " bytes");
            
            // Write byte array back to new image file
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(destPath)) {
                
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                
                System.out.println("Byte array written to new image file: " + destPath);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destImage = "copy.jpg";
        
        convertImageToByteArray(sourceImage, destImage);
    }
}