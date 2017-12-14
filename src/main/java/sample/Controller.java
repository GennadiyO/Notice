package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Controller {

    @FXML
    private TableView<NoticeDetails> tableNotices;
    @FXML
    private TableColumn<NoticeDetails, String> columnDate;
    @FXML
    private TableColumn<NoticeDetails, String> columnNote;

    private ObservableList<NoticeDetails> data;

    @FXML
    private void onClickNote(ActionEvent actionEvent) {
        try {
            Parent rootl = FXMLLoader.load(getClass().getClassLoader().getResource("newNotice.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hello Fucking Idiot");
            stage.setScene(new Scene(rootl, 600, 400));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void onClickUpdate(ActionEvent actionEvent){

        DBWorker worker = new DBWorker();

        try {

            data = FXCollections.observableArrayList();
            Statement statement = worker.getConnection().createStatement();
            String SQL = "SELECT * FROM NOTICE";

            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                data.add(new NoticeDetails(rs.getString(2), rs.getString(3)));
            }
            rs.close();
            statement.close();
            worker.getConnection().close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        columnDate.setCellValueFactory(new PropertyValueFactory<NoticeDetails, String>("date"));
        columnNote.setCellValueFactory(new PropertyValueFactory<NoticeDetails, String>("notice"));

        tableNotices.setItems(null);
        tableNotices.setItems(data);
    }
}
