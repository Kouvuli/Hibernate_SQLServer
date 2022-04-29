package DAO;

import Entities.NhanVien;
import Entities.SinhVien;
import Interfaces.DAOInterface;
import Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NhanVienDAO implements DAOInterface<NhanVien> {
    @Override
    public int addData(NhanVien data) {
        return 0;
    }

    @Override
    public int delData(NhanVien data) {
        return 0;
    }

    @Override
    public int updateData(NhanVien oldData, NhanVien newData) {
        return 0;
    }

    @Override
    public ObservableList<NhanVien> getAll() {
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(NhanVien.class);
        query.from(NhanVien.class);
        List<NhanVien> list=session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
    public NhanVien getNhanVienById(String maNV){
        Session session=HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(NhanVien.class);
        Root<NhanVien>root=query.from(NhanVien.class);
        String str=String.format("%%%s%%",maNV);
        query.where(cb.like(root.get("maNV").as(String.class),str));
        NhanVien nhanVien=(NhanVien) session.createQuery(query).getSingleResult();
        session.close();
        return nhanVien;
    }
    public List<NhanVien> authenticateNhanVien(String username,String password){
        Session session=HibernateUtils.getFACTORY().openSession();
        NativeQuery query=session.createNativeQuery("EXEC SP_AUTHEN_NHANVIEN "+username+","+password);
//        Query query=session.createSQLQuery("EXEC SP_SEL_PUBLIC_NHANVIEN(:usrename,:password)").addEntity(NhanVien.class).setParameter("username",username).setParameter("password",password);
        List<NhanVien> nhanVienList= query.getResultList();
        return nhanVienList;
    }
//    public String hashPassword(String password){
//        Session session=HibernateUtils.getFACTORY().openSession();
//
//        Query query=session.createSQLQuery("EXEC SP_SEL_PUBLIC_NHANVIEN(:password)").addEntity(String.class).setParameter("password",password);
//        String passwordResult= (String) query.getSingleResult();
//        return passwordResult;
//    }
    public NhanVien getNhanVienUserName(String username){
        Session session=HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(NhanVien.class);
        Root<NhanVien>root=query.from(NhanVien.class);
        String str=String.format("%%%s%%",username);
        query.where(cb.like(root.get("tenDN").as(String.class),str));
        NhanVien nhanVien=(NhanVien) session.createQuery(query).getSingleResult();
        session.close();
        return nhanVien;
    }
}
