import java.io.*;

public class PipedStreams {
    
    static class Writer extends Thread {
        private PipedOutputStream pos;
        
        public Writer(PipedOutputStream pos) {
            this.pos = pos;
        }
        
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    String message = "Message " + i + "\n";
                    pos.write(message.getBytes());
                    pos.flush();
                    System.out.println("Writer: Sent " + message.trim());
                    Thread.sleep(1000);
                }
                pos.close();
            } catch (IOException | InterruptedException e) {
                System.out.println("Writer error: " + e.getMessage());
            }
        }
    }
    
    static class Reader extends Thread {
        private PipedInputStream pis;
        
        public Reader(PipedInputStream pis) {
            this.pis = pis;
        }
        
        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("Reader: Received " + line);
                }
            } catch (IOException e) {
                System.out.println("Reader error: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            Writer writer = new Writer(pos);
            Reader reader = new Reader(pis);
            
            writer.start();
            reader.start();
            
            writer.join();
            reader.join();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Main error: " + e.getMessage());
        }
    }
}