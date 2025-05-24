/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.gestioneau.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author saturne
 */
@Entity
@DiscriminatorValue("ConsommationPluie")
public class ConsommationPluie extends Consommation{
    
}
