package lml.snir.gestioneau.physique.data;

import javax.persistence.Query;
import lml.snir.persistence.jpa.AbstracCrudServiceJPA;

/**
 *
 * @author saturne
 */
public class DropImpl extends AbstracCrudServiceJPA<Object> implements Dropable {
    DropImpl(String PU) {
        super(PU);
    }

    @Override
    public void drop() throws Exception {
        try {
            this.open();
            String sql = "DROP TABLE `CONSOMMATION`, `CUVE`, `GRANDEURPHYSIQUE`, `MESURECUVE`, `MESUREPOMPE`, `NIVEAUEAU`, `POMPE`, `SEQUENCE`;";
            Query query = super.em.createNativeQuery(sql);
            query.executeUpdate();
        } finally {
            this.close();
        }
    }
}
