package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.transactionel.ConsommationPluieService;

/**
 *
 * @author joris
 */
public interface ConsommationPluieDataService extends ConsommationPluieService {
    public List<ConsommationPluie> getByDate (Date date) throws Exception;
    
}
