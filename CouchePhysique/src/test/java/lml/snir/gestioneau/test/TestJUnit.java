package lml.snir.gestioneau.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import lml.snir.gestioneau.metier.entity.*;
import lml.snir.gestioneau.physique.data.ConsommationDataService;
import lml.snir.gestioneau.physique.data.ConsommationPluieDataService;
import lml.snir.gestioneau.physique.data.ConsommationVilleDataService;
import lml.snir.gestioneau.physique.data.CuveDataService;
import lml.snir.gestioneau.physique.data.DebitDataService;
import lml.snir.gestioneau.physique.data.MesureCuveDataService;
import lml.snir.gestioneau.physique.data.MesurePompeDataService;
import lml.snir.gestioneau.physique.data.NiveauEauDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;
import lml.snir.gestioneau.physique.data.PompeDataService;
import lml.snir.gestioneau.physique.data.PressionDataService;
import lml.snir.gestioneau.physique.data.RandomValueGenerator;
import lml.snir.gestioneau.physique.data.TemperatureDataService;

public class TestJUnit {

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

    // Information de connexion à la base de données
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionEau";
    private static final String DB_USER = "gestionEau";
    private static final String DB_PASSWORD = "8Tqr8ARcWdpyP2w6";

    private Cuve cuve = new Cuve();
    private Pompe pompe = new Pompe();

    public TestJUnit() throws Exception {
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

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp called");
        // Supprimer la base de données à chaque lancement
        PhysiqueDataFactory.getDrop().drop();

        // Peupler les données après suppression de la base
        populate();
    }

    @Test
    public void test() throws Exception {
        this.testGetConsommationPluie();
        this.testGetConsommationVille();
        this.testGetMesureCuve();
        this.testGetMesurePompe();
        this.testGetNiveauEau();
        this.testGetLastConsommationPluie();  // Test pour la dernière consommation de pluie
        this.testGetLastConsommationVille();  // Test pour la dernière consommation de ville
        this.testGetLastNiveauEau();  // Test pour le dernier niveau d'eau
        this.testGetLastMesureCuve();  // Test pour la dernière mesure de cuve
        this.testGetLastTemperature();  // Appeler le test de la dernière température 
        this.testGetLastPression();  // Test pour la dernière pression
        this.testGetLastDebit();  // Test pour le dernier débit

    }

    private void populate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

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


    public void testGetConsommationPluie() throws Exception {
        // Récupérer la date actuelle du système
        Date currentDate = new Date();

        // Récupérer les consommations de pluie pour la date actuelle
        List<ConsommationPluie> consoPluies = consPluieSrv.getByDate(currentDate);

        // Vérifications (assertions)
        assertNotNull("La liste des consommations de pluie ne doit pas être nulle", consoPluies);
        assertFalse("La liste des consommations de pluie ne doit pas être vide", consoPluies.isEmpty());

        // Affichage des valeurs des consommations de pluie récupérées
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Date du jour : " + sdf.format(currentDate));

        for (ConsommationPluie consoPluie : consoPluies) {
            System.out.println("Consommation Pluie - Date: " + consoPluie.getDate() + ", Value: " + consoPluie.getValue());
        }
    }

    public void testGetConsommationVille() throws Exception {
        
        // Récupérer la date actuelle du système
        Date currentDate = new Date();

        // Récupérer les consommations de ville pour la date actuelle
        List<ConsommationVille> consoVilles = consVilleSrv.getByDate(currentDate);

        // Vérifications (assertions)
//        assertEquals("Il devrait y avoir une consommation de ville pour cette date", 1, consoVilles.size());
        assertNotNull("La liste des consommations de ville ne doit pas être nulle", consoVilles);
        assertFalse("La liste des consommations de ville ne doit pas être vide", consoVilles.isEmpty());

        // Affichage des valeurs des consommations récupérées
        for (ConsommationVille conso : consoVilles) {
            System.out.println("Consommation Ville - Date: " + conso.getDate() + ", Value: " + conso.getValue());
        }
    }

