package DAO;

import Entities.HocPhan;
import Entities.NhanVien;
import Interfaces.DAOInterface;
import Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class HocPhanDAO implements DAOInterface<HocPhan> {
    @Override
    public int addData(HocPhan data) {
        return 0;
    }

    @Override
    public int delData(HocPhan data) {
        return 0;
    }

    @Override
    public int updateData(HocPhan oldData, HocPhan newData) {
        return 0;
    }

    @Override
    public ObservableList<HocPhan> getAll() {
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(HocPhan.class);
        query.from(HocPhan.class);
        List<HocPhan> list=session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
