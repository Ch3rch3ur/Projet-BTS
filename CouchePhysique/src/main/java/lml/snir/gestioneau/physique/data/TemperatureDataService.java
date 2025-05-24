package lml.snir.gestioneau.physique.data;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.gestioneau.metier.transactionel.TemperatureService;

/**
 *
 * @author joris
 */
public interface TemperatureDataService extends TemperatureService {
    public List<Temperature> getByDate (Date date) throws Exception;
}
