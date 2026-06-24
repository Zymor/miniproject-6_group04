package scence_main;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;

import global.Global;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Status;

    @FXML
    private ListView<String> list_view;

    @FXML
    void On_Create(ActionEvent event) throws IOException{
        var stage = (Stage) Status.getScene().getWindow();

        var view_input = getClass().getResource("../scence_input/View.fxml");
        var controller_input = new scence_input.Controller();

        var loader = new FXMLLoader(view_input);
        loader.setController(controller_input);
        loader.setLocation(view_input);

        var scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void On_Read(ActionEvent event) throws IOException {
        var stage = (Stage) Status.getScene().getWindow();
        var file_chooser = new FileChooser();
        var selected = file_chooser.showOpenDialog(stage);

        var data = new ArrayList<String>();
        for (var line : Files.readAllLines(selected.toPath())) {
            data.add(line);
        }
// buisiness logic
        Global.list = data;

        list_view.getItems().addAll(Global.list);
    }

    @FXML
    void On_delete(ActionEvent event) throws IOException {

        String selected_item = list_view.getSelectionModel().getSelectedItem();
        if(selected_item == null){
            System.out.println("No item selected");
            return;
        }
        Global.selected_item = selected_item;
    

        var node = (Node) event.getSource();
        var stage = (Stage) node.getScene().getWindow();

        var view_delete = getClass().getResource("../scence_delete/View.fxml");
        var controller_delete = new scence_delete.Controller();

        var loader = new FXMLLoader(view_delete);
        loader.setController(controller_delete);
        loader.setLocation(view_delete);

        var scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void On_update(ActionEvent event) throws IOException {


        String selected_item = list_view.getSelectionModel().getSelectedItem();
        if(selected_item == null){
            System.out.println("No item selected");
            return;
        }
        Global.selected_item = selected_item;

         var node = (Node) event.getSource();
        var stage = (Stage) node.getScene().getWindow();

        var view_update = getClass().getResource("../scence_update/View.fxml");
        var controller_update = new scence_update.Controller();

        var loader = new FXMLLoader(view_update);
        loader.setController(controller_update);
        loader.setLocation(view_update);

        var scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void initialize() {

        list_view.getItems().addAll(Global.list);

    }

}
