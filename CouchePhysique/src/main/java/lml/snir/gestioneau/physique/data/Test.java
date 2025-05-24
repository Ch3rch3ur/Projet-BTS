package lml.snir.gestioneau.physique.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.gestioneau.metier.entity.Consommation;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.entity.Cuve;
import lml.snir.gestioneau.metier.entity.GrandeurPhysique;
import lml.snir.gestioneau.metier.entity.NiveauEau;
import lml.snir.gestioneau.metier.entity.Pompe;
import lml.snir.gestioneau.metier.entity.MesureCuve;
import lml.snir.gestioneau.metier.entity.MesurePompe;

/**
 *
 * @author saturne
 */
public class Test {

    private final ConsommationPluieDataService consPluieSrv;
    private final ConsommationVilleDataService consVilleSrv;
    private final PressionDataService pressionSrv;
    private final TemperatureDataService tempSrv;
    private final DebitDataService debitSrv;
    private final CuveDataService cuveSrv;
    private final NiveauEauDataService niveaueauSrv;
    private final PompeDataService pompeSrv;
    private final MesureCuveDataService mesurecuveSrv;
    private final MesurePompeDataService mesurepompeSrv;
    private final ConsommationDataService consSrv;
    private final GrandeurPhysiqueDataService gPhysiqueSrv = PhysiqueDataFactory.getGrandeurPhysiqueDataService();

    private Cuve cuve = new Cuve();
    private Pompe pompe = new Pompe();

    public static void main(String[] args) throws Exception {
        Test test = new Test();

        //test.populate();
        test.testget();
    }

    private Test() throws Exception {
        this.consPluieSrv = PhysiqueDataFactory.getConsommationPluieDataService();
        this.consVilleSrv = PhysiqueDataFactory.getConsommationVilleDataService();
        this.pressionSrv = PhysiqueDataFactory.getPressionDataService();
        this.tempSrv = PhysiqueDataFactory.getTemperatureDataService();
        this.debitSrv = PhysiqueDataFactory.getDebitDataService();
        this.cuveSrv = PhysiqueDataFactory.getCuveDataService();
        this.niveaueauSrv = PhysiqueDataFactory.getNiveauEauDataService();
        this.pompeSrv = PhysiqueDataFactory.getPompeDataService();
        this.mesurecuveSrv = PhysiqueDataFactory.getMesureCuveDataService();
        this.mesurepompeSrv = PhysiqueDataFactory.getMesurePompeDataService();
        this.consSrv = PhysiqueDataFactory.getConsommationDataService();

    }

    private void populate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //PhysiqueDataFactory.getDrop().drop();
        // Générer un mode aléatoire avec RandomValueGenerator
        String modeAleatoire = RandomValueGenerator.generateRandomMode();

        // Appliquer ce mode à la cuve
        this.cuve.setMode(modeAleatoire);
        this.cuve.setId(1L);
        this.cuveSrv.update(cuve);

