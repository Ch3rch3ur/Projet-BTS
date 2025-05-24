package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.transactionel.DebitService;

/**
 *
 * @author joris
 */
public interface DebitDataService extends DebitService{
    public List<Debit> getByDate (Date date) throws Exception;
    
}
