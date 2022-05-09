package hank.leetcode.stack;

import java.util.LinkedList;

/**
 * <a href ='https://leetcode.cn/problems/implement-queue-using-stacks/'>
 * <h2>Leetcode 232. 用栈实现队列</h2>
 * </a>
 * <p>请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 * <p>
 *
 * @author hank
 */
public class MyQueue {
    private final LinkedList<Integer> inStack;
    private final LinkedList<Integer> outStack;

    public MyQueue() {
        this.inStack = new LinkedList<>();
        this.outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            moveInStackToOutStack();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            moveInStackToOutStack();
        }
        return outStack.isEmpty() ? -1 : outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveInStackToOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
