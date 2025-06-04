package lml.snir.gestioneau.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lml.snir.gestioneau.metier.MetierFactory;

@ManagedBean
@SessionScoped
public class NiveauEauBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private double lastHistorique = 30.0; // Niveau en litres

    // Valeurs historiques sauvegardées
    private double NiveauEauHistorique = 30.0;

    /**
     * Sauvegarde les valeurs actuelles comme valeurs historiques
     */
    public void sauvegarderValeursHistoriques() {
        NiveauEauHistorique = lastHistorique;
    }

    /**
     * Restaure les valeurs historiques
     */
    public void restaurerValeursHistoriques() {
        lastHistorique = NiveauEauHistorique;
    }

    // Getters et Setters
    public double getLast() throws Exception {
        return MetierFactory.getNiveauEauService().getLast().getValue();
    }

    public void setLastHistorique(double lastHistorique) {
        this.lastHistorique = lastHistorique;
    }
    
    public double getLastHistorique() throws Exception {
        return lastHistorique;
    }
}
