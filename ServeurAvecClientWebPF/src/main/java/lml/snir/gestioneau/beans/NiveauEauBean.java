package lml.snir.gestioneau.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.NiveauEau;

@ManagedBean
@ViewScoped
public class NiveauEauBean implements Serializable {
  
    public double getLast() throws Exception {
        return MetierFactory.getNiveauEauService().getLast().getValue();
    }
} 

