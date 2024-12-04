package InterviewPrep;

import java.util.HashMap;
import java.util.Map;

public class ClonedLinkedList {

    public class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node cur = head;

        // Insert cloned nodes
        while(cur != null){
            Node next = cur.next;
            Node clone = new Node(cur.val);
            cur.next = clone;
            clone.next = next;
            cur = next;
        }

        // Set the random pointers
        cur = head;
        while(cur != null){
            if(cur.next != null){
                cur.next.random = cur.random != null ? cur.random.next : null;
            }
            cur = cur.next.next;
        }

        // Restore original list and cloned list
        Node original = head;
        Node cloned = head.next;
        Node clonedHead = cloned;

        while(original != null) {
            original.next = original.next.next;
            cloned.next = cloned.next != null ? cloned.next.next : null;
            original = original.next;
            cloned = cloned.next;
        }

        return clonedHead;
    }

    public Node copyRandomLinkedListUsingHashMap(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        Node clonedHead = new Node(head.val);
        Node clonedCurr = clonedHead;
        while(cur.next != null){
            Node clonedNext = new Node(cur.next.val);
            clonedCurr.next = clonedNext;
            clonedCurr = clonedNext;
            cur = cur.next;
        }
        Map<Node, Node> nodeMap = new HashMap<>();

        cur = head;
        clonedCurr = clonedHead;
        while(cur != null && clonedCurr!= null){
            nodeMap.put(cur, clonedCurr);
            cur = cur.next;
            clonedCurr = clonedCurr.next;
        }

        cur = head;
        clonedCurr = clonedHead;
        while(cur!= null){
            clonedCurr.random = nodeMap.get(cur.random);
            clonedCurr = clonedCurr.next;
            cur = cur.next;
        }

        return clonedHead;


    }
}
