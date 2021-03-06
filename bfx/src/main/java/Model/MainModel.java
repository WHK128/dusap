/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Datenklassen.MainData;
import Datenklassen.Score;
import Datenklassen.Turnierteilnahme;
import Queries.GeschlechtQueries;
import Queries.KlasseQueries;
import Queries.OrtQueries;
import Queries.ScoreEingabeQueries;
import Queries.TeilnehmerQueries;
import Queries.TurnierteilnahmeQueries;
import Queries.VeranstaltungenQueries;
import Queries.VereinQueries;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Werner
 */
public class MainModel {

    public MainModel(MainData md) {
        loadAnmeldeDaten(md);
        loadKlassen(md);
        loadGeschlecht(md);
        loadPlz(md);
        loadVereine(md);
        loadAktuelleVeranstaltung(md);
        loadTurnierTeilnehmerListe(md);
    }

    private void loadVereine(MainData md) {
        try {
            md.setVereineList(VereinQueries.getVereine());
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadPlz(MainData md) {
        try {
            OrtQueries.loadPlzOrt();
            md.setPlzList(OrtQueries.getPlzOrt());
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadGeschlecht(MainData md) {
        try {
            md.setGeschlechtList(GeschlechtQueries.getGeschlecht());
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadKlassen(MainData md) {
        try {
            md.setKlassenListe(KlasseQueries.getKlassen());
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAnmeldeDaten(MainData md) {
        try {
            md.setAnmeldeDatenListe(TeilnehmerQueries.getAnmeldedaten());
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAktuelleVeranstaltung(MainData md) {
        try {
            md.setAktuelleVeranstaltung(VeranstaltungenQueries.getletzteVeranstaltung());
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadTurnierTeilnehmerListe(MainData md) {
        try {
            md.setTurnierTeilnahmeListe(TeilnehmerQueries.getTurnierTeilnehmerAnmeldedaten(md.getAktuelleVeranstaltung().getIDVeranstaltung()));
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveTurnierteilnahme(Turnierteilnahme t) {
        TurnierteilnahmeQueries.saveTurnierTeilnahme(t);
    }

    public void saveNeueVeranstaltung(String veranstaltung, LocalDate datum) {
        VeranstaltungenQueries.saveNeueVeranstaltung(veranstaltung, datum);
    }
    
     public void saveScore(Score score) {
         ScoreEingabeQueries.saveScore(score);
     }

}
