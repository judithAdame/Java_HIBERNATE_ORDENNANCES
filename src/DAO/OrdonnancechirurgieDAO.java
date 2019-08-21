package dao;

import static DAO.Utilitaire.*;
import entities.Ordonnance;
import entities.Ordonnancechirurgie;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 1895543
 */
public class OrdonnancechirurgieDAO {
    public static void insert(Ordonnancechirurgie och) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(och);
        tx.commit();
        fermerSession(session);
    }

    public static void delete(Ordonnancechirurgie och) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(och);
        tx.commit();
        fermerSession(session);
    }

    public static void updateRang(Ordonnancechirurgie och, Ordonnance ordonnance) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        och.setOrdonnance(ordonnance);
        session.update(och);
        tx.commit();
        fermerSession(session);
    }

    public static void updateNomChirurgie(Ordonnancechirurgie och, String nom) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        och.setNomchirurgie(nom);
        session.update(och);
        tx.commit();
        fermerSession(session);
    }

    //Requete 4 : Nombre de chirurgies par docteur
    public static void listNombreChirurgiesParDocteur() {
        Session session = ouvrirSession();
        Query query = session.createQuery("select D.matricule, D.nomm, count(D.matricule) from Ordonnancechirurgie OC inner join OC.ordonnance O inner join O.consultations C inner join C.docteur D group by D.matricule,D.nomm order by D.matricule, D.nomm");
        List<Object[]> results = query.list();
        System.out.println("=== Nombre de chirurgies par Docteur ===");
        System.out.println("Matricule\tnombre\tnom");
        for (Object[] line : results) {
            System.out.println(line[0] + "\t"+  line[2] + "\t"+ line[1]);
        }
        fermerSession(session);
    }
}
