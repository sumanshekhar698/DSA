package com.lpu.java.dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int count;

    // Constructor
    public MyQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Add an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow: Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % size;
        queue[rear] = value;
        count++;
        System.out.println(value + " enqueued.");
    }

    // Remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot dequeue");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % size;
        count--;
        return value;
    }

    // Get the front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return count == size;
    }

    // Get current size of queue
    public int size() {
        return count;
    }

    // Print queue elements from front to rear
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements (front to rear): ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % size;
            System.out.print(queue[index] + (i < count - 1 ? " <- " : ""));
        }
        System.out.println();
    }

    // Just for comparison: Java's built-in Queue
    public void builtInQueueExample() {
        Queue<Integer> builtInQueue = new LinkedList<>();
        builtInQueue.offer(10);
        builtInQueue.offer(20);
        builtInQueue.offer(30);

        System.out.println("Built-in Queue front: " + builtInQueue.peek());
        System.out.println("Built-in Queue dequeue: " + builtInQueue.poll());
    }

    // Main method to test the custom queue
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        myQueue.enqueue(50);
        myQueue.enqueue(60); // Overflow

        myQueue.printQueue();

        System.out.println("Front element: " + myQueue.peek());
        System.out.println("Dequeued: " + myQueue.dequeue());
        myQueue.printQueue();
        System.out.println("Current size: " + myQueue.size());

        // Built-in queue example
        myQueue.builtInQueueExample();
    }
}
