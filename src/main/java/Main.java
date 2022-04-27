import DAO.NhanVienDAO;
import DAO.SinhVienDAO;
import Entities.NhanVien;
import Entities.SinhVien;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;

public class Main extends Application {
    Stage window;
    Scene scene, scene2;
    @Override
    public void start(Stage stage) throws IOException {
        window =stage;
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Layouts/login.fxml"));
        scene = new Scene(loader.load());
        stage.setTitle("Đăng nhập");
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String[] args) {
        launch();
    }

}
