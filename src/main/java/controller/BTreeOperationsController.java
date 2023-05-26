package controller;

import domain.BTree;
import domain.BTreeNode;
import domain.TreeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTreeOperationsController {


    @FXML
    private Pane drawPane;
    private BTree bTree;
    private Alert alert;
    private TextInputDialog dialog;

    @FXML
    public void initialize() {
        this.alert = util.FXUtility.alert("", "");
        randomize(20);
        drawTree(bTree.getRoot(), 400, 50, 350);
    }

    @FXML
    void onActionRandomize(ActionEvent event) {
        drawPane.getChildren().clear();
        randomize(20);
        drawTree(bTree.getRoot(), 400, 50, 350);
    }

    @FXML
    void onActionAdd(ActionEvent event) {
        int newNode = util.Utility.random(100);
        bTree.add(newNode);
        drawTree(bTree.getRoot(), 400, 50, 350);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText("The node: " + newNode + " has been added successfully!");
        alert.showAndWait();
    }

    @FXML
    void onActionNodeHeight(ActionEvent event) {
        dialog = util.FXUtility.dialog("Node Height", "Height: ");
        dialog.showAndWait();
        int value = Integer.parseInt(dialog.getResult());
        this.alert = util.FXUtility.alert("Node Height", "Height: ");
        alert.setAlertType(Alert.AlertType.INFORMATION);
        try {
            alert.setContentText(String.valueOf(bTree.height(value)));
            alert.showAndWait();
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onActionContains(ActionEvent event) {
        dialog = util.FXUtility.dialog("Node Contains", "Contains: ");
        dialog.showAndWait();
        int value = Integer.parseInt(dialog.getResult());
        this.alert = util.FXUtility.alert("Node Contains", "Contains: ");
        alert.setAlertType(Alert.AlertType.INFORMATION);
        try {
            alert.setContentText(String.valueOf(bTree.contains(value)));
            alert.showAndWait();
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void onActionRemove(ActionEvent event) {
        try {
            boolean insertado = false;
            do {
                int value = util.Utility.random(50);
                if (bTree.contains(value)) {
                    bTree.remove(value);
                    this.alert = util.FXUtility.alert("Node to remove", "Remove: ");
                    alert.setContentText("Node " + value + " removed");
                    alert.showAndWait();
                    drawPane.getChildren().clear();
                    drawTree(bTree.getRoot(), 400, 50, 350);
                    insertado = true;
                }
            } while (!insertado);

        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onActionTreeHeight(ActionEvent event) {
        this.alert = util.FXUtility.alert("Tree Height", "Tree Height: ");
        alert.setAlertType(Alert.AlertType.INFORMATION);
        try {
            alert.setContentText(String.valueOf(bTree.height()));
            alert.showAndWait();
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
    }


    private void drawTree(BTreeNode node, double x, double y, double levelWidth) {
        if (node != null) {
            // Dibujar las conexiones con los nodos hijos primero
            if (node.left != null) {
                double childX = x - levelWidth / 2;
                double childY = y + 40;
                drawTree(node.left, childX, childY, levelWidth / 1.8);

                // Dibujar una línea desde el nodo actual al nodo hijo izquierdo
                Line line = new Line(x, y, childX, childY - 20);
                drawPane.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x + levelWidth / 2;
                double childY = y + 40;
                drawTree(node.right, childX, childY, levelWidth / 1.8);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                drawPane.getChildren().add(line);
            }

            // Dibujar el nodo actual como un círculo después de las líneas
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGREEN); // Cambiar el color a verde claro
            drawPane.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            drawPane.getChildren().add(text);
        }
    }

    private void randomize(int n) {
        bTree = new BTree();
        for (int i = 0; i < n; i++) {
            bTree.add(util.Utility.random(50));
        }
    }
}
