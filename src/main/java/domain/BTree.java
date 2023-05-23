package domain;

public class BTree implements Tree {
    private BTreeNode root;

    @Override
    public int size() throws TreeException {
        return 0;
    }

    //private int size(BTreeNode nodo)

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object element) throws TreeException {
        return false;
    }

    //private boolean binarySearch(BTreeNode node, Object element)

    @Override
    public void add(Object element) {

    }

    //private BtreeNode add(BtreeNode node, Object element)

    @Override
    public void remove(Object element) throws TreeException {

    }

    //private BTreeNode remove(BTreeNode node, Object element)

    @Override
    public int height(Object element) throws TreeException {
        return 0;
    }

    //private int height(BTreeNode node, Object element)

    @Override
    public int height() throws TreeException {
        return 0;
    }

    //private int height(BTreeNode node)

    @Override
    public Object min() throws TreeException {
        return null;
    }

    //private Object min(BTreeNode node)

    @Override
    public Object max() throws TreeException {
        return null;
    }

    //private Object max(BTreeNode node)

    @Override
    public String preOrder() throws TreeException {
        return null;
    }

    //private String preOrder(BTreeNode node)

    @Override
    public String InOrder() throws TreeException {
        return null;
    }

    //private String InOrder(BTreeNode node)

    @Override
    public String postOrder() throws TreeException {
        return null;
    }

    //private String postOrder(BTreeNode node)
}