    public void testGetNiveauEau() throws Exception {
        
        // Récupérer la date actuelle du système
        Date currentDate = new Date();

        // Récupérer les consommations de niveaueau pour la date actuelle
        List<NiveauEau> niveauxEau = niveaueauSrv.getByDate(currentDate);
        
        // Vérifications (assertions)
        assertNotNull("La liste des niveaux d'eau ne doit pas être nulle", niveauxEau);
        assertFalse("La liste des niveaux d'eau ne doit pas être vide", niveauxEau.isEmpty());

        // Affichage des valeurs des niveaux d'eau récupérés
        for (NiveauEau niveau : niveauxEau) {
            System.out.println("Niveau d'Eau - Date: " + niveau.getDate() + ", Value: " + niveau.getValue());
        }
    }

    public void testGetMesureCuve() throws Exception {
        
        // Récupérer la date actuelle du système
        Date currentDate = new Date();

        // Récupérer les consommations de MesureCuve pour la date actuelle
        List<MesureCuve> mesuresCuve = mesurecuveSrv.getByDate(currentDate);

        // Vérifications (assertions)
        assertNotNull("La liste des mesures de cuve ne doit pas être nulle", mesuresCuve);
        assertFalse("La liste des mesures de cuve ne doit pas être vide", mesuresCuve.isEmpty());

        // Affichage des valeurs des mesures de cuve récupérées
        for (MesureCuve mesure : mesuresCuve) {
            System.out.println("Mesure Cuve - Date: " + mesure.getDate() + ", Value: " + mesure.getGrandeurPhysique().getValue());
        }
    }

    public void testGetMesurePompe() throws Exception {
        
        // Récupérer la date actuelle du système
        Date currentDate = new Date();

        // Récupérer les consommations de MesureCuve pour la date actuelle
        List<MesurePompe> mesurespompe = mesurepompeSrv.getByDate(currentDate);

        // Vérifications (assertions)
        assertNotNull("La liste des mesures de pompe ne doit pas être nulle", mesurespompe);
        assertFalse("La liste des mesures de pompe ne doit pas être vide", mesurespompe.isEmpty());

        // Affichage des valeurs des mesures de pompe récupérées
        for (MesurePompe mp : mesurespompe) {
            // Affichage personnalisé des propriétés de chaque MesurePompe
            System.out.println("MesurePompe - Date: " + mp.getDate()
                    + ", Value: " + mp.getGrandeurPhysique().getValue()
                    + ", Pump: " + (mp.getPompe() != null ? mp.getPompe().toString() : "No pump"));
        }
    }

    
    
    
    // Méthode GetLast
    
    
    
    
    // Ajout de la méthode pour tester la récupération de la dernière consommation de pluie
    public void testGetLastConsommationPluie() throws Exception {
        // Récupérer la dernière consommation de pluie enregistrée dans la base de données
        Consommation consopluielast = consSrv.getLastConsommationPluie();

        // Vérifier que la consommation n'est pas nulle
        assertNotNull("La consommation de pluie ne doit pas être nulle", consopluielast);

        // Obtenir la valeur de la consommation
        double derniereValeur = consopluielast.getValue();

        // Afficher la valeur de la consommation
        System.out.println("La dernière valeur de consommation de pluie est : " + derniereValeur);

        // Vérifier que la valeur de la consommation est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("La consommation de pluie devrait être 120.0", 120.0, consopluielast.getValue(), 0.01);
    }

    // Ajout de la méthode pour tester la récupération de la dernière consommation de ville
    public void testGetLastConsommationVille() throws Exception {
        // Récupérer la dernière consommation de ville enregistrée dans la base de données
        Consommation consovillelast = consSrv.getLastConsommationVille();

        // Vérifier que la consommation n'est pas nulle
        assertNotNull("La consommation de ville ne doit pas être nulle", consovillelast);

        // Obtenir la valeur de la consommation
        double derniereValeur = consovillelast.getValue();

        // Afficher la valeur de la consommation
        System.out.println("La dernière valeur de consommation de ville est : " + derniereValeur);

        // Vérifier que la valeur de la consommation est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("La consommation de ville devrait être 350.0", 350.0, consovillelast.getValue(), 0.01);
    }

    // Ajout de la méthode pour tester la récupération du dernier niveau d'eau
    public void testGetLastNiveauEau() throws Exception {
        // Récupérer le dernier niveau d'eau enregistré dans la base de données
        NiveauEau niveaueaulast = niveaueauSrv.getLast();

        // Vérifier que le niveau d'eau n'est pas nul
        assertNotNull("Le niveau d'eau ne doit pas être nul", niveaueaulast);

        // Obtenir la valeur de la consommation
        double derniereValeur = niveaueaulast.getValue();

        // Afficher la valeur de la consommation
        System.out.println("La dernière valeur du niveau d'eau est : " + derniereValeur);

        // Vérifier que la valeur du niveau d'eau est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("Le niveau d'eau devrait être 5.0", 5.0, niveaueaulast.getValue(), 0.01);
    }

