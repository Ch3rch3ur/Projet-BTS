package lml.snir.gestioneau.beans;

import lml.snir.gestioneau.metier.transactionel.ConsommationService;
import lml.snir.gestioneau.metier.transactionel.NiveauEauService;
import lml.snir.gestioneau.metier.transactionel.TemperatureService;
import lml.snir.gestioneau.metier.transactionel.PressionService;
import lml.snir.gestioneau.metier.transactionel.DebitService;


/**
 *
 * @author saturne
 */
public class ClientFactory {
    private ClientFactory() {}
    
    static ConsommationService consommationService;
    
}
