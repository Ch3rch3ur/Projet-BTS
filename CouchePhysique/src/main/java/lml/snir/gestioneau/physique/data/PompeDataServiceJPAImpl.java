package lml.snir.gestioneau.physique.data;

import lml.snir.gestioneau.metier.entity.Pompe;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;
/**
 *
 * @author joris
 */
public class PompeDataServiceJPAImpl extends AbstracCrudServiceJPA<Pompe> implements PompeDataService {
    PompeDataServiceJPAImpl(String PU){
        super(PU);
    }
    
}
