package controller;

import domain.BTree;
import domain.BTreeNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class GraphicBTreeController
{
    @javafx.fxml.FXML
    private BorderPane bp;
    @javafx.fxml.FXML
    private Text treeHeightTextField;
    @javafx.fxml.FXML
    private TreeView<String> treeView;

    @javafx.fxml.FXML
    public void initialize() {
        BTree tree = new BTree();
        for (int i = 0; i < 10; i++) {
            tree.add(util.Utility.random(50));
        }
        TreeItem<String> rootItem = createTreeItem(tree.getRoot());
        treeView.setRoot(rootItem);
    }

    private TreeItem<String> createTreeItem(BTreeNode node) {
        TreeItem<String> item = new TreeItem<>(String.valueOf(node.data));

        if (node.left != null) {
            item.getChildren().add(createTreeItem(node.left));
        }

        if (node.right != null) {
            item.getChildren().add(createTreeItem(node.right));
        }

        return item;
    }

    public void randomizeOnAction(ActionEvent actionEvent) {
    }

    public void levelsOnAction(ActionEvent actionEvent) {
    }
}