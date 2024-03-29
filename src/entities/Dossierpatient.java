package entities;
// Generated 2019-04-17 16:56:23 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Dossierpatient generated by hbm2java
 */
public class Dossierpatient  implements java.io.Serializable {
     private String numdos;
     private Docteur docteur;
     private String nomp;
     private String prenomp;
     private String genre;
     private String numas;
     private Date datenaiss;
     private Date datec;
     private Set consultations = new HashSet(0);

    public Dossierpatient() {    }	
    public Dossierpatient(String numdos, Docteur docteur, String nomp, String prenomp, String numas) {
        this.numdos = numdos;
        this.docteur = docteur;
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.numas = numas;
    }
    public Dossierpatient(String numdos, Docteur docteur, String nomp, String prenomp, String genre, String numas, Date datenaiss, Date datec, Set consultations) {
       this.numdos = numdos;
       this.docteur = docteur;
       this.nomp = nomp;
       this.prenomp = prenomp;
       this.genre = genre;
       this.numas = numas;
       this.datenaiss = datenaiss;
       this.datec = datec;
       this.consultations = consultations;
    }
   
    public String getNumdos() {
        return this.numdos;
    }
    
    public void setNumdos(String numdos) {
        this.numdos = numdos;
    }
    public Docteur getDocteur() {
        return this.docteur;
    }
    
    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }
    public String getNomp() {
        return this.nomp;
    }
    
    public void setNomp(String nomp) {
        this.nomp = nomp;
    }
    public String getPrenomp() {
        return this.prenomp;
    }
    
    public void setPrenomp(String prenomp) {
        this.prenomp = prenomp;
    }
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getNumas() {
        return this.numas;
    }
    
    public void setNumas(String numas) {
        this.numas = numas;
    }
    public Date getDatenaiss() {
        return this.datenaiss;
    }
    
    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }
    public Date getDatec() {
        return this.datec;
    }
    
    public void setDatec(Date datec) {
        this.datec = datec;
    }
    public Set getConsultations() {
        return this.consultations;
    }    
    public void setConsultations(Consultation consultation) {
        this.consultations.add(consultation);
    }




}


