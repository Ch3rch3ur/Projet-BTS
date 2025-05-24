package lml.snir.gestioneau.metier.entity;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

/**
 *
 * @author saturne
 */
@Entity
@DiscriminatorValue("Debit")
public class Debit extends GrandeurPhysique {
    
}