package dao;

import static DAO.Utilitaire.fermerSession;
import static DAO.Utilitaire.ouvrirSession;
import entities.Consultation;
import entities.Ordonnance;
import entities.Ordonnancechirurgie;
import entities.Ordonnancemedicaments;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author 1895543
 */
public class OrdonnanceDAO {
    public static void insert(Ordonnance ord) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void delete(Ordonnance ord) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void updateRecomendation(Ordonnance ord, String rec) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        ord.setRecommandation(rec);
        session.update(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void updateTypeO(Ordonnance ord, String rec) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        ord.setTypeo(rec);// ici on doit validez au niveau du set 
        session.update(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDateC(Ordonnance ord, Date dateC) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        ord.setDatec(dateC); 
        session.update(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void updateOrdonnanceChirurgies(Ordonnance ord, Ordonnancechirurgie ordonnancechirurgie) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        ord.setOrdonnancechirurgies(ordonnancechirurgie);
        session.update(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void updateConsultations(Ordonnance ord, Consultation consultation) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        ord.setConsultations(consultation);
        session.update(ord);
        tx.commit();
        fermerSession(session);
    }
    public static void updateOrdonnancemedicamentses(Ordonnance ord, Ordonnancemedicaments ordonnancemedicaments) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        ord.setOrdonnancemedicamentses(ordonnancemedicaments);
        session.update(ord);
        tx.commit();
        fermerSession(session);
    }    
}
