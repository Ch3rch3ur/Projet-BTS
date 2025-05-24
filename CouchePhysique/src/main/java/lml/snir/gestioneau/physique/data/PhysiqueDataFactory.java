package lml.snir.gestioneau.physique.data;

public class PhysiqueDataFactory {

    private static final String PU = "lml.snir.gestionteau_Common_jar_1.0PU";

    private PhysiqueDataFactory() {
    }

    private static CuveDataService cuveSrv = null;

    public static CuveDataService getCuveDataService() throws Exception {
        if (cuveSrv == null) {
            cuveSrv = new CuveDataServiceJPAImpl(PU);
        }

        return cuveSrv;
    }

    private static PompeDataService pompeSrv = null;

    public static PompeDataService getPompeDataService() throws Exception {
        if (pompeSrv == null) {
            pompeSrv = new PompeDataServiceJPAImpl(PU);
        }

        return pompeSrv;
    }

    private static NiveauEauDataService niveaueauSrv = null;

    public static NiveauEauDataService getNiveauEauDataService() throws Exception {
        if (niveaueauSrv == null) {
            niveaueauSrv = new NiveauEauDataServiceJPAImpl(PU);
        }

        return niveaueauSrv;
    }

    private static ConsommationDataService consSrv = null;

    public static ConsommationDataService getConsommationDataService() throws Exception {
        if (consSrv == null) {
            consSrv = new ConsommationDataServiceJPAImpl(PU);
        }

        return consSrv;
    }

    private static PressionDataService pressionSrv = null;

    public static PressionDataService getPressionDataService() throws Exception {
        if (pressionSrv == null) {
            pressionSrv = new PressionDataServiceJPAImpl(PU);
        }

        return pressionSrv;
    }

    private static GrandeurPhysiqueDataService gphysiqueSrv = null;

    public static GrandeurPhysiqueDataService getGrandeurPhysiqueDataService() throws Exception {
        if (gphysiqueSrv == null) {
            gphysiqueSrv = new GrandeurPhysiqueDataServiceJPAImpl(PU);
        }

        return gphysiqueSrv;
    }

    private static DebitDataService debitSrv = null;

    public static DebitDataService getDebitDataService() throws Exception {
        if (debitSrv == null) {
            debitSrv = new DebitDataServiceJPAImpl(PU);
        }

        return debitSrv;
    }

    private static MesureCuveDataServiceJPAImpl mesurecuveSrv = null;

    public static MesureCuveDataService getMesureCuveDataService() throws Exception {
        if (mesurecuveSrv == null) {
            mesurecuveSrv = new MesureCuveDataServiceJPAImpl(PU);
        }

        return mesurecuveSrv;
    }

    private static MesurePompeDataServiceJPAImpl mesurepompeSrv = null;

    public static MesurePompeDataService getMesurePompeDataService() throws Exception {
        if (mesurepompeSrv == null) {
            mesurepompeSrv = new MesurePompeDataServiceJPAImpl(PU);
        }

        return mesurepompeSrv;
    }

    private static TemperatureDataServiceJPAImpl tempSrv = null;

    public static TemperatureDataService getTemperatureDataService() throws Exception {
        if (tempSrv == null) {
            tempSrv = new TemperatureDataServiceJPAImpl(PU);
        }

        return tempSrv;
    }

    private static ConsommationPluieDataServiceJPAImpl consPluieSrv = null;

    public static ConsommationPluieDataService getConsommationPluieDataService() throws Exception {
        if (consPluieSrv == null) {
            consPluieSrv = new ConsommationPluieDataServiceJPAImpl(PU);
        }

        return consPluieSrv;
    }

    private static ConsommationVilleDataServiceJPAImpl consVilleSrv = null;

    public static ConsommationVilleDataService getConsommationVilleDataService() throws Exception {
        if (consVilleSrv == null) {
            consVilleSrv = new ConsommationVilleDataServiceJPAImpl(PU);
        }

        return consVilleSrv;
    }

    private static DropImpl dropSrv = null;

    public static Dropable getDrop() throws Exception {
        if (dropSrv == null) {
            dropSrv = new DropImpl(PU);
        }

        return dropSrv;
    }

}
