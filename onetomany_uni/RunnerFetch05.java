package com.tpe.onetomany_uni;

import com.tpe.manytoone.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company2.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1--Amazonda çalışan developer bilgilerini getiriniz.
//        String hqlQuery1 = "FROM Company2 c where c.companyname='Amazon'";
//        Company2 company= session.createQuery(hqlQuery1, Company2.class).uniqueResult();
//        company.getDevs().forEach(System.out::println);

        String hqlQuery2 = "Select c.devs FROM Company2 c where c.companyname='Amazon'";
        List<Object> resultList1 = session.createQuery(hqlQuery2).getResultList();
        resultList1.forEach(System.out::println);




        tx.commit();
        session.close();
        sf.close();


    }
}
