/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Datenklassen.MainData;
import Queries.GeschlechtQueries;
import Queries.KlasseQueries;
import Queries.OrtQueries;
import Queries.TeilnehmerQueries;
import Queries.VereinQueries;
import java.sql.SQLException;
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
    
    private void loadAktuelleVeranstaltung(MainData md){
        try {
            md.getAktuelleVeranstaltung();
        } catch (SQLException ex) {
            Logger.getLogger(MainModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void saveTurnierteilnahme(){
        
    }

}
