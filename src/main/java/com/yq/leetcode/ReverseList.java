package com.yq.leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author BaoLei Li
 * @date 2022/9/9
 **/
public class ReverseList {

    @Data
    @AllArgsConstructor
    public static class Node{

        private Object value;

        private Node next;
    }

    public static void main(String[] args) {
        Node node5= new Node(5, null);
        Node node4= new Node(4, node5);
        Node node3= new Node(3, node4);
        Node node2= new Node(2, node3);
        Node node1= new Node(1, node2);

        final Node reverse = reverse(node1);
    }

    public static Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