    // Ajout de la méthode pour tester la récupération de la dernière mesure de cuve
    public void testGetLastMesureCuve() throws Exception {
        // Récupérer la dernière mesure de cuve enregistrée dans la base de données
        MesureCuve mesurecuvelast = mesurecuveSrv.getLastTemperature();

        // Vérifier que la mesure n'est pas nulle
        assertNotNull("La mesure de cuve ne doit pas être nulle", mesurecuvelast);

        // Obtenir la valeur du débit à partir de l'objet GrandeurPhysique
        Temperature temperature = (Temperature) mesurecuvelast.getGrandeurPhysique();
        double derniereValeurDebit = temperature.getValue();

        // Afficher la valeur du débit
        System.out.println("La dernière valeur de la tempéraure de la cuve est : " + derniereValeurDebit);

        // Vérifier que la valeur de la mesure de cuve est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("La valeur de la mesure de cuve devrait être 11.0", 11.0, mesurecuvelast.getGrandeurPhysique().getValue(), 0.01);
    }

    // Ajout de la méthode pour tester la récupération de la dernière température
    public void testGetLastTemperature() throws Exception {
        // Récupérer la dernière température enregistrée dans la base de données
        MesurePompe lastMesurePompe = mesurepompeSrv.getLastTemperature();

        // Vérifier que la mesure n'est pas nulle
        assertNotNull("La mesure de pompe ne doit pas être nulle", lastMesurePompe);

        // Obtenir la valeur du débit à partir de l'objet GrandeurPhysique
        Temperature temeprature = (Temperature) lastMesurePompe.getGrandeurPhysique();
        double derniereValeurDebit = temeprature.getValue();

        // Afficher la valeur du débit
        System.out.println("La dernière valeur de la tempéraure de la pompe est : " + derniereValeurDebit);

        // Vérifier que la valeur de la température est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("La température de la pompe devrait être 20.0", 20.0, lastMesurePompe.getGrandeurPhysique().getValue(), 0.01);
    }

    // Ajout de la méthode pour tester la récupération de la dernière pression de la pompe
    public void testGetLastPression() throws Exception {
        // Récupérer la dernière pression de la pompe enregistrée dans la base de données
        MesurePompe mesurepompelastPression = mesurepompeSrv.getLastPression();

        // Vérifier que la mesure de pression n'est pas nulle
        assertNotNull("La mesure de pression ne doit pas être nulle", mesurepompelastPression);

        // Obtenir la valeur du débit à partir de l'objet GrandeurPhysique
        Pression pression = (Pression) mesurepompelastPression.getGrandeurPhysique();
        double derniereValeurDebit = pression.getValue();

        // Afficher la valeur du débit
        System.out.println("La dernière valeur de la pression de la pompe est : " + derniereValeurDebit);

        // Vérifier que la valeur de la pression est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("La valeur de la pression devrait être 1.8", 1.8, mesurepompelastPression.getGrandeurPhysique().getValue(), 0.01);
    }

    // Ajout de la méthode pour tester la récupération du dernier débit de la pompe
    public void testGetLastDebit() throws Exception {
        // Récupérer le dernier débit de la pompe enregistré dans la base de données
        MesurePompe mesurepompelastDebit = mesurepompeSrv.getLastDebit();

        // Vérifier que la mesure de débit n'est pas nulle
        assertNotNull("La mesure de débit ne doit pas être nulle", mesurepompelastDebit);

        // Obtenir la valeur du débit à partir de l'objet GrandeurPhysique
        Debit debit = (Debit) mesurepompelastDebit.getGrandeurPhysique();
        double derniereValeurDebit = debit.getValue();

        // Afficher la valeur du débit
        System.out.println("La dernière valeur du débit de la pompe est : " + derniereValeurDebit);

        // Vérifier que la valeur du débit est correcte (en fonction de ce que tu as ajouté dans populate)
//        assertEquals("La valeur du débit devrait être 12.3", 12.3, mesurepompelastDebit.getGrandeurPhysique().getValue(), 0.01);
    }

}
