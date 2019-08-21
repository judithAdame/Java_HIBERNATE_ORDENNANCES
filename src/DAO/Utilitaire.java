package DAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import projetbddhivernate.ProjetBDDHivernate;

/**
 * @author 1895648
 */
public class Utilitaire {

    public static Session ouvrirSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();        
        return sessionFactory.openSession();
    }
    public static void fermerSession(Session session) {
        session.close();
    }        
    public static Date createDate(String dateStr) { 
        DateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date Ddate = new Date();
        try {
            Ddate = dateFormat.parse(dateStr);
        } catch (ParseException ex) {
            Logger.getLogger(ProjetBDDHivernate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ddate;
    }
    
    public static Date toDate(String dateStr) { 
        //exemple date
        Date date = new Date();
        try {
            //exemple calendar
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            //exemple calendar format affichage
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setTimeZone(cal.getTimeZone());
            System.out.println(dateFormat.format(cal.getTime()));
            //exemple calendar format conversion
            date = dateFormat.parse(dateStr);
            System.out.println("dernier " + date);
        } catch (ParseException ex) {
            Logger.getLogger(Utilitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    /*
    -- VOUS POUVEZ DEFINIR LE FORMAT DE LA DATE
    INSERT INTO USERS (USER_ID, F_NAME, L_NAME, DOB, GENDER, PHONE_NO, EMAIL, PASSWORD)
        VALUES (100, 'George', 'Abott', TO_DATE('12/08/1991', 'DD/MM/YYYY'), 'MALE', '514-325-0002', 'George@gmail.com', 'StarWars1');


    -- OU VOUS POUVEZ DEFINIR LE FORMAT DE LA DATE
    ALTER SESSION SET NLS_DATE_FORMAT = 'DD;MM;YYYY';
    INSERT INTO Orders 
            VALUES(1,'01;06;2000',10);

    -- OU VOUS POUVEZ CONNAITRE LE FORMAT DE LA DATE DE VOTRE SESSION
    SELECT SYSDATE FROM DUAL;
    */
}
