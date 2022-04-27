package Controllers;

import DAO.NhanVienDAO;
import Entities.NhanVien;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void cancelHandler(ActionEvent event) {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    void loginHandler(ActionEvent event) throws IOException {
        if(!isValidInput()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setContentText("Dữ liệu nhập không hợp lệ!");
            alert.showAndWait();
        }else{
            NhanVienDAO dao=new NhanVienDAO();
            List<NhanVien> nhanVienList=dao.authenticateNhanVien(username.getText(),password.getText());
            if(nhanVienList.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setContentText("Tên đăng nhập và mật khẩu không hợp lệ!");
                alert.showAndWait();
            }
            else{
                Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
                window.close();
                Stage newWindnow = new Stage();

                FXMLLoader loader=new FXMLLoader(getClass().getResource("/Layouts/class-list.fxml"));
                ClassListController controller=new ClassListController();
                controller.setValue(username.getText());
                loader.setController(controller);

                Parent root=loader.load();
//        UserEditDialogController controller=loader.getController();

//        window.setUserData(username.getText());

                Scene editScene = new Scene(root, 500, 350);
                newWindnow.setScene(editScene);
                newWindnow.show();
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public boolean isValidInput(){
        if(username.getText().isEmpty()){
            return false;
        }
        else if(password.getText().isEmpty()){
            return false;
        }
        return true;
    }
}
