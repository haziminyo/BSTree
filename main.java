package com.haziminyo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

	      Tree tree = new Tree();
	      tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        Tree tree2 = new Tree();
	      tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println(tree.equals(tree2));


        tree.traverseInOrder();
        System.out.println("---------------------");
        System.out.println("Max value in this Tree= " +tree.maxVal());
        System.out.println("Min value in this Tree= " +tree.minVal());
        System.out.println("---------------------");
        System.out.println("Value 8 is exist in this Tree:" +tree.find(8));
        System.out.println("Value 30 is exist in this Tree:" +tree.find(30));
        System.out.println("---------------------");
        System.out.println("Height of Tree is: " +tree.height());
        System.out.println("Sum of this Tree= " +tree.sumOfTree());
        System.out.println("---------------------");
        tree.deleteNode(7);
        System.out.println("Delete Node have a value = 7");
        tree.traverseInOrder();

        tree.swapRoot();
        System.out.println(tree.isBinarySearchTree());
        tree.sumOfTree();
        System.out.println(tree.find(6));
        tree.traverseInOrder();

    }
   
}

