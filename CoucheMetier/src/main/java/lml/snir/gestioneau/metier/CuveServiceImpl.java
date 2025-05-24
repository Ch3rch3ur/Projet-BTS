package lml.snir.gestioneau.metier;

import java.util.Date;
import java.util.List;
import lml.snir.gestioneau.metier.entity.Cuve;
import lml.snir.gestioneau.metier.transactionel.CuveService;
import lml.snir.gestioneau.physique.data.CuveDataService;
import lml.snir.gestioneau.physique.data.PhysiqueDataFactory;

/**
 *
 * @author joris
 */
public class CuveServiceImpl implements CuveService {
    private final CuveDataService cuveSrv;
    
    public CuveServiceImpl() throws Exception {
        cuveSrv = PhysiqueDataFactory.getCuveDataService();
    }

    @Override
    public Cuve add(Cuve t) throws Exception {
        try {
            return this.cuveSrv.add(t);
        } catch (Exception ex) {
            String st = ex.getMessage();
            if (st.contains("SQL : 19")) {
                throw new Exception("Cuve déjà enregistrée");
            } else {
                throw ex;
            }
        }
    }

    @Override
    public void remove(Cuve t) throws Exception {
        this.cuveSrv.remove(t);
    }

    @Override
    public void update(Cuve t) throws Exception {
        this.cuveSrv.update(t);
    }

    @Override
    public Cuve getById(Long l) throws Exception {
        return this.cuveSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.cuveSrv.getCount();
    }

    @Override
    public List<Cuve> getAll() throws Exception {
        return this.cuveSrv.getAll();
    }

    @Override
    public List<Cuve> getAll(int i, int i1) throws Exception {
        return this.cuveSrv.getAll(i, i1);
    }

    
}
