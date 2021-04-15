package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import models.Course;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CourseViewController implements Initializable {

    @FXML
    private ListView<Course> coursesListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Course c = new Course("Java", 1006);
        Course c1 = new Course("Python", 1008);
        Course c2 = new Course("Csharp", 1015);
        Course c3 = new Course("Swift", 1023);
        Course c4 = new Course("Javascript", 1019);
        Course c5 = new Course("Html", 1031);
        coursesListView.getItems().addAll(c,c1,c2,c3,c4,c5);
    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/programView.fxml","Georgian College");
    }
}
