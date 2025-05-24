/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.gestioneau.metier.entity;

import java.io.Serializable;
import java.security.Timestamp;
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
public class MesurePompe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pompe pompe;
    @OneToOne
    private GrandeurPhysique grandeurPhysique;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Pompe getPompe() {
        return pompe;
    }

    public void setPompe(Pompe pompe) {
        this.pompe = pompe;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesurePompe)) {
            return false;
        }
        MesurePompe other = (MesurePompe) object;
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
