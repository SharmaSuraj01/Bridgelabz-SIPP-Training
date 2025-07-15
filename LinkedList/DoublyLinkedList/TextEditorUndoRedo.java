class TextState {
    String content;
    TextState next;
    TextState prev;
    
    TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    TextState current;
    TextState head;
    TextState tail;
    int maxHistory;
    int currentSize;
    
    TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.currentSize = 0;
        this.current = null;
        this.head = null;
        this.tail = null;
    }
    
    void addState(String content) {
        TextState newState = new TextState(content);
        
        if (head == null) {
            head = tail = current = newState;
            currentSize = 1;
        } else {
            // Remove any states after current (for redo functionality)
            if (current != tail) {
                current.next = null;
                tail = current;
                // Recalculate size
                currentSize = 0;
                TextState temp = head;
                while (temp != null) {
                    currentSize++;
                    temp = temp.next;
                }
            }
            
            // Add new state
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            currentSize++;
            
            // Remove oldest state if exceeding max history
            if (currentSize > maxHistory) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
                currentSize--;
            }
        }
    }
    
    boolean undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            return true;
        }
        return false;
    }
    
    boolean redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }
    
    String getCurrentContent() {
        return current != null ? current.content : "";
    }
    
    void displayCurrentState() {
        System.out.println("Current Text: \"" + getCurrentContent() + "\"");
    }
    
    void displayHistory() {
        System.out.println("Text History:");
        TextState temp = head;
        int index = 1;
        while (temp != null) {
            String marker = (temp == current) ? " <- CURRENT" : "";
            System.out.println(index + ". \"" + temp.content + "\"" + marker);
            temp = temp.next;
            index++;
        }
    }
}

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5);
        
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! How are you?");
        
        editor.displayHistory();
        System.out.println();
        
        editor.displayCurrentState();
        
        System.out.println("\nPerforming undo:");
        editor.undo();
        editor.displayCurrentState();
        
        System.out.println("\nPerforming undo again:");
        editor.undo();
        editor.displayCurrentState();
        
        System.out.println("\nPerforming redo:");
        editor.redo();
        editor.displayCurrentState();
        
        System.out.println("\nAdding new state after undo:");
        editor.addState("Hello World! Good morning!");
        editor.displayHistory();
    }
}