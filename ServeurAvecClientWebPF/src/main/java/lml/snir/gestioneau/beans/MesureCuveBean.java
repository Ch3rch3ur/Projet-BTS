package lml.snir.gestioneau.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lml.snir.gestioneau.metier.MetierFactory;

@ManagedBean
@SessionScoped
public class MesureCuveBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private double TemperatureHistorique = 18.5;
    
    // Valeurs historiques sauvegardées
    private double TemperatureSaved = 18.5;
    
    /**
     * Sauvegarde les valeurs actuelles comme valeurs historiques
     */
    public void sauvegarderValeursHistoriques() {
        TemperatureSaved = TemperatureHistorique;
    }
    
    /**
     * Restaure les valeurs historiques
     */
    public void restaurerValeursHistoriques() {
        TemperatureHistorique = TemperatureSaved;
    }

    // Getters et Setters
    public double getTemperatureHistorique() {
        return TemperatureHistorique;
    }

    public void setTemperatureHistorique(double TemperatureHistorique) {
        this.TemperatureHistorique = TemperatureHistorique;
    }
    
    public double getLastTemperature() throws Exception {
        return MetierFactory.getMesureCuveService().getLastTemperature().getGrandeurPhysique().getValue();
    }
}