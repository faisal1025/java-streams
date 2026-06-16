package org.airtribe;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class TreeQues {
    public void solve() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        getHorizontal(root, 0);
    }

    public void inorder(Node root, int k, Map<Integer, List<Integer>> mp) {
        if(root == null) return;
        inorder(root.left, k-1, mp);
        mp.getOrDefault(k, new ArrayList<>()).add(root.data);
        inorder(root.right, k+1, mp);
    }


    public void getHorizontal(Node root, int k) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        inorder(root, 0, mp);
        mp.forEach((key, val) -> {
            System.out.println(val);
        });
    }

}
