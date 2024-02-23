package vsa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    public static void main(String[] args) {
        //citajKnihy();
        //zmenaCien();
        //najdiKnihu();
        vytvorKnihu();
    }
    public static void citajKnihy() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createNativeQuery("select * from kniha", Kniha.class);
        List<Kniha> knihy = q.getResultList();

        for (Kniha k : knihy) {
            System.out.println("" + k);
        }
    }

    public static void zmenaCien() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em = emf.createEntityManager();

        Query q = em.createNativeQuery("select * from kniha", Kniha.class);
        List<Kniha> knihy = q.getResultList();

        em.getTransaction().begin();
        for (Kniha k : knihy) {
            k.setCena(k.getCena() * 0.8);
        }
        em.getTransaction().commit();

        for (Kniha k : knihy) {
            System.out.println("" + k);
        }
    }

    public static void najdiKnihu() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em = emf.createEntityManager();

        Kniha k = em.find(Kniha.class, "Pipi");
        System.out.println("" + k);
    }
    
    public static void vytvorKnihu() {
        Kniha k = new Kniha();
        k.setNazov("Pipi");
        k.setIsbn("SA10QWE");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vsaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(k);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }    
}
