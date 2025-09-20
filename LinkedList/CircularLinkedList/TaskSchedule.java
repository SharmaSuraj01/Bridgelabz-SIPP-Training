package LinkedList.CircularLinkedList;
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head;
    Task current;
    
    void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }
    
    void removeTask(int taskId) {
        if (head == null) return;
        
        if (head.taskId == taskId && head.next == head) {
            head = current = null;
            return;
        }
        
        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    if (current == temp) current = head;
                } else {
                    prev.next = temp.next;
                    if (current == temp) current = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    
    void viewCurrentTask() {
        if (current != null) {
            System.out.println("Current Task: " + current.taskName + " (Priority: " + current.priority + ")");
        }
    }
    
    void moveToNext() {
        if (current != null) {
            current = current.next;
        }
    }
    
    Task searchByPriority(int priority) {
        if (head == null) return null;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }
    
    void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Task: " + temp.taskName + 
                             ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedule {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Complete Project", 1, "2024-02-15");
        scheduler.addTask(2, "Review Code", 2, "2024-02-10");
        scheduler.addTask(3, "Write Tests", 3, "2024-02-12");
        
        scheduler.displayTasks();
        System.out.println();
        scheduler.viewCurrentTask();
        scheduler.moveToNext();
        scheduler.viewCurrentTask();
    }
}