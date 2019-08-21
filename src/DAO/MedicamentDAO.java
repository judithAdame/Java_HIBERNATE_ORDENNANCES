package dao;

import static DAO.Utilitaire.*;
import entities.Categorie;
import entities.Medicament;
import entities.Ordonnancemedicaments;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author 1895213
 */
public class MedicamentDAO {

    public static void insert(Medicament m) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(m);
        tx.commit();
        fermerSession(session);
    }

    public static void updateNomMedCategorie(Medicament m, Categorie categorie) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        m.setCategorie(categorie);
        session.update(m);
        tx.commit();
        fermerSession(session);
    }

    public static void updateNomMed(Medicament m, String nomMed) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        m.setNommed(nomMed);
        session.update(m);
        tx.commit();
        fermerSession(session);
    }

    public static void updatePrix(Medicament m, BigDecimal prix) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        m.setPrix(prix);
        session.update(m);
        tx.commit();
        fermerSession(session);
    }

    public static void updateOrdonnanceMedicamentses(Medicament m, Ordonnancemedicaments ordonnancemedicament) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        m.setOrdonnancemedicamentses(ordonnancemedicament);
        session.update(m);
        tx.commit();
        fermerSession(session);
    }

    public static void delete(Medicament m) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(m);
        tx.commit();
        fermerSession(session);
    }
}
