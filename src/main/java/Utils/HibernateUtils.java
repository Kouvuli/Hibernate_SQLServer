package Utils;



import Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;


public class HibernateUtils {
    private final static SessionFactory FACTORY;
    static {
        Configuration conf=new Configuration();
        Properties props=new Properties();
        props.put(Environment.DIALECT,"org.hibernate.dialect.SQLServerDialect");
        props.put(Environment.DRIVER,"com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            props.put(Environment.URL,"jdbc:sqlserver://"+ InetAddress.getLocalHost().getHostName()+";databasename=QLSVNhom;integratedSecurity=true;encrypt=true;trustServerCertificate=true;");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        props.put(Environment.SHOW_SQL,"true");

        conf.setProperties(props);

        conf.addAnnotatedClass(SinhVien.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(Lop.class);
        conf.addAnnotatedClass(BangDiem.class);
        conf.addAnnotatedClass(HocPhan.class);

        ServiceRegistry registry=new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY=conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
