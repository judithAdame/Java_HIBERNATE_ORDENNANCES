package dao;

import static DAO.Utilitaire.fermerSession;
import static DAO.Utilitaire.ouvrirSession;
import entities.Medicament;
import entities.Ordonnance;
import entities.Ordonnancemedicaments;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * @author 1895543
 */
public class OrdonnancemedicamentsDAO {
    public static void insert(Ordonnancemedicaments om) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(om);
        tx.commit();
        fermerSession(session);
    }
    public static void delete(Ordonnancemedicaments om) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(om);
        tx.commit();
        fermerSession(session);
    }
    public static void updateMedicament(Ordonnancemedicaments om, Medicament medicament) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        om.setMedicament(medicament);
        session.update(om);
        tx.commit();
        fermerSession(session);
    }
    public static void updateOrdonnance(Ordonnancemedicaments om, Ordonnance ordonnance) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        om.setOrdonnance(ordonnance);
        session.update(om);
        tx.commit();
        fermerSession(session);
    }
    public static void updateNbBoite(Ordonnancemedicaments om, byte nb) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        om.setNbboites(nb);
        session.update(om);
        tx.commit();
        fermerSession(session);
    }
}