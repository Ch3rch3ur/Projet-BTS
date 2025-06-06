/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.gestioneau.metier.transactionel;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.MesureCuve;
import lml.snir.persistence.CrudService;

/**
 *
 * @author saturne
 */
public interface MesureCuveService extends CrudService<MesureCuve> {
    public List<MesureCuve> getByDate(Date date) throws Exception;
    public MesureCuve getLastTemperature() throws Exception;
}
