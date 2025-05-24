package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.NiveauEau;
import lml.snir.gestioneau.metier.transactionel.NiveauEauService;

/**
 *
 * @author joris
 */
public interface NiveauEauDataService extends NiveauEauService{
    public List<NiveauEau> getByDate (Date date) throws Exception;
        
}
