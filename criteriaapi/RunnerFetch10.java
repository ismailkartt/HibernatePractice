package com.tpe.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class RunnerFetch10 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        CriteriaBuilder cbuilder=session.getCriteriaBuilder();//CriteriaQuery nesnesi oluşturmak ve bazı metodları için
        CriteriaQuery<Developer09> cq=cbuilder.createQuery(Developer09.class);
        Root<Developer09> root=cq.from(Developer09.class);//classımızın tüm datalarını tutan kaynak
//        1- ismi Cemal olan developer ı getririniz.
        cq.select(root).//tüm data ulaşır.
                where(cbuilder.equal(root.get("name"),"Cemal"));//where Predicate ister
        List<Developer09> result=session.createQuery(cq).getResultList();
        result.forEach(System.out::println);

        //  2-ismi Erdem veya salarysi 9000 den fazla olan developerları getririniz
        Predicate pred1=cbuilder.equal(root.get("name"),"Erdem");
        Predicate pred2=cbuilder.greaterThan(root.get("salary"),"9000");
        Predicate predOr=cbuilder.or(pred1,pred2);

        cq.select(root).where(predOr);
        List<Developer09> result2=session.createQuery(cq).getResultList();
        result2.forEach(System.out::println);

//        3-salarysi 8000 olan developerları getririniz--ödev
//         4-salarysi 8000 den fazla olan developerları getririniz--ödev




        tx.commit();
        session.close();
        sf.close();
    }
}
