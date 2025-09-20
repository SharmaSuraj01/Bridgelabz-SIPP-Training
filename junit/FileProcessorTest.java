import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessorTest {
    
    private FileProcessor fileProcessor = new FileProcessor();
    private String testFile = "test.txt";
    
    @AfterEach
    public void cleanup() {
        try {
            Files.deleteIfExists(Paths.get(testFile));
        } catch (IOException e) {
            // Ignore cleanup errors
        }
    }
    
    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        
        fileProcessor.writeToFile(testFile, content);
        assertTrue(fileProcessor.fileExists(testFile));
        
        String readContent = fileProcessor.readFromFile(testFile);
        assertEquals(content, readContent);
    }
    
    @Test
    public void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonexistent.txt");
        });
    }
    
    @Test
    public void testFileExists() throws IOException {
        assertFalse(fileProcessor.fileExists(testFile));
        
        fileProcessor.writeToFile(testFile, "test");
        assertTrue(fileProcessor.fileExists(testFile));
    }
}