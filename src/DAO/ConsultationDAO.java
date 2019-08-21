package DAO;

import static DAO.Utilitaire.*;
import entities.Consultation;
import entities.ConsultationId;
import entities.Docteur;
import entities.Dossierpatient;
import entities.Ordonnance;
import java.util.Date;
import java.util.List;
import java.util.Set; 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author 1895648
 */
public class ConsultationDAO {

    public static void insert(Consultation consultation) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(consultation);
        tx.commit();
        fermerSession(session);
    }

    public static void delete(Consultation consultation) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(consultation);
        tx.commit();
        fermerSession(session);
    }

    public static void updateDocteur(Consultation consultation, Docteur docteur) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        consultation.setDocteur(docteur);
        session.save(consultation);
        tx.commit();
        fermerSession(session);
    }

    public static void updateDossierpatient(Consultation consultation, Dossierpatient dossierpatient) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        consultation.setDossierpatient(dossierpatient);
        session.save(consultation);
        tx.commit();
        fermerSession(session);
    }

    public static void updateOrdonnance(Consultation consultation, Ordonnance ordonnance) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        consultation.setOrdonnance(ordonnance);
        session.save(consultation);
        tx.commit();
        fermerSession(session);
    }

    public static void updateDiagnostic(Consultation consultation, String diagnostic) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        consultation.setDiagnostic(diagnostic);
        session.save(consultation);
        tx.commit();
        fermerSession(session);
    }
    //Lister tous les enregistrements dans toutes les tables de votre BD
    public static void getAll() {
        Session session = ouvrirSession();
        Query query = session.createQuery("from Consultation");
        List<Consultation> results = query.list();
//        System.out.println(" == getAllConsultation == ");
//        System.out.println("IDcodedocteur\tIDnumdos\tIDdatec");
//        System.out.println("tDocteur\tDossierpatient\tDiagnostic");
//        for (Consultation line : results) {
//            System.out.println(line.getId().toString());
//            System.out.println(line.getDocteur().toString());
//            System.out.println(line.getDossierpatient().toString());
//            System.out.println(line.getDiagnostic());
//        }
        fermerSession(session);
    }
    
    //Lister un enregistrement selon son ID (parametre) dans toutes les tables de votre BD
        public static List<Object[]> byId(ConsultationId consultationId) {
        Session session = ouvrirSession();   
        String sql = " from Consultation Consultation "
                   + " inner join Consultation.id ConsultationId "
                   + " where ConsultationId.codedocteur =:codedocteur and "
                         + " ConsultationId.numdos      =:numdos and "
                         + " ConsultationId.datec       =:datec";
        Query query = session.createQuery(sql);
        String codedocteur = consultationId.getCodedocteur();
        String numdos      = consultationId.getNumdos();
        Date datec         = consultationId.getDatec();        
        query.setParameter("codedocteur", codedocteur);
        query.setParameter("numdos", numdos);
        query.setParameter("datec", datec);
        List<Object[]> results = query.list();
        fermerSession(session);
        return results;
    }  
    
    //Requete 1: Afficher le nombre de consultations par docteur
    public static void listNombreParDocteur() {
        Session session = ouvrirSession();
        Query query = session.createQuery("select D.matricule, D.nomm, count(D.matricule) "
                + " from Consultation C "
                + " inner join C.docteur D "
                + " group by D.matricule,D.nomm "
                + " order by D.matricule,D.nomm ");
        List<Object[]> results = query.list();
        System.out.println(" == Nombre de consultations par Docteur == ");
        System.out.println("Matricule\tNombre\t Nom");
        for (Object[] line : results) {
            System.out.println(line[0] + "\t" + line[2] + "\t" + line[1]);
        }
        fermerSession(session);
    }

    //Requete 2: Afficher le nombre de chirurgies par specialité
    public static void listNombreParSpecialite() {
        Session session = ouvrirSession();
        Query query = session.createQuery(" select S.code,S.titre, count(S.code) "
                + " from Consultation C "
                + " inner join C.docteur D "
                + " inner join D.specialite S "
                + " group by S.code, S.titre "
                + " order by S.code, S.titre");
        List<Object[]> results = query.list();
        System.out.println("== Nombre de consultations par spécialité == ");
        System.out.println("Spécialite\tNombre\t\tTitre");
        for (Object[] line : results) {
            System.out.println(line[0] + "\t\t" + line[2] + "\t\t" + line[1]);
        }
        fermerSession(session);
    }

    //Requete 3: Affiche le nombre de consultation par Année
    public static void listNombreConsultationParAnnee() {
        Session session = ouvrirSession();
        Query query = session.createQuery(" select year(id.datec),count(id.datec) "
                + " from Consultation "
                + " group by year(id.datec) "
                + " order by year(id.datec)");
        List<Object[]> results = query.list();
        System.out.println("== Nombre de consultations par année == ");
        System.out.println("Année \tNombre");
        for (Object[] line : results) {
            System.out.println(line[0] + "\t  " + line[1]);
        }
        fermerSession(session);
    }
}
