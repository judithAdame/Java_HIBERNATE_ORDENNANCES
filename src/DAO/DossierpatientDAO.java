package DAO;

import static DAO.Utilitaire.*;
import entities.Consultation;
import entities.Docteur;
import entities.Dossierpatient;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
/*
 * @author 1895648
 */
public class DossierpatientDAO {
    public static void insert(Dossierpatient dossierPatient) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void delete(Dossierpatient dossierPatient) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        session.delete(dossierPatient);
        tx.commit();
        fermerSession(session);
    }    
    public static void updateDocteur(Dossierpatient dossierPatient, Docteur docteur) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setDocteur(docteur);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updateNomP(Dossierpatient dossierPatient, String nomP) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setNomp(nomP);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updatePrenomP(Dossierpatient dossierPatient, String prenomP) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setPrenomp(prenomP);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updateGenre(Dossierpatient dossierPatient, String genre) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setGenre(genre);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updateNumAS(Dossierpatient dossierPatient, String numAS) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setNumas(numAS);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDateNaiss(Dossierpatient dossierPatient, Date dateNaiss) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setDatenaiss(dateNaiss);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updateDateC(Dossierpatient dossierPatient, Date dateC) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setDatec(dateC);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
    public static void updateConsultations(Dossierpatient dossierPatient, Consultation consultation) {
        Session session = ouvrirSession();
        Transaction tx = session.beginTransaction();
        dossierPatient.setConsultations(consultation);
        session.save(dossierPatient);
        tx.commit();
        fermerSession(session);
    }
}