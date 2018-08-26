package linklist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liwanglong on 2018/8/25.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    void printList(){
        List<ListNode> list = new LinkedList<ListNode>();
        for(ListNode current = this; current != null; current = current.next) {
            if (list.contains(current)) {
                break;
            }
            list.add(current);
        }
        System.out.println(list);
    }

    @Override
    public String toString() {
        return val+"";
    }
}