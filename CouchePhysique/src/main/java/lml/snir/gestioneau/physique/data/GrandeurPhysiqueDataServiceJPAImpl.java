package lml.snir.gestioneau.physique.data;

import lml.snir.gestioneau.metier.entity.GrandeurPhysique;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;

/**
 *
 * @author joris
 */
public class GrandeurPhysiqueDataServiceJPAImpl extends AbstracCrudServiceJPA<GrandeurPhysique> implements GrandeurPhysiqueDataService {

    GrandeurPhysiqueDataServiceJPAImpl(String PU) {
        super(PU);
    }

}
