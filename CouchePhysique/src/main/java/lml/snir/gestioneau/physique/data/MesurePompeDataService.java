package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.MesurePompe;
import lml.snir.gestioneau.metier.transactionel.MesurePompeService;

/**
 *
 * @author joris
 */
public interface MesurePompeDataService extends MesurePompeService {
    public List<MesurePompe> getByDate (Date date) throws Exception;
}
