package lml.snir.gestioneau.beans;


import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.transactionel.CuveService;

@ManagedBean
@ViewScoped
public class CuveServiceBean implements Serializable {
    
    private String mode;
    // Getter

    public CuveService cuveService() throws Exception {
        return MetierFactory.getCuveService();
    }
    
    public String getMode() throws Exception {
        return MetierFactory.getCuveService().getById(1L).getMode();
    }
    
} 
