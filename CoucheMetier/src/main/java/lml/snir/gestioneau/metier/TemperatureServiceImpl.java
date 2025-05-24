package lml.snir.gestioneau.metier;

import java.util.List;
import lml.snir.gestioneau.metier.entity.Temperature;
import lml.snir.gestioneau.metier.transactionel.TemperatureService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;
import lml.snir.gestioneau.physique.data.TemperatureDataService;


/**
 *
 * @author joris
 */
public class TemperatureServiceImpl implements TemperatureService {
    private final TemperatureDataService tempSrv;
    
    public TemperatureServiceImpl() throws Exception {
        tempSrv = PhysiqueDataFactory.getTemperatureDataService();
    }

    @Override
    public Temperature add(Temperature t) throws Exception {
        try {
            return this.tempSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Temperateure déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(Temperature t) throws Exception {
        this.tempSrv.remove(t);
    }

    @Override
    public void update(Temperature t) throws Exception {
        this.tempSrv.update(t);
    }

    @Override
    public Temperature getById(Long l) throws Exception {
        return this.tempSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.tempSrv.getCount();
    }

    @Override
    public List<Temperature> getAll() throws Exception {
        return this.tempSrv.getAll();
    }

    @Override
    public List<Temperature> getAll(int i, int i1) throws Exception {
        return this.tempSrv.getAll(i, i1);
    }
   
}
