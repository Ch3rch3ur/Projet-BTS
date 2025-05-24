package lml.snir.gestioneau.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author saturne
 */
@Entity
@DiscriminatorValue("Temperature")
public class Temperature extends GrandeurPhysique {
    
}