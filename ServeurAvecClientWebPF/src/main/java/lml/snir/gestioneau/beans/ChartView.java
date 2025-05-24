package lml.snir.gestioneau.beans;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.ConsommationPluie;
import lml.snir.gestioneau.metier.entity.ConsommationVille;
import lml.snir.gestioneau.metier.ConsommationServiceImpl;

// Utilisation de l'API de graphique traditionnelle de PrimeFaces
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class ChartView implements Serializable {

    private static final long serialVersionUID = 1L;
    private PieChartModel pieModel;
    
    private ConsommationServiceImpl consommationServiceImpl;

    @PostConstruct
    public void init() {
        try {
            createPieModel();
        } catch (Exception ex) {
            Logger.getLogger(ChartView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    private void createPieModel() throws Exception {
        pieModel = new PieChartModel();

        // Ajouter des données
        pieModel.set("Ville", getLastConsommationVille().getValue());
        pieModel.set("Pluie", getLastConsommationPluie().getValue());

        // Configurer l'apparence
        pieModel.setTitle("Consommation d'eau de pluie/ville");
        pieModel.setShowDataLabels(true);
        pieModel.setLegendPosition("e");

        // Pour un effet donut, définir un diamètre (si supporté par votre version)
        try {
            pieModel.setDiameter(150);
        } catch (Exception e) {
            // Ignorer si la méthode n'existe pas dans cette version
        }
    }

    public ConsommationPluie getLastConsommationPluie() throws Exception{
        return MetierFactory.getConsommationService().getLastConsommationPluie();
    }


    public ConsommationVille getLastConsommationVille() throws Exception{
        return MetierFactory.getConsommationService().getLastConsommationVille();
    }
}
