package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Program;
import models.Student;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ProgramViewController implements Initializable {

    @FXML
    private Label studentsLabel;

    @FXML
    private ListView<Student> studentListView;

    @FXML
    private ListView<Program> programsListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Program p = new Program("Computer","Diploma",11,8000);
        programsListView.getItems().add(p);

        try {
            studentListView.getItems().addAll(DBUtility.getStudentsFromDB());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        studentsLabel.setText(String.format("Students Enrolled: %d",studentListView.getItems().size()));
    }

    @FXML
    private void nextButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/courseView.fxml","Georgian College");
    }
}