        // Remplissage des données dans la base
        for (int i = 0; i < 5; i++) {
            addMesureCuve();
            addMesurePompeTemperature();
            addMesurePompeDebit();
            addMesurePompePression();

        }
    }

    public void addMesurePompeGrandeurPhysique(GrandeurPhysique grandeurPhysique) throws Exception {
        Pompe p = this.pompe;

        if (p.getId() == null) {
            // Si la pompe n'a pas d'ID, vous pouvez l'ajouter à la base de données
            p = this.pompeSrv.add(p);
        }

        // Créer une mesure pour la pompe avec la grandeur physique passée en paramètre
        MesurePompe mesurePompe = new MesurePompe();
        mesurePompe.setGrandeurPhysique(grandeurPhysique);
        mesurePompe.setPompe(p);
        mesurePompe.setDate(RandomValueGenerator.generateRandomDate());
        mesurePompe = this.mesurepompeSrv.add(mesurePompe);
    }

    public void addMesurePompeTemperature() throws Exception {
        Temperature t = new Temperature();
        t.setValue(RandomValueGenerator.generateRandomDouble(10, 16));
        t = this.tempSrv.add(t);
        addMesurePompeGrandeurPhysique(t);
    }

    public void addMesurePompePression() throws Exception {
        Pression p = new Pression();
        p.setValue(RandomValueGenerator.generateRandomDouble(0, 10)); // Exemple de plage pour la pression
        p = this.pressionSrv.add(p);
        addMesurePompeGrandeurPhysique(p);
    }

    public void addMesurePompeDebit() throws Exception {
        Debit d = new Debit();
        d.setValue(RandomValueGenerator.generateRandomDouble(0, 100)); // Exemple de plage pour le débit
        d = this.debitSrv.add(d);
        addMesurePompeGrandeurPhysique(d);
    }

    public void addMesureCuve() throws Exception {
        Cuve c = this.cuve;

        if (c.getId() == null) {
            // Si la cuve n'a pas d'ID, vous pouvez l'ajouter à la base de données
            c = this.cuveSrv.add(c);
        }

        MesureCuve mesureCuve = new MesureCuve();
        Temperature t = new Temperature();
        t.setValue(RandomValueGenerator.generateRandomDouble(11, 16));
        t = this.tempSrv.add(t);

        ConsommationPluie consommationpluie;
        ConsommationVille consommationville;
        Random random = new Random();

        consommationville = new ConsommationVille();
        consommationpluie = new ConsommationPluie();

        consommationville.setDate(RandomValueGenerator.generateRandomDate());
        consommationville.setValue(RandomValueGenerator.generateRandomDouble(10, 300));
        consommationville = this.consVilleSrv.add(consommationville);

        consommationpluie.setDate(RandomValueGenerator.generateRandomDate());
        consommationpluie.setValue(RandomValueGenerator.generateRandomDouble(10, 300));
        consommationpluie = this.consPluieSrv.add(consommationpluie);

        NiveauEau niveauEau = new NiveauEau();
        niveauEau.setValue(RandomValueGenerator.generateRandomDouble(0, 100));
        niveauEau.setDate(RandomValueGenerator.generateRandomDate());
        niveauEau = this.niveaueauSrv.add(niveauEau);

        mesureCuve.setGrandeurPhysique(t);
        mesureCuve.setCuve(c);
        mesureCuve.setConsommationVille(consommationville);
        mesureCuve.setConsommationPluie(consommationpluie);
        mesureCuve.setNiveauEau(niveauEau);
        mesureCuve.setDate(RandomValueGenerator.generateRandomDate());
        mesureCuve = this.mesurecuveSrv.add(mesureCuve);
    }

    private void testget() throws Exception {

        // Récupérer la date actuelle du système
        Date currentDate = new Date();

        // Récupérer les consommations de pluie pour la date actuelle
        List<ConsommationPluie> consoPluies = consPluieSrv.getByDate(currentDate);
        for (ConsommationPluie cp : consoPluies) {
            System.out.println(cp);
        }

        List<ConsommationVille> consoVilles = consVilleSrv.getByDate(currentDate);
        for (ConsommationVille cv : consoVilles) {
            System.out.println(cv);
        }

        List<NiveauEau> niveauxeau = niveaueauSrv.getByDate(currentDate);
        for (NiveauEau ne : niveauxeau) {
            System.out.println(ne);
        }

        List<MesureCuve> mesurescuve = mesurecuveSrv.getByDate(currentDate);
        for (MesureCuve mc : mesurescuve) {
            System.out.println(mc);
        }

        List<MesurePompe> mesurespompe = mesurepompeSrv.getByDate(currentDate);
        for (MesurePompe mp : mesurespompe) {
            System.out.println(mp);
        }

        Consommation consopluielast = consSrv.getLastConsommationPluie();

//        // Afficher la dernière consommation de pluie
//        System.out.println("Dernière consommation de pluie : " + consopluielast.getValue());
//
//        // Vérifier si la consommation de pluie est égale à 120.0
//        double derniereValeur = consopluielast.getValue();
//        double valeurAttendue = 120.0;
//        double tolerance = 0.01; // Tolérance pour les erreurs de comparaison de nombres à virgule flottante
//
//        if (Math.abs(derniereValeur - valeurAttendue) <= tolerance) {
//            System.out.println("La consommation de pluie est correcte : " + derniereValeur);
//        } else {
//            System.out.println("Erreur : La consommation de pluie devrait être " + valeurAttendue + " mais elle est " + derniereValeur);
//            // Lancer une exception si la consommation de pluie ne correspond pas à la valeur attendue
//            throw new Exception("Erreur : La consommation de pluie devrait être " + valeurAttendue + " mais elle est " + derniereValeur);
//        }

        Consommation consovillelast = consSrv.getLastConsommationVille();

        NiveauEau niveaueaulast = niveaueauSrv.getLast();

        MesureCuve mesurecuvelast = mesurecuveSrv.getLastTemperature();

        MesurePompe mesurepompelastTemp = mesurepompeSrv.getLastTemperature();

        MesurePompe mesurepompelastPression = mesurepompeSrv.getLastPression();

        MesurePompe mesurepompelastDebit = mesurepompeSrv.getLastDebit();
        
    }

}
