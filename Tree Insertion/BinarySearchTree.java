/*
Code for BST taken directly from (with slight modifications)
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/\
and contributed by Ankur Narain Verma

As this is just an underlying data structure and citation is given, I believe
its within the limits of using this code since the assignment is not directly
testing knowledge of BST.

 */
import java.math.BigInteger;

class BinarySearchTree {

    class Node {
        int key;
        int numOfChildren, interleavings;
        BigInteger numC, interL;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
            interleavings = 0;
            interL = new BigInteger("0");
        }
    }

    Node root;

    BinarySearchTree() {root = null;}

    void insert(int key) {root = insertRec(root, key);}

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key >= root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

}