package lml.snir.gestioneau.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lml.snir.gestioneau.metier.AlerteService;
import lml.snir.gestioneau.metier.MetierFactory;
import lml.snir.gestioneau.metier.entity.Alerte;

@ManagedBean
@ViewScoped
public class AlerteBean {

    public String getCuveLast() throws Exception {
        String alertText = MetierFactory.getAlerteService().getLast().toString();

        if (alertText != null
                && (alertText.equals("OK")
                || alertText.equals("Niveau_Insuffisant")
                || alertText.equals("Temperature_Eau_Basse")
                || alertText.equals("Fuite"))) {

            
            String alertCuveText = MetierFactory.getAlerteService().getLast().toString(); // À adapter
            alertCuveText = alertCuveText.replaceAll("_", " ");
            return alertCuveText;
        } else {
            return "OK";
        }
    }

    public String getPompeLast() throws Exception {
        String alertText = MetierFactory.getAlerteService().getLast().toString();

        if (alertText != null
                && (alertText.equals("OK")
                || alertText.equals("Consommation_Electrique_Haute")
                || alertText.equals("Consommation_Electrique_Faible")
                || alertText.equals("Consommation_Electrique_Longue")
                || alertText.equals("Surpression")
                || alertText.equals("Souspression")
                || alertText.equals("Temperature_Haute")
                || alertText.equals("Fuite"))) {

            alertText = alertText.replaceAll("_", " ");
            String alertPompeText = MetierFactory.getAlerteService().getLast().toString(); // À adapter
            return alertPompeText;
        } else {
            return "OK";
        }

    }
}
