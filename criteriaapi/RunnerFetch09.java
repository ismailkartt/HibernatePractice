package com.tpe.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

//        TASK:id si 1 olan dev in ismini SezaiKarakoç olarak update et.
//        Developer09 dev = session.get(Developer09.class,1L);
//        dev.setName("Sezai Karakoç");
//        session.update(dev);

        // id si 1 olan dev'in ismini şair sezai olarak update ediniz hql ile
//        String hql = "UPDATE Developer09 d SET d.name='Şair Sezai Karakoç' where d.id=1";
//        int numRecord = session.createQuery(hql).executeUpdate();
//        System.out.println("numRecord : " + numRecord);

        //TASK:parametre kullanarak salarysi 7000 den az olan devlerin salarysini 7850 yapınız.




                tx.commit();
        session.close();
        sf.close();




    }
}
