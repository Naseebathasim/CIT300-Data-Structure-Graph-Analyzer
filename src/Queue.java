public class Queue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println("Value enqueued successfully.");
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;

        System.out.println("Dequeued value: " + value);
    }

    public void peek() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Front value: " + queue[front]);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }
}