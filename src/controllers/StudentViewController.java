package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Student;
import utilities.DBUtility;
import utilities.SceneChanger;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentViewController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private Label msgLabel;

    @FXML
    private void getEnrolled() {
        try {
            Student newStudent = new Student(firstNameTextField.getText(),
                                             lastNameTextField.getText(),
                                             birthdayDatePicker.getValue());
            int studentNum = DBUtility.getEnrolledIntoDB(newStudent);
            newStudent.setStudentNum(studentNum);
            msgLabel.setText(newStudent.toString());
        }catch(IllegalArgumentException | SQLException e)
        {
            msgLabel.setText(e.getMessage());
        }
    }
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"../views/programView.fxml","Georgian College");
    }
}
