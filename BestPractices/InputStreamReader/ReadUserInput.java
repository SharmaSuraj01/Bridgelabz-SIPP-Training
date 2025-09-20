package BestPractices.InputStreamReader;
import java.io.*;

public class ReadUserInput {
    public static void readAndWriteInput(String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputFilePath)) {
            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            while (true) {
                line = reader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Input saved to file: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String outputFilePath = "user_input.txt";
        readAndWriteInput(outputFilePath);
    }
}