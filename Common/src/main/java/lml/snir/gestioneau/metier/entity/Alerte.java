
package lml.snir.gestioneau.metier.entity;

import java.io.Serializable;


public enum Alerte implements Serializable{
    OK, 
    Niveau_Insuffisant, 
    Surpression, 
    Souspression, 
    Temperature_Basse, 
    Temperature_Haute, 
    Consommation_Electrique_Haute, 
    Consommation_Electrique_Faible,
    Consommation_Electrique_Longue,
    Fuite;
}

