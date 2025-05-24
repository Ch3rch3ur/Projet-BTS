package lml.snir.gestioneau.physique.data;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lml.snir.gestioneau.metier.entity.Cuve;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;

/**
 *
 * @author saturne
 */
public class CuveDataServiceJPAImpl extends AbstracCrudServiceJPA<Cuve> implements CuveDataService {
    CuveDataServiceJPAImpl(String PU) {
        super(PU);
    }
    
}
