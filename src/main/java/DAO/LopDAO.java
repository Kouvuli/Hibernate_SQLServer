package DAO;

import Entities.Lop;
import Entities.NhanVien;
import Interfaces.DAOInterface;
import Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LopDAO implements DAOInterface<Lop> {
    @Override
    public int addData(Lop data) {
        return 0;
    }

    @Override
    public int delData(Lop data) {
        return 0;
    }

    @Override
    public int updateData(Lop oldData, Lop newData) {
        return 0;
    }

    @Override
    public ObservableList<Lop> getAll() {
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(Lop.class);
        query.from(Lop.class);
        List<Lop> list=session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
    public Lop getClassById(String maLop){
        Session session=HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(Lop.class);
        Root<Lop> root=query.from(Lop.class);
        String str=String.format("%%%s%%",maLop);
        query.where(cb.like(root.get("maLop").as(String.class),str));
        Lop lop=(Lop) session.createQuery(query).getSingleResult();
        session.close();
        return lop;
    }
}
