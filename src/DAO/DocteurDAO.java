package DAO;

import static DAO.Utilitaire.fermerSession;
import static DAO.Utilitaire.ouvrirSession;
import entities.Consultation;
import entities.Docteur;
import entities.Dossierpatient;
import entities.Specialite;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * @author 1895648
 */
public class DocteurDAO {
    public static void insert(Docteur docteur) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }
    public static void delete(Docteur docteur) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(docteur);
        tx.commit();
        fermerSession(session);
    }
    public static void updateSpecialite(Docteur docteur, Specialite specialite) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setSpecialite(specialite);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    } 
    public static void updateNomM(Docteur docteur, String nomM) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setNomm(nomM);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }    
    public static void updatePrenomM(Docteur docteur, String prenomM) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setPrenomm(prenomM);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }    
    public static void updateVille(Docteur docteur, String ville) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setVille(ville);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }    
    public static void updateAdresse(Docteur docteur, String adresse) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setAdresse(adresse);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }    
    public static void updateNiveau(Docteur docteur, String niveau) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setNiveau(niveau);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }   
    public static void updateNbrPatients(Docteur docteur, Short nbrPatients) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setNbrpatients(nbrPatients);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDossierPatients (Docteur docteur, Dossierpatient dossierPatient){
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setDossierpatients(dossierPatient);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }
    public static void updateConsultations (Docteur docteur, Consultation consultation){
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        docteur.setConsultations(consultation);
        session.save(docteur);
        tx.commit();
        fermerSession(session);
    }
}