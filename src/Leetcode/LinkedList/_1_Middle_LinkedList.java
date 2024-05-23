package Leetcode.LinkedList;

public class _1_Middle_LinkedList {

    public class LinkedList {

        private Node head;
        private Node tail;

        class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        public LinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void printAll() {
            if (head == null) {
                System.out.println("Head: null");
                System.out.println("Tail: null");
            } else {
                System.out.println("Head: " + head.value);
                System.out.println("Tail: " + tail.value);
            }
            System.out.println("\nLinked List:");
            if (head == null) {
                System.out.println("empty");
            } else {
                printList();
            }
        }

        public void makeEmpty() {
            head = null;
            tail = null;
        }

        public void append(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Node findMiddleNode(){
            Node slow = getHead();
            Node fast = getHead();

            while(slow!=null && fast.next!= null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == null){
                    return slow;
                }
            }
            return slow;
        }

    }


}