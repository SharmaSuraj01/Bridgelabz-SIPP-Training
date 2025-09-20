class StageNode {

    String name;
    StageNode next;

    public StageNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class ParcelTracker {

    private StageNode head;

    public void addStage(String stageName) {
        StageNode newNode = new StageNode(stageName);
        if (head == null) {
            head = newNode;
        } else {
            StageNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addCheckpointAfter(String afterStage, String newStage) {
        StageNode current = head;
        while (current != null) {
            if (current.name.equals(afterStage)) {
                StageNode newNode = new StageNode(newStage);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println("Stage '" + afterStage + "' not found.");
    }

    public void markAsLostAfter(String stageName) {
        StageNode current = head;
        while (current != null) {
            if (current.name.equals(stageName)) {
                current.next = null; 
                return;
            }
            current = current.next;
        }
        System.out.println("Stage '" + stageName + "' not found.");
    }

    public void printTracking() {
        StageNode current = head;
        if (current == null) {
            System.out.println("No tracking stages found.");
            return;
        }

        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" → ");
            } else {
                System.out.print(" (End)");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class ParcelTracker {

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        System.out.println("Initial Tracking:");
        tracker.printTracking();

        tracker.addCheckpointAfter("In Transit", "Custom Checkpoint - Hub 5");
        System.out.println("\nAfter Adding Checkpoint:");
        tracker.printTracking();

        tracker.markAsLostAfter("Shipped");
        System.out.println("\nAfter Marking as Lost After 'Shipped':");
        tracker.printTracking();
    }
}
