package queueAndStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1363 {
    public static void main(String[] args) {
        P1363 runner = new P1363();
        System.out.println(runner.checkVaild(new int[]{3,1,2,5,4}));
    }

    boolean checkVaild(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        for (int i = 1; i <= arr.length; i++) {
            stack.push(i);
            while (!queue.isEmpty() && queue.peek() == stack.peek()) {
                queue.poll();
                stack.pop();
            }
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
