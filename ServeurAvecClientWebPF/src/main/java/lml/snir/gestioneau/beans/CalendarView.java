package lml.snir.gestioneau.beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CalendarView implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date1 = new Date();

    @ManagedProperty("#{mesureCuveBean}")
    private MesureCuveBean mesureCuveBean;

    @ManagedProperty("#{mesurePompeBean}")
    private MesurePompeBean mesurePompeBean;

    @ManagedProperty("#{niveauEauBean}")
    private NiveauEauBean niveauEauBean;

    @ManagedProperty("#{cuveServiceBean}")
    private CuveServiceBean cuveServiceBean;

    public void onDateSelect() {
        if (date1 != null) {
            // Sauvegarder les valeurs actuelles comme historiques avant de générer de nouvelles données
            sauvegarderValeursHistoriques();

            // Générer des données brutes pour la date sélectionnée
            genererDonneesPourDate(date1);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Données historiques",
                    "Données du " + formatDate(date1) + " chargées");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private void sauvegarderValeursHistoriques() {
        if (mesureCuveBean != null) {
            mesureCuveBean.sauvegarderValeursHistoriques();
        }
        if (mesurePompeBean != null) {
            mesurePompeBean.sauvegarderValeursHistoriques();
        }
        if (niveauEauBean != null) {
            niveauEauBean.sauvegarderValeursHistoriques();
        }
        if (cuveServiceBean != null) {
            cuveServiceBean.sauvegarderValeursHistoriques();
        }
    }

    public void restaurerValeursHistoriques() {
        if (mesureCuveBean != null) {
            mesureCuveBean.restaurerValeursHistoriques();
        }
        if (mesurePompeBean != null) {
            mesurePompeBean.restaurerValeursHistoriques();
        }
        if (niveauEauBean != null) {
            niveauEauBean.restaurerValeursHistoriques();
        }
        if (cuveServiceBean != null) {
            cuveServiceBean.restaurerValeursHistoriques();
        }

        // Remettre la date à maintenant
        date1 = new Date();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Valeurs restaurées",
                "Retour aux données historiques précédentes");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void genererDonneesPourDate(Date date) {

        long seed = date.getTime() / (1000 * 60 * 60 * 24); // Jour en timestamp
        java.util.Random random = new java.util.Random(seed);

        // Données pour la cuve
        double tempCuve = 1.0 + random.nextDouble() * 18.0;
        mesureCuveBean.setTemperatureHistorique(Math.round(tempCuve * 10) / 10.0);

        double niveauLitres = 10 + random.nextDouble() * 40;
        niveauEauBean.setLastHistorique(Math.round(niveauLitres));

        // Mode d'alimentation basé sur le niveau
        if (niveauLitres < 15) {
            cuveServiceBean.setLastMode("Eau de ville");
        } else if (niveauLitres < 25) {
            cuveServiceBean.setLastMode("Mixte");
        } else {
            cuveServiceBean.setLastMode("Eau de pluie");
        }

        // Données pour la pompe
        double tempPompe = 1.0 + random.nextDouble() * 29.0; // 1°C à 30°C
        mesurePompeBean.setTemperatureHistorique(Math.round(tempPompe * 10) / 10.0);

        double pressionPompe = 0.0 + random.nextDouble() * 3.0;
        mesurePompeBean.setPressionHistorique(Math.round(pressionPompe * 10) / 10.0);

        double debitPompe = random.nextDouble() * 30.0;
        mesurePompeBean.setDebitHistorique(Math.round(debitPompe * 10) / 10.0);
    }

    private String formatDate(Date date) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;

        if (date1 != null) {
            genererDonneesPourDate(date1);
        }
    }

    public MesureCuveBean getMesureCuveBean() {
        return mesureCuveBean;
    }

    public void setMesureCuveBean(MesureCuveBean mesureCuveBean) {
        this.mesureCuveBean = mesureCuveBean;
    }

    public MesurePompeBean getMesurePompeBean() {
        return mesurePompeBean;
    }

    public void setMesurePompeBean(MesurePompeBean mesurePompeBean) {
        this.mesurePompeBean = mesurePompeBean;
    }

    public NiveauEauBean getNiveauEauBean() {
        return niveauEauBean;
    }

    public void setNiveauEauBean(NiveauEauBean niveauEauBean) {
        this.niveauEauBean = niveauEauBean;
    }

    public CuveServiceBean getCuveServiceBean() {
        return cuveServiceBean;
    }

    public void setCuveServiceBean(CuveServiceBean cuveServiceBean) {
        this.cuveServiceBean = cuveServiceBean;
    }
}
