/* Main.java
 * CSCI 211 - Spring 2022
 * last edited on Mar. 21, 2022 by M. Lacanilao
 *
 * Our Main class will run an executable program that will instantiate a tree,
 * call the method to build the tree with data from the array, then test our
 * other methods.
 */
package mlacBinaryTree;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // instantiate Scanner class
        Scanner sc = new Scanner (System.in);
        System.out.println ("Enter quantity of elements in your Array: ");

        int quantity = sc.nextInt ();
        int[] arr = new int[quantity];
        System.out.println ("Enter your Array's elements: ");

        for (int i = 0; i < quantity; i++) {
            arr[i] = sc.nextInt ();
        }

        // call each method in the BinaryTree class
        // instantiate BinaryTree class object
        BinaryTree bt = new BinaryTree (arr);
        System.out.println ();
        // Pre Order Transversal
        System.out.println ("PreOrder: ");
        bt.preOrder (bt.root);

        System.out.println ();
        // In Order Transversal
        System.out.println ("InOrder: ");
        bt.inOrder (bt.root);

        System.out.println ();
        // Post Order Transversal
        System.out.println ("PostOrder: ");
        bt.postOrder (bt.root);

        System.out.println ();
        //prints min and max of tree
        System.out.println ("Maximum value in the tree: " + bt.max (bt.root));
        System.out.println ("Minimum value in the tree: " + bt.min (bt.root));

        // enter element to search for
        System.out.println ("Enter element to search for: ");
        int e = sc.nextInt ();
        if (bt.search (bt.root, e)==false) {
            System.out.println ("ELEMENT NOT FOUND!");
        }
    }
}
