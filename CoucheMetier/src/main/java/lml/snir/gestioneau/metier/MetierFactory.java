package lml.snir.gestioneau.metier;

import lml.snir.gestioneau.metier.transactionel.ConsommationService;
import lml.snir.gestioneau.metier.transactionel.ConsommationPluieService;
import lml.snir.gestioneau.metier.transactionel.ConsommationVilleService;
import lml.snir.gestioneau.metier.transactionel.CuveService;
import lml.snir.gestioneau.metier.transactionel.DebitService;
import lml.snir.gestioneau.metier.transactionel.GrandeurPhysiqueService;
import lml.snir.gestioneau.metier.transactionel.MesureCuveService;
import lml.snir.gestioneau.metier.transactionel.MesurePompeService;
import lml.snir.gestioneau.metier.transactionel.NiveauEauService;
import lml.snir.gestioneau.metier.transactionel.PompeService;
import lml.snir.gestioneau.metier.transactionel.PressionService;
import lml.snir.gestioneau.metier.transactionel.TemperatureService;

public class MetierFactory {
    
    private static MesureCuveService mesureCuveService;
    public static MesureCuveService getMesureCuveService() throws Exception {
        if (mesureCuveService == null) {
            mesureCuveService = new MesureCuveServiceImpl();
        }
        return mesureCuveService;
    }
    
    private static ConsommationService consommationService;
    public static ConsommationService getConsommationService() throws Exception {
        if (consommationService == null) {
            consommationService = new ConsommationServiceImpl();
        }
        return consommationService;
    }
    
    private static CuveService cuveService;
    public static CuveService getCuveService() throws Exception {
        if (cuveService == null) {
            cuveService = new CuveServiceImpl();
        }
        return cuveService;
    }
    
    private static DebitService debitService;
    public static DebitService getDebitService() throws Exception {
        if (debitService == null) {
            debitService = new DebitServiceImpl();
        }
        return debitService;
    }
    
    private static GrandeurPhysiqueService grandeurPhysiqueService;
    public static GrandeurPhysiqueService getGrandeurPhysiqueService() throws Exception {
        if (grandeurPhysiqueService == null) {
            grandeurPhysiqueService = new GrandeurPhysiqueServiceImpl();
        }
        return grandeurPhysiqueService;
    }
    
    private static MesurePompeService mesurePompeService;
    public static MesurePompeService getMesurePompeService() throws Exception {
        if (mesurePompeService == null) {
            mesurePompeService = new MesurePompeServiceImpl();
        }
        return mesurePompeService;
    }

    
    private static NiveauEauService niveauEauService;
    public static NiveauEauService getNiveauEauService() throws Exception {
        if (niveauEauService == null) {
            niveauEauService = new NiveauEauServiceImpl();
        }
        return niveauEauService;
    }
    
    private static PompeService pompeService;
    public static PompeService getPompeService() throws Exception {
        if (pompeService == null) {
            pompeService = new PompeServiceImpl();
        }
        return pompeService;
    }
    
    private static PressionService pressionService;
    public static PressionService getPressionService() throws Exception {
        if (pressionService == null) {
            pressionService = new PressionServiceImpl();
        }
        return pressionService;
    }
    
    private static TemperatureService temperatureService;
    public static TemperatureService getTemperatureService() throws Exception {
        if (temperatureService == null) {
            temperatureService = new TemperatureServiceImpl();
        }
        return temperatureService;
    }
    
    private static ConsommationPluieService consommationPluieService;
    public static ConsommationPluieService getConsommationPluieService() throws Exception {
        if (consommationPluieService == null) {
            consommationPluieService = new ConsommationPluieServiceImpl();
        }
        return consommationPluieService;
    }
    
    private static ConsommationVilleService consommationVilleService;
    public static ConsommationVilleService getConsommationVilleService() throws Exception {
        if (consommationVilleService == null) {
            consommationVilleService = new ConsommationVilleServiceImpl();
        }
        return consommationVilleService;
    }
    
    private static AlerteService alerteService = null;
    public static AlerteService getAlerteService() {
        if (alerteService == null) {
            alerteService = new AlerteService();
        }
        return alerteService;
    }
    
    private MetierFactory() {}


}

