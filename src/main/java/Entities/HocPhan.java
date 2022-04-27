package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "HOCPHAN")
public class HocPhan implements Serializable {
    @Id
    @Column(name = "MAHP")
    private String maHP;

    @Column(name = "TENHP")
    private String tenHP;

    @Column(name = "SoTC")
    private int soTC;

    @OneToMany(mappedBy="hocPhan")
    private Set<BangDiem> bangDiemSet;
    public HocPhan() {
    }

    public HocPhan(String maHP, String tenHP, int soTC) {
        this.maHP = maHP;
        this.tenHP = tenHP;
        this.soTC = soTC;
    }

    public Set<BangDiem> getBangDiemSet() {
        return bangDiemSet;
    }

    public void setBangDiemSet(Set<BangDiem> bangDiemSet) {
        this.bangDiemSet = bangDiemSet;
    }

    public String getMaHP() {
        return maHP;
    }

    public void setMaHP(String maHP) {
        this.maHP = maHP;
    }

    public String getTenHP() {
        return tenHP;
    }

    public void setTenHP(String tenHP) {
        this.tenHP = tenHP;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

}
