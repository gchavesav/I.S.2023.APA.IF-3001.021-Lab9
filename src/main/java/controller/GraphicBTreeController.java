package controller;

import domain.BTreeNode;
import javafx.fxml.FXMLLoader;
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
    private TreeView treeView;

    @javafx.fxml.FXML
    public void initialize() {

    }
}