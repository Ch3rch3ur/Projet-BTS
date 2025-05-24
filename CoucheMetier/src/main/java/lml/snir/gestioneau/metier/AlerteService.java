package lml.snir.gestioneau.metier;

import java.util.ArrayList;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Alerte;

public class AlerteService {    
    private List<Alerte> alertes = new ArrayList<>();
    
    public AlerteService() {
        this.alertes.add(Alerte.OK);
    }
   
    public void add(Alerte t) {
        this.alertes.add(t);
    }
   
    public List<Alerte> getAll() {
        return this.alertes;                
    }
    
    public Alerte getLast() {
        return this.alertes.get(this.alertes.size() - 1);
    }
}

