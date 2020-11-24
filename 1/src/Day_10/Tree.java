package Day_10;

public class Tree {
    private Node root;

    private StringBuilder orderedVals;

    public StringBuilder getOrderedVals() {
        goDeeper(root);
        return orderedVals;
    }

    public Tree(Node root) {
        this.root = root;
        orderedVals = new StringBuilder();
    }

    public void addNewNode(Node n, int val) {
        if (val > n.getValue()) {
            if (n.getRightChild() != null) {
                addNewNode(n.getRightChild(), val);
            } else {
                n.setRightChild(new Node(val));
                return;
            }
        } else {
            if (n.getLeftChild() != null) {
                addNewNode(n.getLeftChild(), val);
            } else {
                n.setLeftChild(new Node(val));
                return;
            }
        }
    }

    private void goDeeper(Node n) {
        if (n == null) {
            return;
        }

        goDeeper(n.getLeftChild());
        orderedVals.append(Integer.toString(n.getValue())).append(" ");
        goDeeper(n.getRightChild());
    }
}
