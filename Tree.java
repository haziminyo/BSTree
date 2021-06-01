package com.haziminyo;

import java.time.temporal.ValueRange;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {      // to be clear in run Debug 'Main'
            return "Node=" + value;
        }
    }

    private Node root; // Root of BST

    public boolean isEmpty(){   // check if root is null
        return root == null;
    }

    public void insert(int value) {
        //var node = new Node(value);

        if (isEmpty()) {    // test if root == null
            root = new Node(value);
            return;
        }

        var current = root;
        while (true) {      // infinite loop
            if (value < current.value) {        // So go to left child of this root "current"
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;    // current go one child to left
            }
            else {  // So go to right child
                if (current.rightChild == null){
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;   // current go one child to right
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true; // In this case so value == current.value "We found it!"
        }
        return false; // It's not exist in tree
    }

    public void traversePreOrder() {
       traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (isEmpty())
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return root.leftChild == null && node.rightChild == null;
    }

    public int minVal() {
        if (isEmpty())
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int maxVal() {
        if (isEmpty())
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);
        return false;
    }

    public int sumOfTree() {
        return sumOfTree(root);
    }

    private int sumOfTree(Node root) {
        if (root == null)
            return 0;

        else
            return root.value + sumOfTree(root.leftChild) + sumOfTree(root.rightChild);


    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree() {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return
                isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void printNodesAtDistance(int distance) {

        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if (root == null)
            return;

        if (distance == 0){
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }

   public void deleteNode(int value) {
    deleteNode(root, value);
   }

   private Node deleteNode(Node root, int value) {
        if (root == null) //Base Case: If the tree is empty
            return root;

        // Otherwise, recur down the tree
        if (value < root.value)
            root.leftChild = deleteNode(root.leftChild, value);
        else if (value > root.value)
            root.rightChild = deleteNode(root.rightChild, value);

        else {  // node with only one child or no child
            if (root.leftChild == null)
                return root.rightChild;
            else if (root.rightChild == null)
                return root.leftChild;

            // node with two children get the inorder;
            // successor is the smallest in the right subtree
            root.value = minValue(root.rightChild);

            // Delete the inorder successor
            root.rightChild = deleteNode(root.rightChild, root.value);
        }
        return root;
   }

    private int minValue(Node root) {
        int minval = root.value;
        while (root.leftChild != null) {
            minval = root.leftChild.value;
            root = root.leftChild;
        }
        return minval;
    }


}
