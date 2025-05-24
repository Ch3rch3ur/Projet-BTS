package lml.snir.gestioneau.beans;


import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.Cuve;
import lml.snir.gestioneau.metier.entity.GrandeurPhysique;
import lml.snir.gestioneau.metier.entity.MesureCuve;

@ManagedBean
@ViewScoped
public class MesureCuveBean implements Serializable {
    
    private Cuve cuve;
    private Date date;
    private GrandeurPhysique grandeurPhysique;

    public GrandeurPhysique getGrandeurPhysique() {
        return grandeurPhysique;
    }

    public void setGrandeurPhysique(GrandeurPhysique grandeurPhysique) {
        this.grandeurPhysique = grandeurPhysique;
    }

    
    public double getLastTemperature() throws Exception {
        return MetierFactory.getMesureCuveService().getLastTemperature().getGrandeurPhysique().getValue();
    }
} 
