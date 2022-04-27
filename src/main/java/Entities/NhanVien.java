package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien implements Serializable {
    @Id
    @Column(name = "MANV")
    private String maNV;

    @Column(name = "HOTEN")
    private String hoTen;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LUONG")
    private String luong;

    @Column(name = "TENDN")
    private String tenDN;

    @Column(name = "MATKHAU")
    private String matKhau;

    @Column(name = "PUBKEY")
    private String pubKey;

    @OneToMany(mappedBy="nhanVien",fetch = FetchType.EAGER)
    private Set<Lop> lopSet;

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    public Set<Lop> getLopSet() {
        return lopSet;
    }

    public void setLopSet(Set<Lop> lopSet) {
        this.lopSet = lopSet;
    }
}
