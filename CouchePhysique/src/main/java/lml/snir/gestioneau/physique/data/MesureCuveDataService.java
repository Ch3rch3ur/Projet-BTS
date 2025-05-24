package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.MesureCuve;
import lml.snir.gestioneau.metier.transactionel.MesureCuveService;

/**
 *
 * @author joris
 */
public interface MesureCuveDataService extends MesureCuveService {
    public List<MesureCuve> getByDate (Date date) throws Exception;
        
}
