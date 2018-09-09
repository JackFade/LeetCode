package queueAndStack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
* */
public class L295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    Queue<Integer> lowerHalf = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    Queue<Integer> higherHalf = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (lowerHalf.isEmpty()) {
            lowerHalf.add(num);
            return;
        }

        if (lowerHalf.peek() > num) {
            lowerHalf.add(num);
        } else {
            higherHalf.add(num);
        }

        if (lowerHalf.size() - higherHalf.size() == 2) {
            higherHalf.add(lowerHalf.poll());
        } else if (higherHalf.size() - lowerHalf.size() == 2) {
            lowerHalf.add(higherHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == higherHalf.size()) {
            return (lowerHalf.peek() + higherHalf.peek()) / 2.0;
        } else if (lowerHalf.size() > higherHalf.size()) {
            return lowerHalf.peek();
        } else {
            return higherHalf.peek();
        }
    }
}


