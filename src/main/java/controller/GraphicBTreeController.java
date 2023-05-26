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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
    private Text preOrderTextField;
    @javafx.fxml.FXML
    private Text inOrderTextField;
    @javafx.fxml.FXML
    private Text postOrderTextField;
    private BTree tree;
    @javafx.fxml.FXML
    private Pane lienzo;

    @javafx.fxml.FXML
    public void initialize() throws TreeException {
        tree = new BTree();
        for (int i = 0; i < 50; i++) {
            tree.add(util.Utility.random(50));
        }
        drawBinaryTree(tree.getRoot(), lienzo.getPrefWidth(), 50, lienzo.getPrefWidth()/1.7);
        setFields();
    }

    private void drawBinaryTree(BTreeNode node, double x, double y, double level) {
        if (node != null) {
            // Dibujar las conexiones con los nodos hijos primero
            if (node.left != null) {
                double childX = x - level / 1.1;
                double childY = y + 50;
                drawBinaryTree(node.left, childX, childY, level / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo izquierdo
                Line line = new Line(x, y, childX, childY - 20);
                lienzo.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x +level / 1.1;
                double childY = y + 50;
                drawBinaryTree(node.right, childX, childY, level / 2);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                lienzo.getChildren().add(line);
            }

            // Dibujar el nodo actual como un círculo después de las líneas
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGREEN); // Cambiar el color a verde claro
            lienzo.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            lienzo.getChildren().add(text);
        }
    }

    private void setFields() throws TreeException {
        inOrderTextField.setText(tree.InOrder());
        postOrderTextField.setText(tree.postOrder());
        preOrderTextField.setText(tree.preOrder());
        treeHeightTextField.setText(" " + tree.height());
    }

    public void randomizeOnAction(ActionEvent actionEvent) throws TreeException {
        tree = new BTree();
        for (int i = 0; i < 50; i++) {
            tree.add(util.Utility.random(50));
        }
        lienzo.getChildren().clear();
        drawBinaryTree(tree.getRoot(), lienzo.getPrefWidth(), 50, lienzo.getPrefWidth()/1.7);
        setFields();
    }

    public void levelsOnAction(ActionEvent actionEvent) throws TreeException {
        lienzo.getChildren().clear(); // Limpiar el lienzo

        // Obtener el número máximo de niveles en el árbol
        int maxLevel = tree.height();

        // Dibujar el árbol con líneas adicionales en cada nivel
        drawBinaryTreeWithLevels(tree.getRoot(), lienzo.getPrefWidth(), 50, lienzo.getPrefWidth() / 1.7, maxLevel, 0);
    }

    private void drawBinaryTreeWithLevels(BTreeNode node, double x, double y, double level, int maxLevel, int currentLevel) {
        if (node != null) {
            // Dibujar las conexiones con los nodos hijos primero
            if (node.left != null) {
                double childX = x - level / 1.1;
                double childY = y + 50;
                drawBinaryTreeWithLevels(node.left, childX, childY, level / 2, maxLevel, currentLevel + 1);

                // Dibujar una línea desde el nodo actual al nodo hijo izquierdo
                Line line = new Line(x, y, childX, childY - 20);
                lienzo.getChildren().add(line);
            }

            if (node.right != null) {
                double childX = x + level / 1.1;
                double childY = y + 50;
                drawBinaryTreeWithLevels(node.right, childX, childY, level / 2, maxLevel, currentLevel + 1);

                // Dibujar una línea desde el nodo actual al nodo hijo derecho
                Line line = new Line(x, y, childX, childY - 20);
                lienzo.getChildren().add(line);
            }

            // Dibujar una línea debajo del nodo actual si no es el último nivel
            if (currentLevel < maxLevel) {
                double startX = x - level;
                double endX = x + level*2;
                double lineY = y + 20;
                Line levelLine = new Line(startX, lineY, endX, lineY);
                lienzo.getChildren().add(levelLine);
            }

            // Dibujar el nodo actual como un círculo después de las líneas
            Circle circle = new Circle(x, y, 20);
            circle.setFill(Color.LIGHTGREEN); // Cambiar el color a verde claro
            lienzo.getChildren().add(circle);

            // Mostrar el valor del nodo
            Text text = new Text(String.valueOf(node.data));
            text.setX(x - 5);
            text.setY(y + 5);
            lienzo.getChildren().add(text);
        }
    }
}