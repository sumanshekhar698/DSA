package com.lpu.java.dsa.queue;

public class SimpleQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public SimpleQueue(int size) {
        this.size = size;
        queue = new int[this.size];
        front = 0;
        rear = 0;
    }

    // Enqueue: Add to rear
    public void enqueue(int value) {
        if (rear == size) {
            System.out.println("Queue Overflow: Cannot enqueue " + value);
            return;
        }
        queue[rear++] = value;
        System.out.println(value + " enqueued.");
    }

    // Dequeue: Remove from front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot dequeue");
            return -1;
        }
        return queue[front++];
    }

    // Peek: View front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return front == rear;
    }

    // Size of the queue
    public int size() {
        return rear - front;
    }

    // Print queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + (i < rear - 1 ? " <- " : ""));
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        SimpleQueue q = new SimpleQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // Overflow

        q.printQueue();

        System.out.println("Front element: " + q.peek());
        System.out.println("Dequeued: " + q.dequeue());
        q.printQueue();
        System.out.println("Size: " + q.size());
    }
}
