package dao;

import static DAO.Utilitaire.*;
import entities.Docteur;
import entities.Specialite;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * @author 1895213
 */
public class SpecialiteDAO {
    public static void insert(Specialite s) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
        fermerSession(session);
    }
    public static void updateTitre(Specialite s, String titre) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        s.setTitre(titre);
        session.update(s);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDescription(Specialite s, String des) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        s.setDescription(des);
        session.update(s);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDocteurs(Specialite s, Docteur docteur) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        s.setDocteurs(docteur);
        session.update(s);
        tx.commit();
        fermerSession(session);
    }
    public static void delete(Specialite s) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
        fermerSession(session);
    }
}