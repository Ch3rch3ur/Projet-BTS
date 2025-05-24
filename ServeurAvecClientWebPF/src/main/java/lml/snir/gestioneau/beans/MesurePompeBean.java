package lml.snir.gestioneau.beans;


import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.GrandeurPhysique;
import lml.snir.gestioneau.metier.entity.MesurePompe;
import lml.snir.gestioneau.metier.entity.Pompe;

@ManagedBean
@ViewScoped
public class MesurePompeBean implements Serializable {
   
    private Pompe pompe;
    private Date date;
    private GrandeurPhysique grandeurPhysique;

    public GrandeurPhysique getGrandeurPhysique() {
        return grandeurPhysique;
    }

    public void setGrandeurPhysique(GrandeurPhysique grandeurPhysique) {
        this.grandeurPhysique = grandeurPhysique;
    }

    
    public double getLastTemperature() throws Exception {
        return MetierFactory.getMesurePompeService().getLastTemperature().getGrandeurPhysique().getValue();
    }
    
    public double getLastPression() throws Exception {
        return MetierFactory.getMesurePompeService().getLastPression().getGrandeurPhysique().getValue();
    }
    
    public double getLastDebit() throws Exception {
        return MetierFactory.getMesurePompeService().getLastPression().getGrandeurPhysique().getValue();
    }
} 
