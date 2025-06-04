package lml.snir.gestioneau.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lml.snir.gestioneau.metier.MetierFactory;

@ManagedBean
@SessionScoped
public class MesurePompeBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private double TemperatureHistorique = 22.5;
    private double PressionHistorique = 3.8;
    private double DebitHistorique = 15.2;
    
    // Valeurs historiques sauvegardées
    private double lastTemperatureHistorique = 22.5;
    private double lastPressionHistorique = 3.8;
    private double lastDebitHistorique = 15.2;
    
    /**
     * Sauvegarde les valeurs actuelles comme valeurs historiques
     */
    public void sauvegarderValeursHistoriques() {
        lastTemperatureHistorique = TemperatureHistorique;
        lastPressionHistorique = PressionHistorique;
        lastDebitHistorique = DebitHistorique;
    }
    
    /**
     * Restaure les valeurs historiques
     */
    public void restaurerValeursHistoriques() {
        TemperatureHistorique = lastTemperatureHistorique;
        PressionHistorique = lastPressionHistorique;
        DebitHistorique = lastDebitHistorique;
    }

    // Getters et Setters
    public double getTemperatureHistorique() {
        return TemperatureHistorique;
    }

    public void setTemperatureHistorique(double TemperatureHistorique) {
        this.TemperatureHistorique = TemperatureHistorique;
    }

    public double getPressionHistorique() {
        return PressionHistorique;
    }

    public void setPressionHistorique(double PressionHistorique) {
        this.PressionHistorique = PressionHistorique;
    }

    public double getDebitHistorique() {
        return DebitHistorique;
    }

    public void setDebitHistorique(double DebitHistorique) {
        this.DebitHistorique = DebitHistorique;
    }
    
    public double getLastTemperature() throws Exception {
        return MetierFactory.getMesurePompeService().getLastTemperature().getGrandeurPhysique().getValue();
    }
    
    public double getLastPression() throws Exception {
        return MetierFactory.getMesurePompeService().getLastPression().getGrandeurPhysique().getValue();
    }
    
    public double getLastDebit() throws Exception {
        return MetierFactory.getMesurePompeService().getLastDebit().getGrandeurPhysique().getValue();
    }
    
}