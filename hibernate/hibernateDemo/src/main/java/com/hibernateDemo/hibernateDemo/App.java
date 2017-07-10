package com.hibernateDemo.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Name n = new Name();
    	n.setFname("Priyam");
    	n.setLname("Sharma");
        alien a = new alien();
        a.setId(101);
        a.setName(n);
        a.setColor("blue");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(alien.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(a);
        //a = (alien)session.get(alien.class, 12);
        
        tx.commit();
        System.out.println(a);
    }
}
