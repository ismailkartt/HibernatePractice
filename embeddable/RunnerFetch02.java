package com.tpe.embeddable;

import com.tpe.annotations.Developer01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch02 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //1- id=1 olan developerın tüm bilgilerini yazdırınız.
        Developer02 dev = session.get(Developer02.class,1L);
        System.out.println(dev);

        //2- id=1 olan developerın sadece eğitim bilgilerini yazdırınız.
        System.out.println(dev.getEducation());





        tx.commit();
        session.close();
        sf.close();
    }
}
