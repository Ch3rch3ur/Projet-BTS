/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.gestioneau.metier.transactionel;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Debit;
import lml.snir.gestioneau.metier.entity.MesurePompe;
import lml.snir.gestioneau.metier.entity.Pression;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.persistence.CrudService;

/**
 *
 * @author saturne
 */
public interface MesurePompeService extends CrudService<MesurePompe> {
    public List<MesurePompe> getByDate(Date date) throws Exception;
    public MesurePompe getLastTemperature() throws Exception;
    public MesurePompe getLastPression() throws Exception;
    public MesurePompe getLastDebit() throws Exception;
    
}
