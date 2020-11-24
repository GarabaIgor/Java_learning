package Day_10;

public class TestBinaryTree {
    public static void main(String[] args) {
        Node rootNode = new Node(20);
        Tree tree = new Tree(rootNode);

        int[] valuesArr = {23,22,27,24,150,14,11,16,15,18,5,8};
        for (int v : valuesArr) {
            tree.addNewNode(rootNode, v);
        }

        System.out.println(tree.getOrderedVals());
    }
}
