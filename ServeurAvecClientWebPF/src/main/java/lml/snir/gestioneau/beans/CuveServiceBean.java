package lml.snir.gestioneau.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.transactionel.CuveService;

@ManagedBean
@SessionScoped
public class CuveServiceBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String LastMode = "Eau de pluie";
    
    // Valeurs historiques sauvegardées
    private String modeHistorique = "Eau de pluie";
    
    /**
     * Sauvegarde les valeurs actuelles comme valeurs historiques
     */
    public void sauvegarderValeursHistoriques() {
        modeHistorique = LastMode;
    }
    
    /**
     * Restaure les valeurs historiques
     */
    public void restaurerValeursHistoriques() {
        LastMode = modeHistorique;
    }

    // Getters et Setters
    public String getLastMode() throws Exception {
        return LastMode;
    }

    public void setLastMode(String LastMode) {
        this.LastMode = LastMode;
    }
    
    private String mode;
    // Getter

    public CuveService cuveService() throws Exception {
        return MetierFactory.getCuveService();
    }
    
    public String getMode() throws Exception {
        return MetierFactory.getCuveService().getById(1L).getMode();
    }
}