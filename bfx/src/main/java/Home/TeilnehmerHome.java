/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import Model.Anmeldedaten;
import Queries.TeilnehmerQueries;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Werner
 */
public abstract class TeilnehmerHome {

    private String idTeilnehmer;
    private String ort;
    private String vorname;
    private String nachname;
    private String gebDatum;
    private String email;
    private String verein;
    private String geschlecht;
    private String klasse;

    public TeilnehmerHome() {
        super();
    }

    public void setValues(String[] values) {
        setIdTeilnehmer(values[0]);
        setVorname(values[1]);
        setNachname(values[2]);
        setEmail(values[3]);
        setOrt(values[4]);
        setVerein(values[5]);
        setGebDatum(values[6]);
        setGeschlecht(values[7]);
        setKlasse(values[8]);
    }

    protected abstract Object[] getValues();

    protected abstract String[] getKeyValues();

    protected void setUniqueKey() {
    }

    protected void setUniqueKey(String[] keys) {
    }

//    public static List<Anmeldedaten> getAnmeldedaten() {
//        List<Anmeldedaten> result = new LinkedList<Anmeldedaten>();
//        try {
//            for (String[] r : TeilnehmerQueries.getAnmeldedaten()) {
//                Anmeldedaten re = new Anmeldedaten();
//                re.setValues(r);
//                result.add(re);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TeilnehmerHome.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }

    public String getIdTeilnehmer() {
        return idTeilnehmer;
    }
    public void setIdTeilnehmer(String idTeilnehmer) {
        this.idTeilnehmer = idTeilnehmer;
    }

    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGebDatum() {
        return gebDatum;
    }
    public void setGebDatum(String gebDatum) {
        this.gebDatum = gebDatum;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerein() {
        return verein;
    }
    public void setVerein(String verein) {
        this.verein = verein;
    }

    public String getGeschlecht() {
        return geschlecht;
    }
    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getKlasse() {
        return klasse;
    }
    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }
}