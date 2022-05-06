/* Node.java
 * CSCI 211 - Spring 2022
 * last edited on Mar. 21, 2021 by M. Lacanilao
 *
 * This is a Node class designed to store our data properties.
 */

package mlacBinaryTree;

public class Node {
    int data; // our tree's data type
    Node leftChild;
    Node rightChild;

    public Node(int value) { // null constructor
        data = value;
        leftChild = null;
        rightChild = null;
    }
}
