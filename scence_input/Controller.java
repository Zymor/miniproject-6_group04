package scence_input;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Text_field;

    @FXML
    void On_save(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Text_field != null : "fx:id=\"Text_field\" was not injected: check your FXML file 'View.fxml'.";

    }

}
