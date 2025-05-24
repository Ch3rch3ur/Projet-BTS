package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.gestioneau.metier.transactionel.ConsommationVilleService;

/**
 *
 * @author joris
 */
public interface ConsommationVilleDataService extends ConsommationVilleService {
    public List<ConsommationVille> getByDate (Date date) throws Exception;
    
}
