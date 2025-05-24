package lml.snir.gestioneau.beans;


import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.transactionel.ConsommationService;

@ManagedBean
@ViewScoped
public class ConsommationServiceBean implements Serializable {
    
    private String mode;
    // Getter

    public ConsommationService consommationService() throws Exception {
        return MetierFactory.getConsommationService();
    }
    
} 
