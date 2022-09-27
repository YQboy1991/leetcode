package com.yq.leetcode;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author BaoLei Li
 * @date 2022/9/21
 **/
public class Tree {

    public static void main(String[] args) {
        Node n6 = new Node(7, null,null);
        Node n5 = new Node(8, null,null);
        Node n4 = new Node(6,null,null );
        Node n3 = new Node(3, n6, null);
        Node n2 = new Node(5, n4,n5);
        Node n1 = new Node(9, n2,n3);
        List<String> result = Lists.newArrayList();
        preOrder(n1, null, result);
        System.out.println(result);
    }


    public static void preOrder(Node root, Node parent, List<String> list){
        if (root == null){
            return;
        }
//        if (parent != null){
//            root.str = parent.str + root.value;
//        }else {
//            root.str = root.value + "";
//        }
//        if (root.left == null && root.right == null){
//            list.add(root.str);
//        }
        preOrder(root.left, root, list);
        System.out.println(root.value);
        preOrder(root.right, root, list);
    }



    public static class Node{

        int value;

        Node left;

        Node right;

        String str;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
