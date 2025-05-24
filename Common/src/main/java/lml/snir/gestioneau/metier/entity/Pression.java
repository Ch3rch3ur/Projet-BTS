package lml.snir.gestioneau.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author saturne
 */
@Entity
@DiscriminatorValue("Pression")
public class Pression extends GrandeurPhysique {
    
}
