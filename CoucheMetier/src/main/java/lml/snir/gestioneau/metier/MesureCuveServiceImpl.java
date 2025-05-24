package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.MesureCuve;
import lml.snir.gestioneau.metier.transactionel.MesureCuveService;
import lml.snir.gestioneau.physique.data.MesureCuveDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class MesureCuveServiceImpl implements MesureCuveService {
    private final MesureCuveDataService mesurecuveSrv;
    
    public MesureCuveServiceImpl() throws Exception {
        mesurecuveSrv = PhysiqueDataFactory.getMesureCuveDataService();
    }

    @Override
    public List<MesureCuve> getByDate(Date date) throws Exception {
        return this.mesurecuveSrv.getByDate(date);
    }

    @Override
    public MesureCuve add(MesureCuve t) throws Exception {
        try {
            return this.mesurecuveSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("MesureCuve déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(MesureCuve t) throws Exception {
        this.mesurecuveSrv.remove(t);
    }

    @Override
    public void update(MesureCuve t) throws Exception {
        this.mesurecuveSrv.update(t);
    }

    @Override
    public MesureCuve getById(Long l) throws Exception {
        return this.mesurecuveSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.mesurecuveSrv.getCount();
    }

    @Override
    public List<MesureCuve> getAll() throws Exception {
        return this.mesurecuveSrv.getAll();
    }

    @Override
    public List<MesureCuve> getAll(int i, int i1) throws Exception {
        return this.mesurecuveSrv.getAll(i, i1);
    }

    @Override
    public MesureCuve getLastTemperature() throws Exception {
        return this.mesurecuveSrv.getLastTemperature();
    }
   
}
