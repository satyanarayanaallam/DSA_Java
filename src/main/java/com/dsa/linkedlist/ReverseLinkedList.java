package com.dsa.linkedlist;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
public class ReverseLinkedList {
    public static void main(String args[]){
        // 🔹 Test Case 1: Normal list
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        System.out.print("Original List 1: ");
        printList(head1);
        Node reversed1 = reverseLinkedList(head1);
        System.out.print("Reversed List 1: ");
        printList(reversed1);

        // 🔹 Test Case 2: Single node list
        Node head2 = new Node(42);
        System.out.print("Original List 2: ");
        printList(head2);
        Node reversed2 = reverseLinkedList(head2);
        System.out.print("Reversed List 2: ");
        printList(reversed2);

        // 🔹 Test Case 3: Empty list
        Node head3 = null;
        System.out.print("Original List 3: ");
        printList(head3);
        Node reversed3 = reverseLinkedList(head3);
        System.out.print("Reversed List 3: ");
        printList(reversed3);

        // 🔹 Test Case 4: List with duplicate values
        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(1);
        head4.next.next.next = new Node(2);
        System.out.print("Original List 4: ");
        printList(head4);
        Node reversed4 = reverseLinkedList(head4);
        System.out.print("Reversed List 4: ");
        printList(reversed4);
    }
    private static Node reverseLinkedList(Node head){
        Node prev= null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
