package controller;

import domain.BTree;
import domain.BTreeNode;
import domain.TreeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTreeOperations {
    private BTree bTree; // Tu árbol binario

    private Group nodeGroup;
    @FXML
    private Pane tela;
    private Alert alert;
    private TextInputDialog dialog;

    @FXML
    public void initialize() {
        // Crear una instancia de tu árbol binario
        bTree = new BTree();
        for (int i = 0; i < 20; i++) {
            bTree.add(util.Utility.random(50));
        }
        drawTree(bTree.getRoot(), 600, 50, 350);//modifique x y para cambiar la posición del gráfico en el panel
    }

    @FXML
    void btnRandomize(ActionEvent event) {
    }


    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnNodeHeight(ActionEvent event) {

    }

    @FXML
    void btnContains(ActionEvent event) {
        dialog = util.FXUtility.dialog("Node Contains","Contains: ");
        dialog.showAndWait();
        int value = Integer.parseInt(dialog.getResult());
        this.alert=util.FXUtility.alert("Node Contains","Contains: ");
        alert.setAlertType(Alert.AlertType.INFORMATION);
        try {
            alert.setContentText(String.valueOf(bTree.contains(value)));
            alert.showAndWait();
        } catch (TreeException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void btnRemove(ActionEvent event) {

    }

    @FXML
    void btnTreeHeight(ActionEvent event) {

        this.alert=util.FXUtility.alert("Tree Height","Tree Height: ");
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
                double childX = x - levelWidth / 1.1;
                double childY = y + 50;
                drawTree(node.left, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo izquierdo
                Line line = new Line(x, y, childX, childY - 20);
                tela.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x + levelWidth / 1.1;
                double childY = y + 50;
                drawTree(node.right, childX, childY, levelWidth / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                tela.getChildren().add(line);
            }

            // Dibujar el nodo actual como un círculo después de las líneas
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGREEN);
            tela.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            tela.getChildren().add(text);
        }
    }




}