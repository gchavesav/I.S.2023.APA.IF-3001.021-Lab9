package domain;

public class BTreeNode {
    public Object data;
    public BTreeNode left, right;

    public BTreeNode(Object data) {
        this.data = data;
        this.left = this.right = null;
    }
}
