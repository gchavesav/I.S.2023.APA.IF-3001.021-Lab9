package controller;

import domain.BTree;
import domain.BTreeNode;
import domain.TreeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    private Group treeGroup;
    private Circle nodeCircle;
    @javafx.fxml.FXML
    private Text preOrderTextField;
    @javafx.fxml.FXML
    private Text inOrderTextField;
    @javafx.fxml.FXML
    private Text postOrderTextField;
    private BTree tree;

    @javafx.fxml.FXML
    public void initialize() throws TreeException {
        tree = new BTree();
        for (int i = 0; i < 10; i++) {
            tree.add(util.Utility.random(50));
        }
        drawBinaryTree(tree.getRoot(), 0, 0, 0);
        setFields();
    }

    private void drawBinaryTree(BTreeNode node, double x, double y, int level) {
        if (node != null) {
            // Create and position a visual representation of the current node
            nodeCircle = new Circle(20);
            nodeCircle.setStroke(Color.WHITE);
            nodeCircle.setStroke(javafx.scene.paint.Color.WHITE);
            nodeCircle.setCenterX(x);
            nodeCircle.setCenterY(y);

            // Add any necessary styling or labels to the nodeCircle

            // Add the nodeCircle to the treeGroup
            treeGroup.getChildren().add(nodeCircle);

            // Calculate the coordinates for the left and right child nodes
            double childY = y + 100;
            double leftChildX = x - Math.pow(2, level) * 30;
            double rightChildX = x + Math.pow(2, level) * 30;

            // Recursively draw the left and right child nodes
            drawBinaryTree(node.left, leftChildX, childY, level + 1);
            drawBinaryTree(node.right, rightChildX, childY, level + 1);
        }
    }

    private void setFields() throws TreeException {
        inOrderTextField.setText(tree.InOrder());
        postOrderTextField.setText(tree.postOrder());
        preOrderTextField.setText(tree.preOrder());
        treeHeightTextField.setText(" " + tree.height());
    }

    public void randomizeOnAction(ActionEvent actionEvent) {
    }

    public void levelsOnAction(ActionEvent actionEvent) {
    }
}