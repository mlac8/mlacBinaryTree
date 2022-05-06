/* BinaryTree.java
 * CSCI 211 - Spring 2022
 * last edited on Mar. 21, 2022 by M. Lacanilao
 *
 * This is a Binary Tree data structure class used to store the following
 * transversal algorithm methods: Preorder, Inorder, Postorder
 * This project is meant to explore the different ways a binary tree can be
 * searched.
 */
package mlacBinaryTree;

public class BinaryTree {
    // root node
    Node root;
    int size = 0;

    public BinaryTree() {
        // null constructor
        root = null;
    }
    public BinaryTree(int[]arr) {
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            insert(root, newNode);
        }
    }
    public void insert(Node head, Node temp) {
        // algorithm to add new nodes with data to the tree
        // starts at the new root node

        // if tree is null
        if (size == 0) {
            root = temp;
            size+=1;
        } else {
            // if left node is null, insert at left node
            if (head.leftChild == null) {
                head.leftChild = temp;
                size++;

                // if right node is null, insert at right node
            } else if (head.rightChild == null) {
                head.rightChild = temp;
                size++;
            } else {
                // add node to left subtree or right subtree
                if (size%2==0) {
                    insert (head.leftChild, temp);
                } else {
                    insert (head.rightChild, temp);
                }
            }
        }
    } // end insert()

    // Prints the tree in PreOrder with the given root
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println (" " + node.data);
            preOrder (node.leftChild);
            preOrder (node.rightChild);
        }
    } // end preOrder()

    // Prints the tree in InOrder with the given root
    public void inOrder(Node node) {
        if (node != null) {
            inOrder (node.leftChild);
            System.out.println (" " + node.data);
            inOrder (node.rightChild);
        }
    }

    // prints the tree in PostOrder with given root
    public void postOrder(Node node) {
        if (node != null) {
            postOrder (node.leftChild);
            postOrder (node.rightChild);
            System.out.println (" " + node.data);
        }
    }

    // search for a Node
    public boolean search (Node node, int item) {
        boolean b1 = false, b2 = false;
        if (node!=null) {
            // keeps going until item is found
            if (node.data == item) {
                System.out.println ("Item found!");
                return true;
            }
            // if item not found, we look into the left subtree or right subtree
            b1=search (node.leftChild, item);
            b2=search (node.rightChild, item);
        }
        return b1 || b2;
    }
    // finds max of tree
    public int max(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int leftRes = max(node.leftChild);
        int rightRes = max(node.rightChild);

        if (leftRes > res)
            res = leftRes;
        if (rightRes > res)
            res = rightRes;
        return res;
    }

    // finds min of tree
    public int min(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        int res = node.data;
        int leftRes = min (node.leftChild);
        int rightRes = min (node.rightChild);

        if (leftRes < res)
            res = leftRes;
        if (rightRes < res)
            res = rightRes;
        return res;
    }
}
