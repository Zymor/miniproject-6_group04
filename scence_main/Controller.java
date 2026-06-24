package scence_main;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void On_Create(ActionEvent event) {

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
        list_view.getItems().addAll(data);
    }

    @FXML
    void On_delete(ActionEvent event) {

    }

    @FXML
    void On_update(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    }

}
