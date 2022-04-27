package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LOP")
public class Lop implements Serializable {
    @Id
    @Column(name = "MALOP")
    private String maLop;

    @Column(name = "TENLOP")
    private String tenLop;

//    @Column(name = "MANV")
//    private String maNV;
    @ManyToOne
    @JoinColumn(name="MANV", nullable=false)
    private NhanVien nhanVien;

    @OneToMany(mappedBy="lop",fetch = FetchType.EAGER)
    private Set<SinhVien> sinhvienSet;

    public Lop() {
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Set<SinhVien> getSinhvienSet() {
        return sinhvienSet;
    }

    public void setSinhvienSet(Set<SinhVien> sinhvienSet) {
        this.sinhvienSet = sinhvienSet;
    }
}
