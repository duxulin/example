package com.dxl.example.common.test;

public class MergeLinkedNode {

	Node Merge(Node head1 , Node head2) {
		if(head1 ==null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		Node newHead;
		if(head1.data<head2.data){
			newHead = head1;
			newHead.next = Merge(head1.next,head2);
		}else {
			newHead = head2;
			newHead.next = Merge(head1,head2.next);
		}
		return newHead;

	}


}
class Node{
	int data;
	Node next;
}
