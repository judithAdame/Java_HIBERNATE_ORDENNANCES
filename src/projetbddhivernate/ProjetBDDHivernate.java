package projetbddhivernate;

import DAO.ConsultationDAO;
import static DAO.ConsultationDAO.listNombreConsultationParAnnee;
import static DAO.ConsultationDAO.listNombreParDocteur;
import static DAO.ConsultationDAO.listNombreParSpecialite;
import DAO.DocteurDAO;
import DAO.DossierpatientDAO;
import DAO.HibernateUtil;
import static DAO.Utilitaire.createDate;
import dao.CategorieDAO;
import dao.MedicamentDAO;
import dao.OrdonnanceDAO;
import dao.OrdonnancechirurgieDAO;
import static dao.OrdonnancechirurgieDAO.listNombreChirurgiesParDocteur;
import dao.OrdonnancemedicamentsDAO;
import dao.SpecialiteDAO;
import entities.*;
import java.util.Date;
import java.util.Set;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 1895127
 */
public class ProjetBDDHivernate {
    public static void main(String[] args) { 
        
        //Insert de Categorie 
        byte idcategorie = 11;
        String nomCategorie = "Cancérologie‎";
        String descriptionCategorie = "La cancérologie, « science des cancers » également appelée oncologie, s’intéresse à tous les cancers. Elle est pratiquée par des médecins spécialistes, les cancérologues (ou oncologues) pour les tumeurs solides et les hématologues pour les cancers de type leucémie.";
        Set medicaments = null;
        Categorie categorie = new Categorie(idcategorie, nomCategorie, descriptionCategorie, medicaments);        

        //insert de Medicament
        int idmed = 70000;
        String nommed = "Tylenol";
        BigDecimal prix = new BigDecimal(10.20);
        Categorie categorieMedicament = categorie;
        Set ordonnancemedicamentses = null;
        Medicament medicament = new Medicament(idmed, categorieMedicament, nommed, prix, ordonnancemedicamentses);

        //insert de Specialite
        short code = 311;
        String titre = "Gériatrie";
        String description = "La gériatrie est la médecine des personnes âgées";
        Set docteurs = null;
        Specialite specialite = new Specialite(code, titre, description, docteurs);
        
        //insert de Docteur
        String matricule = "123ABC456B";
        Specialite specialiteDocteur = specialite;
        String nomDocteur = "Adame Aragon";
        String prenomDocteur = "Judith";
        String villeDocteur = "Riviere de prairie";
        String adresseDocteur = "123456 Ulric-Gravel";
        String niveauDocteur = "Docteur";
        Short nbrpatients = 100;
        Set dossierpatients = null;
        Set consultations = null;
        Docteur docteur = new Docteur(matricule, specialiteDocteur, nomDocteur, prenomDocteur, villeDocteur, adresseDocteur, niveauDocteur, nbrpatients, dossierpatients, consultations);
        
        //insert de Ordonnance
        int numord = 20011;
        String recommandation = "ne pas faire des devoirs de BD";
        String typeo = "Chirurgie";
        Date datecOrdonnance = createDate("2020-05-19 00:00:00");
        Set ordonnancechirurgies = null;
        Set consultationsOrdonnance = null;
        Set ordonnancemedicamentsesOrdonnance = null;
        Ordonnance ordonnance = new Ordonnance(numord, recommandation, typeo, datecOrdonnance, ordonnancechirurgies, consultationsOrdonnance, ordonnancemedicamentsesOrdonnance);
        
        //insert de DossierPatient
        String numdos = "1021";
        Docteur docteurDossierPatient = docteur;
        String nomp = "Martinez";
        String prenomp = "Rogelio";
        String genre = "M";
        String numas = "ROMZ 7424 1";
        Date datenaiss = createDate("1974-05-19 00:00:00");
        Date datecDossierPatient = createDate("1999-05-19 00:00:00");
        Set consultationsDossierPatient = null;
        Dossierpatient dossierPatient = new Dossierpatient(numdos, docteurDossierPatient, nomp, prenomp, genre, numas, datenaiss, datecDossierPatient, consultationsDossierPatient);

        //insert de Consultation 
        String codedocteur = matricule;
        String numdosConsultation = numdos;
        Date datec = createDate("2019-04-22 00:00:00");
        ConsultationId consultationId = new ConsultationId(codedocteur, numdosConsultation, datec);
        Docteur docteurConsultation = docteur;
        Dossierpatient dossierpatientConsultation = dossierPatient;
        Ordonnance ordonnanceConsultation = ordonnance;
        String diagnostic = "Uriticaire aux devoirs";
        Consultation consultation = new Consultation(consultationId, docteurConsultation, dossierpatientConsultation, ordonnanceConsultation, diagnostic);

        //insert de Ordonnancechirurgie  
        int numordOrdonnancechirurgie = numord;
        byte rang = 1;
        OrdonnancechirurgieId idOrdonnancechirurgie = new OrdonnancechirurgieId(numordOrdonnancechirurgie, rang);
        Ordonnance ordonnanceOrdonnancechirurgie = ordonnance;
        String nomchirurgie = "chirurgie du cerveau";
        Ordonnancechirurgie ordonnanceChirurgie = new Ordonnancechirurgie(idOrdonnancechirurgie, ordonnanceOrdonnancechirurgie, nomchirurgie);
        
        //insert de Ordonnancemedicaments
        int numordOrdonnancemedicaments = numord;
        int idmedOrdonnancemedicaments = idmed;
        OrdonnancemedicamentsId idOrdonnancemedicaments = new OrdonnancemedicamentsId(numordOrdonnancemedicaments,idmedOrdonnancemedicaments);
        Medicament medicamentOrdonnancemedicaments = medicament;
        Ordonnance ordonnanceOrdonnancemedicaments = ordonnance;
        Byte nbboites = 5;
        Ordonnancemedicaments ordonnanceMedicaments = new Ordonnancemedicaments(idOrdonnancemedicaments, medicamentOrdonnancemedicaments, ordonnanceOrdonnancemedicaments, nbboites);

//        CategorieDAO.insert(categorie);
//        MedicamentDAO.insert(medicament);
//        SpecialiteDAO.insert(specialite);
//        DocteurDAO.insert(docteur);
//        OrdonnanceDAO.insert(ordonnance);
//        DossierpatientDAO.insert(dossierPatient);
//        ConsultationDAO.insert(consultation);
//        OrdonnancechirurgieDAO.insert(ordonnanceChirurgie);
//        OrdonnancemedicamentsDAO.insert(ordonnanceMedicaments); 

        //Lister tous les enregistrements dans toutes les tables de votre BD
        //ConsultationDAO.getAll();

       //Lister un enregistrement selon son ID (parametre) dans toutes les tables de votre BD
        List<Object[]> temp = ConsultationDAO.byId(consultationId);
        //4 requetes
        /*
        listNombreParDocteur();
        listNombreParSpecialite();
        listNombreConsultationParAnnee();
        listNombreChirurgiesParDocteur();
        */
        
        HibernateUtil.getSessionFactory().close();
    }
}
