package LinkedList.CircularLinkedList;
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    Process next;
    
    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head;
    Process current;
    int timeQuantum;
    int currentTime;
    
    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.currentTime = 0;
    }
    
    void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            current = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }
    
    void removeProcess(int processId) {
        if (head == null) return;
        
        if (head.processId == processId && head.next == head) {
            head = current = null;
            return;
        }
        
        Process temp = head;
        Process prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head) {
                    Process last = head;
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
    
    void simulate() {
        if (head == null) return;
        
        System.out.println("Round Robin Scheduling (Time Quantum: " + timeQuantum + ")");
        
        while (hasRemainingProcesses()) {
            if (current.remainingTime > 0) {
                int executeTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executeTime;
                currentTime += executeTime;
                
                System.out.println("Process " + current.processId + " executed for " + executeTime + 
                                 " units. Remaining: " + current.remainingTime);
                
                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    System.out.println("Process " + current.processId + " completed");
                }
            }
            current = current.next;
        }
    }
    
    boolean hasRemainingProcesses() {
        if (head == null) return false;
        Process temp = head;
        do {
            if (temp.remainingTime > 0) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }
    
    void displayProcesses() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println("Process " + temp.processId + ": Burst=" + temp.burstTime + 
                             ", Remaining=" + temp.remainingTime + ", Priority=" + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
    
    void calculateAverages() {
        if (head == null) return;
        
        int totalWaiting = 0, totalTurnaround = 0, count = 0;
        Process temp = head;
        do {
            totalWaiting += temp.waitingTime;
            totalTurnaround += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);
        
        System.out.println("Average Waiting Time: " + (double)totalWaiting / count);
        System.out.println("Average Turnaround Time: " + (double)totalTurnaround / count);
    }
}

public class RoundRobinSchedule {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        
        scheduler.displayProcesses();
        System.out.println();
        scheduler.simulate();
        System.out.println();
        scheduler.calculateAverages();
    }
}