package com.dsa.linkedlist;

public class RemoveKthLastNode {
    public static void main(String args[]){

    }
    private static Node removeKthLastNode(Node head,int k){
        Node dummy=new Node(-1);
        Node fast=dummy,slow=dummy;
        dummy.next=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
            if(fast==null) return head;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}
