package Models;

import Entities.BangDiem;
import Entities.HocPhan;
import javafx.scene.control.Button;


public class MarkRow extends HocPhan {

    private float diem;
    private Button editBtn;

    public MarkRow(String maHP, String tenHP, int soTC, float diem, Button editBtn) {
        this.setTenHP(tenHP);
        this.setMaHP(maHP);
        this.setSoTC(soTC);
        this.diem=diem;
        this.editBtn = editBtn;
    }




    public float getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(Button editBtn) {
        this.editBtn = editBtn;
    }
}
