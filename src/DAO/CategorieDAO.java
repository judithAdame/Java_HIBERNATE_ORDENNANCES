package dao;

import static DAO.Utilitaire.*;
import entities.Categorie;
import entities.Medicament;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author 1895213
 */
public class CategorieDAO {
    public static void update(Categorie c, Medicament medicament){
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        c.setMedicaments(medicament);
        session.update(c);
        tx.commit();
        fermerSession(session);
    }
    public static void insert(Categorie c) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        fermerSession(session);
    }
    public static void updateNom(Categorie c, String nomC) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        c.setNom(nomC);
        session.update(c);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDescription(Categorie c, String des) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        c.setDescription(des);
        session.update(c);
        tx.commit();
        fermerSession(session);
    }
    public static void delete(Categorie c) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        fermerSession(session);
    }
}