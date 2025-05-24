package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.transactionel.PressionService;

/**
 *
 * @author joris
 */
public interface PressionDataService extends PressionService{
    public List<Pression> getByDate (Date date) throws Exception;
        
}
