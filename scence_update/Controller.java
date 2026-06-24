package scence_update;

import java.net.URL;
import java.util.ResourceBundle;

import global.Global;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Text_field;

    @FXML
    void On_save(ActionEvent event) throws Exception {
        var node = (Node) event.getSource();
        var stage = (Stage) node.getScene().getWindow();

        var view_main = getClass().getResource("../scence_main/View.fxml");
        var controller_main = new scence_main.Controller();

        var loader = new FXMLLoader();
        loader.setLocation(view_main);
        loader.setController(controller_main);


        var scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        var selected = Global.list.indexOf(Global.selected_item);
        Text_field.setText(Global.list.get(selected));

    }

}
