package DAO;

import Entities.BangDiem;
import Interfaces.DAOInterface;
import Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BangDiemDAO implements DAOInterface<BangDiem> {
    @Override
    public int addData(BangDiem data) {
        return 0;
    }

    @Override
    public int delData(BangDiem data) {
        return 0;
    }

    @Override
    public int updateData(BangDiem oldData, BangDiem newData) {
        Session session= HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        EntityManager em=session.getEntityManagerFactory().createEntityManager();
        em.persist(oldData);
        oldData=newData;
        session.saveOrUpdate(oldData);
        transaction.commit();
        session.close();
        return 0;
    }

    @Override
    public ObservableList<BangDiem> getAll() {
        Session session = HibernateUtils.getFACTORY().openSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery query=cb.createQuery(BangDiem.class);
        query.from(BangDiem.class);
        List<BangDiem> list=session.createQuery(query).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
    public List<Object[]> getBangDiemByStudentId(String id){
        Session session=HibernateUtils.getFACTORY().openSession();
        NativeQuery query=session.createNativeQuery("EXEC SP_SELECT_BANGDIEM_SINHVIEN "+id);
//        Query query=session.createSQLQuery("EXEC SP_SEL_PUBLIC_NHANVIEN(:usrename,:password)").addEntity(NhanVien.class).setParameter("username",username).setParameter("password",password);
        List<Object[]> bangDiemList= query.getResultList();
        return bangDiemList;
    }
}
