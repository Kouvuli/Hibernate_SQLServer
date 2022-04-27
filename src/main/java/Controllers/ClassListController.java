package Controllers;

import DAO.LopDAO;
import DAO.NhanVienDAO;
import Entities.Lop;
import Entities.NhanVien;
import Entities.SinhVien;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClassListController implements Initializable {
    @FXML
    private Text classId;

    @FXML
    private ListView<String> classList;

    @FXML
    private Text className;

    @FXML
    private Hyperlink studentListHL;


    private String username;
    private NhanVien currNhanVien;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NhanVienDAO dao=new NhanVienDAO();
        NhanVien nhanVien=dao.getNhanVienById(currNhanVien.getMaNV());
        List<String> a=new ArrayList<>();
        for (Lop lop: nhanVien.getLopSet()) {
            a.add(lop.getMaLop());
        }
        classList.setItems(FXCollections.observableArrayList(a));
        classList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String maLop = (String) classList.getSelectionModel().getSelectedItem();
                LopDAO lopDAO=new LopDAO();
                Lop lop=lopDAO.getClassById(maLop);
                className.setText(lop.getTenLop());
                classId.setText(maLop);
                studentListHL.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Stage window = new Stage();
                        window.initModality(Modality.APPLICATION_MODAL);
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Layouts/stu-list.fxml"));
                        StudentListController controller=new StudentListController();
                        List<SinhVien> h=new ArrayList<>(lop.getSinhvienSet());
                        controller.setValue(h);
                        loader.setController(controller);

                        Parent root= null;
                        try {
                            root = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene editScene = new Scene(root);
                        window.setTitle("Danh sách sinh viên");
                        window.setScene(editScene);
                        window.show();
                    }
                });
            }
        });
    }

    public void setValue(String username){
        this.username=username;
        NhanVienDAO dao=new NhanVienDAO();
        currNhanVien=dao.getNhanVienUserName(username);
    }
}
