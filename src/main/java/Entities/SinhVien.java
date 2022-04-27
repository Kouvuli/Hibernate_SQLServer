package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien implements Serializable {
    @Id
    @Column(name = "MASV",nullable = false)
    private String maSV;

    @Column(name = "HOTEN",nullable = false)
    private String hoTen;


    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;


    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "TENDN",nullable = false)
    private String tenDN;

    @Column(name = "MATKHAU",nullable = false)
    private Byte[] matKhau;

    @ManyToOne
    @JoinColumn(name="MALOP", nullable=false)
    private Lop lop;

    @OneToMany(mappedBy="sinhVien",fetch = FetchType.EAGER)
    private Set<BangDiem> bangDiemSet;
    public SinhVien() {
    }

    public SinhVien( String hoTen, Date ngaySinh, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public Set<BangDiem> getBangDiemSet() {
        return bangDiemSet;
    }

    public void setBangDiemSet(Set<BangDiem> bangDiemSet) {
        this.bangDiemSet = bangDiemSet;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }



    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public void setMatKhau(Byte[] matKhau) {
        this.matKhau = matKhau;
    }

    public Lop getLop() {
        return lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }


    public String getDiaChi() {
        return diaChi;
    }

    public String getTenDN() {
        return tenDN;
    }

    public Byte[] getMatKhau() {
        return matKhau;
    }
}
