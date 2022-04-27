package DAO;

import Entities.Lop;
import Entities.SinhVien;
import Interfaces.DAOInterface;
import Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SinhVienDAO implements DAOInterface<SinhVien> {
    @Override
    public int addData(SinhVien data) {
        return 0;
    }

    @Override
    public int delData(SinhVien data) {
        return 0;
    }

    @Override
    public int updateData(SinhVien oldData, SinhVien newData) {
        Session session=HibernateUtils.getFACTORY().openSession();
        Transaction transaction=session.beginTransaction();
        SinhVien sinhVien=session.get(SinhVien.class, oldData.getMaSV());
        sinhVien.setNgaySinh(newData.getNgaySinh());
        sinhVien.setDiaChi(newData.getDiaChi());
        sinhVien.setHoTen(newData.getHoTen());
        session.saveOrUpdate(sinhVien);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public ObservableList<SinhVien> getAll() {
        Session session= HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb= session.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(SinhVien.class);
        query.from(SinhVien.class);
        List<SinhVien> list=session.createQuery(query).getResultList();

        return FXCollections.observableArrayList(list);
    }
    public SinhVien getStudentById(String maSV){
        Session session=HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(SinhVien.class);
        Root<Lop> root=query.from(SinhVien.class);
        String str=String.format("%%%s%%",maSV);
        query.where(cb.like(root.get("maSV").as(String.class),str));
        SinhVien sinhVien=(SinhVien) session.createQuery(query).getSingleResult();
        session.close();
        return sinhVien;
    }
    public ObservableList<String> getAllStudentOfClass(String maLop){
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb= session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(SinhVien.class);
        Root<SinhVien> root=query.from(SinhVien.class);
        query.select(root.get("username"));
        List<String> list=session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
