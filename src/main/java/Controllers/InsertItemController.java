package Controllers;

import DAO.BangDiemDAO;
import DAO.HocPhanDAO;
import DAO.SinhVienDAO;
import Entities.BangDiem;
import Entities.HocPhan;
import Entities.SinhVien;
import Models.MarkRow;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InsertItemController implements Initializable {
    @FXML
    private TableColumn<MarkRow, String> courseIdCol;

    @FXML
    private TableColumn<MarkRow, String> courseNameCol;

    @FXML
    private TableColumn<MarkRow, Button> editCol;

    @FXML
    private TableColumn<MarkRow, String> markCourseCol;

    @FXML
    private TableView<MarkRow> markTable;

    @FXML
    private Text studentId;

    @FXML
    private Text classId;

    private String maSV;
    private SinhVien sinhVien;
    @FXML
    private TableColumn<MarkRow, String> tcCourseCol;

    @FXML
    void cancelHandler(ActionEvent event) {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setText(sinhVien.getMaSV());
        classId.setText(sinhVien.getLop().getMaLop());
        BangDiemDAO bangDiemDAO=new BangDiemDAO();
        List<Object[]> bangDiemList=bangDiemDAO.getBangDiemByStudentId(sinhVien.getMaSV());

        List<MarkRow> rowList=new ArrayList<>();

        bangDiemList.forEach(i->{
           
        });
        for (Object[] i:bangDiemList) {
            String maSV=(String)i[0];
            String maHP=(String)i[1];
            String diem=(String)i[2];
            Image img = new Image("/Images/Pencil.png");
            ImageView imageView=new ImageView(img);
            imageView.setFitHeight(14);
            imageView.setPreserveRatio(true);
            Button editBtn=new Button();
            editBtn.setGraphic(imageView);
            addEditBtnHandler(editBtn);

            HocPhanDAO hocPhanDAO=new HocPhanDAO();
            HocPhan hocPhan=hocPhanDAO.getHocPhanById(maHP);
            MarkRow r = new MarkRow(hocPhan.getMaHP(), hocPhan.getTenHP(), hocPhan.getSoTC(), Integer.parseInt(diem), editBtn);
            rowList.add(r);
        }

        courseIdCol.setCellValueFactory(new PropertyValueFactory<MarkRow,String>("maHP"));
        courseNameCol.setCellValueFactory(new PropertyValueFactory<MarkRow,String>("tenHP"));
        markCourseCol.setCellValueFactory(new PropertyValueFactory<MarkRow,String>("diem"));
        tcCourseCol.setCellValueFactory(new PropertyValueFactory<MarkRow,String>("soTC"));
        editCol.setCellValueFactory(new PropertyValueFactory<MarkRow,Button>("editBtn"));

        markTable.setItems(FXCollections.observableArrayList(rowList));

    }

    public void addEditBtnHandler(Button editBtn){
        editBtn.setOnAction(event -> {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/Layouts/mark-view.fxml"));
            MarkController controller=new MarkController();
//            controller.setValue(bangDiem);
            loader.setController(controller);

            Parent root= null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene editScene = new Scene(root);
            window.setScene(editScene);
            window.show();
        });
    }
    @FXML
    void saveHandler(ActionEvent event) {

        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    public void setValue(String maSV){
        this.maSV=maSV;
        SinhVienDAO dao=new SinhVienDAO();
        sinhVien=dao.getStudentById(maSV);
    }
}
