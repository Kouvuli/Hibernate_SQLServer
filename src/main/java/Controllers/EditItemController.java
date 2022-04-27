package Controllers;

import DAO.SinhVienDAO;
import Entities.SinhVien;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ResourceBundle;

public class EditItemController implements Initializable {
    @FXML
    private TextField studentAddress;

    @FXML
    private DatePicker studentBirthday;

    @FXML
    private Text studentId;

    @FXML
    private TextField studentName;
//
    private SinhVien sinhVien;
    private String maSV;
    @FXML
    void cancelHandler(ActionEvent event) {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    void saveHandler(ActionEvent event) {
        if(!isValidInput()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Dữ liệu nhập không hợp lệ!");
            alert.showAndWait();
        }
        else {
            SinhVienDAO dao=new SinhVienDAO();
            SinhVien newSinhVien=new SinhVien(studentName.getText(),java.util.Date.from(studentBirthday.getValue().atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant()),studentAddress.getText());
            dao.updateData(sinhVien,newSinhVien);
            Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            window.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setText(sinhVien.getMaSV());
        studentAddress.setText(sinhVien.getDiaChi());
        studentName.setText(sinhVien.getHoTen());
        studentBirthday.setValue(Instant.ofEpochMilli(sinhVien.getNgaySinh().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());

    }

    public void setValue(String maSV){
        this.maSV = maSV;
        SinhVienDAO dao=new SinhVienDAO();
        sinhVien=dao.getStudentById(maSV);

    }
    public boolean isValidInput(){
        if(studentName.getText().isEmpty()){
            return false;
        }
        else if (studentAddress.getText().isEmpty()){
            return false;
        }
        else if(studentBirthday.getValue()==null){
            return false;
        }
        return true;
    }
}
