package Controllers;

import DAO.BangDiemDAO;
import Entities.BangDiem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MarkController implements Initializable {
    @FXML
    private TextField markTxt;

    private BangDiem bangDiem;
    @FXML
    void cancelHandler(ActionEvent event) {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    void confirmHandler(ActionEvent event) {
        if(!isValidInput()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Dữ liệu nhập không hợp lệ!");
            alert.showAndWait();
        }
        else{
            BangDiemDAO bangDiemDAO = new BangDiemDAO();
            BangDiem newBangDiem=new BangDiem(markTxt.getText(),bangDiem.getSinhVien(),bangDiem.getHocPhan());
            bangDiemDAO.updateData(bangDiem,newBangDiem);
            Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setValue(BangDiem bangDiem){
        this.bangDiem=bangDiem;
    }
    public boolean isValidInput(){
        if(markTxt.getText().isEmpty()){
            return false;

        }
        return true;
    }

}
