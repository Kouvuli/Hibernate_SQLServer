package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BANGDIEM")
public class BangDiem implements Serializable {


    @Column(name = "DIEMTHI")
    private String diemThi;

    @Id
    @ManyToOne
    @JoinColumn(name="MASV", nullable=false)
    private SinhVien sinhVien;

    @Id
    @ManyToOne
    @JoinColumn(name="MAHP", nullable=false)
    private HocPhan hocPhan;
    public BangDiem() {
    }

    public BangDiem(String diemThi, SinhVien sinhVien, HocPhan hocPhan) {
        this.diemThi = diemThi;
        this.sinhVien = sinhVien;
        this.hocPhan = hocPhan;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }



    public String getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(String diemThi) {
        this.diemThi = diemThi;
    }
}
