package com.dsa.linkedlist;

public class LinkedListIntersection {
    public static void main(String args[]){
        // ✅ Test 1: Intersecting at node with value 8
        Node common = new Node(8);
        common.next = new Node(10);

        Node head1 = new Node(3);
        head1.next = new Node(7);
        head1.next.next = common;

        Node head2 = new Node(99);
        head2.next = new Node(1);
        head2.next.next = common;

        Node result1 = findIntersection(head1, head2);
        System.out.println("Test 1 (Should intersect at 8): " + (result1 != null ? result1 : "No Intersection"));

        // ✅ Test 2: No intersection
        Node head3 = new Node(4);
        head3.next = new Node(6);

        Node head4 = new Node(2);
        head4.next = new Node(9);

        Node result2 = findIntersection(head3, head4);
        System.out.println("Test 2 (Should be null): " + (result2 != null ? result2 : "No Intersection"));

        // ✅ Test 3: One list is empty
        Node result3 = findIntersection(null, head4);
        System.out.println("Test 3 (One list empty): " + (result3 != null ? result3 : "No Intersection"));

        // ✅ Test 4: Both lists are same
        Node head5 = new Node(1);
        head5.next = new Node(2);
        Node result4 = findIntersection(head5, head5);
        System.out.println("Test 4 (Same list): " + (result4 != null ? result4 : "No Intersection"));

        // ✅ Test 5: Intersect at head itself
        Node head6 = new Node(100);
        Node result5 = findIntersection(head6, head6);
        System.out.println("Test 5 (Intersect at head): " + (result5 != null ? result5 : "No Intersection"));
    }
    private static Node findIntersection(Node head1,Node head2){
        if (head1 == null || head2 == null) return null;
        Node temp1=head1,temp2=head2;
        while(temp1!=temp2){
            temp1 = (temp1 != null) ? temp1.next : head2;
            temp2 = (temp2 != null) ? temp2.next : head1;
        }
        return temp1;
    }
}
