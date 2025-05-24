/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.gestioneau.metier.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author saturne
 */
@Entity
public class MesureCuve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Cuve cuve;
    @OneToOne
    private GrandeurPhysique grandeurPhysique;
    @OneToOne
    private ConsommationPluie consommationPluie;
    @OneToOne
    private ConsommationVille consommationVille;
    @OneToOne
    private NiveauEau niveauEau;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Cuve getCuve() {
        return cuve;
    }

    public void setCuve(Cuve cuve) {
        this.cuve = cuve;
    }

    public GrandeurPhysique getGrandeurPhysique() {
        return grandeurPhysique;
    }

    public void setGrandeurPhysique(GrandeurPhysique grandeurPhysique) {
        this.grandeurPhysique = grandeurPhysique;
        // c'est les valeurs
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConsommationPluie getConsommationPluie() {
        return consommationPluie;
    }

    public void setConsommationPluie(ConsommationPluie consommationPluie) {
        this.consommationPluie = consommationPluie;
    }

    public ConsommationVille getConsommationVille() {
        return consommationVille;
    }

    public void setConsommationVille(ConsommationVille consommationVille) {
        this.consommationVille = consommationVille;
    }

    public NiveauEau getNiveauEau() {
        return niveauEau;
    }

    public void setNiveauEau(NiveauEau niveauEau) {
        this.niveauEau = niveauEau;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesureCuve)) {
            return false;
        }
        MesureCuve other = (MesureCuve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lml.snir.gestioneau.metier.entity.Mesure[ id=" + id + " value=" + grandeurPhysique + " ]";
    }

}
