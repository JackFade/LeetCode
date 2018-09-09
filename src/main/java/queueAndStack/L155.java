package queueAndStack;

import java.util.Stack;

/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

        push(x) -- 将元素 x 推入栈中。
        pop() -- 删除栈顶的元素。
        top() -- 获取栈顶元素。
        getMin() -- 检索栈中的最小元素。
        示例:

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   --> 返回 -3.
        minStack.pop();
        minStack.top();      --> 返回 0.
        minStack.getMin();   --> 返回 -2.
*/
public class L155 {

    public static void main(String[] args) {
        MinStack stack= new MinStack();
        stack.push(-2);
        System.out.println(stack.getMin());
        stack.push(0);
        System.out.println(stack.getMin());
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}

class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty() && x > minStack.peek()) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(x);
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
