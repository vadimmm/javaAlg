package gb.local;

import static gb.local.RedBlackTree.printRedBlackTree;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(3);
        tree.add(5);
        tree.add(11);
        tree.add(2);
        tree.add(8);
        tree.add(44);
        tree.add(33);
        tree.add(22);
        printRedBlackTree(tree);
    }
}