package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class NewNoticeController {

    @FXML
    private javafx.scene.control.TextArea inputTextField;

    @FXML
    public void textToString (ActionEvent event){

        String newNoteText = new String(inputTextField.getText());

        DBWorker worker = new DBWorker();

        Date javaDate = new Date();

        String Note_date = javaDate.toString();

        try {

            Statement statement = worker.getConnection().createStatement();
            String SQL = "INSERT INTO NOTICE (NOTICECOL, TIME) VALUES ("+"'"+ newNoteText+"', CURRENT_TIME)";

            statement.executeUpdate(SQL);
            statement.close();
            worker.getConnection().close();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
