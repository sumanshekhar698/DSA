package com.lpu.java.dsa.stack;

import java.util.Stack;

public class MyStack {
     int[] stack;   // Array for stack elements
     int top;       // Points to top element
     int size;  // Max size of stack

    // Constructor to initialize stack
    public MyStack(int size) {
        this.size = size;
        stack = new int[this.size];
        top = -1; // Stack is initially empty
    }

    // Push an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed to stack.");
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop");
            return -1;
        }
        return stack[top--];
    }

    // Peek the top element without popping
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == size - 1;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }

    // Print elements from top to bottom
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + (i > 0 ? " -> " : ""));
        }
        System.out.println();
    }

    // Just for comparison: Use Java's built-in Stack
    public void builtInStackExample() {
        Stack<Integer> builtInStack = new Stack<>();
        builtInStack.push(10);
        builtInStack.push(20);
        builtInStack.push(30);

        System.out.println("Built-in Stack top: " + builtInStack.peek());
        System.out.println("Built-in Stack pop: " + builtInStack.pop());
    }

    // Main method to test the custom stack
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        myStack.push(60); // Stack overflow

        myStack.printStack();

        System.out.println("Top element: " + myStack.peek());
        System.out.println("Popped element: " + myStack.pop());
        System.out.println("Current size: " + myStack.size());

        // Testing built-in stack
        myStack.builtInStackExample();
    }
}
