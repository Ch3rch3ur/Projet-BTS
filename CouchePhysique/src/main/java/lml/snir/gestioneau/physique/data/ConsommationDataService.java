package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Consommation;
import lml.snir.gestioneau.metier.transactionel.ConsommationService;

/**
 *
 * @author joris
 */
public interface ConsommationDataService extends ConsommationService {
    public List<Consommation> getByDate (Date date) throws Exception;
    
}
